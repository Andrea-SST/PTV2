package com.ASST.examenes.apirest.Controllers;
import com.ASST.examenes.apirest.Entities.EnviarRespuestas;
import com.ASST.examenes.apirest.Repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enviarexamen")

public class EnviarRespuestasController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping
    public List<EnviarRespuestas> obtenerRespuestas() {
        return respuestaRepository.findAll();
    }


    @PostMapping
    public EnviarRespuestas responderExamen(@RequestBody EnviarRespuestas enviarRespuestas) {
        return respuestaRepository.save(enviarRespuestas);
    }


}
