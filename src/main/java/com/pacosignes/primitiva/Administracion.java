package com.pacosignes.primitiva;
import java.util.Random;

public class Administracion {
    private static Random rdn= new Random();

    private int codAdmin;



    /**
     * Genera apuesta aletatoria
     * @param rango recibe el numero mayor del sorteo(se supone 1 el menor)
     * @param cantidad cantidad de numeros a los que se apuesta (en nuestro ejemplo son 6);
     * @return Devuelve una apuesta
     */
    public static Apuesta generarApuesta(int rango, int cantidad){

        int[] bombo=new int[rango];
        int aleat;
        int[] resultado=new int[cantidad];
        for(int i=0;i<bombo.length;i++){

            bombo[i]=i+1;
        }

        for(int j=0;j<6;j++){
            aleat = rdn.nextInt(bombo.length-1-j);
            resultado[j]=bombo[aleat];
            bombo[aleat]=bombo[bombo.length-1-j];
        }
        resultado=ordenarArray(resultado);

        return new Apuesta(resultado,rdn.nextInt(10));

    }
    private static int[] ordenarArray(int[] array){
        int aux;
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array.length-i;j++){
                if(j<array.length-1 && array[j]>array[j+1]){
                    aux=array[j];
                    array[j]=array[j+1];
                    array[j+1]=aux;
                }
            }
        }
        return array;
    }

    //metodos simulacion





}
