package com.pacosignes.primitiva;

import java.util.Scanner;

public class Main {
    private static Scanner lector=new Scanner(System.in);
    public static void main(String[] args) {
        //Holi
        saludar();

        int menu;
        do{
            do {
                mostrarMenu();
                menu=lector.nextInt();
                lector.nextLine();
                if(menu<0 || menu>5){
                    System.out.println("No correcto introduzca de nuevo");
                }
            }while(menu<0 || menu>5);
            switch (menu){
                case 1:
                    unaApuesta();
                    break;
                case 2:
                    mostrarResultados(hastaPremio());
                    break;
                case 3:
                    mostrarResultados(hastaPremioNR());
                    break;
                case 4:
                    mostrarResultados(diezMilSorteos());
                    break;
                case 5:
                    mostrarResultados(hastaEspecial());
                    break;
                case 0:
                    System.out.println("Hasta luego Lucas");
            }
        }while(menu!=0);


    }


    /**
     * Mega menu de opciones
     */
    public static void mostrarMenu(){
        System.out.println("***Loteria***\n");
        System.out.println("1. Una apuesta");
        System.out.println("2. Sorteo hasta premio");
        System.out.println("3. Sorteo hasta premio,sin reintegro");
        System.out.println("4. Diez mil sorteos");
        System.out.println("5. Bucle hasta especial");
        System.out.println("-------------------------");
        System.out.println("0.Salir");
    }

    /**
     * Metodo diezmil sorteos
     * Crea un array resultados con los premios de diferentes categorias y luego lo rellena
     * cotejando apuestas con el metodo de la base de datos.
     * todos los otros metodos son un copiapega de este modificados
     * @return
     */
    private static long[] diezMilSorteos(){
        Apuesta apuesta=Administracion.manualOAutomatica();
        long[] premios=new long[7];
        for(int i=0;i<10000;i++){
            Sorteo sorteo=Bombo.primitiva();
            apuesta.setPremio(Apuesta.Premiada.NO_PREMIADA);
            Database.cotejarApuesta(apuesta, sorteo);

            switch (apuesta.getPremio()){
                case REINTEGRO:
                    premios[6]++;
                    break;
                case QUINTA:
                    premios[5]++;
                    break;
                case CUARTA:
                    premios[4]++;
                    break;
                case TERCERA:
                    premios[3]++;
                case SEGUNDA:
                    premios[2]++;
                case PRIMERA:
                    premios[1]++;
                    break;
                case ESPECIAL:
                    premios[0]++;
            }

        }

        return premios;

    }

    /**
     * Este es el metodo que muestra resultados, recibe un array de long porsiaca
     * @param premios
     */
    private static void mostrarResultados(long[] premios){
        if(premios[0]!=0) {
            System.out.println("Categoria especial: " + premios[0]);
        }
        if(premios[1]!=0) {
            System.out.println("Primera categoria:  " + premios[1]);
        }
        if(premios[2]!=0) {
            System.out.println("Segunda categoria:  " + premios[2]);
        }
        if(premios[3]!=0) {
            System.out.println("Tercera categoria:  " + premios[3]);
        }
        if(premios[4]!=0) {
            System.out.println("Cuarta categoria:   " + premios[4]);
        }
        if(premios[5]!=0) {
            System.out.println("Quinta categoria:   " + premios[5]);
        }
        if(premios[6]!=0) {
            System.out.println("Reintegros:         " + premios[6]);
        }
        if(premios.length==8 ){
            System.out.println("NUMERO DE ITERACIONES HASTA LLEGAR: " +premios[7]);
        }

        System.out.println("Pulsa intro para continuar");
        lector.nextLine();

    }

