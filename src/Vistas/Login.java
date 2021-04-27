package Vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import conexionSQL.conexionSQL;

public class Login extends javax.swing.JFrame {

    private JPanel LoginPanel;
    private JButton entrarButton;
    private JTextField EmailField;
    private JPasswordField PasswordField;
    private JLabel TitleLabel;
    private JLabel EmailLabel;
    private JLabel PasswordLabel;

    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    ResultSet result = null;
    Statement stmt = null;
    String Password = null;
    String Email = null;

    public Login()
    {
//        AgregarProducto agregarProducto = new AgregarProducto();
        add(LoginPanel);
        setTitle("Login");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);


        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
                EmailField.setText(null);
                PasswordField.setText(null);
            }
        });

    }

    @SuppressWarnings("unchecked")

    public void login(){
        try {

            String sql = "SELECT * FROM user_tbl WHERE Email = ? and Password = ?";

//            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setString(1, EmailField.getText());
//            pst.setString(2, PasswordField.getText());
            stmt = con.createStatement();
            result = stmt.executeQuery("SELECT * FROM user_tbl WHERE Email='"+EmailField.getText()+"' AND Password ='"+
                    new String(PasswordField.getPassword())+"'");

            while (result.next()) {
                Email = result.getString("Email");
                Password = result.getString("Password");
            }

            if(Email != null && Password != null){
                Demo dm = new Demo();
                dm.setVisible(true);
                dispose();
                Password = null;
                Email = null;
            }else {
                JOptionPane.showMessageDialog(null,"Datos Erroneos");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en login: "+ e.getMessage());
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
