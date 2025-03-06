package interfaz;

/*
 * @author Santiago Gordillo Molina,Sebastian Roman Sanchez


 */  
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import mundo.Cliente;

public class RegistroUsuario extends JFrame {
    private JTextField txtNombre, txtDni;
    private JButton btnRegistrar;
    private List<Cliente> listaClientes;

    public RegistroUsuario(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
        setTitle("Registro de Usuario");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("DNI:"));
        txtDni = new JTextField();
        add(txtDni);

        btnRegistrar = new JButton("Registrar");
        add(btnRegistrar);

        btnRegistrar.addActionListener((ActionEvent e) -> {
            String nombre = txtNombre.getText().trim();
            String dni = txtDni.getText().trim();

            if (!nombre.isEmpty() && !dni.isEmpty()) {
                Cliente nuevoCliente = new Cliente(nombre, dni);
                listaClientes.add(nuevoCliente);
                JOptionPane.showMessageDialog(null, "Usuario registrado: " + nombre);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}