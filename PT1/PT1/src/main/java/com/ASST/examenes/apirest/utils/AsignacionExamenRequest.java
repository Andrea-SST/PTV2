package com.ASST.examenes.apirest.utils;

import java.io.Serializable;

public class AsignacionExamenRequest implements Serializable {

    private int id_examen;
    private String fecha;

    public int getId_examen() {
        return id_examen;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
