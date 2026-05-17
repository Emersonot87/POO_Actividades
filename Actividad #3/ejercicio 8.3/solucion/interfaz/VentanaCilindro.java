package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Cilindro;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radioLabel;
    private JLabel alturaLabel;
    private JLabel volumenLabel;
    private JLabel superficieLabel;
    private JTextField campoRadio;
    private JTextField campoAltura;
    private JButton calcularButton;

    public VentanaCilindro() {
        iniciarComponentes();
        setTitle("Cilindro");
        setSize(440, 240);
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

        alturaLabel = new JLabel("Altura (cms):");
        alturaLabel.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(100, 80, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel("Volumen (cm3):");
        volumenLabel.setBounds(20, 110, 235, 23);
        superficieLabel = new JLabel("Superficie (cm2):");
        superficieLabel.setBounds(20, 140, 235, 23);

        FiguraImagen imagen = new FiguraImagen("cilindro");
        imagen.setBounds(280, 20, 130, 140);

        contenedor.add(radioLabel);
        contenedor.add(campoRadio);
        contenedor.add(alturaLabel);
        contenedor.add(campoAltura);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagen);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        try {
            double radio = Double.parseDouble(campoRadio.getText());
            double altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        }
        if (error) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
