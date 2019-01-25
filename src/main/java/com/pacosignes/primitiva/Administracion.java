package com.pacosignes.primitiva;
import java.util.Random;

public class Administracion {
    private static Random rdn= new Random();








    public static int[] generarApuesta(){

        int[] bombo=new int[49];
        int aleat;
        int[] resultado=new int[6];
        for(int i=0;i<bombo.length;i++){

            bombo[i]=i;
        }

        for(int j=0;j<6;j++){
            aleat = rdn.nextInt(bombo.length-1-j);
            resultado[j]=bombo[aleat];
            bombo[aleat]=bombo[bombo.length-1-j];
        }
        return resultado;

    }
    public static int[] generarReintegro(){

    }

}
