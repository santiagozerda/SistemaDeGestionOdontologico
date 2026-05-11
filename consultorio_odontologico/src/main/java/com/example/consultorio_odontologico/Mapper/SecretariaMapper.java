
package com.example.consultorio_odontologico.Mapper;

import com.example.consultorio_odontologico.DTO.SecretariaDTO;
import com.example.consultorio_odontologico.Model.Secretaria;


public class SecretariaMapper {
    
    public static SecretariaDTO toDTO(Secretaria s){
        
        if(s == null) return null;
        
        return SecretariaDTO.builder()
                .secretariaID(s.getIdSecretaria())
                .nombre(s.getNombre())
                .apellido(s.getApellido())
                .dni(s.getDni())
                .fechaNac(s.getFechaNac())
                .build();
    }
    
    public static Secretaria toEntity(Secretaria s){
        
        if(s==null) return null;
        
        return Secretaria.builder()
                .idSecretaria(s.getIdSecretaria())
                .nombre(s.getNombre())
                .apellido(s.getApellido())
                .dni(s.getDni())
                .fechaNac(s.getFechaNac())
                .build();
    }
}
