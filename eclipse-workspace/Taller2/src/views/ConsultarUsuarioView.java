package views;

import javax.swing.*;

import controllers.ConsultarUsuarioController;
import controllers.UsuariosController;
import domain.UsersDomain;
import entities.DTO.ComboItem;
import entities.DTO.Estado_Civil;
import entities.DTO.Genero;
import entities.DTO.GrupoSanguineo;
import entities.DTO.Rh;
import entities.DTO.TipoDocumento;
import entities.DTO.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConsultarUsuarioView extends JDialog {
    public JComboBox<ComboItem> comboTipoDocumento;
    public JTextField txtNumeroDocumento;
    public JButton btnBuscar;
    private ConsultarUsuarioController _usuariosController;
    private UsersDomain _usersDomain;
    public ConsultarUsuarioView(JFrame parent) {
        super(parent, "Consultar Usuario", true);
        _usuariosController = new ConsultarUsuarioController();

        // Configuración del JDialog
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(parent);

        // Etiqueta y combo box para tipo de documento
        JLabel lblTipoDocumento = new JLabel("Tipo de Documento:");
        lblTipoDocumento.setBounds(30, 30, 150, 25);
        add(lblTipoDocumento);

        comboTipoDocumento = new JComboBox<>();
        comboTipoDocumento.setBounds(180, 30, 150, 25);
        add(comboTipoDocumento);

        // Etiqueta y campo para número de documento
        JLabel lblNumeroDocumento = new JLabel("Número de Documento:");
        lblNumeroDocumento.setBounds(30, 70, 150, 25);
        add(lblNumeroDocumento);

        txtNumeroDocumento = new JTextField();
        txtNumeroDocumento.setBounds(180, 70, 150, 25);
        add(txtNumeroDocumento);

        // Botón Buscar
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(150, 120, 100, 30);
        add(btnBuscar);

        // Acción al hacer clic en el botón "Buscar"
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });

        // Llamar al controlador para llenar el combo de tipo de documento
        _usuariosController.llenarComboTipoDocumento(this);
    }

    private void buscarUsuario() {
        try {
        	_usuariosController.consultarUsuario(this);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar el usuario: " + ex.getMessage());
        }
    }   
    
   
}
