package com.ASST.examenes.apirest.utils;

import java.io.Serializable;

public class AsignacionExamenResponse implements Serializable {

    private int id_alumno;
    private String nombre_alumno;
    private int id_examen;
    private String nombre_examen;
    private String fechaAplicacion;

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public int getId_examen() {
        return id_examen;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public String getNombre_examen() {
        return nombre_examen;
    }

    public void setNombre_examen(String nombre_examen) {
        this.nombre_examen = nombre_examen;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }
}
