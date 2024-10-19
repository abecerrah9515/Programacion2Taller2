package domain;


import java.util.List;

import entities.DTO.*;
import infrastructure.UsersRepository;

public class UsersDomain {
	private UsersRepository _repository = new UsersRepository();
	
	public Usuario consultarUsuario(long numeroDocumento) {
		try {			
			return _repository.getUsusario(numeroDocumento);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Estado_Civil> consultarEstadoCivil() {
		try {			
			return _repository.getEstadoCivil();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Genero> consultarGenero() {
		try {			
			return _repository.getGenero();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<GrupoSanguineo> consultarGrupoSanguineo() {
		try {			
			return _repository.getGrupoSanguineo();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Rh> consultarRh() {
		try {			
			return _repository.getRh();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<TipoDocumento> consultarTipoDocumento() {
		try {			
			return _repository.getTiposDocumento();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
