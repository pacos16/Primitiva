package com.pacosignes.primitiva;

import java.util.GregorianCalendar;

public class Sorteo {
    private int idSorteo;
    private GregorianCalendar fechaSorteo;
    private String fechaString;
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
     * Constructor de sorteo para la base de datos de aciertos.
     * @param linea recibe un vector de strings del documento primitiva.txt
     */
    public Sorteo(String[] linea){
        this.numeros=new int[6];
        this.fechaString=linea[0];
        this.numeros[0]=Integer.parseInt(linea[1]);
        this.numeros[1]=Integer.parseInt(linea[2]);
        this.numeros[2]=Integer.parseInt(linea[3]);
        this.numeros[3]=Integer.parseInt(linea[4]);
        this.numeros[4]=Integer.parseInt(linea[5]);
        this.numeros[5]=Integer.parseInt(linea[6]);
        this.complementario=Integer.parseInt(linea[7]);

    }
    public Sorteo(){

    }

    /**
     * Contructor utilizado en la practiva para generar sorteos aleatorios
     * @param numsMasComplementario array de ints con los 6 numeros mas el complementario
     * @param renitegro  recibe un reintegro (0-9)
     */
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
