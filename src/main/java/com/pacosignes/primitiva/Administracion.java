package com.pacosignes.primitiva;

import java.util.Random;
import java.util.Scanner;

public class Administracion {
    private static Random rdn= new Random();
    private static Scanner lector=new Scanner(System.in);

    private int codAdmin;



    /**
     * Genera apuesta aletatoria
     * @param rango recibe el numero mayor del sorteo(se supone 1 el menor)
     * @param cantidad cantidad de numeros a los que se apuesta (en nuestro ejemplo son 6);
     * @return Devuelve una apuesta
     */
    public static Apuesta apuestaAutomatica(int rango, int cantidad){

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
    public static Apuesta apuestaManual(){
        System.out.println("Introduce los 6 numeros uno a uno");
        int []numeros=new int[6];
        int contador=0;
        boolean correcto;

        do{
            correcto=true;
            System.out.println((contador+1)+"º numero");
            System.out.println("introduce un numero del 1 al 50");
            numeros[contador]=lector.nextInt();
            lector.nextLine();
            if (numeros[contador]>0 && numeros[contador]<50){

                for(int i = contador-1; i>=0;i--){
                    if (numeros[i]==numeros[contador]){
                        System.out.println("no se pueden repetir numeros");
                        correcto=false;
                    }
                }
                if(correcto) contador++;

            }else{
                System.out.println("El numero introducido no es correcto introduzca otro");
            }
        }while(contador<numeros.length);
        numeros=ordenarArray(numeros);

        return new Apuesta(numeros, rdn.nextInt(10));
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
    public static Apuesta manualOAutomatica(){
        int menu;
        do{
            System.out.println("Manual o automatica?");
            System.out.println("1.Manual");
            System.out.println("2.Automatica");
            menu=lector.nextInt();
            lector.nextLine();
            if(menu<1 || menu>2){
                System.out.println("intoruduce 1 o 2 porfavor");
            }
        }while(menu<1 || menu>2);
        switch (menu){
            case 1:
                return Administracion.apuestaManual();
            case 2:
                return Administracion.apuestaAutomatica(49 , 6 );

            default:return Administracion.apuestaAutomatica(49,6);
        }

    }

    //metodos simulacion





}
