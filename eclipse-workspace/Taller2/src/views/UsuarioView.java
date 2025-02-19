package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioView extends JFrame {
    
    public UsuarioView() {
        // Configuración del JFrame
        setTitle("Gestión de Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        
        // Crear el JMenuBar
        JMenuBar menuBar = new JMenuBar();
        
        // Crear el JMenu "Opciones"
        JMenu menuOpciones = new JMenu("Opciones");
        
        // Crear las opciones del menú
        JMenuItem consultarUsuario = new JMenuItem("Consultar Usuario");
        JMenuItem crearUsuario = new JMenuItem("Crear Usuario");
        
        // Agregar las opciones al JMenu
        menuOpciones.add(consultarUsuario);
        menuOpciones.add(crearUsuario);
        
        // Agregar el JMenu a la barra de menú
        menuBar.add(menuOpciones);
        
        // Agregar la barra de menú al JFrame
        setJMenuBar(menuBar);
        
        // Acción para "Consultar Usuario"
        consultarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarUsuario(); // Llamada al método que define la acción de consultar usuario
            }
        });
        
        // Acción para "Crear Usuario"
        crearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUsuario(); // Llamada al método que define la acción de crear usuario
            }
        });
        
        this.setVisible(true);
    }

    // Método para la acción de "Consultar Usuario"
    private void consultarUsuario() {
        JOptionPane.showMessageDialog(this, "Aquí puedes consultar usuarios.");
        new ConsultarUsuarioView(this).setVisible(true);
        // Aquí puedes abrir una nueva ventana o panel para realizar la consulta de usuarios
    }

    // Método para la acción de "Crear Usuario"
    private void crearUsuario() {
        JOptionPane.showMessageDialog(this, "Aquí puedes crear usuarios.");
        new CrearUsuarioView().setVisible(true);
        // Aquí puedes abrir una nueva ventana o panel para crear un nuevo usuario
    }    
    
}

