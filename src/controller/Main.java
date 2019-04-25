/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vinic
 */
public class Main extends Application {
    
    private static Stage stage;
    
    private static Scene tela1;
    private static Scene tela2;
    private static Scene telaVendas;
     private static Scene telaUser;
    @Override
    public void start(Stage priStage) throws Exception {
        stage = priStage;
        Parent telaA = FXMLLoader.load(getClass().getResource("/telas/Tela1.fxml"));
        tela1 = new Scene(telaA);
        
        Parent telaB = FXMLLoader.load(getClass().getResource("/telas/TelaMercadoria.fxml"));
        tela2 = new Scene(telaB);
      
        Parent telac = FXMLLoader.load(getClass().getResource("/telas/TelaVendas.fxml"));
        telaVendas = new Scene(telac);
        
        Parent telad = FXMLLoader.load(getClass().getResource("/telas/TelaUser.fxml"));
        telaUser = new Scene(telad);
     
        priStage.setScene(tela1);
        priStage.setMaximized(true);
   
        priStage.show();
       
    }
    public static void trocaTela(int nT){
       System.out.printf("sdfghjkl");
        switch(nT){
            case 1:     
                stage.setScene(tela1);
                break;
            case 2:   
                stage.setScene(tela2);
                break;
            case 3:
                stage.setScene(telaVendas);
                break;
            case 4:
                stage.setScene(telaUser);
                break;
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
/**/