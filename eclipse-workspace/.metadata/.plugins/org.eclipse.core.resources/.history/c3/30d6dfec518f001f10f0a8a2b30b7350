package Controllers;

import javax.swing.JFrame;

import Vistas.Pantalla;
import models.ModeloPersonas;

public class ControladorPersonas {

	private Pantalla pantalla;
	
	public void getPeople(Pantalla pan) {
		this.pantalla = pan;
		ModeloPersonas mp = new ModeloPersonas();
		String resultado = mp.getPeople();
		pan.setTextJTA(resultado);
	}
}
