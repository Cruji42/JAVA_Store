package conexionSQL;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import javax.swing.*;
import java.sql.DriverManager;

public class conexionSQL {
    Connection conectar = null;

public Connection conexion(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/diego_store","root","");
        //JOptionPane.showMessageDialog(null,"Conexión Establecida");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error de conexion:" + e.getMessage());
    }
    return conectar;
}
}
