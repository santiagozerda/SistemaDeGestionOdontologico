
package com.example.consultorio_odontologico.Repository;

import com.example.consultorio_odontologico.Model.Turno;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTurno extends JpaRepository<Turno, Long>{
    
    List<Turno> findByOdontologoIdOdontologoAndFechaHoraInicioBetween(Long odontologoId, LocalDateTime inicioDia, LocalDateTime finDia);
}
