
package com.example.consultorio_odontologico.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Builder
public class Paciente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idPaciente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private LocalDate fechaNac;
    
    @Enumerated(EnumType.STRING)
    private TipoCobertura cobertura;
    
    @OneToMany(mappedBy ="paciente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(Long idPaciente, String nombre, String apellido, String dni, String telefono, String email, LocalDate fechaNac, TipoCobertura cobertura, List<Turno> listaTurnos) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.cobertura = cobertura;
        this.listaTurnos = listaTurnos;
    }

    

    
}
