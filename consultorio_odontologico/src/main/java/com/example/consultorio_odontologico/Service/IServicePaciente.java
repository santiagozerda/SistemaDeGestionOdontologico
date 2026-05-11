
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearPacienteDTO;
import com.example.consultorio_odontologico.DTO.DetallePacienteDTO;
import com.example.consultorio_odontologico.DTO.PacienteDTO;
import java.util.List;


public interface IServicePaciente {
    
    public PacienteDTO crearPaciente(CrearPacienteDTO paciente);
    
    public PacienteDTO editarPaciente(Long id, CrearPacienteDTO paciente);
    
    public void eliminarPaciente(Long id);
    
    public List<PacienteDTO> traerPacientes();
    
    public DetallePacienteDTO traerPaciente(Long id);
}
