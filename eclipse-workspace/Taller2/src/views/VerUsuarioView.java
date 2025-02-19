package views;

import javax.swing.*;
import org.jdatepicker.impl.*;

import controllers.ConsultarUsuarioController;
import entities.DTO.ComboItem;
import entities.DTO.DateLabelFormatter;
import entities.DTO.Usuario;

import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerUsuarioView extends JFrame {
	 // Componentes del formulario
    public JTextField txtIdUsuario, txtDocumento, txtNombres, txtApellidos, txtNumeroHijos, txtCelular, txtCorreo, txtContrasena;
    public JComboBox<ComboItem> comboTipoDocumento, comboGenero, comboGrupoSang, comboRh, comboEstadoCivil;
    public JButton btnModificar, btnBorrar;
    public JDatePickerImpl datePickerFechaExpedicion;
    public ConsultarUsuarioController _usuariosController;
    public Usuario usuario;  // Objeto Usuario que contiene los datos consultados

    public VerUsuarioView(Usuario usuario) {
        this.usuario = usuario;
        _usuariosController = new ConsultarUsuarioController();

        // Configuración del JFrame
        setTitle("Ver Usuario");
        setSize(500, 800);  // Ajustamos el tamaño para acomodar todos los campos
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Etiqueta y campo para ID (inhabilitado)
        JLabel lblIdUsuario = new JLabel("ID Usuario:");
        lblIdUsuario.setBounds(30, 30, 150, 25);
        add(lblIdUsuario);

        txtIdUsuario = new JTextField(String.valueOf(usuario.getIdUsuario()));
        txtIdUsuario.setBounds(200, 30, 200, 25);
        txtIdUsuario.setEnabled(false);  // Campo inhabilitado
        add(txtIdUsuario);

        // Rellenar y mostrar los demás campos con los datos del usuario
        JLabel lblTipoDocumento = new JLabel("Tipo de Documento:");
        lblTipoDocumento.setBounds(30, 70, 150, 25);
        add(lblTipoDocumento);

        comboTipoDocumento = new JComboBox<>();
        comboTipoDocumento.setBounds(200, 70, 200, 25);
        add(comboTipoDocumento);

        JLabel lblDocumento = new JLabel("Número de Documento:");
        lblDocumento.setBounds(30, 110, 150, 25);
        add(lblDocumento);

        txtDocumento = new JTextField(String.valueOf(usuario.getDocumento()));
        txtDocumento.setBounds(200, 110, 200, 25);
        add(txtDocumento);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(30, 150, 150, 25);
        add(lblNombres);

        txtNombres = new JTextField(usuario.getNombres());
        txtNombres.setBounds(200, 150, 200, 25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(30, 190, 150, 25);
        add(lblApellidos);

        txtApellidos = new JTextField(usuario.getApellidos());
        txtApellidos.setBounds(200, 190, 200, 25);
        add(txtApellidos);

        JLabel lblNumeroHijos = new JLabel("Número de Hijos:");
        lblNumeroHijos.setBounds(30, 230, 150, 25);
        add(lblNumeroHijos);

        txtNumeroHijos = new JTextField(String.valueOf(usuario.getNumeroHijos()));
        txtNumeroHijos.setBounds(200, 230, 200, 25);
        add(txtNumeroHijos);

        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(30, 270, 150, 25);
        add(lblCelular);

        txtCelular = new JTextField(usuario.getCelular());
        txtCelular.setBounds(200, 270, 200, 25);
        add(txtCelular);

        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setBounds(30, 310, 150, 25);
        add(lblCorreo);

        txtCorreo = new JTextField(usuario.getCorreoElectronico());
        txtCorreo.setBounds(200, 310, 200, 25);
        add(txtCorreo);

        // Etiqueta y campo para contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 350, 150, 25);
        add(lblContrasena);

        txtContrasena = new JTextField(usuario.getContrasenha());  // Campo de contraseña
        txtContrasena.setBounds(200, 350, 200, 25);
        add(txtContrasena);

        // Etiqueta y DatePicker para Fecha de Expedición
        JLabel lblFechaExpedicion = new JLabel("Fecha de Expedición:");
        lblFechaExpedicion.setBounds(30, 390, 150, 25);
        add(lblFechaExpedicion);

        // Configuración del DatePicker
        UtilDateModel model = new UtilDateModel(usuario.getFechaExpedicion());
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePickerFechaExpedicion = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerFechaExpedicion.setBounds(200, 390, 200, 25);
        add(datePickerFechaExpedicion);

        // ComboBoxes para los demás campos
        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(30, 430, 150, 25);
        add(lblGenero);

        comboGenero = new JComboBox<>();
        comboGenero.setBounds(200, 430, 200, 25);
        add(comboGenero);

        JLabel lblGrupoSang = new JLabel("Grupo Sanguíneo:");
        lblGrupoSang.setBounds(30, 470, 150, 25);
        add(lblGrupoSang);

        comboGrupoSang = new JComboBox<>();
        comboGrupoSang.setBounds(200, 470, 200, 25);
        add(comboGrupoSang);

        JLabel lblRh = new JLabel("RH:");
        lblRh.setBounds(30, 510, 150, 25);
        add(lblRh);

        comboRh = new JComboBox<>();
        comboRh.setBounds(200, 510, 200, 25);
        add(comboRh);

        JLabel lblEstadoCivil = new JLabel("Estado Civil:");
        lblEstadoCivil.setBounds(30, 550, 150, 25);
        add(lblEstadoCivil);

        comboEstadoCivil = new JComboBox<>();
        comboEstadoCivil.setBounds(200, 550, 200, 25);
        add(comboEstadoCivil);

        // Botón Modificar
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(100, 650, 100, 30);
        add(btnModificar);

        // Botón Borrar
        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(250, 650, 100, 30);
        add(btnBorrar);

        // Llamada al método para llenar los combo boxes con los datos de la BD
        _usuariosController.llenarCombos(this);
     // Establecer la selección del comboTipoDocumento
        _usuariosController.seleccionarComboItem(comboTipoDocumento, usuario.getIdTipoDocumento());

        // Establecer la selección del comboGenero
        _usuariosController.seleccionarComboItem(comboGenero, usuario.getIdGenero());

        // Establecer la selección del comboGrupoSang
        _usuariosController.seleccionarComboItem(comboGrupoSang, usuario.getIdGrupoSang());

        // Establecer la selección del comboRh
        _usuariosController.seleccionarComboItem(comboRh, usuario.getIdRh());

        // Establecer la selección del comboEstadoCivil
        _usuariosController.seleccionarComboItem(comboEstadoCivil, usuario.getIdEstadoCivil());
        // Acción al hacer clic en "Modificar"
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarUsuario();
            }
        });

        // Acción al hacer clic en "Borrar"
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarUsuario();
            }
        });
    }



    private void modificarUsuario() {
        // Lógica para modificar el usuario
        _usuariosController.modificarUsuario(this);
        dispose();
    }

    private void borrarUsuario() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            _usuariosController.borrarUsuario(usuario.getIdUsuario());
            JOptionPane.showMessageDialog(this, "Usuario eliminado.");
            dispose();  // Cerrar la ventana después de eliminar
        }
    }
    
    private boolean validarFormulario() {
        // Validar número de documento
        String documento = txtDocumento.getText();
        if (!documento.matches("\\d{1,12}")) {
            JOptionPane.showMessageDialog(this, "El número de documento debe contener solo números y tener un máximo de 12 caracteres.");
            return false;
        }

        // Validar nombres
        String nombres = txtNombres.getText();
        if (!nombres.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "Los nombres solo deben contener letras.");
            return false;
        }

        // Validar apellidos
        String apellidos = txtApellidos.getText();
        if (!apellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "Los apellidos solo deben contener letras.");
            return false;
        }

        // Validar número de hijos
        String numeroHijos = txtNumeroHijos.getText();
        if (!numeroHijos.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El número de hijos solo debe contener números.");
            return false;
        }

        // Validar celular
        String celular = txtCelular.getText();
        if (!celular.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "El número de celular debe contener solo números y tener un máximo de 10 caracteres.");
            return false;
        }

        // Validar correo electrónico
        String correo = txtCorreo.getText();
        if (!correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un correo electrónico válido.");
            return false;
        }

        // Validar contraseña
        String contrasena = txtContrasena.getText();
        if (!contrasena.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,}$")) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 8 caracteres, incluyendo una letra mayúscula, una letra minúscula, un número y un carácter especial.");
            return false;
        }

        // Validar que la fecha de expedición sea válida
        java.util.Date selectedDate = (java.util.Date) datePickerFechaExpedicion.getModel().getValue();
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una fecha de expedición válida.");
            return false;
        }
        
        // Si todas las validaciones pasan
        return true;
    }
}

