
package com.example.consultorio_odontologico.Mapper;

import com.example.consultorio_odontologico.DTO.CrearOdontologoDTO;
import com.example.consultorio_odontologico.DTO.DetalleOdontologoDTO;
import com.example.consultorio_odontologico.DTO.OdontologoDTO;
import com.example.consultorio_odontologico.Model.Odontologo;
import java.time.LocalDateTime;
import java.util.List;


public class OdontologoMapper {
    
    public static OdontologoDTO toDTO(Odontologo o){
        
        if(o==null) return null;
        
        return OdontologoDTO.builder()
                .odontologoID(o.getIdOdontologo())
                .nombre(o.getNombre())
                .apellido(o.getApellido())
                .especialidad(o.getEspecialidad())
                .dni(o.getDni())
                .fechaNac(o.getFechaNac())
                .build();
    }
    
    public static DetalleOdontologoDTO toDetalleDTO(Odontologo o){
        
        if(o==null) return null;
        
        return DetalleOdontologoDTO.builder()
                .odontologoID(o.getIdOdontologo())
                .nombre(o.getNombre())
                .apellido(o.getApellido())
                .especialidad(o.getEspecialidad())
                .fechaNac(o.getFechaNac())
                .dni(o.getDni())
                .listaHorario(o.getListaHorario() != null 
                        ? o.getListaHorario().stream()
                        .map(HorarioMapper::toDTO)
                        .toList()
                        : List.of()                        
                )
                .listaTurno(o.getListaTurnos().stream()
                        .filter(t-> t.getFechaHoraInicio().isAfter(LocalDateTime.now()))
                        .map(TurnoMapper::toOdontologoDTO)
                        .toList()
                ).build();
    }
    
    public static Odontologo toEntity(CrearOdontologoDTO o){
        
        if(o==null) return null;
        
        return Odontologo.builder()
                .nombre(o.getNombre())
                .apellido(o.getApellido())
                .especialidad(o.getEspecialidad())
                .fechaNac(o.getFechaNac())
                .dni(o.getDni())
                .build();
    }
}
