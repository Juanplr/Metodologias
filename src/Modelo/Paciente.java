package Modelo;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author juanl
 */
public class Paciente {
    private int id;
    private String nombre;
    private String fechaN;
    private String estadoC;
    private String nivelEstud;
    private String ocupacion;

    public Paciente(){
    }
    public Paciente(int id, String nombre, String fechaN, String estadoC, String nivelEstud, String ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaN = fechaN;
        this.estadoC = estadoC;
        this.nivelEstud = nivelEstud;
        this.ocupacion = ocupacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaN() {
        return fechaN;
    }

    public String getEstadoC() {
        return estadoC;
    }

    public String getNivelEstud() {
        return nivelEstud;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public void setEstadoC(String estadoC) {
        this.estadoC = estadoC;
    }

    public void setNivelEstud(String nivelEstud) {
        this.nivelEstud = nivelEstud;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
     public ObservableList<Paciente> getServicios() {
        ObservableList<Paciente> obs = FXCollections.observableArrayList();
        try {

            // Abro la conexion
            Modelo conexion = new Modelo();;

            ResultSet rs = conexion.getPacientes();

            // recorro los resultados
            while (rs.next()) {

                // Cojo los datos
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String fechaN = rs.getString("fecha_nacimiento");
                String estadoC = rs.getString("estado_civil");
                String nivelEstud = rs.getString("nivel_estudios");
                String ocupacion = rs.getString("ocupacion");

                // Creo el servicio
                Paciente p = new Paciente(id, nombre, fechaN, estadoC, nivelEstud, ocupacion);

                obs.add(p);

            }

        } catch (SQLException ex) {
            //Logger.getLogger(Paciente.class.getName()).log(Level.WARNING, null, ex);
        }
        return obs;
    }
    
    
}
