package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserBasicMapper.class})
public interface UserBasicMapper {
    UserBasicDTO toDTO(Usuario user);
}
