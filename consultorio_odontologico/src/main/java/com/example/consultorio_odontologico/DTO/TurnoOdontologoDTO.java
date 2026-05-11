
package com.example.consultorio_odontologico.DTO;

import com.example.consultorio_odontologico.Model.EstadoAtencion;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class TurnoOdontologoDTO {
    
    private Long turnoId;
    
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    
    private Long pacienteId;
    private String nombrePaciente;
    
    private EstadoAtencion estadoAtencion;

    public TurnoOdontologoDTO(Long turnoId, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Long pacienteId, String nombrePaciente, EstadoAtencion estadoAtencion) {
        this.turnoId = turnoId;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.pacienteId = pacienteId;
        this.nombrePaciente = nombrePaciente;
        this.estadoAtencion = estadoAtencion;
    }

   
    public TurnoOdontologoDTO() {
    }
    
    
}
