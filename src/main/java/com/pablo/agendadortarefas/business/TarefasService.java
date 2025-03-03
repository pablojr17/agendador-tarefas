package com.pablo.agendadortarefas.business;

import com.pablo.agendadortarefas.business.dto.TarefasDTO;
import com.pablo.agendadortarefas.business.mapper.TarefasConverter;
import com.pablo.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.pablo.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.pablo.agendadortarefas.infrastructure.security.JwtUtil;
import com.pablo.agendadortarefas.infrastructure.unums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefasEntity(dto);

        return tarefaConverter.paraTarefasDTO(tarefasRepository.save(entity));
    }
}
