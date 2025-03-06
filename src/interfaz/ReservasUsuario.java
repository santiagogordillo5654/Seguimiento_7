package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.stream.Collectors;
import mundo.Cliente;
import mundo.Reserva;
import java.time.LocalDate;

public class ReservasUsuario extends JFrame {
    private JComboBox<String> cbCedulas;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaReservas;
    private JButton btnEliminar, btnEditar;
    private List<Cliente> listaClientes;
    private List<Reserva> listaReservasTotales;

    public ReservasUsuario(List<Cliente> listaClientes, List<Reserva> listaReservasTotales) {
        this.listaClientes = listaClientes;
        this.listaReservasTotales = listaReservasTotales;

        setTitle("Reservas por Usuario");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con ComboBox de cédulas
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Seleccionar cédula:"));
        cbCedulas = new JComboBox<>();
        actualizarComboBox();
        panelSuperior.add(cbCedulas);
        add(panelSuperior, BorderLayout.NORTH);

        // Lista de reservas
        modeloLista = new DefaultListModel<>();
        listaReservas = new JList<>(modeloLista);
        add(new JScrollPane(listaReservas), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnEliminar = new JButton("Eliminar Reserva");
        btnEditar = new JButton("Editar Reserva");
        panelBotones.add(btnEliminar);
        panelBotones.add(btnEditar);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        cbCedulas.addActionListener(e -> actualizarListaReservas());
        btnEliminar.addActionListener(this::eliminarReserva);
        btnEditar.addActionListener(this::editarReserva);
    }

    private void actualizarComboBox() {
        cbCedulas.removeAllItems();
        for (Cliente cliente : listaClientes) {
            cbCedulas.addItem(cliente.getDni());
        }
    }

    private void actualizarListaReservas() {
        modeloLista.clear();
        String cedulaSeleccionada = (String) cbCedulas.getSelectedItem();
        if (cedulaSeleccionada == null) return;

        List<Reserva> reservasFiltradas = listaReservasTotales.stream()
                .filter(r -> r.getCliente().getDni().equals(cedulaSeleccionada))
                .collect(Collectors.toList());

        for (Reserva reserva : reservasFiltradas) {
            modeloLista.addElement("Habitación " + reserva.getHabitacion().getNumero() +
                    " | Entrada: " + reserva.getFechaEntrada() +
                    " | Salida: " + reserva.getFechaSalida());
        }
    }

    private void eliminarReserva(ActionEvent e) {
        int indice = listaReservas.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cedulaSeleccionada = (String) cbCedulas.getSelectedItem();
        List<Reserva> reservasFiltradas = listaReservasTotales.stream()
                .filter(r -> r.getCliente().getDni().equals(cedulaSeleccionada))
                .collect(Collectors.toList());

        listaReservasTotales.remove(reservasFiltradas.get(indice));
        actualizarListaReservas();
        JOptionPane.showMessageDialog(this, "Reserva eliminada con éxito.");
    }

    private void editarReserva(ActionEvent e) {
        int indice = listaReservas.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cedulaSeleccionada = (String) cbCedulas.getSelectedItem();
        List<Reserva> reservasFiltradas = listaReservasTotales.stream()
                .filter(r -> r.getCliente().getDni().equals(cedulaSeleccionada))
                .collect(Collectors.toList());

        Reserva reservaSeleccionada = reservasFiltradas.get(indice);

        // Solicitar nuevas fechas
        String nuevaFechaEntrada = JOptionPane.showInputDialog(this, "Nueva fecha de entrada (YYYY-MM-DD):", reservaSeleccionada.getFechaEntrada());
        String nuevaFechaSalida = JOptionPane.showInputDialog(this, "Nueva fecha de salida (YYYY-MM-DD):", reservaSeleccionada.getFechaSalida());

        try {
            LocalDate fechaEntrada = LocalDate.parse(nuevaFechaEntrada);
            LocalDate fechaSalida = LocalDate.parse(nuevaFechaSalida);

            if (fechaSalida.isBefore(fechaEntrada)) {
                JOptionPane.showMessageDialog(this, "La fecha de salida no puede ser antes de la de entrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            reservaSeleccionada.setFechaEntrada(fechaEntrada);
            reservaSeleccionada.setFechaSalida(fechaSalida);
            actualizarListaReservas();
            JOptionPane.showMessageDialog(this, "Reserva actualizada con éxito.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
