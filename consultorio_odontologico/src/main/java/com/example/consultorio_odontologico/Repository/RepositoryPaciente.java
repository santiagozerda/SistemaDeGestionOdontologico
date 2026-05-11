
package com.example.consultorio_odontologico.Repository;

import com.example.consultorio_odontologico.Model.Paciente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPaciente extends JpaRepository<Paciente, Long> {
    
    Optional<Paciente> findByIdPaciente(Long id);
}
