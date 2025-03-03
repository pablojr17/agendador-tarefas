package com.pablo.agendadortarefas.business.mapper;

import com.pablo.agendadortarefas.business.dto.TarefasDTO;
import com.pablo.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {
    TarefasEntity paraTarefasEntity(TarefasDTO dto);

    TarefasDTO paraTarefasDTO(TarefasEntity entity);
}
