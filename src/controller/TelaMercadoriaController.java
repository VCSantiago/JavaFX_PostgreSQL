
package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaMercadoriaController {
  
    @FXML
    private Button btnC;
    @FXML
    private Button venda;
    @FXML
    private Button user;
    @FXML
    private Button botaoMerca;
    @FXML
    private Button btnRemoMErc;
    @FXML
    private Button btnVisuMer;

   
    @FXML
    private void mouseEC(MouseEvent event) {
         btnC.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                 + "-fx-background-color:  #c90d0d"
                 + "; -fx-background-image: url(imagens/CMerA.png); "
                 + "-fx-background-position: center; "
                 + "-fx-background-repeat: no-repeat;"
                 + " -fx-background-radius: 10;");
    }
    @FXML
    private void mouseSC(MouseEvent event) {
        btnC.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0);"
                + " -fx-background-color: WHite;"
                + " -fx-background-image: url(imagens/CMer.png);"
                + " -fx-background-position: center;"
                + " -fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void telaCadas(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCadasPro.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    /*botao vendas*/
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
    /*
    
    
    */
    
    
    /*botao usuarios*/
    @FXML
    private void usersai(MouseEvent event) {
         user.setStyle("-fx-background-color: #c90d0d; "
                + "-fx-background-image: url(imagens/UserA.png);"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 0;");
    }

    @FXML
    private void eserent(MouseEvent event) {
         user.setStyle("-fx-background-color: White; "
                + "-fx-background-image: url(imagens/User.png);"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 0;");
    }
    @FXML
    private void usuClick(MouseEvent event) {
        Main.trocaTela(4);
    }
    
    
    /*botao remover mercadoria*/
    @FXML
    private void saiuclicRemoverMerca(MouseEvent event) {
        btnRemoMErc.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: WHite; "
                + "-fx-background-image: url(imagens/RMer.png);"
                + " -fx-background-position: center; "
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void entrouclicRemoverMerca(MouseEvent event) {
         btnRemoMErc.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: #c90d0d; "
                + "-fx-background-image: url(imagens/RMerA.png);"
                + " -fx-background-position: center; "
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void clicRemoverMerca(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaRemoPro.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*
    
    */
    /*
    botao visualizar mercadoria
    */
    @FXML
    private void saiuVisuMerca(MouseEvent event) {
        btnVisuMer.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: WHite; "
                + "-fx-background-image: url(imagens/VMer.png);"
                + "-fx-background-position: center; -fx-background-repeat: no-repeat;"
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void entrouVisuMerca(MouseEvent event) {
         btnVisuMer.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 0); "
                + "-fx-background-color: #c90d0d; "
                + "-fx-background-image: url(imagens/VMerA.png);"
                + "-fx-background-position: center; -fx-background-repeat: no-repeat;"
                + "-fx-background-radius: 10;");
    }

    @FXML
    private void clicouVisuMerca(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaVisuMerca.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
 

   

   
}
