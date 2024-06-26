package com.ASST.examenes.apirest.Repositories;
import com.ASST.examenes.apirest.Entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    @Query("update Alumno a set a.fecha_presentacion = ?2, a.examen.id = ?3 where a.id =  ?1")
    @Modifying
    void asignarExamenAlumno(Long id_alumno, String fecha, Long id_examen);
}
