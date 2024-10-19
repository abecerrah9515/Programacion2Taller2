package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Arrays;

public class Ventana extends JFrame implements ActionListener {

	private JTextField txtNum1, txtNum2, txtNum3;
	private JButton mayor, menor;
	private JLabel resultado;
	
	private int[] numeros = new int[3];
	
	
	public Ventana() {
		System.out.println("Usted ha creado un objeto de tipo VentanaCalculadora");
		inicializar();
		dimensionar();
		adicionar();
		accionar();
		mostrar();
	}
	
	public void inicializar() {
		
		this.txtNum1 = new JTextField("");
		this.txtNum2 = new JTextField("");
		this.txtNum3 = new JTextField("");
		
		this.mayor = new JButton(">");
		this.menor = new JButton("<");
		
		this.resultado = new JLabel();
		
	}
	
	public void dimensionar() {
		this.setLayout(null);
		
		this.txtNum1.setBounds(40, 10, 100, 20);
		this.txtNum2.setBounds(40, 40, 100, 20);
		this.txtNum3.setBounds(40, 70, 100, 20);
		
		this.mayor.setBounds(40, 100, 45, 20);
		this.menor.setBounds(90, 100, 45, 20);
		
		this.resultado.setBounds(50, 130, 100, 20);
	}
	
	public void adicionar() {
		
		this.add(txtNum1);
		this.add(txtNum2);
		this.add(txtNum3);

		this.add(mayor);
		this.add(menor);

		this.add(resultado);
	}
	
	public void accionar() {
		this.mayor.addActionListener(this);
		this.menor.addActionListener(this);
	}
	
	public void mostrar() {
		this.setSize(200,200);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.numeros[0] = Integer.parseInt(this.txtNum1.getText());
		this.numeros[1] = Integer.parseInt(this.txtNum2.getText());
		this.numeros[2] = Integer.parseInt(this.txtNum3.getText());
		
		Arrays.sort(this.numeros);
		
		if (e.getSource() == this.mayor) {
			try {
				this.resultado.setText("(" + this.numeros[2] + ") , (" + this.numeros[1] + ") , (" + this.numeros[0] + ")");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else {
			try {
				this.resultado.setText("(" + this.numeros[0] + ") , (" + this.numeros[1] + ") , (" + this.numeros[2] + ")");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
