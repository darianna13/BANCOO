package com.Nombre.CajeroAutomatico.Controllers;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.Nombre.CajeroAutomatico.Main.App;
import com.Nombre.CajeroAutomatico.Main.Archivos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class FXMLController implements Initializable {
    Archivos archivos = new Archivos();

    private App app = new App();


    /*Las variables de tiiko tendran una "F" al final"*/
    //1.fxml
    String numeroTarjetaF = "2";
    int numCuenta, num;
    int numCuentaF=0;
    float monto=0, monto1D=0, monto2D=0, monto3D=0;
    int cfePagar=400,comapaPagar=300,guardarCfe,guardarComapaPagar;

    String numeroTarjeta1, numeroTarjeta2, numeroTarjeta3, numeroComprobar;
    String nip1, nip2, nip3, nipNuevo1, nipNuevo2, nipNuevo3;
    String monto1, monto2, monto3;

    int operacion1,operacion2,operacion3;
    String NIPIngresadoF;
    String guardarTarjeta = "";

    @FXML
    TextField idLabel;

    @FXML
    Button retiro100, retiro200, retiro300, retiro400, retiro500, botonOtro, retiro, botonAceptarRetiro, cuentaReceptora;
    //fxml 1
    @FXML
    Button boton1F, boton2F, boton3F, boton4F, boton5F, botonHistorial, botonValidarNipF, btnCambiarNip, btnValidarNipCambio, cerrarEnNip;

    @FXML
    Button comapa,CFE;
    //fxml 3
    @FXML
    TextField primerNipF;

    @FXML
    Label textoSaldo;

    @FXML
    TextField texto,textMiNipF;

    @FXML
    TextField miNip,nuevoNip,confirmarNuevoNip;
    //Primera ventana FXML 1
    public void botonN1F(){

        try {
            FileWriter fichero = new FileWriter("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/Tarjetas.txt");
            PrintWriter escritor = new PrintWriter(fichero);
            escritor.flush();
            escritor.write("1");
            escritor.close();
        } catch (IOException e) {
            System.out.println("F el archivo");
        }

        app.fxml3();

        Stage stage = (Stage) this.boton1F.getScene().getWindow();

        stage.close();



    }
    public void botonN2F(){
        try {
            FileWriter fichero = new FileWriter("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/Tarjetas.txt");
            PrintWriter escritor = new PrintWriter(fichero);
            escritor.flush();
            escritor.write("2");
            escritor.close();
        } catch (IOException e) {
            System.out.println("F el archivo");
        }
        app.fxml3();
        Stage stage = (Stage) this.boton2F.getScene().getWindow();
        stage.close();
    }
    public void botonN3F(){
        numeroTarjetaF = "1";
        app.fxml2();
        Stage stage = (Stage) this.boton3F.getScene().getWindow();
       // stage.close();
    }
    public void botonN4F(){
        numeroTarjetaF = "1";
        app.fxml3();
        Stage stage = (Stage) this.boton4F.getScene().getWindow();
        stage.close();
    }
    public void botonN5F(){
        numeroTarjetaF = "2";
        app.fxml2();
        Stage stage = (Stage) this.boton5F.getScene().getWindow();
        stage.close();
    }

    public void saldo() {
        String tarjeta1 = "";
        try {
            BufferedReader bf1 = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/Tarjetas.txt"));
            String temp = "";
            String bfRead;
            while ((bfRead = bf1.readLine()) != null) {
                tarjeta1 = bfRead;
                System.out.println("AQUI IMPRIME LA TARDEJtA" + tarjeta1);
            }


        } catch (Exception e) {

        }

        try{
            BufferedReader bf1 = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIP.txt"));
            String bfRead;
            String temp;
            int inicio1=0,inicio2=0,inicio3=0;
            int fin1=0,fin2=0,fin3=0;
            while ((bfRead = bf1.readLine()) != null) {

                temp = bfRead;
                inicio1 = temp.indexOf("");
                fin1 = temp.indexOf("$", inicio1 + 1);
                numeroComprobar = temp.substring(inicio1, fin1);
                if ("1".equals(temp.substring(inicio1, fin1))) {

                    inicio1 = temp.indexOf("");
                    fin1 = temp.indexOf("$", inicio1 + 1);
                    numeroTarjeta1 = numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&", inicio2 + 1);
                    nip1 = temp.substring(inicio2 + 1, fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%", inicio3 + 1);
                    monto1 = temp.substring(inicio3 + 1, fin3);


                    if ("1".equals(tarjeta1)) {
                        textoSaldo.setText(monto1);

                    }

                }
                if ("2".equals(temp.substring(inicio1, fin1))) {

                    inicio1 = temp.indexOf("");
                    fin1 = temp.indexOf("$", inicio1 + 1);
                    numeroTarjeta2 = numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&", inicio2 + 1);
                    nip2 = temp.substring(inicio2 + 1, fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%", inicio3 + 1);
                    monto2 = temp.substring(inicio3 + 1, fin3);

                    if ("2".equals(tarjeta1)) {
                        textoSaldo.setText(monto2);
                    }
                }
            }
        }catch (Exception e){

        }


    }







    //Tercera ventana FXML 3

    public void validarNipF(){

       archivos.primeraValidacionPinF("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/Tarjetas.txt");
        String passwordTxt = "";

        try {

            BufferedReader bf = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIPElegido.txt"));
            String temp = "";
            String bfRead;


            while ((bfRead = bf.readLine()) != null) {
                passwordTxt = bfRead;


            }



        } catch (Exception e) {
            System.out.println("No se encontro archivo");
        }

        if(passwordTxt.equals(primerNipF.getText())){
            //Menu FXML 5
            app.fxml5();
            Stage stage = (Stage) this.botonValidarNipF.getScene().getWindow();
            stage.close();
        }else{
            app.fxml4();
            Stage stage = (Stage) this.botonValidarNipF.getScene().getWindow();
            //stage.close();
        }

    }

    public void pasarHistorial(){
        app.fxml20();
        Stage stage = (Stage) this.btnCambiarNip.getScene().getWindow();
        stage.close();
    }

    public void pagoServicios(){
        app.fxml13();
        Stage stage = (Stage) this.btnCambiarNip.getScene().getWindow();
        stage.close();
    }

    public void consultarSaldo(){
        app.fxml6();

        Stage stage = (Stage) this.btnCambiarNip.getScene().getWindow();
        stage.close();
    }

    public void retirar(){
        app.fxml21();
        Stage stage = (Stage) this.btnCambiarNip.getScene().getWindow();
        //stage.close();
    }
    public void retirar100() {
        idLabel.setText("100");
        idLabel.setDisable(true);
    }
    public void retirar200() {
        idLabel.setText("200");
        idLabel.setDisable(true);
    }
    public void retirar300() {
        idLabel.setText("300");
        idLabel.setDisable(true);
    }
    public void retirar400() {
        idLabel.setText("400");
        idLabel.setDisable(true);
    }
    public void retirar500() {
        idLabel.setText("500");
        idLabel.setDisable(true);
    }
    public void otro() {
        idLabel.setDisable(false);
    }

    public void Transferir(){
        app.fxml10();
        Stage stage = (Stage) this.btnCambiarNip.getScene().getWindow();
        stage.close();
    }


    //Cambiar Nip FXML 18
    public void cambiarNip(){

        app.fxml16();
        Stage stage = (Stage) this.btnCambiarNip.getScene().getWindow();
        stage.close();

    }




    public void validacion(){
        miNip.getText();
        String guardarNip="";
        try {

            BufferedReader bf = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIPElegido.txt"));
            String temp = "";
            String bfRead;


            while ((bfRead = bf.readLine()) != null) {
                guardarNip = bfRead;


            }



        } catch (Exception e) {
            System.out.println("No se encontro archivo");
        }

        if (guardarNip.equals(miNip.getText())&& !miNip.getText().equals(nuevoNip.getText())  && nuevoNip.getText().equals(confirmarNuevoNip.getText()) && nuevoNip.getLength() == 4){



            try {

                BufferedReader bf = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/textos/NIP.txt"));
                String tempNTarjeta = "";
                String tempNip = "";
                String tempMonto = "";
                int inicio1=0,inicio2=0,inicio3=0;
                int fin1=0,fin2=0,fin3=0;


                String bfRead;
                String temp="";

                while ((bfRead = bf.readLine()) != null) {

                    temp = bfRead;
                    inicio1= temp.indexOf("");
                    fin1=temp.indexOf("$",inicio1+1);
                    numeroComprobar = temp.substring(inicio1,fin1);
                    if("1".equals(temp.substring(inicio1,fin1))){

                        inicio1= temp.indexOf("");
                        fin1=temp.indexOf("$",inicio1+1);
                        numeroTarjeta1 =numeroComprobar;

                        inicio2 = temp.indexOf("$");
                        fin2 = temp.indexOf("&",inicio2+1);
                        nip1 = temp.substring(inicio2+1,fin2);

                        inicio3 = temp.indexOf("&");
                        fin3 = temp.indexOf("%",inicio3+1);
                        monto1 = temp.substring(inicio3+1,fin3);



                        if(nip1.equals(miNip.getText())){
                           // archivos.primeraValidacionPinF("C:\\Users\\fran1\\OneDrive\\Desktop\\CajeroAutomatico\\src\\main\\resources\\textos\\Tarjetas.txt\\");
                            FileWriter fichero = new FileWriter("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIPElegido.txt");
                            PrintWriter escritor = new PrintWriter(fichero);
                            escritor.flush();
                            escritor.write(nuevoNip.getText());
                            escritor.close();
                            nip1 = nuevoNip.getText();

                        }

                    }if("2".equals(temp.substring(inicio1,fin1))){

                        inicio1= temp.indexOf("");
                        fin1=temp.indexOf("$",inicio1+1);
                        numeroTarjeta2 =numeroComprobar;

                        inicio2 = temp.indexOf("$");
                        fin2 = temp.indexOf("&",inicio2+1);
                        nip2 = temp.substring(inicio2+1,fin2);

                        inicio3 = temp.indexOf("&");
                        fin3 = temp.indexOf("%",inicio3+1);
                        monto2 = temp.substring(inicio3+1,fin3);



                        if(nip2.equals(miNip.getText())){
                            // archivos.primeraValidacionPinF("C:\\Users\\fran1\\OneDrive\\Desktop\\CajeroAutomatico\\src\\main\\resources\\textos\\Tarjetas.txt\\");
                            FileWriter fichero = new FileWriter("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIPElegido.txt");
                            PrintWriter escritor = new PrintWriter(fichero);
                            escritor.flush();
                            escritor.write(nuevoNip.getText());
                            escritor.close();
                            nip2 = nuevoNip.getText();

                        }

                    }if("3".equals(temp.substring(inicio1,fin1))){

                        inicio1= temp.indexOf("");
                        fin1=temp.indexOf("$",inicio1+1);
                        numeroTarjeta3 =numeroComprobar;

                        inicio2 = temp.indexOf("$");
                        fin2 = temp.indexOf("&",inicio2+1);
                        nip3 = temp.substring(inicio2+1,fin2);

                        inicio3 = temp.indexOf("&");
                        fin3 = temp.indexOf("%",inicio3+1);
                        monto3 = temp.substring(inicio3+1,fin3);


                        if(nip3.equals(miNip.getText())){
                            // archivos.primeraValidacionPinF("C:\\Users\\fran1\\OneDrive\\Desktop\\CajeroAutomatico\\src\\main\\resources\\textos\\Tarjetas.txt\\");
                            FileWriter fichero = new FileWriter("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIPElegido.txt");
                            PrintWriter escritor = new PrintWriter(fichero);
                            escritor.flush();
                            escritor.write(nuevoNip.getText());
                            escritor.close();
                            nip3 = nuevoNip.getText();


                        }
                    }




                }



            } catch (Exception e) {
                System.out.println("No se encontro archivo");
            }


            try {
                File archivo = new File("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIP.txt");
                FileWriter escribir = new FileWriter(archivo);

                escribir.write(numeroTarjeta1+"$"+nip1+"&"+monto1+"%"+"\n");
                escribir.write(numeroTarjeta2+"$"+nip2+"&"+monto2+"%"+"\n");
                escribir.write(numeroTarjeta3+"$"+nip3+"&"+monto3+"%"+"\n");

                escribir.close();

            }catch (Exception e){


            }



        }
        app.fxml19();


        Stage stage = (Stage) this.btnValidarNipCambio.getScene().getWindow();
        stage.close();

    }
    public void validacion3() throws IOException {
        String cuentaIngresada="";
        cuentaIngresada=this.cuentaReceptora.getText();

        File archivo2 = new File("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/TarjetaR.txt");
        FileWriter escribir = new FileWriter(archivo2);

        escribir.write(cuentaReceptora+"\n");


    }
    public void validacion2 (){
        System.out.println("Llegue");
        try {

            String temp = "";
            String bfRead;
            BufferedReader bf2 = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/NIP.txt"));
            BufferedReader cuenta = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/Tarjetas.txt"));
            String tempNTarjeta = "";
            String tempNip = "";
            String tempMonto = "";
            String numDeCuenta;

            String cuentaRead;
            while((cuentaRead=cuenta.readLine())!=null){
                numDeCuenta=cuentaRead;
                numCuentaF=0+Integer.parseInt(numDeCuenta);
            }
            int inicio1=0,inicio2=0,inicio3=0;
            int fin1=0,fin2=0,fin3=0;

            while ((bfRead = bf2.readLine()) != null) {
                temp = bfRead;
                inicio1= temp.indexOf("");
                fin1=temp.indexOf("$",inicio1+1);
                numeroComprobar = temp.substring(inicio1,fin1);
                if("1".equals(temp.substring(inicio1,fin1))){

                    inicio1= temp.indexOf("");
                    fin1=temp.indexOf("$",inicio1+1);
                    numeroTarjeta1 =numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&",inicio2+1);
                    nip1 = temp.substring(inicio2+1,fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%",inicio3+1);
                    monto1 = temp.substring(inicio3+1,fin3);

                }if("2".equals(temp.substring(inicio1,fin1))){

                    inicio1= temp.indexOf("");
                    fin1=temp.indexOf("$",inicio1+1);
                    numeroTarjeta2 =numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&",inicio2+1);
                    nip2 = temp.substring(inicio2+1,fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%",inicio3+1);
                    monto2 = temp.substring(inicio3+1,fin3);

                }if("3".equals(temp.substring(inicio1,fin1))){

                    inicio1= temp.indexOf("");
                    fin1=temp.indexOf("$",inicio1+1);
                    numeroTarjeta3 =numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&",inicio2+1);
                    nip3 = temp.substring(inicio2+1,fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%",inicio3+1);
                    monto3 = temp.substring(inicio3+1,fin3);

                }

            }} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
                /*
                numeroTarjeta1
                nip1
                monto1

                numeroTarjeta2
                nip2
                monto2

                numeroTarjeta3
                nip3
                monto3
                */

            monto= (float) Double.parseDouble(idLabel.getText());

            monto1D= (float) Double.parseDouble(monto1);
            monto2D= (float) Double.parseDouble(monto2);
            monto3D= (float) Double.parseDouble(monto3);
            System.out.println("Inicio: "+monto+" / "+monto1D+" / "+monto1);
            switch(numCuentaF){
                case 1:
                    if(monto>monto1D){

                        System.out.println("Error, la cantidad retirada supera la guardada");
                        app.fxmlretiroMalo();
                    } else {
                        monto1D=monto1D-monto;
                        monto1="";
                        monto1=String.valueOf(monto1D);
                    }
                    break;
                case 2:
                    if(monto>monto2D){

                        System.out.println("Error, la cantidad retirada supera la guardada");
                        //app.fxmlretiroMalo();
                    } else {
                        monto2D=monto2D-monto;
                        monto2="";
                        monto2=String.valueOf(monto2D);
                    }
                    break;
                case 3:
                    if(monto>monto3D){

                        System.out.println("Error, la cantidad retirada supera la guardada");
                        app.fxmlretiroMalo();
                    } else {
                        monto3D=monto3D-monto;
                        monto3="";
                        monto3=String.valueOf(monto3D);
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Final: "+monto+" / "+monto1D+" / "+monto1);
            File archivo = new File("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/textos/NIP.txt");
            FileWriter escribir = new FileWriter(archivo);

            escribir.write(numeroTarjeta1+"$"+nip1+"&"+monto1+"%"+"\n");
            escribir.write(numeroTarjeta2+"$"+nip2+"&"+monto2+"%"+"\n");
            escribir.write(numeroTarjeta3+"$"+nip3+"&"+monto3+"%"+"\n");

            escribir.close();

        }catch (Exception e){

        }



    }

    public void cerrarNip(){

        Stage stage = (Stage) this.cerrarEnNip.getScene().getWindow();
        stage.close();
    }

    public void entrarEnPagoServicios(){


        app.fxml14();




    }

    public void cobrarRecibo(){

        String tarjeta1 = "";
        try {
            BufferedReader bf1 = new BufferedReader(new FileReader("/home/ahren/Escritorio/CajeroAutomatico/src/main/resources/textos/Tarjetas.txt"));
            String temp = "";
            String bfRead;
            while ((bfRead = bf1.readLine()) != null) {
                tarjeta1 = bfRead;
                System.out.println("AQUI IMPRIME LA TARDEJtA" + tarjeta1);
            }


        } catch (Exception e) {

        }


        try {
            BufferedReader bf = new BufferedReader(new FileReader(""));

        }catch (Exception e){

        }


    }
    /*
    public void cobrarRecibo(){
        try {

            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\fran1\\OneDrive\\Desktop\\CajeroAutomatico\\src\\main\\resources\\textos\\Tarjetas.txt\\"));

            String bfRead;


            while ((bfRead = bf.readLine()) != null) {
                guardarTarjeta = bfRead;


            }



        } catch (Exception e) {
            System.out.println("No se encontro archivo");
        }



        try {

            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\fran1\\OneDrive\\Desktop\\CajeroAutomatico\\src\\main\\resources\\textos\\NIP.txt\\"));
            String tempNTarjeta = "";
            String tempNip = "";
            String tempMonto = "";
            int inicio1=0,inicio2=0,inicio3=0;
            int fin1=0,fin2=0,fin3=0;


            String bfRead;
            String temp="";

            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                inicio1= temp.indexOf("");
                fin1=temp.indexOf("$",inicio1+1);
                numeroComprobar = temp.substring(inicio1,fin1);



                if(guardarTarjeta.equals(temp.substring(inicio1,fin1))){

                    inicio1= temp.indexOf("");
                    fin1=temp.indexOf("$",inicio1+1);
                    numeroTarjeta1 =numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&",inicio2+1);
                    nip1 = temp.substring(inicio2+1,fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%",inicio3+1);
                    monto1 = temp.substring(inicio3+1,fin3);



                    if(Integer.parseInt(monto1) >= cfePagar){
                        operacion1 = Integer.parseInt(monto1)-cfePagar;

                        monto1=String.valueOf(operacion1);



                    }else{
                        System.out.println("no entro a la primera");
                    }



                }

                if("2".equals(temp.substring(inicio2,fin2))){


                    inicio1= temp.indexOf("");
                    fin1=temp.indexOf("$",inicio1+1);
                    numeroTarjeta2 =numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&",inicio2+1);
                    nip2 = temp.substring(inicio2+1,fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%",inicio3+1);
                    monto2 = temp.substring(inicio3+1,fin3);



                }if("3".equals(temp.substring(inicio3,fin3))){

                    inicio1= temp.indexOf("");
                    fin1=temp.indexOf("$",inicio1+1);
                    numeroTarjeta3 =numeroComprobar;

                    inicio2 = temp.indexOf("$");
                    fin2 = temp.indexOf("&",inicio2+1);
                    nip3 = temp.substring(inicio2+1,fin2);

                    inicio3 = temp.indexOf("&");
                    fin3 = temp.indexOf("%",inicio3+1);
                    monto3 = temp.substring(inicio3+1,fin3);



                }





            }



        } catch (Exception e) {
            System.out.println("No se encontro archivo");
        }


        try {
            File archivo = new File("C:\\Users\\fran1\\OneDrive\\Desktop\\CajeroAutomatico\\src\\main\\resources\\textos\\NIP.txt\\");
            FileWriter escribir = new FileWriter(archivo);

            escribir.write(numeroTarjeta1+"$"+nip1+"&"+monto1+"%"+"\n");
            escribir.write(numeroTarjeta2+"$"+nip2+"&"+monto2+"%"+"\n");
            escribir.write(numeroTarjeta3+"$"+nip3+"&"+monto3+"%"+"\n");

            escribir.close();

        }catch (Exception e){






        }


    }
*/



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
    
}