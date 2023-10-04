package proyectometodologias;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author inigu
 */
public class ProyectoMetodologias extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        try {
            //Cargo la vista
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ProyectoMetodologias.class.getResource("Login.fxml"));
            
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();
            
            // Cargo el scene
            Scene scene = new Scene(ventana);
            
            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
