
package com.example.consultorio_odontologico.Repository;

import com.example.consultorio_odontologico.Model.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySecretaria extends JpaRepository<Secretaria, Long> {
    
}
