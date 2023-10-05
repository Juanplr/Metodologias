package Controlador;

import Modelo.Modelo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juanl
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    private Modelo modelo = new Modelo();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void iniciar(ActionEvent event) {
         if(modelo.verificarUsuario(txtUser.getText(), txtPassword.getText())){
             try {
                 Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                 alerta.setContentText("Bienvenido");
                 alerta.setTitle("Acseso Consedido");
                 alerta.showAndWait();
                 cargarVentana("/Vista/WindowHome.fxml", event);
             } catch (Exception e) {
             }
        }else{
            System.out.println("Error Usuario O Contraseña incorrecta");
        }
    }
    private void cargarVentana(String url,Event event) throws IOException{
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene ecena = new Scene(root);
        Stage nuevaS = new Stage();
        nuevaS.setScene(ecena);
        nuevaS.show();
    }
    
}
