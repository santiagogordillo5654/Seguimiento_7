package mundo;
/*
 * @author Santiago Gordillo Molina,Sebastian Roman Sanchez
 * Clase que tiene parametros para cliente
 * Universidad del Quindio
 * Facultad de ingenieria 
 * ingenieria de sistemas y computacion
 */
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private List<Reserva> reservas;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
}