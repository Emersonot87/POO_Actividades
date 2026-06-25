package EjercicioSobrecargaConstructores;

public class Empleado {

    int identificador;
    String nombre;
    String apellidos;
    int edad;

    public Empleado() {
        this(100, "Nuevo empleado", "Nuevo empleado", 18);
    }

    public Empleado(int identificador, String nombre, String apellidos, int edad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public void imprimir() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Edad: " + edad);
    }

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado();
        System.out.println("=== Empleado 1 (valores por defecto) ===");
        empleado1.imprimir();

        System.out.println();

        Empleado empleado2 = new Empleado(200, "Juan", "García López", 30);
        System.out.println("=== Empleado 2 (valores personalizados) ===");
        empleado2.imprimir();
    }
}