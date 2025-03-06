package interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import mundo.Cliente;

public class UsuariosRegistrados extends JFrame {
    private JTable tablaUsuarios;
    private JButton btnCerrar;

    public UsuariosRegistrados(List<Cliente> listaClientes) {
        setTitle("Usuarios Registrados");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columnas = {"DNI", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modelo);

        for (Cliente cliente : listaClientes) {
            Object[] fila = {cliente.getDni(), cliente.getNombre(), };
            modelo.addRow(fila);
        }

        add(new JScrollPane(tablaUsuarios), BorderLayout.CENTER);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar, BorderLayout.SOUTH);
    }
}

