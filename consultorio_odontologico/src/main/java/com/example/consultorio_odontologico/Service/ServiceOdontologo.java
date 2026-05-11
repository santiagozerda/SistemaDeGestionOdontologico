
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearOdontologoDTO;
import com.example.consultorio_odontologico.DTO.DetalleOdontologoDTO;
import com.example.consultorio_odontologico.DTO.OdontologoDTO;
import com.example.consultorio_odontologico.Exceptions.NotFoundException;
import com.example.consultorio_odontologico.Mapper.OdontologoMapper;
import com.example.consultorio_odontologico.Model.Odontologo;
import com.example.consultorio_odontologico.Repository.RepositoryOdontologo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceOdontologo implements IServiceOdontologo {

    @Autowired
    private RepositoryOdontologo odontoRepo;
    
    @Override
    public OdontologoDTO crearOdontologo(CrearOdontologoDTO odonto) {
        
        //Creamos el odontologo
        Odontologo odontologo = OdontologoMapper.toEntity(odonto);
        
        //Guardamos
        Odontologo guardar = odontoRepo.save(odontologo);
        
        //Mostramos en pantalla los datos
        return OdontologoMapper.toDTO(guardar);
    }

    @Override
    public OdontologoDTO editarOdontologo(Long id, CrearOdontologoDTO odonto) {
        
        Odontologo odontologo = odontoRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Odontologo no encontrado"));
        
        odontologo.setNombre(odonto.getNombre());
        odontologo.setApellido(odontologo.getApellido());
        odontologo.setEspecialidad(odonto.getEspecialidad());
        
        Odontologo actualizar = odontoRepo.save(odontologo);
        
        return OdontologoMapper.toDTO(actualizar);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        if(!odontoRepo.existsById(id))
            throw new NotFoundException("Error no se puede eliminar un Odontologo que no se creo");
        odontoRepo.deleteById(id);
    }

    @Override
    public List<OdontologoDTO> traerOdontologos() {
        return odontoRepo.findAll()
                .stream()
                .map(OdontologoMapper::toDTO)
                .toList();
    }

    @Override
    public DetalleOdontologoDTO detalles(Long id) {
        
        Odontologo odontologo = odontoRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Odontologo no encontrado"));
        
        return OdontologoMapper.toDetalleDTO(odontologo);
    }
    
}
