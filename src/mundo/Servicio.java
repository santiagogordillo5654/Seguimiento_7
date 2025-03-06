package mundo;

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