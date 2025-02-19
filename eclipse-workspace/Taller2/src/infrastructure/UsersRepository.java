package infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.DTO.Estado_Civil;
import entities.DTO.Genero;
import entities.DTO.GrupoSanguineo;
import entities.DTO.Rh;
import entities.DTO.TipoDocumento;
import entities.DTO.Usuario;

public class UsersRepository {
	
	public List<TipoDocumento> getTiposDocumento(){
		List<TipoDocumento> _listTipos = new ArrayList<TipoDocumento>();
		try {
			Repository c = new Repository();
			Connection con = c.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id_tipo_documento, descripcion, abreviatura "
					+ "from taller2.tbl_TipoDocumento;");			
			while (rs.next()) {
				TipoDocumento _tipoDocumento = new TipoDocumento();
				_tipoDocumento.setIdTipoDocumento(rs.getLong("id_tipo_documento"));
				_tipoDocumento.setAbreviatura(rs.getString("abreviatura"));
				_tipoDocumento.setDescripcion(rs.getString("descripcion"));
				_listTipos.add(_tipoDocumento);
			}
			c.closeConnection(con);
			return _listTipos;
		} catch (Exception e) {
			return _listTipos;
		}
	}
	
	public List<Genero> getGenero(){
		List<Genero> _listGenero = new ArrayList<Genero>();
		try {
			Repository c = new Repository();
			Connection con = c.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id_genero, descripcion, abreviatura "
					+ "from taller2.tbl_Genero");			
			while (rs.next()) {
				Genero _genero = new Genero();
				_genero.setIdGenero(rs.getLong("id_genero"));
				_genero.setAbreviatura(rs.getString("abreviatura"));
				_genero.setDescripcion(rs.getString("descripcion"));
				_listGenero.add(_genero);
			}
			c.closeConnection(con);
			return _listGenero;
		} catch (Exception e) {
			return _listGenero;
		}
	}
	
	public List<GrupoSanguineo> getGrupoSanguineo(){
		List<GrupoSanguineo> _listGrupoSanguineo = new ArrayList<GrupoSanguineo>();
		try {
			Repository c = new Repository();
			Connection con = c.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from taller2.tbl_grupo_sanguineo");			
			while (rs.next()) {
				GrupoSanguineo _grupo = new GrupoSanguineo();
				_grupo.setId_grup_sang(rs.getLong("id_grup_sang"));
				_grupo.setDescripcion(rs.getString("descripcion"));
				_listGrupoSanguineo.add(_grupo);
			}
			c.closeConnection(con);
			return _listGrupoSanguineo;
		} catch (Exception e) {
			return _listGrupoSanguineo;
		}
	}
	
	public List<Rh> getRh(){
		List<Rh> _listRh = new ArrayList<Rh>();
		try {
			Repository c = new Repository();
			Connection con = c.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from taller2.tbl_rh");			
			while (rs.next()) {
				Rh _rh = new Rh();
				_rh.setId_grup_sang(rs.getLong("id_rh"));
				_rh.setDescripcion(rs.getString("descripcion"));
				_listRh.add(_rh);
			}
			c.closeConnection(con);
			return _listRh;
		} catch (Exception e) {
			return _listRh;
		}
	}
	
	public List<Estado_Civil> getEstadoCivil(){
		List<Estado_Civil> _listEstado = new ArrayList<Estado_Civil>();
		try {
			Repository c = new Repository();
			Connection con = c.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from taller2.tbl_estado_civil");			
			while (rs.next()) {
				Estado_Civil _estado = new Estado_Civil();
				_estado.setId_esta_civil(rs.getLong("id_esta_civil"));
				_estado.setDescripcion(rs.getString("descripcion"));
				_listEstado.add(_estado);
			}
			c.closeConnection(con);
			return _listEstado;
		} catch (Exception e) {
			return _listEstado;
		}
	}
	
	public Usuario getUsusario(Usuario user) {
	    Usuario _usuario = new Usuario();
	    try {
	        Repository c = new Repository();
	        Connection con = c.getConnection();
	        Statement st = con.createStatement();
	        // Ajustamos la consulta para filtrar tanto por tipo de documento como por número de documento
	        String query = "SELECT id_usuario, id_tipo_documento, documento, fecha_expedicion, nombres, apellidos, numero_hijos, " +
	                "celular, correo_electronico, contrasenha, id_genero, id_grup_sang, id_rh, id_esta_civil " +
	                "FROM taller2.tbl_Usuario " +
	                "WHERE id_tipo_documento = " + user.getIdTipoDocumento() + 
	                " AND documento = " + user.getDocumento() + ";";
	        ResultSet rs = st.executeQuery(query);

	        while (rs.next()) {
	            _usuario.setIdUsuario(rs.getLong("id_usuario"));
	            _usuario.setIdTipoDocumento(rs.getInt("id_tipo_documento"));
	            _usuario.setDocumento(rs.getLong("documento"));
	            _usuario.setFechaExpedicion(rs.getDate("fecha_expedicion"));
	            _usuario.setNombres(rs.getString("nombres"));
	            _usuario.setApellidos(rs.getString("apellidos"));
	            _usuario.setNumeroHijos(rs.getInt("numero_hijos"));
	            _usuario.setCelular(rs.getString("celular"));
	            _usuario.setCorreoElectronico(rs.getString("correo_electronico"));
	            _usuario.setContrasenha(rs.getString("contrasenha"));
	            _usuario.setIdGenero(rs.getInt("id_genero"));
	            _usuario.setIdGrupoSang(rs.getInt("id_grup_sang"));
	            _usuario.setIdRh(rs.getInt("id_rh"));
	            _usuario.setIdEstadoCivil(rs.getInt("id_esta_civil"));
	        }
	        c.closeConnection(con);
	        return _usuario;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return _usuario;
	    }
	}

	
	public boolean updateUsuario(Usuario usuario) {
		try {
			Repository c = new Repository();
			Connection con = c.getConnection();
			String query = "UPDATE taller2.tbl_usuario "
					+ "SET id_tipo_documento = ?, "
					+ "documento = ?, "
					+ "fecha_expedicion = ?, "
					+ "nombres = ?, "
					+ "apellidos = ?, "
					+ "numero_hijos = ?, "
					+ "celular = ?, "
					+ "correo_electronico = ?, "
					+ "contrasenha = ?, "
					+ "id_genero = ?, "
					+ "id_grup_sang = ?, "
					+ "id_rh = ?, "
					+ "id_esta_civil = ? "
					+ "WHERE id_usuario = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, usuario.getIdTipoDocumento());
			ps.setLong(2, usuario.getDocumento());
			ps.setDate(3, new java.sql.Date(usuario.getFechaExpedicion().getTime()));
			ps.setString(4, usuario.getNombres());
			ps.setString(5, usuario.getApellidos());
			ps.setInt(6, usuario.getNumeroHijos());
			ps.setString(7, usuario.getCelular());
			ps.setString(8, usuario.getCorreoElectronico());
			ps.setString(9, usuario.getContrasenha());
			ps.setInt(10, usuario.getIdGenero());
			ps.setInt(11, usuario.getIdGrupoSang());
			ps.setInt(12, usuario.getIdRh());
			ps.setInt(13, usuario.getIdEstadoCivil());
			ps.setLong(14, usuario.getIdUsuario());
			int rowsAffected = ps.executeUpdate();
			c.closeConnection(con);
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteUsuario(Long idUsuario) {
		try {
			Repository c = new Repository();
			Connection con = c.getConnection();
			String query = "DELETE FROM taller2.tbl_usuario WHERE id_usuario = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, idUsuario);
			int rowsAffected = ps.executeUpdate();
			c.closeConnection(con);
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createUsuario(Usuario usuario) {
	    try {
	        Repository c = new Repository();
	        Connection con = c.getConnection();
	        String query = "INSERT INTO taller2.tbl_usuario (id_tipo_documento, documento, fecha_expedicion, nombres, apellidos, "
	                     + "numero_hijos, celular, correo_electronico, contrasenha, id_genero, id_grup_sang, id_rh, id_esta_civil) "
	                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, usuario.getIdTipoDocumento());
	        ps.setLong(2, usuario.getDocumento());
	        ps.setDate(3, new java.sql.Date(usuario.getFechaExpedicion().getTime()));
	        ps.setString(4, usuario.getNombres());
	        ps.setString(5, usuario.getApellidos());
	        ps.setInt(6, usuario.getNumeroHijos());
	        ps.setString(7, usuario.getCelular());
	        ps.setString(8, usuario.getCorreoElectronico());
	        ps.setString(9, usuario.getContrasenha());
	        ps.setInt(10, usuario.getIdGenero());
	        ps.setInt(11, usuario.getIdGrupoSang());
	        ps.setInt(12, usuario.getIdRh());
	        ps.setInt(13, usuario.getIdEstadoCivil());
	        int rowsAffected = ps.executeUpdate();
	        c.closeConnection(con);
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
