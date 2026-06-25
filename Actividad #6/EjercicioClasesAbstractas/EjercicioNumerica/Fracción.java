package EjercicioClasesAbstractas.EjercicioNumerica;

public class Fracción extends Numérica {

    private int numerador;
    private int denominador;

    public Fracción(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    @Override
    public boolean equals(Object ob) {
        Fracción otra = (Fracción) ob;
        return this.numerador == otra.numerador && this.denominador == otra.denominador;
    }

    @Override
    public Numérica sumar(Numérica número) {
        Fracción otra = (Fracción) número;
        int num = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int den = this.denominador * otra.denominador;
        return new Fracción(num, den);
    }

    @Override
    public Numérica restar(Numérica número) {
        Fracción otra = (Fracción) número;
        int num = this.numerador * otra.denominador - otra.numerador * this.denominador;
        int den = this.denominador * otra.denominador;
        return new Fracción(num, den);
    }

    @Override
    public Numérica multiplicar(Numérica número) {
        Fracción otra = (Fracción) número;
        return new Fracción(this.numerador * otra.numerador, this.denominador * otra.denominador);
    }

    @Override
    public Numérica dividir(Numérica número) {
        Fracción otra = (Fracción) número;
        return new Fracción(this.numerador * otra.denominador, this.denominador * otra.numerador);
    }
}
