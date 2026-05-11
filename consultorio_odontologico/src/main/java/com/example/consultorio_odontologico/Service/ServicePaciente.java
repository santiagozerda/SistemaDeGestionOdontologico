
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearPacienteDTO;
import com.example.consultorio_odontologico.DTO.DetallePacienteDTO;
import com.example.consultorio_odontologico.DTO.PacienteDTO;
import com.example.consultorio_odontologico.Exceptions.NotFoundException;
import com.example.consultorio_odontologico.Mapper.PacienteMapper;
import com.example.consultorio_odontologico.Model.Paciente;
import com.example.consultorio_odontologico.Repository.RepositoryPaciente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ServicePaciente implements IServicePaciente {

    @Autowired
    private RepositoryPaciente pacienRepo;
    
    @Override
    public PacienteDTO crearPaciente(CrearPacienteDTO paciente) {
        
        Paciente p = PacienteMapper.toEntity(paciente);
        
        Paciente guardar = pacienRepo.save(p);
        
        return PacienteMapper.toDTO(guardar);
    }

    @Override
    public PacienteDTO editarPaciente(Long id, CrearPacienteDTO paciente) {
        
        Paciente p = pacienRepo.findById(id)
                .orElseThrow(() -> new RuntimeException ("Paciente no encontrado"));
        
        p.setNombre(paciente.getNombre());
        p.setApellido(paciente.getApellido());
        p.setDni(paciente.getDni());
        p.setEmail(paciente.getEmail());
        p.setTelefono(paciente.getTelefono());
        p.setCobertura(paciente.getCobertura());
        
        Paciente actualizar = pacienRepo.save(p);
        
        return PacienteMapper.toDTO(actualizar);
    }

    @Override
    public void eliminarPaciente(Long id) {
        if(!pacienRepo.existsById(id))
            throw new NotFoundException("Error, no se puede eliminar un paciente que no existe");
        pacienRepo.deleteById(id);
    }

    @Override
    public List<PacienteDTO> traerPacientes() {
        return pacienRepo.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

    @Override
    public DetallePacienteDTO traerPaciente(Long id) {
        Paciente paciente = pacienRepo.findByIdPaciente(id)
                .orElseThrow(()->  new NotFoundException("Paciente no encontrado"));
        
        return PacienteMapper.toDetalleDTO(paciente);
    }
    
}
