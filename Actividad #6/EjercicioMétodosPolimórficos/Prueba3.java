package EjercicioMétodosPolimórficos;

public class Prueba3 {

    public static void main(String[] args) {
        Profesor profesor1 = new ProfesorTitular();
        profesor1.imprimir();
        profesor1.espacio();


        ProfesorTitular profesor2 = new ProfesorTitular();
        profesor2.años = 10;
        profesor2.imprimir();
        profesor2.imprimirAños();
        profesor2.espacio();
    }
}