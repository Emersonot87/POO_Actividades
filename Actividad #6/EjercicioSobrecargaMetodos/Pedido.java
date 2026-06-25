package EjercicioSobrecargaMetodos;

public class Pedido {

    public void calcularPedido(String primerPlato, double costoPrimerPlato, String bebida, double costoBebida) 
    {
        double total = costoPrimerPlato + costoBebida; 
        System.out.println("El costo de " + primerPlato + " y " + bebida + " es = $" + total);
    }

    public void calcularPedido(String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato, String bebida, double costoBebida) 
    {
        double total = costoPrimerPlato + costoSegundoPlato +costoBebida;
        System.out.println("El costo de " + primerPlato + " + " +segundoPlato + " + " + bebida + " es = $" + total);
    }

    public void calcularPedido(String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato, String postre, double costoPostre, String bebida, double costoBebida) 
    {
        double total = costoPrimerPlato + costoSegundoPlato + costoBebida + costoPostre;
        System.out.println("El costo de " + primerPlato + " + " +segundoPlato + " + " + bebida + " + " + postre + " es = $" + total);
    }

    public static void main (String args[]) {
        Pedido pedido1 = new Pedido();
        pedido1.calcularPedido("Sancocho", 5000, "Gaseosa", 2000);
        
        Pedido pedido2 = new Pedido();
        pedido2.calcularPedido("Crema de verduras", 5000, "Churrasco", 6000, "Gaseosa", 2000);
        
        Pedido pedido3 = new Pedido();
        pedido3.calcularPedido("Crema de espinacas", 5000, "Salmón", 10000, "Tiramisú", 5000, "Gaseosa", 2000);
    }

}  