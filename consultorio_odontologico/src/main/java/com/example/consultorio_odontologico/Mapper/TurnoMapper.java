
package com.example.consultorio_odontologico.Mapper;


import com.example.consultorio_odontologico.DTO.TurnoDTO;
import com.example.consultorio_odontologico.DTO.TurnoOdontologoDTO;
import com.example.consultorio_odontologico.DTO.TurnoPacienteDTO;
import com.example.consultorio_odontologico.Model.Turno;


public class TurnoMapper {
    
    public static TurnoDTO toDTO(Turno t){
        
        if(t==null) return null;
        
        return TurnoDTO.builder()
                .turnoID(t.getIdTurno())
                .fechaHoraInicio(t.getFechaHoraInicio())
                .fechaHoraFin(t.getFechaHoraFin())
                .estadoAgenda(t.getEstadoAgenda())
                .estadoAtencion(t.getEstadoAtencion())
                
                //Datos del paciente
                .pacienteID(t.getPaciente().getIdPaciente())
                .nombrePaciente(t.getPaciente().getNombre())
                
                //Datos del Odontologo
                .odontologoID(t.getOdontologo().getIdOdontologo())
                .nombreOdontologo(t.getOdontologo().getNombre())
                .build();
    }
    
    
    public static TurnoPacienteDTO toPacienteDTO(Turno t){
        
        if(t == null) return null;
        
        return TurnoPacienteDTO.builder()
                .turnoId(t.getIdTurno())
                .odontologoID(t.getOdontologo().getIdOdontologo())
                .nombreOdontologo(t.getOdontologo().getNombre())
                .fechaHoraInicio(t.getFechaHoraInicio())
                .fechaHoraFin(t.getFechaHoraFin())
                .estadoAgenda(t.getEstadoAgenda())
                .build();
    }
    
    public static TurnoOdontologoDTO toOdontologoDTO(Turno t){
    
        if(t==null) return null;
        
        return TurnoOdontologoDTO.builder()
                .turnoId(t.getIdTurno())
                .fechaHoraInicio(t.getFechaHoraInicio())
                .fechaHoraFin(t.getFechaHoraFin())
                .pacienteId(t.getPaciente().getIdPaciente())
                .nombrePaciente(t.getPaciente().getNombre())
                .estadoAtencion(t.getEstadoAtencion())
                .build();
    }
    
}
