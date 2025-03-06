package mundo;
/*
 * @author Santiago Gordillo Molina,Sebastian Roman Sanchez
 * 
 * Universidad del Quindio
 * Facultad de ingenieria 
 * ingenieria de sistemas y computacion
 */
public class Habitacion {
    private int numero;
    private String tipo; 
    private double precio;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = asignarPrecio(tipo);
    }
    /*
     * @author Santiago Gordillo Molina,Sebastian Roman Sanchez
     * metodo para asiganar precios 
     */
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
