package com.example.crudandroidspring.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PresionArterial {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("fecha")
    @Expose
    private String fecha;

    @SerializedName("hora")
    @Expose
    private String hora;

    @SerializedName("sistolica")
    @Expose
    private String sistolica;

    @SerializedName("diastolica")
    @Expose
    private String diastolica;

    @SerializedName("pacienteId")
    @Expose
    private int pacienteId;

    public PresionArterial() {

    }

    public PresionArterial(int id, String fecha, String hora, String sistolica, String diastolica, int pacienteId) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.sistolica = sistolica;
        this.diastolica = diastolica;
        this.pacienteId = pacienteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSistolica() {
        return sistolica;
    }

    public void setSistolica(String sistolica) {
        this.sistolica = sistolica;
    }

    public String getDiastolica() {
        return diastolica;
    }

    public void setDiastolica(String diastolica) {
        this.diastolica = diastolica;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
}
