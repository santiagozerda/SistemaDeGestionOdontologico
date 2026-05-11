
package com.example.consultorio_odontologico.DTO;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CrearOdontologoDTO {
    
    private String nombre;
    private String apellido;
    private String especialidad;
    private LocalDate fechaNac;
    private String dni;

    public CrearOdontologoDTO(String nombre, String apellido, String especialidad, LocalDate fechaNac, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.fechaNac = fechaNac;
        this.dni = dni;
    }

   

    public CrearOdontologoDTO() {
    }
    
    
}
