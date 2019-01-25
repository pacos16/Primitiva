package com.pacosignes.primitiva;
import java.util.Random;
public class Bombo {
    private static Random rdn= new Random();

    public static int[] primitiva(){

        int[] bombo=new int[49];
        int aleat;
        int[] resultado=new int[7];
        for(int i=0;i<bombo.length;i++){

            bombo[i]=i;
        }

        for(int j=0;j<7;j++){
            aleat = rdn.nextInt(bombo.length-1-j);
            resultado[j]=bombo[aleat];
            bombo[aleat]=bombo[bombo.length-1-j];
        }
        return resultado;
    }
    public static int reintegro(){
        return rdn.nextInt(9);
    }

}
