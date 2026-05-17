package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Cubo;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel ladoLabel;
    private JLabel volumenLabel;
    private JLabel superficieLabel;
    private JTextField campoLado;
    private JButton calcularButton;

    public VentanaCubo() {
        iniciarComponentes();
        setTitle("Cubo");
        setSize(440, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        ladoLabel = new JLabel("Lado (cms):");
        ladoLabel.setBounds(20, 20, 100, 23);
        campoLado = new JTextField();
        campoLado.setBounds(120, 20, 135, 23);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(120, 55, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel("Volumen (cm3):");
        volumenLabel.setBounds(20, 100, 235, 23);

        superficieLabel = new JLabel("Superficie (cm2):");
        superficieLabel.setBounds(20, 130, 235, 23);

        FiguraImagen imagen = new FiguraImagen("cubo");
        imagen.setBounds(280, 20, 130, 150);

        contenedor.add(ladoLabel);
        contenedor.add(campoLado);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagen);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        try {
            double lado = Double.parseDouble(campoLado.getText());
            Cubo cubo = new Cubo(lado);
            volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
            superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        }
        if (error) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
