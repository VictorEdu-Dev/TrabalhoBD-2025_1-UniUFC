package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.RefreshToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper {
    TokenInfoDTO.RefreshTokenDTO toDTO(RefreshToken entity);
    RefreshToken toEntity(TokenInfoDTO.RefreshTokenDTO dto);
}
