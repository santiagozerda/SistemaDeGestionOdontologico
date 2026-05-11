
package com.example.consultorio_odontologico.DTO;

import com.example.consultorio_odontologico.Model.DiaSemana;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CrearHorarioDTO {
    
    private Long odontologoID;
    
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public CrearHorarioDTO(Long odontologoID, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.odontologoID = odontologoID;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    

    public CrearHorarioDTO() {
    }
    
    
}
