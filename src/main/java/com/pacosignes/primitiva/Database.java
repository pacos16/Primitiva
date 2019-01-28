package com.pacosignes.primitiva;


public class Database {

    private Sorteo arraySorteos;





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

    }
}
