
package com.example.consultorio_odontologico.Repository;

import com.example.consultorio_odontologico.Model.DiaSemana;
import com.example.consultorio_odontologico.Model.Horario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryHorario extends JpaRepository<Horario, Long> {
    
    List<Horario> findByOdontologoIdOdontologoAndDiaSemana(Long id, DiaSemana dia);
    
    //Traer la lista de los horarios de los odontologos
    List<Horario> findByOdontologoIdOdontologo(Long id);
            
}
