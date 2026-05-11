package com.example.consultorio_odontologico.Mapper;

import com.example.consultorio_odontologico.DTO.CrearPacienteDTO;
import com.example.consultorio_odontologico.DTO.DetallePacienteDTO;
import com.example.consultorio_odontologico.DTO.PacienteDTO;
import com.example.consultorio_odontologico.Model.Paciente;
import java.util.List;

public class PacienteMapper {

    public static PacienteDTO toDTO(Paciente p) {

        if (p == null) {
            return null;
        }

        return PacienteDTO.builder()
                .pacienteID(p.getIdPaciente())
                .nombre(p.getNombre())
                .apellido(p.getApellido())
                .dni(p.getDni())
                .email(p.getEmail())
                .fechaNac(p.getFechaNac())
                .telefono(p.getTelefono())
                .cobertura(p.getCobertura())
                .build();
    }

    public static DetallePacienteDTO toDetalleDTO(Paciente p) {

        if (p == null) {
            return null;
        }

        return DetallePacienteDTO.builder()
                .pacienteID(p.getIdPaciente())
                .nombre(p.getNombre())
                .apellido(p.getApellido())
                .dni(p.getDni())
                .email(p.getEmail())
                .fechaNac(p.getFechaNac())
                .telefono(p.getTelefono())
                .cobertura(p.getCobertura())
                .listaTurno(p.getListaTurnos() != null
                        ? p.getListaTurnos().stream()
                                .map(TurnoMapper::toPacienteDTO)
                                .toList() : List.of())
                .build();
    }

    public static Paciente toEntity(CrearPacienteDTO p) {

        if (p == null) {
            return null;
        }

        return Paciente.builder()
                .nombre(p.getNombre())
                .apellido(p.getApellido())
                .dni(p.getDni())
                .email(p.getEmail())
                .telefono(p.getTelefono())
                .fechaNac(p.getFechaNac())
                .cobertura(p.getCobertura())
                .build();
    }
}
