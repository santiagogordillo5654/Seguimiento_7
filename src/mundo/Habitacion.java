package mundo;

public class Habitacion {
    private int numero;
    private String tipo; // "Simple", "Doble", "Suite"
    private double precio;

    // Constructor original
    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Nuevo constructor que solo recibe número y tipo
    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = asignarPrecio(tipo);
    }

    private double asignarPrecio(String tipo) {
        return switch (tipo) {
            case "Simple" -> 50.0;
            case "Doble" -> 80.0;
            case "Suite" -> 120.0;
            default -> 0.0;
        };
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}
