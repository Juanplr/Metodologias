package Controlador;

import Modelo.Modelo;
import Modelo.Paciente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {
    Paciente p;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtFechaNacimiento;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableView<Paciente> tablaP;
    @FXML
    private TableColumn<Paciente, Integer> columId;
    @FXML
    private TableColumn<Paciente, String> columNombre;
    @FXML
    private TableColumn<Paciente, String> columFN;
    @FXML
    private TableColumn<Paciente, String> columEC;
    @FXML
    private TableColumn<Paciente, String> columNivelE;
    @FXML
    private TableColumn<Paciente, String> columOcup;
    @FXML
    private Button botonAgregar;
    @FXML
    private TextField txtEC;
    @FXML
    private TextField txtOcupacion;
    @FXML
    private TextField txtNivelE;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        this.columId.setCellValueFactory(new PropertyValueFactory("id"));
        this.columNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.columFN.setCellValueFactory(new PropertyValueFactory("fechaN"));
        this.columEC.setCellValueFactory(new PropertyValueFactory("estadoC"));
        this.columNivelE.setCellValueFactory(new PropertyValueFactory("nivelEstud"));
        this.columOcup.setCellValueFactory(new PropertyValueFactory("ocupacion"));
        
        mostarPacientes();
    }


    @FXML
    private void selecionar(MouseEvent event) {
         try {
            Paciente p = tablaP.getSelectionModel().getSelectedItem();
            p = new Paciente(p.getId(), p.getNombre(), p.getFechaN(), p.getEstadoC(), p.getNivelEstud(), p.getOcupacion());
            this.p = p;
            txtNombre.setText(p.getNombre());
            txtID.setText(""+p.getId());
            txtNivelE.setText(p.getNivelEstud());
            txtFechaNacimiento.setText(p.getFechaN());
            txtEC.setText(p.getEstadoC());
            txtOcupacion.setText(p.getOcupacion());
        } catch (Exception e) {
        }
    }

    
    @FXML
private void agegar(ActionEvent event) { 
   try {
        Paciente np = new Paciente();
        Modelo m = new Modelo();
    
        // Verifica que el campo de ID no esté vacío antes de intentar la conversión
        if (!txtID.getText().isEmpty()) {
            np.setId(Integer.parseInt(txtID.getText()));
        } else {
            System.out.println("El campo ID no puede estar vacío.");
            return;
        }

        np.setNombre(txtNombre.getText());
        np.setFechaN(txtFechaNacimiento.getText());
        np.setEstadoC(txtEC.getText());
        np.setNivelEstud(txtNivelE.getText());
        np.setOcupacion(txtOcupacion.getText());  

        // Agrega un mensaje de depuración para verificar los datos antes de agregar el paciente
        System.out.println("Paciente a agregar: " + np.toString());

        m.agregarPaciente(np);
        mostarPacientes();
    } catch (NumberFormatException e) {
        System.out.println("Error al convertir el ID a entero: " + e.getMessage());
    }
}


    @FXML
    private void ActualizarP(MouseEvent event) {
         Paciente pa = new Paciente();
         pa.setId(Integer.parseInt(txtID.getText()));
         pa.setNombre(txtNombre.getText());
         pa.setFechaN(txtFechaNacimiento.getText());
         pa.setEstadoC(txtEC.getText());
         pa.setNivelEstud(txtNivelE.getText());
         pa.setOcupacion(txtOcupacion.getText());
         Modelo m = new Modelo();
         m.ActualizarPaciente(pa);
         mostarPacientes();
       
    }

    private void mostarPacientes(){
        Paciente s = new Paciente();
        ObservableList<Paciente> items = s.getServicios();
        this.tablaP.setItems(items);
    }
    
}
