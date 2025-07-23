package org.equipe_9.uniufc.domain.service;

import jakarta.transaction.Transactional;
import org.equipe_9.uniufc.domain.exception.ResourceNotFoundException;
import org.equipe_9.uniufc.domain.model.*;
import org.equipe_9.uniufc.domain.model.dto.*;
import org.equipe_9.uniufc.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthUserCmdService {
    private UsuarioDAO usuarioDAO;
    private AlunoDAO alunoDAO;
    private ProfessorDAO professorDAO;
    private DepartamentoDAO departamentoDAO;
    private CursoDAO cursoDAO;

    @Transactional
    public UsuarioDTO registerUser(UsuarioDTO.UsuarioRegisterDTO registrationDto, Usuario usuario) {
        checkIfUserExists(usuario);
        Usuario newUser = Usuario
                .builder()
                .login(registrationDto.login())
                .senha(registrationDto.senha())
                .nome(registrationDto.nome())
                .regra(Usuario.Regra.ALUNO)
                .build();

        Usuario u = usuarioDAO.save(newUser);
        return UsuarioDTO
                .builder()
                .id(u.getId())
                .login(u.getLogin())
                .nome(u.getNome())
                .senha("*************")
                .regra(u.getRegra())
                .build();
    }

    @Transactional
    public ProfessorDTO.ProfessorRegisterDTO registerProfessor(ProfessorDTO.ProfessorRegisterDTO registrationDto,Usuario usuario) {
        checkIfUserExists(usuario);
        Usuario newUser = Usuario
                .builder()
                .login(registrationDto.usuario().login())
                .senha(registrationDto.usuario().senha())
                .nome(registrationDto.usuario().nome())
                .regra(Usuario.Regra.PROFESSOR)
                .build();

        Usuario u = usuarioDAO.save(newUser);
        Departamento departamento = departamentoDAO.findById(registrationDto.departamentoCodigo()).orElseThrow(
                () -> new ResourceNotFoundException("Departamento não encontrado com o código: " + registrationDto.departamentoCodigo())
        );
        Professor p = Professor
                .builder()
                .siape(registrationDto.siape())
                .dataIngresso(registrationDto.dataIngresso().atStartOfDay())
                .usuario(u)
                .departamento(departamento)
                .nomeCompleto(registrationDto.nomeCompleto())
                .dataNascimento(registrationDto.dataNascimento().atStartOfDay())
                .telefones(registrationDto.telefones())
                .emails(registrationDto.emails())
                .build();

        professorDAO.save(p);

        return ProfessorDTO.ProfessorRegisterDTO
                .builder()
                .siape(p.getSiape())
                .nomeCompleto(p.getNomeCompleto())
                .dataNascimento(p.getDataNascimento().toLocalDate())
                .dataIngresso(p.getDataIngresso().toLocalDate())
                .emails(p.getEmails())
                .telefones(p.getTelefones())
                .departamentoCodigo(departamento.getId())
                .usuario(UsuarioDTO.UsuarioRegisterDTO
                        .builder()
                        .login(u.getLogin())
                        .nome(u.getNome())
                        .senha("*************")
                        .build())
                .build();
    }

    @Transactional
    public AlunoDTO.AlunoRegisterDTO registerAluno(AlunoDTO.AlunoRegisterDTO registrationDto, Usuario usuario) {
        checkIfUserExists(usuario);
        Usuario newUser = Usuario
                .builder()
                .login(registrationDto.usuario().login())
                .senha(registrationDto.usuario().senha())
                .nome(registrationDto.usuario().nome())
                .regra(Usuario.Regra.ALUNO)
                .build();

        Usuario u = usuarioDAO.save(newUser);
        Curso curso = cursoDAO.findByCodigo(registrationDto.cursoNomeCodigo()).orElseThrow(
                () -> new ResourceNotFoundException("Curso não encontrado com o código: " + registrationDto.cursoNomeCodigo())
        );
        Set<Aluno.TelefoneAluno> telefoneAluno = registrationDto.telefones().stream()
                .map(telefoneDto -> new Aluno.TelefoneAluno(telefoneDto.numero(), telefoneDto.descricao()))
                .collect(Collectors.toSet());

        AlunoGraduacao alunoGraduacao = new AlunoGraduacao();
        alunoGraduacao.setCurso(curso);
        alunoGraduacao.setMatricula(registrationDto.matricula());
        alunoGraduacao.setNome(registrationDto.nome());
        alunoGraduacao.setUsuario(u);
        alunoGraduacao.setTelefones(telefoneAluno);
        alunoGraduacao.setEndereco(registrationDto.endereco());
        alunoGraduacao.setDataIngresso(registrationDto.dataIngresso().atStartOfDay());
        Aluno a = alunoDAO.save(alunoGraduacao);


        alunoGraduacao.setDataIngresso(registrationDto.dataIngresso().atStartOfDay());
        alunoDAO.save(alunoGraduacao);

        UsuarioDTO.UsuarioRegisterDTO UsuarioDTO = org.equipe_9.uniufc.domain.model.dto.UsuarioDTO.UsuarioRegisterDTO
                .builder()
                .login(u.getLogin())
                .nome(u.getNome())
                .senha("*************")
                .build();
        Set<Aluno.TelefoneAluno> telefoneAluno1 = alunoGraduacao.getTelefones().stream()
                .map(telefoneDto -> new Aluno.TelefoneAluno(telefoneDto.getNumero(), telefoneDto.getDescricao()))
                .collect(Collectors.toSet());
        Set<AlunoGraduacaoDTO.TelefoneAlunoDTO> telefoneAlunoDTO = telefoneAluno1.stream()
                .map(telefone -> new AlunoGraduacaoDTO.TelefoneAlunoDTO(telefone.getNumero(), telefone.getDescricao()))
                .collect(Collectors.toSet());

        return AlunoDTO.AlunoRegisterDTO
                .builder()
                .matricula(a.getMatricula())
                .nome(a.getNome())
                .endereco(a.getEndereco())
                .cursoNomeCodigo(curso.getCodigo())
                .telefones(telefoneAlunoDTO)
                .usuario(UsuarioDTO)
                .dataIngresso(alunoGraduacao.getDataIngresso().toLocalDate())
                .build();
    }

    @Transactional
    public UsuarioDTO updateProfile(UsuarioDTO.UsuarioRegisterDTO profileDto, Usuario usuario) {
        checkIfUserNotExists(usuario);
        Usuario existingUser = usuarioDAO.findById(usuario.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + usuario.getId()));

        existingUser.setLogin(profileDto.login());
        existingUser.setNome(profileDto.nome());
        existingUser.setSenha(profileDto.senha());

        Usuario updatedUser = usuarioDAO.save(existingUser);
        return UsuarioDTO
                .builder()
                .id(updatedUser.getId())
                .login(updatedUser.getLogin())
                .nome(updatedUser.getNome())
                .senha("*************")
                .regra(updatedUser.getRegra())
                .build();
    }

    @Transactional
    public ProfessorDTO.ProfessorRegisterDTO updateProfileProfessor(ProfessorDTO.ProfessorRegisterDTO profileDto, Usuario usuario) {
        checkIfUserNotExists(usuario);

        Departamento departamento = departamentoDAO.findById(profileDto.departamentoCodigo())
                .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado com o código: " + profileDto.departamentoCodigo()));

        Professor updatedProfessor = Professor
                .builder()
                .id(usuario.getId())
                .siape(profileDto.siape())
                .nomeCompleto(profileDto.nomeCompleto())
                .dataNascimento(profileDto.dataNascimento().atStartOfDay())
                .dataIngresso(profileDto.dataIngresso().atStartOfDay())
                .emails(profileDto.emails())
                .telefones(profileDto.telefones())
                .usuario(usuario)
                .departamento(departamento)
                .build();
        professorDAO.save(updatedProfessor);

        UsuarioDTO.UsuarioRegisterDTO usuario1 = UsuarioDTO.UsuarioRegisterDTO
                .builder()
                .login(updatedProfessor.getUsuario().getLogin())
                .nome(updatedProfessor.getUsuario().getNome())
                .senha("*************")
                .build();

        return ProfessorDTO.ProfessorRegisterDTO
                .builder()
                .siape(updatedProfessor.getSiape())
                .nomeCompleto(updatedProfessor.getNomeCompleto())
                .dataNascimento(updatedProfessor.getDataNascimento().toLocalDate())
                .dataIngresso(updatedProfessor.getDataIngresso().toLocalDate())
                .emails(updatedProfessor.getEmails())
                .telefones(updatedProfessor.getTelefones())
                .departamentoCodigo(departamento.getId())
                .usuario(usuario1)
                .build();
    }

    @Transactional
    public AlunoDTO.AlunoRegisterDTO updateProfileAluno(AlunoDTO.AlunoRegisterDTO profileDto, Usuario usuario) {
        checkIfUserNotExists(usuario);

        Curso curso = cursoDAO.findByCodigo(profileDto.cursoNomeCodigo())
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o código: " + profileDto.cursoNomeCodigo()));

        Set<Aluno.TelefoneAluno> telefoneAluno = profileDto.telefones().stream()
                .map(telefoneDto -> new Aluno.TelefoneAluno(telefoneDto.numero(), telefoneDto.descricao()))
                .collect(Collectors.toSet());

        AlunoGraduacao updatedAluno = new AlunoGraduacao();
        updatedAluno.setId(usuario.getId());
        updatedAluno.setMatricula(profileDto.matricula());
        updatedAluno.setNome(profileDto.nome());
        updatedAluno.setUsuario(usuario);
        updatedAluno.setCurso(curso);
        updatedAluno.setTelefones(telefoneAluno);
        updatedAluno.setEndereco(profileDto.endereco());
        updatedAluno.setDataIngresso(profileDto.dataIngresso().atStartOfDay());

        alunoDAO.save(updatedAluno);

        return AlunoDTO.AlunoRegisterDTO
                .builder()
                .matricula(updatedAluno.getMatricula())
                .nome(updatedAluno.getNome())
                .endereco(updatedAluno.getEndereco())
                .cursoNomeCodigo(curso.getCodigo())
                .telefones(profileDto.telefones())
                .usuario(UsuarioDTO.UsuarioRegisterDTO
                        .builder()
                        .login(updatedAluno.getUsuario().getLogin())
                        .nome(updatedAluno.getUsuario().getNome())
                        .senha("*************")
                        .build())
                .dataIngresso(((AlunoGraduacao) updatedAluno).getDataIngresso().toLocalDate())
                .build();
    }

    @Transactional
    public void deleteUser(Long userIdToDelete) {
        usuarioDAO.deleteById(userIdToDelete);
    }

    private void checkIfUserNotExists(Usuario usuario) {
        if (!usuarioDAO.existsById(usuario.getId())) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + usuario.getId());
        }
    }

    private void checkIfUserExists(Usuario usuario) {
        if (usuarioDAO.existsById(usuario.getId())) {
            throw new ResourceNotFoundException("Usuário já existe com ID: " + usuario.getId());
        }
    }

    @Autowired
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Autowired
    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    @Autowired
    public void setProfessorDAO(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    @Autowired
    public void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    @Autowired
    public void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }
}
