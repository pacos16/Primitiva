package com.pacosignes.primitiva;
import java.util.Random;
public class Bombo {
    private static Random rdn= new Random();

    public static Sorteo primitiva(){

        final int CANTIDAD_DE_NUMEROS=49; //define el rango de numeros de la primitiva
        final int NUMEROS_POR_APUESTA=7;  //6+COMPLEMENTARIO
        int[] bombo=new int[CANTIDAD_DE_NUMEROS]; //creamos un bombo
        int aleat;
        int[] resultado=new int[NUMEROS_POR_APUESTA];

        //este bucle rellena el bombo con numeros del 1 al CANTIDAD_DE_NUMEROS
        for(int i=0;i<bombo.length;i++){

            bombo[i]=i+1; //es necesario anyadir 1 para que vaya de 1 a 49;
        }

        for(int j=0;j<NUMEROS_POR_APUESTA;j++){
            aleat = rdn.nextInt((bombo.length-j));//creamos aleatorios cada vez mas pequeños
            resultado[j]=bombo[aleat];
            bombo[aleat]=bombo[bombo.length-1-j];
        }
        resultado=ordenarArray(resultado);
        return new Sorteo(resultado,rdn.nextInt(10));
    }


    /**
     * Metodo de ordenacion.
     * @param array
     * @return
     */
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




}
