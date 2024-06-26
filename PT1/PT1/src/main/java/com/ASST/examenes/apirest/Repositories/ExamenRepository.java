package com.ASST.examenes.apirest.Repositories;

import com.ASST.examenes.apirest.Entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
}
