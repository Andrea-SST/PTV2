package com.ASST.examenes.apirest.Controllers;

import com.ASST.examenes.apirest.Entities.Alumno;
import com.ASST.examenes.apirest.Entities.Examen;
import com.ASST.examenes.apirest.Repositories.AlumnoRepository;
import com.ASST.examenes.apirest.Repositories.ExamenRepository;
import com.ASST.examenes.apirest.utils.AsignacionExamenRequest;
import com.ASST.examenes.apirest.utils.AsignacionExamenResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/examen")
public class ExamenController {

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @PostMapping
    public Examen createExamen(@RequestBody Examen examen) {
        return examenRepository.save(examen);
    }

    @PostMapping("/asignar")
    @Transactional
    public List<AsignacionExamenResponse> asignarExamen(@RequestBody AsignacionExamenRequest request) {
        List<AsignacionExamenResponse> responses = new ArrayList<>();

        LocalDateTime ldt = LocalDateTime.parse(request.getFecha(), DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId bogotaZoneId = ZoneId.of("America/Bogota");
        System.out.println("TimeZone : " + bogotaZoneId);

        ZonedDateTime bogotaZonedDateTime = ldt.atZone(bogotaZoneId);
        System.out.println("Date (Bogota) : " + bogotaZonedDateTime);

        List<Alumno> alumnos = alumnoRepository.findAll();
        Examen examen = examenRepository.getReferenceById((long)request.getId_examen());

        alumnos.forEach(alumno -> {
            AsignacionExamenResponse alumnoResponse = new AsignacionExamenResponse();

            ZoneId alumnoZoneId = ZoneId.of(alumno.getTimezone());
            System.out.println("TimeZone : " + alumnoZoneId);

            ZonedDateTime nyDateTime = bogotaZonedDateTime.withZoneSameInstant(alumnoZoneId);
            System.out.println("Date (Alumno) : " + nyDateTime);

            DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);

            alumnoRepository.asignarExamenAlumno(alumno.getId(), format.format(nyDateTime), (long) request.getId_examen());

            alumnoResponse.setId_alumno(alumno.getId().intValue());
            alumnoResponse.setNombre_alumno(alumno.getNombre());
            alumnoResponse.setId_examen(request.getId_examen());
            alumnoResponse.setNombre_examen(examen.getNombre());
            alumnoResponse.setFechaAplicacion(format.format(nyDateTime));

            responses.add(alumnoResponse);
        });

        return responses;
    }
}
