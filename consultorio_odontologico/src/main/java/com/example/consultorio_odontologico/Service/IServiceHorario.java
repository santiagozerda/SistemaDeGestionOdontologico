
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearHorarioDTO;
import com.example.consultorio_odontologico.DTO.HorarioDTO;
import java.util.List;


public interface IServiceHorario {
    
    public HorarioDTO crearHorario(CrearHorarioDTO horario);
    
    public HorarioDTO editarHorario(Long id, CrearHorarioDTO horario);
    
    public void eliminarHorario(Long id);
    
    public List<HorarioDTO> traerHorarioOdontologo(Long odontologoID);
}
