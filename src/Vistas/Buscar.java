package Vistas;
import com.mysql.jdbc.Connection;
import conexionSQL.conexionSQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Buscar extends JFrame {
    private JPanel panel1;
    private JLabel BuscarPanel;
    private JTextField BuscarField;
    private JButton regresarButton;
    private JButton BuscarBtn;
    private JTextField FindName;
    private JTextField FindStock;
    private JTextField FindSize;
    private JTextField FindCode;
    private JTextField FindPrice;

    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    ResultSet result = null;
    Statement stmt = null;

    public Buscar(){
        add(panel1);
        setTitle("Buscar Pieza Existente");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu a = new Menu();
                a.setVisible(true);

            }
        });

        BuscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buscarProducto();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public ResultSet buscarProducto() throws SQLException {
        ResultSet result = null;
        String query;

        String txt = BuscarField.getText();

        query = String.format("SELECT * FROM product_tbl WHERE Name= '%s' OR Code='%s'", txt, txt);

        stmt = con.createStatement();
        try{
            result = stmt.executeQuery(query);

            if (result.first()) {
                FindName.setText(result.getString("Name"));
                FindCode.setText(result.getString("Code"));
                FindPrice.setText(result.getString("Price"));
                FindSize.setText(result.getString("Size"));
                FindStock.setText(result.getString("Stock"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe");
            }

        }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
        return result;
    }

}
