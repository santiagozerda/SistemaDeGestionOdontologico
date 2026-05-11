
package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearSecretariaDTO;
import com.example.consultorio_odontologico.DTO.SecretariaDTO;
import java.util.List;


public interface IServiceSecretaria {
    
    public SecretariaDTO crearSecretaria(CrearSecretariaDTO secretaria);
    
    public SecretariaDTO editarSecretaria(Long id, CrearSecretariaDTO secretaria);
    
    public List<SecretariaDTO> traerSecretarias();
    
    public SecretariaDTO buscarSecretaria(Long id);
}
