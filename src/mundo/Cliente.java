package mundo;

import java.util.ArrayList;
import java.util.List;

// Clase Cliente
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