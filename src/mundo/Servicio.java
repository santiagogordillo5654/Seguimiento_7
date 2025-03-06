package mundo;
/*
 * @author Santiago Gordillo Molina,Sebastian Roman Sanchez
 * 
 * Universidad del Quindio
 * Facultad de ingenieria 
 * ingenieria de sistemas y computacion
 */
public class Servicio implements Consumible {
    private String nombre;

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void consumir() {
        System.out.println("Servicio " + nombre + " consumido.");
    }
}