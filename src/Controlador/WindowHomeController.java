package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juanl
 */
public class WindowHomeController implements Initializable {

    @FXML
    private Button btnPaciente;
    @FXML
    private Button btnPsicologo;
    @FXML
    private Button bntSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    

    @FXML
    private void pacientes(ActionEvent event) {
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FXMLDocument.fxml"));
        
        Parent root = loader.load();
        Scene ecena = new Scene(root);
        Stage nuevaS = new Stage();
        nuevaS.setScene(ecena);
        nuevaS.show();
        
        } catch (IOException ex) {
            Logger.getLogger(WindowHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
