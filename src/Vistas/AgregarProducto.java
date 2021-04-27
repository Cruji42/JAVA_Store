package Vistas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexionSQL.conexionSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarProducto extends javax.swing.JFrame {



    public AgregarProducto(){

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertar();
                NombreField.setText(null);
                CodigoField.setText(null);
                PrecioField.setText(null);
            }
        });
    }
    @SuppressWarnings("unchecked")

    public static void main(String args[]){
        JFrame frame = new JFrame("AgregarProducto");
        frame.setContentPane(new AgregarProducto().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void insertar(){
        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();
        try {
            String sql = "INSERT INTO product_tbl (Name,Price,Code,Size,Stock) VALUES (?,?,?,?,?); ";

            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);

            int tallaSeleccionada = TallasBox.getSelectedIndex();

            pst.setString(1, NombreField.getText());
            pst.setDouble(2, Double.parseDouble(PrecioField.getText()));
            pst.setString(3, CodigoField.getText());
            pst.setString(4, (String) TallasBox.getItemAt(tallaSeleccionada));
            pst.setString(5, "Disponible");

            pst.execute();

            JOptionPane.showMessageDialog(null, "Tu producto fue agregado!");


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
        }
    }

    private JLabel NombreLabel;
    private JLabel CódigoLabel;
    private JTextField NombreField;
    private JTextField CodigoField;
    private JTextField PrecioField;
    private JComboBox TallasBox;
    private JLabel TítuloLabel;
    private JButton regresarButton;
    private JButton agregarButton;
    private JPanel PanelPrincipal;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}