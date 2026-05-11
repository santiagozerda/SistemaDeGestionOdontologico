
package com.example.consultorio_odontologico.DTO;

import com.example.consultorio_odontologico.Model.EstadoAgenda;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class TurnoPacienteDTO {
 
    private Long turnoId;
    
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    
    private Long odontologoID;
    private String nombreOdontologo;
    
    private EstadoAgenda estadoAgenda;

    public TurnoPacienteDTO(Long turnoId, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Long odontologoID, String nombreOdontologo, EstadoAgenda estadoAgenda) {
        this.turnoId = turnoId;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.odontologoID = odontologoID;
        this.nombreOdontologo = nombreOdontologo;
        this.estadoAgenda = estadoAgenda;
    }

    

    public TurnoPacienteDTO() {
    }
}