    /**
     * Metodo que generasorteos hasta que encuentra el especial
     * @return
     */
    private static long[] hastaEspecial(){
        Apuesta apuesta=Administracion.manualOAutomatica();
        System.out.println(apuesta.toString());
        long[] premios=new long[8];
        int contador=0;
        System.out.println("Paciencia....");
        while(premios[0]!=1){
            Sorteo sorteo=Bombo.primitiva();
            apuesta.setPremio(Apuesta.Premiada.NO_PREMIADA);
            Database.cotejarApuesta(apuesta, sorteo);

            switch (apuesta.getPremio()){
                case REINTEGRO:
                    premios[6]++;
                    break;
                case QUINTA:
                    premios[5]++;
                    break;
                case CUARTA:
                    premios[4]++;
                    break;
                case TERCERA:
                    premios[3]++;
                    break;
                case SEGUNDA:
                    premios[2]++;
                    break;
                case PRIMERA:
                    premios[1]++;
                    break;
                case ESPECIAL:
                    premios[0]++;
                    break;
            }
            contador++;

        }
        premios[7]=contador;

        return premios;

    }
    private static long[] hastaPremioNR(){
        Apuesta apuesta=Administracion.manualOAutomatica();
        long[] premios=new long[8];
        long contador=0;
        while(premios[0]==0 && premios[1]==0 && premios[2]==0 && premios[3]==0 && premios[4]==0 && premios[5]==0){
            Sorteo sorteo=Bombo.primitiva();
            apuesta.setPremio(Apuesta.Premiada.NO_PREMIADA);
            Database.cotejarApuesta(apuesta, sorteo);

            switch (apuesta.getPremio()){
                case REINTEGRO:
                    premios[6]++;
                    break;
                case QUINTA:
                    premios[5]++;
                    break;
                case CUARTA:
                    premios[4]++;
                    break;
                case TERCERA:
                    premios[3]++;
                case SEGUNDA:
                    premios[2]++;
                case PRIMERA:
                    premios[1]++;
                    break;
                case ESPECIAL:
                    premios[0]++;
            }
            contador++;

        }
        premios[7]=contador;

        return premios;

    }
    private static long[] hastaPremio(){
        Apuesta apuesta= Administracion.manualOAutomatica();
        long[] premios=new long[8];
        int contador=0;
        while(premios[0]==0 && premios[1]==0 && premios[2]==0 && premios[3]==0
                && premios[4]==0 && premios[5]==0 && premios[6]==0){

            Sorteo sorteo=Bombo.primitiva();
            apuesta.setPremio(Apuesta.Premiada.NO_PREMIADA);
            Database.cotejarApuesta(apuesta, sorteo);

            switch (apuesta.getPremio()){
                case REINTEGRO:
                    premios[6]++;
                    break;
                case QUINTA:
                    premios[5]++;
                    break;
                case CUARTA:
                    premios[4]++;
                    break;
                case TERCERA:
                    premios[3]++;
                case SEGUNDA:
                    premios[2]++;
                case PRIMERA:
                    premios[1]++;
                    break;
                case ESPECIAL:
                    premios[0]++;
            }
            contador++;

        }
        premios[7]=contador;

        return premios;

    }

    private static void unaApuesta(){
        Apuesta apuesta=Administracion.manualOAutomatica();
        System.out.println(apuesta.toString());
        Sorteo sorteo=Bombo.primitiva();
        Database.cotejarApuesta(apuesta, sorteo);

        switch (apuesta.getPremio()){
            case REINTEGRO:
                System.out.println("Reintegro");
                break;
            case QUINTA:
                System.out.println("Quinta categoria");
                break;
            case CUARTA:
                System.out.println("Cuarta categoria");
                break;
            case TERCERA:
                System.out.println("Tercera categoria");
            case SEGUNDA:
                System.out.println("Segunda categoria");
            case PRIMERA:
                System.out.println("Primera categoria");
                break;
            case ESPECIAL:
                System.out.println("Especial");
                break;
            case NO_PREMIADA:
                System.out.println("No premiada");
                break;
        }

        System.out.println("Pulsa intro para continuar");
        lector.nextLine();
    }


//fin








































    private static void saludar(){
        String s;
        System.out.println("Practica Loteria");
        System.out.println("Pulse intro para continuar");
        s=lector.nextLine();
        if (s.equals("Paco tiene un 11")){
            System.out.println("Paco esta contento");

            miPractica();

        }
    }
    public static void miPractica() {

        Database db= new Database();
        db.uploadRegister();

        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();

        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("Maldtio thread sleep");
        }
        int i=30;
        do {
            System.out.printf("\u001B[1;"+i+"mBienvenido a mi practica\n\u001B[0m");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Maldtio thread sleep");
            }
            System.out.print("\u001B[H\u001B[2J");
            System.out.flush();
            i++;
        }while(i<36);
        System.out.println(db.numerosCalientes());
        try{
            Thread.sleep(1200);
        }catch(InterruptedException e){
            System.out.println("Maldtio thread sleep");
        }



        System.out.println("Pulse intro para continuar a la practica standart");
        lector.nextLine();
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();


    }






}
