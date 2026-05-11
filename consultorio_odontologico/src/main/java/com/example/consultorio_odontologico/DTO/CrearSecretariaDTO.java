
package com.example.consultorio_odontologico.DTO;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CrearSecretariaDTO {
    
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String dni;

    public CrearSecretariaDTO(String nombre, String apellido, LocalDate fechaNac, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
    }

    public CrearSecretariaDTO() {
    }
    
    
}
