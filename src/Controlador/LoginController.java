package Controlador;

import Modelo.Modelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
            System.out.println("Welcome!!!");
        }else{
            System.out.println("Error Usuario O Contraseña incorrecta");
        }
    }
    
}
