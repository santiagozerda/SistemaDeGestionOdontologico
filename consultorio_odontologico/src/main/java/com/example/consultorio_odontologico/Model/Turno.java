
package com.example.consultorio_odontologico.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Builder
public class Turno {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idTurno;
    
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "idOdontologo")
    private Odontologo odontologo;
    
    //Secretaria que confirmo el turno
    @ManyToOne
    private Secretaria secretariaConfirmacion;
    
    //Secretaria que cancelo el turno
    @ManyToOne
    private Secretaria secretariaCancelacion;
    
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    
    //Secretaria
    @Enumerated(EnumType.STRING)
    private EstadoAgenda estadoAgenda;
    
    //Odontologo
    @Enumerated(EnumType.STRING)
    private EstadoAtencion estadoAtencion;
    
    @Enumerated(EnumType.STRING)
    private TipoCobertura tipoCobertura;

    public Turno(Long idTurno, Paciente paciente, Odontologo odontologo, Secretaria secretariaConfirmacion, Secretaria secretariaCancelacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, EstadoAgenda estadoAgenda, EstadoAtencion estadoAtencion, TipoCobertura tipoCobertura) {
        this.idTurno = idTurno;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.secretariaConfirmacion = secretariaConfirmacion;
        this.secretariaCancelacion = secretariaCancelacion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.estadoAgenda = estadoAgenda;
        this.estadoAtencion = estadoAtencion;
        this.tipoCobertura = tipoCobertura;
    }

    public Turno() {
    }
    
    
}
