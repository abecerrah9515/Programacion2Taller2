package controllers;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import domain.UsersDomain;
import entities.DTO.ComboItem;
import entities.DTO.Estado_Civil;
import entities.DTO.Genero;
import entities.DTO.GrupoSanguineo;
import entities.DTO.Rh;
import entities.DTO.TipoDocumento;
import entities.DTO.Usuario;
import views.ConsultarUsuarioView;
import views.VerUsuarioView;

public class ConsultarUsuarioController {
	private UsersDomain _usersDomain = new UsersDomain();

    // Método para llenar el ComboBox de tipo de documento en la vista
    public void llenarComboTipoDocumento(ConsultarUsuarioView view) {
        List<TipoDocumento> tiposDocumento = _usersDomain.consultarTipoDocumento();

        // Limpiar el combo box antes de llenarlo
        view.comboTipoDocumento.removeAllItems();

        // Llenar el combo box con los tipos de documento obtenidos de la base de datos
        for (TipoDocumento tipo : tiposDocumento) {
            view.comboTipoDocumento.addItem(new ComboItem((Long) tipo.getIdTipoDocumento(), tipo.getDescripcion()));
        }
    }

    // Método para consultar usuario con el tipo y número de documento
    public void consultarUsuario(ConsultarUsuarioView view) {
        // Obtener el tipo de documento seleccionado
        int tipoDocumentoId = view.comboTipoDocumento.getSelectedIndex() + 1;

        // Validar número de documento
        String numeroDocumento = view.txtNumeroDocumento.getText();
        if (!numeroDocumento.matches("\\d+")) {
            JOptionPane.showMessageDialog(view, "El número de documento debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear objeto usuario con los valores seleccionados
        Usuario _usuario = new Usuario();
        _usuario.setIdTipoDocumento(tipoDocumentoId);
        _usuario.setDocumento(Long.parseLong(numeroDocumento));

        // Consultar usuario en la base de datos a través de la capa de dominio
        _usuario = _usersDomain.consultarUsuario(_usuario);

        // Verificar si se encontró el usuario
        if (_usuario != null && _usuario.getIdUsuario() != null) {
            // Cerrar la ventana actual de consulta
            view.dispose();

            // Levantar la vista de VerUsuarioView con la información del usuario
            VerUsuarioView verUsuarioView = new VerUsuarioView(_usuario);
            verUsuarioView.setVisible(true);
        } else {
            // Mostrar un mensaje de error si no se encuentra el usuario
            JOptionPane.showMessageDialog(view, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void llenarCombos(VerUsuarioView view) {
//     	
    	List<TipoDocumento> tiposDocumento = _usersDomain.consultarTipoDocumento();
        for (TipoDocumento tipo : tiposDocumento) {
            view.comboTipoDocumento.addItem(new ComboItem((Long)tipo.getIdTipoDocumento(), tipo.getDescripcion()));
        }

        // Llenar combo de Género
        List<Genero> generos = _usersDomain.consultarGenero();
        for (Genero genero : generos) {        	
            view.comboGenero.addItem(new ComboItem((Long)genero.getIdGenero(), genero.getDescripcion()));
        }

        // Llenar combo de Grupo Sanguíneo
        List<GrupoSanguineo> gruposSanguineos = _usersDomain.consultarGrupoSanguineo();
        for (GrupoSanguineo grupo : gruposSanguineos) {
            view.comboGrupoSang.addItem(new ComboItem((Long)grupo.getId_grup_sang(), grupo.getDescripcion()));
        }

        // Llenar combo de RH
        List<Rh> rhs = _usersDomain.consultarRh();
        for (Rh rh : rhs) {
            view.comboRh.addItem(new ComboItem((Long)rh.getId_grup_sang(), rh.getDescripcion()));
        }

        // Llenar combo de Estado Civil
        List<Estado_Civil> estadosCiviles = _usersDomain.consultarEstadoCivil();
        for (Estado_Civil estadoCivil : estadosCiviles) {
            view.comboEstadoCivil.addItem(new ComboItem((Long)estadoCivil.getId_esta_civil(), estadoCivil.getDescripcion()));
        }
    }
    
    public void modificarUsuario(VerUsuarioView view) {
        Usuario usuarioModificado = new Usuario();
        usuarioModificado.setIdUsuario(Long.parseLong(view.txtIdUsuario.getText()));
        usuarioModificado.setDocumento(Long.parseLong(view.txtDocumento.getText()));
        usuarioModificado.setNombres(view.txtNombres.getText());
        usuarioModificado.setApellidos(view.txtApellidos.getText());
        usuarioModificado.setNumeroHijos(Integer.parseInt(view.txtNumeroHijos.getText()));
        usuarioModificado.setCelular(view.txtCelular.getText());
        usuarioModificado.setContrasenha(view.txtContrasena.getText());
        usuarioModificado.setCorreoElectronico(view.txtCorreo.getText());
        usuarioModificado.setIdTipoDocumento(view.comboTipoDocumento.getSelectedIndex() + 1);  // Simulación de ID
        usuarioModificado.setIdGenero(view.comboGenero.getSelectedIndex() + 1);  // Simulación de ID
        usuarioModificado.setIdGrupoSang(view.comboGrupoSang.getSelectedIndex() + 1);  // Simulación de ID
        usuarioModificado.setIdRh(view.comboRh.getSelectedIndex() + 1);  // Simulación de ID
        usuarioModificado.setIdEstadoCivil(view.comboEstadoCivil.getSelectedIndex() + 1);  // Simulación de ID

        // Obtener la fecha seleccionada del DatePicker
        java.util.Date selectedDate = (java.util.Date) view.datePickerFechaExpedicion.getModel().getValue();
        if (selectedDate != null) {
            usuarioModificado.setFechaExpedicion(new java.sql.Date(selectedDate.getTime()));
        }

        // Continuar con la lógica para actualizar el usuario
        boolean success = _usersDomain.actualizarUsuario(usuarioModificado);

        if (success) {
            JOptionPane.showMessageDialog(view, "Usuario modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(view, "Error al modificar el usuario.");
        }
    }
    
    public void borrarUsuario(Long idUsuario) {
        boolean success = _usersDomain.eliminarUsuario(idUsuario);

        if (success) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario.");
        }
    }
    
    public void seleccionarComboItem(JComboBox<ComboItem> comboBox, int idSeleccionado) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            ComboItem item = (ComboItem) comboBox.getItemAt(i);
            if (item.getId() == idSeleccionado) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
}
