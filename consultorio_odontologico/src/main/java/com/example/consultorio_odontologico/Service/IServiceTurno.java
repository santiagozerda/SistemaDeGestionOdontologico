
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearTurnoDTO;
import com.example.consultorio_odontologico.DTO.TurnoDTO;
import java.util.List;


public interface IServiceTurno {
    
    public TurnoDTO crearTurno(CrearTurnoDTO turno);
    
    public TurnoDTO editarTurno(Long id, CrearTurnoDTO turno);
    
    public void eliminarTurno(Long id);
    
    public List<TurnoDTO> traerTurnos();
    
    public TurnoDTO confirmarTurno(Long id, Long idSecretaria);
    
    public TurnoDTO cancelarTurno(Long id, Long idSecretaria);
    
    public TurnoDTO marcarAtendido(Long id);
    
    public TurnoDTO marcarAusente(Long id);
}
