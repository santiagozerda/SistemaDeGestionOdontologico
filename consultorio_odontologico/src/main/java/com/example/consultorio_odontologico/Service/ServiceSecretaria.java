
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearSecretariaDTO;
import com.example.consultorio_odontologico.DTO.SecretariaDTO;
import com.example.consultorio_odontologico.Exceptions.NotFoundException;
import com.example.consultorio_odontologico.Mapper.SecretariaMapper;
import com.example.consultorio_odontologico.Model.Secretaria;
import com.example.consultorio_odontologico.Repository.RepositorySecretaria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ServiceSecretaria implements IServiceSecretaria{

    @Autowired
    private RepositorySecretaria secreRepo;
    
    @Override
    public SecretariaDTO crearSecretaria(CrearSecretariaDTO secretaria) {
        
        Secretaria secre = Secretaria.builder()
                .nombre(secretaria.getNombre())
                .apellido(secretaria.getApellido())
                .dni(secretaria.getDni())
                .fechaNac(secretaria.getFechaNac())
                .build();
        
        return SecretariaMapper.toDTO(secreRepo.save(secre));
    }

    @Override
    public SecretariaDTO editarSecretaria(Long id, CrearSecretariaDTO secretaria) {
        
        Secretaria secre = secreRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Error, no existe una Secretaria con esta ID"));
        
        secre.setNombre(secretaria.getNombre());
        secre.setApellido(secretaria.getApellido());
        secre.setDni(secretaria.getDni());
        secre.setFechaNac(secretaria.getFechaNac());
        
        return SecretariaMapper.toDTO(secreRepo.save(secre));
    }

    @Override
    public List<SecretariaDTO> traerSecretarias() {
        return secreRepo.findAll().stream()
                .map(SecretariaMapper::toDTO)
                .toList();
    }

    @Override
    public SecretariaDTO buscarSecretaria(Long id) {
        Secretaria secre = secreRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Error, no existe una Secretaria con esta ID"));
        return SecretariaMapper.toDTO(secre);
    }
    
    
}
