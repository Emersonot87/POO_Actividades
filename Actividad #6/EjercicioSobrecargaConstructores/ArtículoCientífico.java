package EjercicioSobrecargaConstructores;

public class ArtículoCientífico {

    String título; 
    String autor; 
    String[] palabrasClaves = new String[3];
    String publicación;
    int año;
    String resumen;
    

    public ArtículoCientífico(String título, String autor) {
        this.título = título;
        this.autor = autor;
    }

    public ArtículoCientífico(String título, String autor, String[] palabrasClaves, String publicación, int año) {
        this(título, autor); 
        this.palabrasClaves = palabrasClaves;
        this.publicación = publicación;
        this.año = año;
    }

    public ArtículoCientífico(String título, String autor, String[] palabrasClaves, String publicación, int año, String resumen) {
        this(título, autor, palabrasClaves, publicación, año);
        this.resumen = resumen;
    }

    public void imprimir() {
        System.out.println("Título del artículo = " + título);
        System.out.println("Autor del artículo = " + autor);
        System.out.println("Palabras clave = ");

        for (int i = 0; i < palabrasClaves.length; i++) {
            System.out.println(palabrasClaves[i]);
        }

        System.out.println("Publicación = " + publicación);
        System.out.println("Año = " + año);
        System.out.println("Resumen = " + resumen);
    }

    public static void main (String args[]) {
        String[] palabras = {"Física","Espacio","Tiempo"};
        String[] palabras2 = {"Fluido","Electricidad","Tormenta"};
        ArtículoCientífico artículo1 = new ArtículoCientífico("La teoría especial de la relatividad", "Albert Einstein", palabras, "Anales de Física", 1913, "Las leyes de la física son las mismas en todos los sistemas de referencia inerciales.");
        artículo1.imprimir();
        System.out.println();

        ArtículoCientífico artículo2 = new ArtículoCientífico("La presente situación en mecánica cuántica", "Erwin Schrödinger");
        artículo2.imprimir();
        System.out.println();

        ArtículoCientífico artículo3 = new ArtículoCientífico("Dinámica de fluidos de las nubes de tormenta", "Edward Lorenz", palabras2, "Journal of the Atmospheric Sciences", 1963);
        artículo3.imprimir();
    }
}