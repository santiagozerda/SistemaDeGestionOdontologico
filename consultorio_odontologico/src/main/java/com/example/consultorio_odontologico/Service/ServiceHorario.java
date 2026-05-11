package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearHorarioDTO;
import com.example.consultorio_odontologico.DTO.HorarioDTO;
import com.example.consultorio_odontologico.Exceptions.NotFoundException;
import com.example.consultorio_odontologico.Mapper.HorarioMapper;
import com.example.consultorio_odontologico.Model.DiaSemana;
import com.example.consultorio_odontologico.Model.Horario;
import com.example.consultorio_odontologico.Model.Odontologo;
import com.example.consultorio_odontologico.Repository.RepositoryHorario;
import com.example.consultorio_odontologico.Repository.RepositoryOdontologo;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceHorario implements IServiceHorario {

    @Autowired
    private RepositoryHorario horaRepo;

    @Autowired
    private RepositoryOdontologo odontoRepo;

    @Override
    public HorarioDTO crearHorario(CrearHorarioDTO horario) {

        //Validamos de crear el horario dentro de un dia laboral
        if (horario.getDiaSemana() == DiaSemana.SABADO || horario.getDiaSemana() == DiaSemana.DOMINGO)
            throw new RuntimeException("No se permiten horarios fines de semana");

        //Validar el rango del horario
        if (horario.getHoraInicio().isAfter(horario.getHoraFin()) || horario.getHoraInicio().equals(horario.getHoraFin()))
            throw new RuntimeException("Rango de horario invalido");

        Odontologo odonto = odontoRepo.findById(horario.getOdontologoID())
                .orElseThrow(() -> new RuntimeException("Odontólogo no encontrado"));

        //Buscamos horarios existentes del mismo dia
        List<Horario> existe = horaRepo.findByOdontologoIdOdontologoAndDiaSemana(odonto.getIdOdontologo(), horario.getDiaSemana());

        //Validamos que no se mezclen los horarios
        for (Horario h : existe) {
            if (seSolapa(horario.getHoraInicio(), horario.getHoraFin(),
                    h.getHoraInicio(), h.getHoraFin())) {
                throw new RuntimeException("Disponibilidad no permitida, los horarios se solapa");
            }
        }

        //Creamos el horario
        Horario hora = Horario.builder()
                .diaSemana(horario.getDiaSemana())
                .horaInicio(horario.getHoraInicio())
                .horaFin(horario.getHoraFin())
                .odontologo(odonto)
                .build();

        return HorarioMapper.toDTO(horaRepo.save(hora));
    }

    @Override
    public HorarioDTO editarHorario(Long id, CrearHorarioDTO horario) {

        Horario hora = horaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no disponible"));

        if (horario.getDiaSemana() == DiaSemana.SABADO || horario.getDiaSemana() == DiaSemana.DOMINGO)
            throw new RuntimeException("No se permiten horarios fines de semana");
        
        if (horario.getHoraInicio().isAfter(horario.getHoraFin())
                || horario.getHoraInicio().equals(horario.getHoraFin())) {
            throw new RuntimeException("Rango de horario invalido");
        }

        Odontologo odonto = hora.getOdontologo();
        
        List<Horario> existentes = horaRepo.findByOdontologoIdOdontologoAndDiaSemana(odonto.getIdOdontologo(), horario.getDiaSemana());

        for (Horario h : existentes) {
            if (!h.getIdHorario().equals(id)
                    && seSolapa(horario.getHoraInicio(), horario.getHoraFin(),
                            h.getHoraInicio(), h.getHoraFin())) {
                throw new RuntimeException("La disponibilidad horaria, se solapa con otra exsitente");
            }
        }

        hora.setDiaSemana(horario.getDiaSemana());
        hora.setHoraInicio(horario.getHoraInicio());
        hora.setHoraFin(horario.getHoraFin());

        Horario actualizar = horaRepo.save(hora);

        return HorarioMapper.toDTO(actualizar);
    }

    @Override
    public void eliminarHorario(Long id) {
        if (!horaRepo.existsById(id)) {
            throw new NotFoundException("No se puede eliminar un horario, no existente");
        }

        horaRepo.deleteById(id);
    }

    @Override
    public List<HorarioDTO> traerHorarioOdontologo(Long odontologoID) {
        return horaRepo.findByOdontologoIdOdontologo(odontologoID)
                .stream()
                .map(HorarioMapper::toDTO)
                .toList();
    }

    private boolean seSolapa(LocalTime inicioNuevo, LocalTime finNuevo,
            LocalTime inicioExistente, LocalTime finExistente) {

        return inicioNuevo.isBefore(finExistente) && finNuevo.isAfter(inicioExistente);
    }

   
}
