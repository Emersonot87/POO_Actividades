package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindroButton;
    private JButton esferaButton;
    private JButton piramideButton;
    private JButton cuboButton;
    private JButton prismaButton;

    public VentanaPrincipal() {
        iniciarComponentes();
        setTitle("Figuras");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindroButton = new JButton("Cilindro");
        cilindroButton.setBounds(20, 50, 100, 23);
        cilindroButton.addActionListener(this);

        esferaButton = new JButton("Esfera");
        esferaButton.setBounds(140, 50, 100, 23);
        esferaButton.addActionListener(this);

        cuboButton = new JButton("Cubo");
        cuboButton.setBounds(20, 90, 100, 23);
        cuboButton.addActionListener(this);

        prismaButton = new JButton("Prisma");
        prismaButton.setBounds(140, 90, 100, 23);
        prismaButton.addActionListener(this);

        piramideButton = new JButton("Pirámide");
        piramideButton.setBounds(260, 50, 100, 23);
        piramideButton.addActionListener(this);

        contenedor.add(cilindroButton);
        contenedor.add(esferaButton);
        contenedor.add(cuboButton);
        contenedor.add(prismaButton);
        contenedor.add(piramideButton);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esferaButton) {
            VentanaEsfera ventana = new VentanaEsfera();
            ventana.setVisible(true);
        }
        if (evento.getSource() == cilindroButton) {
            VentanaCilindro ventana = new VentanaCilindro();
            ventana.setVisible(true);
        }
        if (evento.getSource() == cuboButton) {
            VentanaCubo ventana = new VentanaCubo();
            ventana.setVisible(true);
        }
        if (evento.getSource() == prismaButton) {
            VentanaPrisma ventana = new VentanaPrisma();
            ventana.setVisible(true);
        }
        if (evento.getSource() == piramideButton) {
            VentanaPiramide ventana = new VentanaPiramide();
            ventana.setVisible(true);
        }
    }
}
