package views;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controllers.UsuariosController;
import entities.DTO.DateLabelFormatter;

import java.awt.*;
import java.util.Date;
import java.util.Properties;

public class CrearUsuarioView extends JFrame {
    // Componentes del formulario
    public JTextField txtDocumento, txtNombres, txtApellidos, txtNumeroHijos, txtCelular, txtCorreo, txtContrasena;
    public JComboBox<String> comboTipoDocumento, comboGenero, comboGrupoSang, comboRh, comboEstadoCivil;
    public JButton btnGuardar, btnCancelar;
    public JDatePickerImpl datePickerFechaExpedicion; // DatePicker para la fecha de expedición
    private UsuariosController _usuariosController;

    public CrearUsuarioView() {
        _usuariosController = new UsuariosController();

        // Configuración del JFrame
        setTitle("Crear Usuario");
        setSize(500, 650);  // Aumentar el tamaño del frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Permite cerrar esta ventana sin cerrar la aplicación principal
        setLocationRelativeTo(null);
        setLayout(null); // Uso de layout null para posicionar manualmente

        // Crear los labels y campos del formulario con setBounds
        JLabel lblTipoDocumento = new JLabel("Tipo de Documento:");
        lblTipoDocumento.setBounds(30, 30, 150, 25);
        add(lblTipoDocumento);

        comboTipoDocumento = new JComboBox<>();
        comboTipoDocumento.setBounds(200, 30, 200, 25);
        add(comboTipoDocumento);

        JLabel lblDocumento = new JLabel("Número de Documento:");
        lblDocumento.setBounds(30, 70, 150, 25);
        add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(200, 70, 200, 25);
        add(txtDocumento);

        // Cambiar el campo de fecha de expedición a un DatePicker
        JLabel lblFechaExpedicion = new JLabel("Fecha de Expedición:");
        lblFechaExpedicion.setBounds(30, 110, 150, 25);
        add(lblFechaExpedicion);

        // Configurar el DatePicker para la fecha de expedición
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePickerFechaExpedicion = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerFechaExpedicion.setBounds(200, 110, 200, 25);
        add(datePickerFechaExpedicion);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(30, 150, 150, 25);
        add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBounds(200, 150, 200, 25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(30, 190, 150, 25);
        add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(200, 190, 200, 25);
        add(txtApellidos);

        JLabel lblNumeroHijos = new JLabel("Número de Hijos:");
        lblNumeroHijos.setBounds(30, 230, 150, 25);
        add(lblNumeroHijos);

        txtNumeroHijos = new JTextField();
        txtNumeroHijos.setBounds(200, 230, 200, 25);
        add(txtNumeroHijos);

        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(30, 270, 150, 25);
        add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setBounds(200, 270, 200, 25);
        add(txtCelular);

        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setBounds(30, 310, 150, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(200, 310, 200, 25);
        add(txtCorreo);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 350, 150, 25);
        add(lblContrasena);

        txtContrasena = new JTextField();
        txtContrasena.setBounds(200, 350, 200, 25);
        add(txtContrasena);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(30, 390, 150, 25);
        add(lblGenero);

        comboGenero = new JComboBox<>();
        comboGenero.setBounds(200, 390, 200, 25);
        add(comboGenero);

        JLabel lblGrupoSang = new JLabel("Grupo Sanguíneo:");
        lblGrupoSang.setBounds(30, 430, 150, 25);
        add(lblGrupoSang);

        comboGrupoSang = new JComboBox<>();
        comboGrupoSang.setBounds(200, 430, 200, 25);
        add(comboGrupoSang);

        JLabel lblRh = new JLabel("RH:");
        lblRh.setBounds(30, 470, 150, 25);
        add(lblRh);

        comboRh = new JComboBox<>();
        comboRh.setBounds(200, 470, 200, 25);
        add(comboRh);

        JLabel lblEstadoCivil = new JLabel("Estado Civil:");
        lblEstadoCivil.setBounds(30, 510, 150, 25);
        add(lblEstadoCivil);

        comboEstadoCivil = new JComboBox<>();
        comboEstadoCivil.setBounds(200, 510, 200, 25);
        add(comboEstadoCivil);

        // Botón Guardar
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 570, 100, 30);
        add(btnGuardar);

        // Botón Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 570, 100, 30);
        add(btnCancelar);

        // Llamar al controlador para llenar los ComboBoxes
        _usuariosController.llenarComboboxes(this);

        // Acción al hacer clic en "Guardar"
        btnGuardar.addActionListener(e -> guardarUsuario());

        // Acción al hacer clic en "Cancelar"
        btnCancelar.addActionListener(e -> cancelar());
    }

    protected void guardarUsuario() {        
        // Asignar la fecha y guardar el usuario (la lógica va en el controlador)
    	if (validarFormulario())
    		_usuariosController.guardarUsuario(this);
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
    
    protected void cancelar() {
        // Cierra la ventana actual y podría volver al menú principal
        this.dispose();
        // Aquí puedes incluir el código para volver al menú principal si es necesario
    }
    
}
