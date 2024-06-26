package com.ASST.examenes.apirest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pregunta;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_respuesta_a")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Respuesta respuestaA;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_respuesta_b")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Respuesta respuestaB;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_respuesta_c")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Respuesta respuestaC;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_respuesta_d")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Respuesta respuestaD;

    private int puntaje;

    public String getRespuesta_Correcta() {
        return respuesta_Correcta;
    }

    public void setRespuesta_Correcta(String respuesta_Correcta) {
        this.respuesta_Correcta = respuesta_Correcta;
    }

    private String respuesta_Correcta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Respuesta getRespuestaA() {
        return respuestaA;
    }

    public void setRespuestaA(Respuesta respuestaA) {
        this.respuestaA = respuestaA;
    }

    public Respuesta getRespuestaB() {
        return respuestaB;
    }

    public void setRespuestaB(Respuesta respuestaB) {
        this.respuestaB = respuestaB;
    }

    public Respuesta getRespuestaC() {
        return respuestaC;
    }

    public void setRespuestaC(Respuesta respuestaC) {
        this.respuestaC = respuestaC;
    }

    public Respuesta getRespuestaD() {
        return respuestaD;
    }

    public void setRespuestaD(Respuesta respuestaD) {
        this.respuestaD = respuestaD;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
