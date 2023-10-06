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
    
}
