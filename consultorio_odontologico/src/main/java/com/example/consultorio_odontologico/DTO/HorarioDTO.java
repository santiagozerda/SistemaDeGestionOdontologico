
package com.example.consultorio_odontologico.DTO;

import com.example.consultorio_odontologico.Model.DiaSemana;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class HorarioDTO {
    
    private Long horarioID;
    
    private DiaSemana diaSemana;
    
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    private Long odontologoID;

    public HorarioDTO() {
    }

    public HorarioDTO(Long horarioID, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin, Long odontologoID) {
        this.horarioID = horarioID;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.odontologoID = odontologoID;
    }

    
    
}
