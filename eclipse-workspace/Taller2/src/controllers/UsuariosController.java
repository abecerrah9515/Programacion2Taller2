package controllers;

import entities.DTO.*;
import views.CrearUsuarioView;

import java.util.List;

import javax.swing.*;

import domain.UsersDomain;

public class UsuariosController {
    
    private UsersDomain _usersDomain;

    public UsuariosController() {
        _usersDomain = new UsersDomain();
    }

    /**
     * Recibe la vista y extrae los datos del formulario para crear un nuevo usuario.
     */
    public void guardarUsuario(CrearUsuarioView view) {
        try {
            // Crear un objeto Usuario con los datos ingresados en el formulario
            Usuario newUser = new Usuario();
            newUser.setIdTipoDocumento(view.comboTipoDocumento.getSelectedIndex() + 1);  // Simulación de ID
            newUser.setDocumento(Long.parseLong(view.txtDocumento.getText()));
            newUser.setNombres(view.txtNombres.getText());
            newUser.setApellidos(view.txtApellidos.getText());
            newUser.setNumeroHijos(Integer.parseInt(view.txtNumeroHijos.getText()));
            newUser.setCelular(view.txtCelular.getText());
            newUser.setCorreoElectronico(view.txtCorreo.getText());
            newUser.setContrasenha(view.txtContrasena.getText());
            newUser.setIdGenero(view.comboGenero.getSelectedIndex() + 1);  // Simulación de ID
            newUser.setIdGrupoSang(view.comboGrupoSang.getSelectedIndex() + 1);  // Simulación de ID
            newUser.setIdRh(view.comboRh.getSelectedIndex() + 1);  // Simulación de ID
            newUser.setIdEstadoCivil(view.comboEstadoCivil.getSelectedIndex() + 1);  // Simulación de ID

            // Obtener la fecha seleccionada del JDatePickerImpl
            java.util.Date selectedDate = (java.util.Date) view.datePickerFechaExpedicion.getModel().getValue();
            if (selectedDate != null) {
                newUser.setFechaExpedicion(new java.sql.Date(selectedDate.getTime()));  // Convertir a java.sql.Date para almacenarlo en la BD
            } else {
                JOptionPane.showMessageDialog(view, "Por favor selecciona una fecha de expedición válida.");
                return;
            }

            // Llamar al método del repositorio para guardar el usuario
            boolean success = _usersDomain.crearUsuario(newUser);

            // Mostrar mensaje de éxito o error
            if (success) {
                JOptionPane.showMessageDialog(view, "Usuario creado exitosamente.");
                view.dispose();  // Cerrar la ventana de creación de usuario
            } else {
                JOptionPane.showMessageDialog(view, "Error al crear el usuario.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Por favor ingresa valores numéricos válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }


    
    public void llenarComboboxes(CrearUsuarioView view) {
        //     	
    	List<TipoDocumento> tiposDocumento = _usersDomain.consultarTipoDocumento();
        for (TipoDocumento tipo : tiposDocumento) {
            view.comboTipoDocumento.addItem(new ComboItem((Long)tipo.getIdTipoDocumento(), tipo.getDescripcion()).getDescription());
        }

        // Llenar combo de Género
        List<Genero> generos = _usersDomain.consultarGenero();
        for (Genero genero : generos) {
            view.comboGenero.addItem(new ComboItem((Long)genero.getIdGenero(), genero.getDescripcion()).getDescription());
        }

        // Llenar combo de Grupo Sanguíneo
        List<GrupoSanguineo> gruposSanguineos = _usersDomain.consultarGrupoSanguineo();
        for (GrupoSanguineo grupo : gruposSanguineos) {
            view.comboGrupoSang.addItem(new ComboItem((Long)grupo.getId_grup_sang(), grupo.getDescripcion()).getDescription());
        }

        // Llenar combo de RH
        List<Rh> rhs = _usersDomain.consultarRh();
        for (Rh rh : rhs) {
            view.comboRh.addItem(new ComboItem((Long)rh.getId_grup_sang(), rh.getDescripcion()).getDescription());
        }

        // Llenar combo de Estado Civil
        List<Estado_Civil> estadosCiviles = _usersDomain.consultarEstadoCivil();
        for (Estado_Civil estadoCivil : estadosCiviles) {
            view.comboEstadoCivil.addItem(new ComboItem((Long)estadoCivil.getId_esta_civil(), estadoCivil.getDescripcion()).getDescription());
        }
    }
}
