
package com.example.consultorio_odontologico.Controller;

import com.example.consultorio_odontologico.DTO.CrearPacienteDTO;
import com.example.consultorio_odontologico.DTO.DetallePacienteDTO;
import com.example.consultorio_odontologico.DTO.PacienteDTO;
import com.example.consultorio_odontologico.Service.IServicePaciente;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/paciente")
public class PacienteController {
    
    @Autowired
    private IServicePaciente pacienService;
    
    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody CrearPacienteDTO paciente){
        PacienteDTO crear = pacienService.crearPaciente(paciente);
        return ResponseEntity.created(URI.create("/app/paciente/"+crear.getPacienteID())).body(crear);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> editPaciente(@PathVariable Long id, @RequestBody CrearPacienteDTO paciente){
        return ResponseEntity.ok(pacienService.editarPaciente(id, paciente));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id){
        pacienService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getPacientes(){
        return ResponseEntity.ok(pacienService.traerPacientes());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetallePacienteDTO> getDetalles(@PathVariable Long id){
        return ResponseEntity.ok(pacienService.traerPaciente(id));
    }
}
