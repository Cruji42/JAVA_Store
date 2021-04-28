package Vistas;

import javax.swing.*;
import conexionSQL.conexionSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class Agregar extends JFrame {
    private JLabel AgregarLabel;
    private JPanel AgregarPanel;
    private JLabel NombreLabel;
    private JTextField NombreField;
    private JLabel CodigoLable;
    private JTextField PrecioField;
    private JLabel PrecioLabel;
    private JTextField CodigoField;
    private JButton RegresarButton;
    private JButton ContinuarButton;
    private JLabel TallaLabel;
    private JComboBox TallaBox;

    public Agregar(){
        add(AgregarPanel);
        setTitle("Agregar Nueva Pieza");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

//        ContinuarButton.addActionListener(new ActionListener() {
//           @Override
//           public void actionPerfomed(ActionEvent e) {
//               if(NombreField == null || PrecioField == null || CodigoField == null){
//                   JOptionPane.showMessageDialog(null, "Completa todos los campos");
//               }else{
//                   insertar();
//               }
//        }
//        });

        RegresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu mn = new Menu();
                mn.setVisible(true);
                dispose();
            }
        });
        ContinuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(NombreField.getText() == "" || PrecioField.getText() == "" || CodigoField.getText() == ""){
                   JOptionPane.showMessageDialog(null, "Completa todos los campos");
               }else{
                   insertar();
               }
            }
        });

    }

    public void insertar(){
        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();
        try {
            String sql = "INSERT INTO product_tbl (Name,Price,Code,Size,Stock) VALUES (?,?,?,?,?); ";

            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);

            int tallaSeleccionada = TallaBox.getSelectedIndex();

            pst.setString(1, NombreField.getText());
            pst.setDouble(2, Double.parseDouble(PrecioField.getText()));
            pst.setString(3, CodigoField.getText());
            pst.setString(4, (String) TallaBox.getItemAt(tallaSeleccionada));
            pst.setString(5, "Disponible");
            pst.execute();

            JOptionPane.showMessageDialog(null, "Tu producto fue agregado!");

            NombreField.setText(null);
            PrecioField.setText(null);
            CodigoField.setText(null);

        }catch (Exception e){
           if( e.getMessage() == "empty String"){
               JOptionPane.showMessageDialog(null, "LLena todos los campos");
           }else{
               JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
           }
        }
    }

}
