package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Prisma;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel baseLabel;
    private JLabel alturaLabel;
    private JLabel profundidadLabel;
    private JLabel volumenLabel;
    private JLabel superficieLabel;
    private JTextField campoBase;
    private JTextField campoAltura;
    private JTextField campoProfundidad;
    private JButton calcularButton;

    public VentanaPrisma() {
        iniciarComponentes();
        setTitle("Prisma");
        setSize(440, 280);
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

        profundidadLabel = new JLabel("Profundidad (cms):");
        profundidadLabel.setBounds(20, 80, 130, 23);
        campoProfundidad = new JTextField();
        campoProfundidad.setBounds(150, 80, 105, 23);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(120, 115, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel("Volumen (cm3):");
        volumenLabel.setBounds(20, 150, 235, 23);

        superficieLabel = new JLabel("Superficie (cm2):");
        superficieLabel.setBounds(20, 180, 235, 23);

        FiguraImagen imagen = new FiguraImagen("prisma");
        imagen.setBounds(280, 20, 130, 170);

        contenedor.add(baseLabel);
        contenedor.add(campoBase);
        contenedor.add(alturaLabel);
        contenedor.add(campoAltura);
        contenedor.add(profundidadLabel);
        contenedor.add(campoProfundidad);
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
            double profundidad = Double.parseDouble(campoProfundidad.getText());
            Prisma prisma = new Prisma(base, altura, profundidad);
            volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", prisma.calcularVolumen()));
            superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", prisma.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        }
        if (error) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
