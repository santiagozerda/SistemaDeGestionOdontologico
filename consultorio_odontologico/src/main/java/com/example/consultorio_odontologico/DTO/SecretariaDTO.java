
package com.example.consultorio_odontologico.DTO;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class SecretariaDTO {
    
    private Long secretariaID;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String dni;

    public SecretariaDTO(Long secretariaID, String nombre, String apellido, LocalDate fechaNac, String dni) {
        this.secretariaID = secretariaID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
    }

    public SecretariaDTO() {
    }
    
    
}
