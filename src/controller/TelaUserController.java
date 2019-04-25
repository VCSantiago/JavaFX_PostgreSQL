/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaUserController{
    @FXML
    private Button botaoMerca;
    @FXML
    private Button venda;
    @FXML
    private Button btnC;
    @FXML
    private Button btnRemoMErc;
    @FXML
    private Button btnVisuMer;
    @FXML
    private Button user;

  

    @FXML
    private void saiMer(MouseEvent event) {
        botaoMerca.setStyle("-fx-background-color: #c90d0d; "
                + "-fx-background-radius: 0; "
                + "-fx-background-image: url(imagens/MerA.png); "
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-position: center top;");
    }

    @FXML
    private void entMer(MouseEvent event) {
         botaoMerca.setStyle("-fx-background-color: White; "
                + "-fx-background-radius: 0; "
                + "-fx-background-image: url(imagens/Mer.png); "
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-position: center top;");
    }

    @FXML
    private void clicMer(MouseEvent event) {
        Main.trocaTela(2);
    }

    @FXML
    private void suser(MouseEvent event) {
        venda.setStyle("-fx-background-color: #c90d0d; "
                + "-fx-background-image: url(imagens/Ven.png);"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 0;");
    }

    @FXML
    private void euser(MouseEvent event) {
         venda.setStyle("-fx-background-color: white; "
                 + "-fx-background-image:url(imagens/VenA.png); "
                 + "-fx-background-position: center;"
                 + "-fx-background-repeat: no-repeat; "
                 + "-fx-background-radius: 0;");
    }

    @FXML
    private void cuser(MouseEvent event) {
        Main.trocaTela(3);
    }

    @FXML
    private void mouseSC(MouseEvent event) {
        btnC.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0);"
                + " -fx-background-color: WHite;"
                + " -fx-background-image: url(imagens/CadasUser.png);"
                + " -fx-background-position: center; "
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void mouseEC(MouseEvent event) {
         btnC.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0);"
                + " -fx-background-color: #c90d0d;"
                + " -fx-background-image: url(imagens/CadasUserA.png);"
                + " -fx-background-position: center; "
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 10;");
    }

    @FXML
    
    
    private void telaCadas(MouseEvent event) throws IOException {
        
        Stage stage1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCadasUser.fxml"));
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
    }
  
    @FXML
    private void saiuclicRemoverMerca(MouseEvent event) {
        btnRemoMErc.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: WHite;"
                + " -fx-background-image: url(imagens/RemoUser.png);"
                + " -fx-background-position: center;"
                + " -fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void entrouclicRemoverMerca(MouseEvent event) {
            btnRemoMErc.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: #c90d0d;"
                + " -fx-background-image: url(imagens/RemoUserA.png);"
                + " -fx-background-position: center;"
                + " -fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void clicRemoverMerca(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaRemoverUser.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void saiuVisuMerca(MouseEvent event) {
        btnVisuMer.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: WHite; "
                + "-fx-background-image: url(imagens/UsersA.png);"
                + " -fx-background-position: center; "
                + "-fx-background-repeat: no-repeat;"
                + " -fx-background-radius: 10;");
    }

    @FXML
    private void entrouVisuMerca(MouseEvent event) {
             btnVisuMer.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: #c90d0d; "
                + "-fx-background-image: url(imagens/Users.png);"
                + " -fx-background-position: center; "
                + "-fx-background-repeat: no-repeat;"
                + " -fx-background-radius: 10;");
    }

    @FXML
    private void clicouVisuMerca(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telas/VisuUser.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void usersai(MouseEvent event) {
    }

    @FXML
    private void eserent(MouseEvent event) {
    }

    @FXML
    private void userClic(MouseEvent event) throws IOException {
        
    }
    
}
