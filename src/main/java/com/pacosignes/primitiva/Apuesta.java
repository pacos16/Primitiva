package com.pacosignes.primitiva;

import java.util.GregorianCalendar;

public class Apuesta {

    private int[] numeros;
    private int reintegro;
    private GregorianCalendar fechaApuesta;
    private GregorianCalendar fechaSorteo;

    public enum Premiada {ESPECIAL, PRIMERA, SEGUNDA, TERCERA, CUARTA, NO_PREMIADA}

    private Premiada premio;

    public Apuesta(int[] numeros, int reintegro) {
        this.numeros = numeros;
        this.reintegro = reintegro;
    }

    public Apuesta(int[] numeros, int reintegro, GregorianCalendar fechaApuesta, GregorianCalendar fechaSorteo) {
        this.numeros = numeros;
        this.reintegro = reintegro;
        this.fechaApuesta = fechaApuesta;
        this.fechaSorteo = fechaSorteo;
    }

    public void setPremio(Premiada premio) {
        this.premio = premio;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public int getReintegro() {
        return reintegro;
    }

    public GregorianCalendar getFechaApuesta() {
        return fechaApuesta;
    }

    public GregorianCalendar getFechaSorteo() {
        return fechaSorteo;
    }

    public Premiada getPremio() {
        return premio;
    }
    //todo tostring
    //todo ordenar


}
