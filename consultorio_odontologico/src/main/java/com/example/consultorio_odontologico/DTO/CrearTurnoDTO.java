
package com.example.consultorio_odontologico.DTO;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CrearTurnoDTO {
    
    private Long pacienteID;
    private Long odontologoID;
    
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    public CrearTurnoDTO() {
    }

    public CrearTurnoDTO(Long pacienteID, Long odontologoID, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.pacienteID = pacienteID;
        this.odontologoID = odontologoID;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }
    
    
}
