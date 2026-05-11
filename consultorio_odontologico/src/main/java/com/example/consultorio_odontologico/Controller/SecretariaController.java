
package com.example.consultorio_odontologico.Controller;

import com.example.consultorio_odontologico.DTO.CrearSecretariaDTO;
import com.example.consultorio_odontologico.DTO.SecretariaDTO;
import com.example.consultorio_odontologico.Service.IServiceSecretaria;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/secretaria")
public class SecretariaController {
    
    @Autowired
    private IServiceSecretaria secreService;
    
    @PostMapping
    public ResponseEntity<SecretariaDTO> createSecretaria(@RequestBody CrearSecretariaDTO secretaria){
        SecretariaDTO crear = secreService.crearSecretaria(secretaria);
        return ResponseEntity.created(URI.create("/app/secretaria" + crear.getSecretariaID())).body(crear);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SecretariaDTO> editSecretaria(@PathVariable Long id, @RequestBody CrearSecretariaDTO secretaria){
        return ResponseEntity.ok(secreService.editarSecretaria(id, secretaria));
    }
    
    @GetMapping
    public ResponseEntity<List<SecretariaDTO>> getSecretarias(){
        return ResponseEntity.ok(secreService.traerSecretarias());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SecretariaDTO> findSecretaria(@PathVariable Long id){
        return ResponseEntity.ok(secreService.buscarSecretaria(id));
    }
}
