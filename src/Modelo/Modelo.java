package Modelo;

import Controlador.Conector;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Modelo {
    private static Conector cn = Conector.getInstance();
    private static Connection conexion;
    public Modelo(){}
    
    public boolean verificarUsuario(String usuario, String contrasena){
        boolean verificacion =false;
        try {
               conexion = cn.conectar();
               Statement stm;
                String sql ="select * from usuarios " 
                        + "where nombre_usuario= '"+usuario+"' and contrasena_usuario='"+contrasena+"'";
                stm = conexion.createStatement();
                ResultSet resultado = stm.executeQuery(sql);
                if(resultado.next()){
                    verificacion = true;
                }else{
                   verificacion = false;
                }
                cn.cerrarconexion();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        return verificacion;
    }
    
    public ResultSet getPacientes() {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from paciente;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }
    public void ActualizarPaciente(Paciente p) {
        try {
            conexion = cn.conectar();
            PreparedStatement ps = conexion.prepareStatement("update paciente set nombre='"+p.getNombre()+"',fecha_nacimiento='"+p.getFechaN()+"', estado_civil='"+p.getEstadoC()+"',nivel_estudios='"+p.getNivelEstud()+"',ocupacion='"+p.getOcupacion()+"' where id='"+p.getId()+"';");
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }
    
}
