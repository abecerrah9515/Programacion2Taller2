package Source;

import Entities.Conexion;
import Vistas.Pantalla;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pantalla _pantalla = new Pantalla();
		Conexion _conexion = new Conexion();
		_conexion.conectar();
	}

}
