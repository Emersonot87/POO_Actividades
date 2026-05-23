package interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FiguraImagen extends JPanel {
    private final String tipo;
    private Image imagen;

    public FiguraImagen(String tipo) {
        this.tipo = tipo;
        setPreferredSize(new Dimension(140, 140));
        setBackground(Color.WHITE);
        cargarImagen();
    }

    private void cargarImagen() {
        String nombreArchivo;
        if ("cubo".equals(tipo)) {
            nombreArchivo = "cubo.jpg";
        } else if ("cilindro".equals(tipo)) {
            nombreArchivo = "cilindro.png";
        } else if ("esfera".equals(tipo)) {
            nombreArchivo = "esfera.png";
        } else if ("piramide".equals(tipo)) {
            nombreArchivo = "piramide.jpeg";
        } else if ("prisma".equals(tipo)) {
            nombreArchivo = "prisma.png";
        } else {
            nombreArchivo = null;
        }

        if (nombreArchivo == null) {
            return;
        }

        File imagenDir = buscarDirectorioImagenes();
        if (imagenDir == null) {
            return;
        }

        File archivo = new File(imagenDir, nombreArchivo);
        if (!archivo.exists()) {
            return;
        }

        try {
            imagen = ImageIO.read(archivo);
            if (imagen != null) {
                imagen = imagen.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            }
        } catch (IOException ignored) {
        }
    }

    private File buscarDirectorioImagenes() {
        File actual = new File(System.getProperty("user.dir"));
        
        File directo = new File(actual, "imagenes");
        if (directo.isDirectory()) {
            return directo;
        }
        
        directo = new File(actual.getParentFile(), "imagenes");
        if (directo != null && directo.isDirectory()) {
            return directo;
        }
        
        directo = new File(actual, "solucion" + File.separator + "imagenes");
        if (directo.isDirectory()) {
            return directo;
        }
        
        directo = new File(actual, "ejercicio 8.3" + File.separator + "solucion" + File.separator + "imagenes");
        if (directo.isDirectory()) {
            return directo;
        }

        File actual2 = actual;
        for (int i = 0; i < 8 && actual2 != null; i++) {
            File candidato = new File(actual2, "imagenes");
            if (candidato.isDirectory()) {
                return candidato;
            }
            actual2 = actual2.getParentFile();
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            int x = (getWidth() - imagen.getWidth(this)) / 2;
            int y = (getHeight() - imagen.getHeight(this)) / 2;
            g.drawImage(imagen, x, y, this);
        } else {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawString("Imagen no disponible", 10, getHeight() / 2);
        }
    }
}
