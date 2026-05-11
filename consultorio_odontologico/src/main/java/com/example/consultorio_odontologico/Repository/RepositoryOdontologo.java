
package com.example.consultorio_odontologico.Repository;

import com.example.consultorio_odontologico.Model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOdontologo extends JpaRepository<Odontologo, Long> {
    
}
