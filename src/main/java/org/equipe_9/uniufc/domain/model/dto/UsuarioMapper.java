package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario usuario);
    UsuarioDTO toDTO(UsuarioDTO.UsuarioRegisterDTO usuarioRegisterDTO);
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
