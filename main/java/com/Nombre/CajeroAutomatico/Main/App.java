package com.Nombre.CajeroAutomatico.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        System.out.println("actializad");
        launch(args);



    }

    @Override
    public void start(Stage stage) throws Exception {
        stage = FXMLLoader.load(getClass().getResource("/fxml/1.fxml"));
        stage.show();
    }

    public void fxml2(){
          try {
              Stage op = FXMLLoader.load(getClass().getResource("/fxml/2.fxml"));
              op.show();

        } catch (IOException e) {

        }
    }

    public void fxml3(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/3.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }
    public void fxmlretiroMalo(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/retiroMalo.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }
    
    public void fxml4(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/4.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }

    public void fxml5(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/5.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }
    public void fxml16(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/16.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }

    public void fxml14(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/14.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }
    public void fxml18(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/18.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }

    public void fxml20(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/20.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }

    public void fxml6(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/6.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }
    public void fxml13(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/13.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }
    public void fxml10(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/10.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }

    public void fxml19(){
        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/19.fxml"));
            fxml.show();

        } catch (IOException e) {

        }
    }



    public void fxml21(){

        try {
            Stage fxml = FXMLLoader.load(getClass().getResource("/fxml/21.fxml"));
            fxml.show();

        } catch (IOException e) {

        }

    }

}
