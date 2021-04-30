package Vistas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buscar extends JFrame {
    private JPanel panel1;
    private JLabel BuscarPanel;
    private JTextField textField1;
    private JButton regresarButton;

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
    }
}
