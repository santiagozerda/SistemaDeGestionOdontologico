
package com.example.consultorio_odontologico.DTO;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class DetalleOdontologoDTO {
    
    private Long odontologoID;
    
    private String nombre;
    private String apellido;
    private String especialidad;
    private LocalDate fechaNac;
    private String dni;
    
    private List<TurnoOdontologoDTO> listaTurno;
    private List<HorarioDTO> listaHorario;

    public DetalleOdontologoDTO(Long odontologoID, String nombre, String apellido, String especialidad, LocalDate fechaNac, String dni, List<TurnoOdontologoDTO> listaTurno, List<HorarioDTO> listaHorario) {
        this.odontologoID = odontologoID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.listaTurno = listaTurno;
        this.listaHorario = listaHorario;
    }

    
    public DetalleOdontologoDTO() {
    }
    
    
}
