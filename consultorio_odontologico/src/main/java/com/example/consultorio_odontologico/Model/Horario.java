
package com.example.consultorio_odontologico.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Builder
public class Horario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idHorario;
    
    @ManyToOne
    @JoinColumn(name="idOdontologo")
    private Odontologo odontologo;
    
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;
    
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(Long idHorario, Odontologo odontologo, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.idHorario = idHorario;
        this.odontologo = odontologo;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    

    public Horario() {
    }
    
    
}
