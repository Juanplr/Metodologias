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
