
package com.example.consultorio_odontologico.Controller;

import com.example.consultorio_odontologico.DTO.CrearOdontologoDTO;
import com.example.consultorio_odontologico.DTO.DetalleOdontologoDTO;
import com.example.consultorio_odontologico.DTO.OdontologoDTO;
import com.example.consultorio_odontologico.Service.IServiceOdontologo;
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
@RequestMapping("/app/odontologo")
public class OdontologoController {
    
    @Autowired
    private IServiceOdontologo odontoService;
    
    @PostMapping
    public ResponseEntity<OdontologoDTO> createOdontologo(@RequestBody CrearOdontologoDTO odonto){
        OdontologoDTO crear = odontoService.crearOdontologo(odonto);
        return ResponseEntity.created(URI.create("/app/odontologo/" + crear.getOdontologoID())).body(crear);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<OdontologoDTO> editOdontologo(@PathVariable Long id, @RequestBody CrearOdontologoDTO odonto){
        return ResponseEntity.ok(odontoService.editarOdontologo(id, odonto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOdontologo(@PathVariable Long id){
        odontoService.eliminarOdontologo(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> getOdontolgos(){
        return ResponseEntity.ok(odontoService.traerOdontologos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalleOdontologoDTO> getOdontologo(@PathVariable Long id){
        return ResponseEntity.ok(odontoService.detalles(id));
    }
    
}
