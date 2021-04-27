package Vistas;

import javax.swing.*;

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
    }
}
