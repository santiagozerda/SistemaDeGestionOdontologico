
package com.example.consultorio_odontologico.DTO;

import com.example.consultorio_odontologico.Model.EstadoAgenda;
import com.example.consultorio_odontologico.Model.EstadoAtencion;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class TurnoDTO {
    
    private Long turnoID;
    
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    
    //Datos del Paciente
    private Long pacienteID;
    private String nombrePaciente;
    
    //Datos del Odontologo
    private Long odontologoID;
    private String nombreOdontologo;

    private EstadoAtencion estadoAtencion;
    private EstadoAgenda estadoAgenda;

    public TurnoDTO(Long turnoID, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Long pacienteID, String nombrePaciente, Long odontologoID, String nombreOdontologo, EstadoAtencion estadoAtencion, EstadoAgenda estadoAgenda) {
        this.turnoID = turnoID;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.pacienteID = pacienteID;
        this.nombrePaciente = nombrePaciente;
        this.odontologoID = odontologoID;
        this.nombreOdontologo = nombreOdontologo;
        this.estadoAtencion = estadoAtencion;
        this.estadoAgenda = estadoAgenda;
    }
    
    public TurnoDTO() {
    }
    
    
}
