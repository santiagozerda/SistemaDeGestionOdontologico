
package com.example.consultorio_odontologico.DTO;

import com.example.consultorio_odontologico.Model.TipoCobertura;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Builder
public class DetallePacienteDTO {
    
    private Long pacienteID;
    
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private LocalDate fechaNac;
    
    private TipoCobertura cobertura;
    
    private List<TurnoPacienteDTO> listaTurno;

    public DetallePacienteDTO(Long pacienteID, String nombre, String apellido, String dni, String telefono, String email, LocalDate fechaNac, TipoCobertura cobertura, List<TurnoPacienteDTO> listaTurno) {
        this.pacienteID = pacienteID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.cobertura = cobertura;
        this.listaTurno = listaTurno;
    }

   
    public DetallePacienteDTO() {
    }
    
    
}
