package EjercicioPolimorfismo;

public class Prueba {
    public static void main(String[] args) {
        Profesor profesor1 = new ProfesorTitular();
        profesor1.imprimir();
    }

    public class Prueba2 {
        public static void main(String[] args) {
            Profesor profesor1 = new ProfesorTitular();
            Profesor profesor2 = (Profesor) profesor1;
            profesor2.imprimir();
        }
    }
}
