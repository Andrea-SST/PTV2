package com.ASST.examenes.apirest.Repositories;

import com.ASST.examenes.apirest.Entities.EnviarRespuestas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<EnviarRespuestas, Long> {

}
