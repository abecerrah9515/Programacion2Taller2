package domain;

import java.util.List;
import entities.DTO.*;
import infrastructure.UsersRepository;

public class UsersDomain {
    private UsersRepository _repository;
        
    public UsersDomain() {
    	_repository = new UsersRepository();
	}

	// Método para consultar un usuario por número de documento
    public Usuario consultarUsuario(Usuario user) {
        try {
            return _repository.getUsusario(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para consultar todos los estados civiles
    public List<Estado_Civil> consultarEstadoCivil() {
        try {
            return _repository.getEstadoCivil();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para consultar todos los géneros
    public List<Genero> consultarGenero() {
        try {
            return _repository.getGenero();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para consultar todos los grupos sanguíneos
    public List<GrupoSanguineo> consultarGrupoSanguineo() {
        try {
            return _repository.getGrupoSanguineo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para consultar todos los tipos de RH
    public List<Rh> consultarRh() {
        try {
            return _repository.getRh();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para consultar todos los tipos de documentos
    public List<TipoDocumento> consultarTipoDocumento() {
        try {
            return _repository.getTiposDocumento();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para crear un nuevo usuario
    public boolean crearUsuario(Usuario usuario) {
        try {
            return _repository.createUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar los datos de un usuario existente
    public boolean actualizarUsuario(Usuario usuario) {
        try {
            return _repository.updateUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un usuario por su ID
    public boolean eliminarUsuario(long idUsuario) {
        try {
            return _repository.deleteUsuario(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
