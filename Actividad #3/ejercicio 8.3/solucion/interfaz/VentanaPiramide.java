package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Piramide;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel baseLabel;
    private JLabel alturaLabel;
    private JLabel apotemaLabel;
    private JLabel volumenLabel;
    private JLabel superficieLabel;
    private JTextField campoBase;
    private JTextField campoAltura;
    private JTextField campoApotema;
    private JButton calcularButton;

    public VentanaPiramide() {
        iniciarComponentes();
        setTitle("Pirámide");
        setSize(440, 270);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        baseLabel = new JLabel("Base (cms):");
        baseLabel.setBounds(20, 20, 100, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        alturaLabel = new JLabel("Altura (cms):");
        alturaLabel.setBounds(20, 50, 100, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        apotemaLabel = new JLabel("Apotema (cms):");
        apotemaLabel.setBounds(20, 80, 100, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(120, 110, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel("Volumen (cm3):");
        volumenLabel.setBounds(20, 140, 235, 23);
        superficieLabel = new JLabel("Superficie (cm2):");
        superficieLabel.setBounds(20, 170, 235, 23);

        FiguraImagen imagen = new FiguraImagen("piramide");
        imagen.setBounds(280, 20, 130, 160);

        contenedor.add(baseLabel);
        contenedor.add(campoBase);
        contenedor.add(alturaLabel);
        contenedor.add(campoAltura);
        contenedor.add(apotemaLabel);
        contenedor.add(campoApotema);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagen);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        try {
            double base = Double.parseDouble(campoBase.getText());
            double altura = Double.parseDouble(campoAltura.getText());
            double apotema = Double.parseDouble(campoApotema.getText());
            Piramide piramide = new Piramide(base, altura, apotema);
            volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", piramide.calcularVolumen()));
            superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", piramide.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        }
        if (error) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
