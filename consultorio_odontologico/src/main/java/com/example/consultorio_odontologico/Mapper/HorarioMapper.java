
package com.example.consultorio_odontologico.Mapper;

import com.example.consultorio_odontologico.DTO.HorarioDTO;
import com.example.consultorio_odontologico.Model.Horario;



public class HorarioMapper {
    
    public static HorarioDTO toDTO(Horario h){
        
        if(h==null) return null;
        
        return HorarioDTO.builder()
                .horarioID(h.getIdHorario())
                .diaSemana(h.getDiaSemana())
                .horaInicio(h.getHoraInicio())
                .horaFin(h.getHoraFin())
                .odontologoID(h.getOdontologo()!= null ? h.getOdontologo().getIdOdontologo() : null)
                .build();
    }
}
