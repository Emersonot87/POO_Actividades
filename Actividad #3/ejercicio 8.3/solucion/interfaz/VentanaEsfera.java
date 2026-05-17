package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Esfera;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radioLabel;
    private JLabel volumenLabel;
    private JLabel superficieLabel;
    private JTextField campoRadio;
    private JButton calcularButton;

    public VentanaEsfera() {
        iniciarComponentes();
        setTitle("Esfera");
        setSize(440, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radioLabel = new JLabel("Radio (cms):");
        radioLabel.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(120, 20, 135, 23);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(100, 50, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel("Volumen (cm3):");
        volumenLabel.setBounds(20, 90, 235, 23);
        superficieLabel = new JLabel("Superficie (cm2):");
        superficieLabel.setBounds(20, 120, 235, 23);

        FiguraImagen imagen = new FiguraImagen("esfera");
        imagen.setBounds(280, 20, 130, 140);

        contenedor.add(radioLabel);
        contenedor.add(campoRadio);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagen);
    }

    public void actionPerformed(ActionEvent evento) {
        boolean error = false;
        try {
            double radio = Double.parseDouble(campoRadio.getText());
            Esfera esfera = new Esfera(radio);
            volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
            superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        }
        if (error) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
