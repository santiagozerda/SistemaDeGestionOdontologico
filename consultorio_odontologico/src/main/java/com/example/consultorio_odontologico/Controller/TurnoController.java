
package com.example.consultorio_odontologico.Controller;

import com.example.consultorio_odontologico.DTO.CrearTurnoDTO;
import com.example.consultorio_odontologico.DTO.TurnoDTO;
import com.example.consultorio_odontologico.Service.IServiceTurno;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/turno")
public class TurnoController {
    
    @Autowired
    private IServiceTurno turnoService;
    
    @PostMapping
    public ResponseEntity<TurnoDTO> createTurno(@RequestBody CrearTurnoDTO turno){
        TurnoDTO crear = turnoService.crearTurno(turno);
        return ResponseEntity.created(URI.create("/app/turno/" + crear.getTurnoID())).body(crear);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> editTurno(@PathVariable Long id, @RequestBody CrearTurnoDTO turno){
        return ResponseEntity.ok(turnoService.editarTurno(id, turno));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> getTurnos(){
        return ResponseEntity.ok(turnoService.traerTurnos());
    }
    
    //Acciones de la Secretaria
    @PatchMapping("/{id}/confirmar")
    public ResponseEntity<TurnoDTO> confirmarTurno(@PathVariable Long id, @RequestParam Long secretariaId){
        return ResponseEntity.ok(turnoService.confirmarTurno(id, secretariaId));
    }
    
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<TurnoDTO> cancelarTurno(@PathVariable Long id, @RequestParam Long secretariaId){
        return ResponseEntity.ok(turnoService.cancelarTurno(id, secretariaId));
    }
    
    //Acciones del Odontologo
    @PatchMapping("/{id}/atendido")
    public ResponseEntity<TurnoDTO> atenderTurno(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.marcarAtendido(id));
    }
    
    @PatchMapping("/{id}/ausente")
    public ResponseEntity<TurnoDTO> turnoAusente(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.marcarAusente(id));
    }
}
