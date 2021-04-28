package Vistas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel MenuPanel;
    private JButton BuscarBtn;
    private JButton AñadirBtn;

    public Menu(){
        add(MenuPanel);
        setTitle("Menu");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

        AñadirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Agregar a = new Agregar();
                a.setVisible(true);

            }
        });
        BuscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Buscar a = new Buscar();
                a.setVisible(true);

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
