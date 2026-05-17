package logica;

/**
 * Esta clase denominada FiguraGeométrica modela un figura geométrica
 * que cuenta con un volumen y una superficie a ser calculados de
 * acuerdo al tipo de figura geométrica.
 * @version 1.2/2020
 */
public class FiguraGeométrica {
    private double volumen;
    private double superficie;

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getVolumen() {
        return this.volumen;
    }

    public double getSuperficie() {
        return this.superficie;
    }
}
