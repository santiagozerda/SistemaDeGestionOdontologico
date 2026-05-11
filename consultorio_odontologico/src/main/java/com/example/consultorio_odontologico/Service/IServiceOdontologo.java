
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearOdontologoDTO;
import com.example.consultorio_odontologico.DTO.DetalleOdontologoDTO;
import com.example.consultorio_odontologico.DTO.OdontologoDTO;
import java.util.List;


public interface IServiceOdontologo {
    
    public OdontologoDTO crearOdontologo(CrearOdontologoDTO odonto);
    
    public OdontologoDTO editarOdontologo(Long id, CrearOdontologoDTO odonto);
    
    public void eliminarOdontologo(Long id);
    
    public List<OdontologoDTO> traerOdontologos();
    
    public DetalleOdontologoDTO detalles(Long id);
}
