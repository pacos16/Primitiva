package com.pacosignes.primitiva;
import java.io.*;
import java.util.Arrays;


public class Database {

    private Sorteo[] arraySorteos;

    /**
     * Metodo que cotjea las apuestas, recibe un objeto de la classe apuesta y uno de la clase sorteo.
     * @param apuesta
     * @param sorteo
     */
    public static void cotejarApuesta(Apuesta apuesta , Sorteo sorteo){

        boolean complementario=false;
        int aciertos=0;
        for(int i =0;i<apuesta.getNumeros().length;i++){
            for (int j=0;j<apuesta.getNumeros().length; j++){
                if (apuesta.getNumeros()[i]==sorteo.getNumeros()[j]){

                    aciertos++;
                }

            }
            if(sorteo.getComplementario()==apuesta.getNumeros()[i]){
                complementario=true;
            }
        }


        switch (aciertos){
            case 0:
            case 1:
            case 2:
                apuesta.setPremio(Apuesta.Premiada.NO_PREMIADA);
                if(apuesta.getReintegro()==sorteo.getReintegro()){
                    apuesta.setPremio(Apuesta.Premiada.REINTEGRO);
                }
                break;
            case 3:
                apuesta.setPremio(Apuesta.Premiada.QUINTA);
                break;
            case 4:
                apuesta.setPremio(Apuesta.Premiada.CUARTA);
                break;
            case 5:
                if(complementario){
                    apuesta.setPremio(Apuesta.Premiada.SEGUNDA);
                }else{
                    apuesta.setPremio(Apuesta.Premiada.TERCERA);
                }
                break;
            case 6:
                if(apuesta.getReintegro()==sorteo.getReintegro()){
                    apuesta.setPremio(Apuesta.Premiada.ESPECIAL);
                }else{
                    apuesta.setPremio(Apuesta.Premiada.PRIMERA);
                }
                break;
        }
        apuesta.setCotejada();

    }
    public void uploadRegister() {

        String[] linea;
        arraySorteos=new Sorteo[10000];
        int contador=0;
        try {
            FileReader f= new FileReader("Primitiva.txt");
            BufferedReader reader = new BufferedReader(f);
            String line;
            while ((line = reader.readLine()) != null) {
                linea=line.split("\\s+");
                arraySorteos[contador]=new Sorteo(linea);
                contador++;
            }
        }catch( IOException e){
            System.out.println("Lolaso");
            System.out.println("En casa funcionaba");
            System.out.println("Es tu ordenador");
            System.out.println("Fallar? mi codigo? imposible");
            System.out.println("Eso sera el antivirus");
        }
    }

    public void imprime(){
        for(int i=0;i<100;i++){
            System.out.println(Arrays.toString(arraySorteos[i].getNumeros()));
        }


    }

    public String numerosCalientes(){
        int i=0;
        int[] cVeces=new int[49];
        int[] frios=new int[5];
        int[] calientes=new int[5];
        int max;
        int posicionMax;
        int min;
        int posicionMin;
        while(arraySorteos[i]!=null && i<arraySorteos.length){
            for (int j=0;j<arraySorteos[i].getNumeros().length;j++){
                cVeces[arraySorteos[i].getNumeros()[j]-1]++;
            }
            i++;
        }


        for(int k=0;k<frios.length;k++){
            max=0;
            posicionMax=0;
            min=500000000;
            posicionMin=0;
            for (int l=0;l<cVeces.length;l++){

                if(cVeces[l]!=-1){

                    if(cVeces[l]<min){
                        min=cVeces[l];
                        posicionMin=l+1;
                    }
                    if(cVeces[l]>max){
                        max=cVeces[l];
                        posicionMax=l+1;
                    }

                }

            }
            cVeces[posicionMax-1]=-1;
            cVeces[posicionMin-1]=-1;
            frios[k]=posicionMin;
            calientes[k]=posicionMax;

        }
        return "Numeros que menos salen: "+Arrays.toString(frios)+"\nNumeros que mas salen:   "+Arrays.toString(calientes);

    }


}

