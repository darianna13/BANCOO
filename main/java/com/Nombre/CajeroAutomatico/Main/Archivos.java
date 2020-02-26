package com.Nombre.CajeroAutomatico.Main;

import com.Nombre.CajeroAutomatico.Controllers.FXMLController;

import java.io.*;

public class Archivos {




    /*public String leerTexto(String direccion){
            int inicio = 0;
            int fin=0;
            String texto="";
            try{

                BufferedReader bf = new BufferedReader(new FileReader(direccion));
                String temp="";
                String bfRead;
                while((bfRead = bf.readLine())!=null){
                    temp = bfRead;
                    inicio =temp.indexOf("$");
                    fin = temp.indexOf("&",inicio+1);
                    System.out.println("El resultado es: "+temp.substring(inicio+1,fin));



                }

                texto = temp;


            }catch(Exception e){
                System.out.println("No se encontro archivo");
            }
            return texto;
        }*/
    //String numeroTarjeta,direccion;




    public String primeraValidacionPinF(String direccion) {

        String textoTarjetaIngresada = "";

        try {

            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;


            while ((bfRead = bf.readLine()) != null) {
                textoTarjetaIngresada = bfRead;


            }



        } catch (Exception e) {
            System.out.println("No se encontro archivo");
        }



        int inicio = 0;
        int fin=0;
        String texto="";
        try{

            BufferedReader bf = new BufferedReader(new FileReader("/home/loperena/Descargas/Definitivo/CajeroAutomatico/src/main/resources/textos/NIP.txt"));
            String temp="";
            String bfRead;
            while((bfRead = bf.readLine())!=null){
                temp = bfRead;
                inicio =temp.indexOf("");
                fin = temp.indexOf("$",inicio+1);

                if(textoTarjetaIngresada.equals(temp.substring(inicio,fin))){

                    temp = bfRead;
                    inicio =temp.indexOf("$");
                    fin = temp.indexOf("&",inicio+1);

                    FileWriter fichero = new FileWriter("/home/loperena/Descargas/Definitivo/CajeroAutomatico/src/main/resources/textos/NIPElegido.txt");
                    PrintWriter escritor = new PrintWriter(fichero);
                    escritor.flush();
                    escritor.write(temp.substring(inicio+1,fin));
                    escritor.close();
                }
            }
            texto = temp.substring(inicio+1,fin);


        }catch(Exception e){
            System.out.println("No se encontro archivo");
        }




        return texto;
    }




}