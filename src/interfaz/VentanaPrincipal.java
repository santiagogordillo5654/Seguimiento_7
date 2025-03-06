package interfaz;

/*
 * @author Santiago Gordillo Molina,Sebastian Roman Sanchez
 * 

 */  
import javax.swing.*;
import java.awt.*;
import java.util.List;
import mundo.Cliente;
import mundo.Reserva;

public class VentanaPrincipal extends JFrame {
    private JButton btnRegistrarUsuario;
    private JButton btnUsuariosRegistrados;
    private JButton btnHacerReserva;
    private JButton btnReservasUsuario;
    private List<Cliente> listaClientes;
    private List<Reserva> listaReservas;

    public VentanaPrincipal(List<Cliente> listaClientes, List<Reserva> listaReservas) {
        this.listaClientes = listaClientes;
        this.listaReservas = listaReservas;
        setTitle("Gestión de Hotel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        btnRegistrarUsuario = new JButton("Registrar Usuario");
        btnUsuariosRegistrados = new JButton("Usuarios Registrados");
        btnHacerReserva = new JButton("Hacer Reserva");
        btnReservasUsuario = new JButton("Reservas de Usuario");

        add(btnRegistrarUsuario);
        add(btnUsuariosRegistrados);
        add(btnHacerReserva);
        add(btnReservasUsuario);

        btnRegistrarUsuario.addActionListener(e -> new RegistroUsuario(listaClientes).setVisible(true));
        btnUsuariosRegistrados.addActionListener(e -> new UsuariosRegistrados(listaClientes).setVisible(true));
        btnHacerReserva.addActionListener(e -> new HacerReserva(listaClientes, listaReservas).setVisible(true));
        btnReservasUsuario.addActionListener(e -> new ReservasUsuario(listaClientes, listaReservas).setVisible(true));
    }
}


