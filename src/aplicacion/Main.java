package aplicacion;

import interfaz.VentanaPrincipal;
import mundo.Cliente;
import mundo.Reserva;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        List<Reserva> listaReservas = new ArrayList<>();

        listaClientes.add(new Cliente("Juan Pérez","12345678"));
        listaClientes.add(new Cliente( "María Gómez","87654321"));

        SwingUtilities.invokeLater(() -> new VentanaPrincipal(listaClientes, listaReservas).setVisible(true));
    }
}
