
package com.example.consultorio_odontologico.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@Entity
public class Secretaria {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idSecretaria;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String dni;

    public Secretaria(Long idSecretaria, String nombre, String apellido, LocalDate fechaNac, String dni) {
        this.idSecretaria = idSecretaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
    }

    public Secretaria() {
    }
    
    

}
