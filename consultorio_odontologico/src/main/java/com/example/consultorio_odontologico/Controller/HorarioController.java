
package com.example.consultorio_odontologico.Controller;

import com.example.consultorio_odontologico.DTO.CrearHorarioDTO;
import com.example.consultorio_odontologico.DTO.HorarioDTO;
import com.example.consultorio_odontologico.Service.IServiceHorario;
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
@RequestMapping("/app/horario")
public class HorarioController {
    
    @Autowired
    private IServiceHorario horarioService;
    
    @PostMapping
    public ResponseEntity<HorarioDTO> createHorario(@RequestBody CrearHorarioDTO horario){
        HorarioDTO crear = horarioService.crearHorario(horario);
        return ResponseEntity.created(URI.create("/app/horario/" + crear.getHorarioID())).body(crear);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<HorarioDTO> editHorario(@PathVariable Long id, @RequestBody CrearHorarioDTO horario){
        return ResponseEntity.ok(horarioService.editarHorario(id, horario));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id){
        horarioService.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<HorarioDTO>> getHorariosOdontologo(@PathVariable Long id){
        return ResponseEntity.ok(horarioService.traerHorarioOdontologo(id));
    }
}
