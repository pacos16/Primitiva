package com.pacosignes.primitiva;

import java.util.GregorianCalendar;

public class Sorteo {
    private int idSorteo;
    private GregorianCalendar fechaSorteo;
    private int[] numeros;
    private int complementario;
    private int reintegro;

    /**
     * Constructor para sorteos Para inicializar la base de datos buena
     * @param idSorteo
     * @param fechaSorteo
     */
    public Sorteo(int idSorteo, GregorianCalendar fechaSorteo) {
        this.idSorteo = idSorteo;
        this.fechaSorteo = fechaSorteo;
    }

    /**
     * Contructor para la practica
     * @param numeros
     * @param complementario
     * @param reintegro
     */
    public Sorteo(int[] numeros, int complementario, int reintegro) {
        this.numeros = numeros;
        this.complementario = complementario;
        this.reintegro = reintegro;
    }
    public Sorteo(int [] numsMasComplementario, int renitegro){
        int i;
        numeros=new int[6];
        for (i =0;i<numeros.length;i++){
            this.numeros[i]=numsMasComplementario[i];
        }
        this.complementario=numsMasComplementario[i];
        this.reintegro=renitegro;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void setComplementario(int complementario) {
        this.complementario = complementario;
    }

    public void setReintegro(int reintegro) {
        this.reintegro = reintegro;
    }

    public int getIdSorteo() {
        return idSorteo;
    }

    public GregorianCalendar getFechaSorteo() {
        return fechaSorteo;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public int getComplementario() {
        return complementario;
    }

    public int getReintegro() {
        return reintegro;
    }
    //todo ordenar
    //todo toString


}
