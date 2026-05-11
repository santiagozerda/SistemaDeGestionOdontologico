
package com.example.consultorio_odontologico.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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

@Getter @Setter
@Entity
@Builder
public class Odontologo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idOdontologo;
    
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String dni;
    
    private String especialidad;
    
    @OneToMany(mappedBy="odontologo", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Turno> listaTurnos;
    
    @OneToMany(mappedBy="odontologo")
    private List<Horario> listaHorario;

    public Odontologo() {
    }

    public Odontologo(Long idOdontologo, String nombre, String apellido, LocalDate fechaNac, String dni, String especialidad, List<Turno> listaTurnos, List<Horario> listaHorario) {
        this.idOdontologo = idOdontologo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.listaHorario = listaHorario;
    }

    
    
}
