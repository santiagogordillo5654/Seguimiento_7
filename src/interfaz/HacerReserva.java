package interfaz;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import mundo.Cliente;
import mundo.Reserva;
import mundo.Habitacion;
import mundo.Servicio;

public class HacerReserva extends JFrame {
    private JComboBox<String> cbUsuarios, cbTipoHabitacion, cbServicios;
    private JTextField txtFechaEntrada, txtFechaSalida, txtNumeroHabitacion;
    private JButton btnReservar;
    private List<Cliente> listaClientes;
    private List<Reserva> listaReservas;

    public HacerReserva(List<Cliente> listaClientes, List<Reserva> listaReservas) {
        this.listaClientes = listaClientes;
        this.listaReservas = listaReservas;
        setTitle("Hacer Reserva");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel("Usuario:"));
        cbUsuarios = new JComboBox<>();
        actualizarComboUsuarios();
        add(cbUsuarios);

        add(new JLabel("Tipo de Habitación:"));
        cbTipoHabitacion = new JComboBox<>(new String[]{"Simple", "Doble", "Suite"});
        add(cbTipoHabitacion);

        add(new JLabel("Servicio:"));
        cbServicios = new JComboBox<>(new String[]{"Spa", "Restaurante", "Limpieza"});
        add(cbServicios);

        add(new JLabel("Fecha Entrada (YYYY-MM-DD):"));
        txtFechaEntrada = new JTextField();
        add(txtFechaEntrada);

        add(new JLabel("Fecha Salida (YYYY-MM-DD):"));
        txtFechaSalida = new JTextField();
        add(txtFechaSalida);

        add(new JLabel("Número de Habitación:"));
        txtNumeroHabitacion = new JTextField();
        add(txtNumeroHabitacion);

        btnReservar = new JButton("Reservar");
        add(btnReservar);

        btnReservar.addActionListener(e -> realizarReserva());
    }

    private void actualizarComboUsuarios() {
        cbUsuarios.removeAllItems();
        for (Cliente cliente : listaClientes) {
            cbUsuarios.addItem(cliente.getDni());
        }
    }

    private void realizarReserva() {
        if (cbUsuarios.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "No hay usuarios disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dni = (String) cbUsuarios.getSelectedItem();
        String tipoHabitacion = (String) cbTipoHabitacion.getSelectedItem();
        String servicio = (String) cbServicios.getSelectedItem();
        LocalDate fechaEntrada, fechaSalida;
        int numeroHabitacion;

        try {
            fechaEntrada = LocalDate.parse(txtFechaEntrada.getText().trim());
            fechaSalida = LocalDate.parse(txtFechaSalida.getText().trim());
            if (fechaSalida.isBefore(fechaEntrada)) {
                JOptionPane.showMessageDialog(null, "La fecha de salida no puede ser anterior a la fecha de entrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            numeroHabitacion = Integer.parseInt(txtNumeroHabitacion.getText().trim());
            if (numeroHabitacion <= 0) {
                JOptionPane.showMessageDialog(null, "El número de habitación debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El número de habitación debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = listaClientes.stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Habitacion habitacion = new Habitacion(numeroHabitacion, tipoHabitacion);
        Servicio servicioHabitacion = new Servicio(servicio);
        Reserva nuevaReserva = new Reserva(cliente, habitacion, fechaEntrada, fechaSalida, servicioHabitacion);

        listaReservas.add(nuevaReserva);
        JOptionPane.showMessageDialog(null, "Reserva realizada con éxito.");
        dispose();
    }
}