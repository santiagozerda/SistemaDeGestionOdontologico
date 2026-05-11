package com.example.consultorio_odontologico.Service;

import com.example.consultorio_odontologico.DTO.CrearTurnoDTO;
import com.example.consultorio_odontologico.DTO.TurnoDTO;
import com.example.consultorio_odontologico.Exceptions.NotFoundException;
import com.example.consultorio_odontologico.Mapper.TurnoMapper;
import com.example.consultorio_odontologico.Model.DiaSemana;
import com.example.consultorio_odontologico.Model.EstadoAgenda;
import com.example.consultorio_odontologico.Model.EstadoAtencion;
import com.example.consultorio_odontologico.Model.Horario;
import com.example.consultorio_odontologico.Model.Odontologo;
import com.example.consultorio_odontologico.Model.Paciente;
import com.example.consultorio_odontologico.Model.Secretaria;
import com.example.consultorio_odontologico.Model.Turno;
import com.example.consultorio_odontologico.Repository.RepositoryHorario;
import com.example.consultorio_odontologico.Repository.RepositoryOdontologo;
import com.example.consultorio_odontologico.Repository.RepositoryPaciente;
import com.example.consultorio_odontologico.Repository.RepositorySecretaria;
import com.example.consultorio_odontologico.Repository.RepositoryTurno;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceTurno implements IServiceTurno {

    @Autowired
    private RepositoryTurno turnoRepo;

    @Autowired
    private RepositoryOdontologo odontoRepo;

    @Autowired
    private RepositoryPaciente pacienRepo;

    @Autowired
    private RepositoryHorario horaRepo;

    @Autowired
    private RepositorySecretaria secreRepo;

    @Override
    public TurnoDTO crearTurno(CrearTurnoDTO turno) {

        validarFecha(turno.getFechaHoraInicio(), turno.getFechaHoraFin());
        validarNoPasado(turno.getFechaHoraInicio());

        Odontologo odonto = odontoRepo.findById(turno.getOdontologoID())
                .orElseThrow(() -> new RuntimeException("Odontologo no encontrado"));

        Paciente pacien = pacienRepo.findById(turno.getPacienteID())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        validarHorarioOdontologo(turno, odonto);
        validarSolapamiento(turno, odonto, null);
        
        Turno tur = Turno.builder()
                .paciente(pacien)
                .odontologo(odonto)
                .fechaHoraInicio(turno.getFechaHoraInicio())
                .fechaHoraFin(turno.getFechaHoraFin())
                .estadoAgenda(EstadoAgenda.PENDIENTE)
                .estadoAtencion(EstadoAtencion.PENDIENTE)
                .build();

        return TurnoMapper.toDTO(turnoRepo.save(tur));
    }

    @Override
    public TurnoDTO editarTurno(Long id, CrearTurnoDTO turno) {

        Turno tur = turnoRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Turno no encontrado"));

        if (tur.getEstadoAgenda() != EstadoAgenda.PENDIENTE || tur.getEstadoAtencion() != EstadoAtencion.PENDIENTE) {
            throw new NotFoundException("Solo se puede modificar turno PENDIENTES");
        }

        validarFecha(turno.getFechaHoraInicio(), turno.getFechaHoraFin());
        validarNoPasado(turno.getFechaHoraInicio());

        Odontologo odonto = odontoRepo.findById(turno.getOdontologoID())
                .orElseThrow(() -> new RuntimeException("Odontologo no encontrado"));

        Paciente pacien = pacienRepo.findById(turno.getPacienteID())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        validarHorarioOdontologo(turno, odonto);
        validarSolapamiento(turno, odonto, id);

        tur.setPaciente(pacien);
        tur.setOdontologo(odonto);
        tur.setFechaHoraInicio(turno.getFechaHoraInicio());
        tur.setFechaHoraFin(turno.getFechaHoraFin());

        return TurnoMapper.toDTO(turnoRepo.save(tur));
    }

    @Override
    public void eliminarTurno(Long id) {

        Turno turno = turnoRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("No se puede eliminar un turno que no existe"));

        if (turno.getEstadoAgenda() == EstadoAgenda.CONFIRMADO
                || turno.getEstadoAtencion() == EstadoAtencion.ATENDIDO) {
            throw new RuntimeException("No se puede eliminar el Turno");
        }

        turnoRepo.deleteById(id);
    }

    @Override
    public List<TurnoDTO> traerTurnos() {
        return turnoRepo.findAll()
                .stream()
                .map(TurnoMapper::toDTO)
                .toList();
    }

    @Override
    public TurnoDTO confirmarTurno(Long id, Long idSecretaria) {

        Turno turno = turnoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        if (turno.getEstadoAgenda() != EstadoAgenda.PENDIENTE) {
            throw new NotFoundException("Solo se puede confirmar el turno en estado PENDIENTE");
        }

        validarNoPasado(turno.getFechaHoraInicio());

        Secretaria secre = secreRepo.findById(idSecretaria)
                .orElseThrow(() -> new NotFoundException("Secretaria no encontrada"));

        turno.setEstadoAgenda(EstadoAgenda.CONFIRMADO);
        turno.setSecretariaConfirmacion(secre);

        return TurnoMapper.toDTO(turnoRepo.save(turno));
    }

    @Override
    public TurnoDTO cancelarTurno(Long id, Long idSecretaria) {

        Turno turno = turnoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        if (turno.getEstadoAgenda() == EstadoAgenda.CANCELADO
                || turno.getEstadoAtencion() == EstadoAtencion.ATENDIDO) {
            throw new NotFoundException("Error, no se puede cancelar el turno");
        }

        validarNoPasado(turno.getFechaHoraInicio());

        Secretaria secre = secreRepo.findById(idSecretaria)
                .orElseThrow(() -> new NotFoundException("Secretaria no encontrada"));

        turno.setEstadoAgenda(EstadoAgenda.CANCELADO);
        turno.setSecretariaCancelacion(secre);

        return TurnoMapper.toDTO(turnoRepo.save(turno));
    }

    @Override
    public TurnoDTO marcarAtendido(Long id) {

        Turno turno = turnoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        if (turno.getEstadoAgenda() != EstadoAgenda.CONFIRMADO) {
            throw new NotFoundException("El turno debe estar CONFIRMADO primero");
        }

        if (turno.getEstadoAtencion() != EstadoAtencion.PENDIENTE) {
            throw new NotFoundException("Error, el turno ya fue ATENDIDO");
        }

        if (turno.getFechaHoraInicio().isAfter(LocalDateTime.now())) {
            throw new NotFoundException("Solo se puede marcar como ATENDIDO un turno que aun no haya ocurrido");
        }

        turno.setEstadoAtencion(EstadoAtencion.ATENDIDO);

        return TurnoMapper.toDTO(turnoRepo.save(turno));
    }

    @Override
    public TurnoDTO marcarAusente(Long id) {

        Turno turno = turnoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        if (turno.getEstadoAgenda() != EstadoAgenda.CONFIRMADO) {
            throw new NotFoundException("El turno debe estar CONFIRMADO");
        }

        if (turno.getEstadoAtencion() != EstadoAtencion.PENDIENTE) {
            throw new NotFoundException("Solo se puede marcar AUSENTE un turno PENDIENTE");
        }

        if (turno.getFechaHoraInicio().isAfter(LocalDateTime.now())) {
            throw new NotFoundException("No se puede atender un turno futuro");
        }

        turno.setEstadoAtencion(EstadoAtencion.AUSENTE);

        return TurnoMapper.toDTO(turnoRepo.save(turno));
    }

    //Metodos Reutilizables
    private DiaSemana convertirDia(DayOfWeek dia) {
        return switch (dia) {
            case MONDAY ->
                DiaSemana.LUNES;
            case TUESDAY ->
                DiaSemana.MARTES;
            case WEDNESDAY ->
                DiaSemana.MIERCOLES;
            case THURSDAY ->
                DiaSemana.JUEVES;
            case FRIDAY ->
                DiaSemana.VIERNES;
            // Sábado y Domingo nunca llegan aquí, se cortan antes
            default ->
                throw new RuntimeException("Día no laborable");
        };
    }

    private boolean seSolapa(LocalDateTime inicioNuevo, LocalDateTime finNuevo,
            LocalDateTime inicioExistente, LocalDateTime finExistente) {

        return inicioNuevo.isBefore(finExistente) && finNuevo.isAfter(inicioExistente);
    }

    private void validarFecha(LocalDateTime inicio, LocalDateTime fin) {
        if (!inicio.isBefore(fin)) {
            throw new RuntimeException("La fecha de inicio debe ser anterior a la de fin");
        }

        DayOfWeek dia = inicio.getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
            throw new RuntimeException("No se permiten turnos fines de semana");
        }
    }

    private void validarNoPasado(LocalDateTime fecha) {
        if (fecha.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("No se puede operar con turnos en el pasado");
        }
    }

    private void validarHorarioOdontologo(CrearTurnoDTO turno, Odontologo odonto) {

        DiaSemana dia = convertirDia(turno.getFechaHoraInicio().getDayOfWeek());

        List<Horario> horarios = horaRepo
                .findByOdontologoIdOdontologoAndDiaSemana(odonto.getIdOdontologo(), dia);

        if (horarios.isEmpty()) {
            throw new RuntimeException("El odontologo no tiene horarios definidos");
        }

        LocalTime inicio = turno.getFechaHoraInicio().toLocalTime();
        LocalTime fin = turno.getFechaHoraFin().toLocalTime();

        boolean valido = horarios.stream()
                .anyMatch(h
                        -> !inicio.isBefore(h.getHoraInicio())
                && !fin.isAfter(h.getHoraFin())
                );

        if (!valido) {
            throw new RuntimeException("Turno fuera del horario del odontologo");
        }
    }

    private void validarSolapamiento(CrearTurnoDTO turno, Odontologo odonto, Long turnoId) {

        LocalDate fecha = turno.getFechaHoraInicio().toLocalDate();

        LocalDateTime inicioDia = fecha.atStartOfDay();
        LocalDateTime finDia = fecha.atTime(23, 59, 59);

        List<Turno> turnos = turnoRepo
                .findByOdontologoIdOdontologoAndFechaHoraInicioBetween(
                        odonto.getIdOdontologo(),
                        inicioDia,
                        finDia
                );

        for (Turno t : turnos) {

            if (turnoId != null && t.getIdTurno().equals(turnoId)) {
                continue;
            }

            if (seSolapa(
                    turno.getFechaHoraInicio(),
                    turno.getFechaHoraFin(),
                    t.getFechaHoraInicio(),
                    t.getFechaHoraFin())) {

                throw new RuntimeException("Ya existe un turno en ese horario");
            }
        }
    }
}
