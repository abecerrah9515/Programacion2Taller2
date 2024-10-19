package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

import source.Operaciones;
import vistas.VentanaCalculadora2;

public class VentanaCalculadora extends JFrame implements ActionListener, ItemListener{
	
	private JLabel lblCabeza, lblNum1, lblNum2, lblResul, lblResultado;
	private JTextField txtNum1, txtNum2;
	private JButton btnSum, btnRes, btnMul, btnDiv, btnSin, btnCos, btnRaiz, btnRaizEnesima, btnFac, btnLog, btnExp;
	private JMenuBar jmb;
	private JMenu jarchivo, jedicion;
	private JMenuItem jiabrir, jisalir, jicopiar, jipegar;
	private JComboBox<String> lista;
	private JComboBox<Integer> listaInt;
	private JTable tabla;
	
	public VentanaCalculadora() {
		System.out.println("Usted ha creado un objeto de tipo VentanaCalculadora");
		inicializar();
		dimensionar();
		adicionar();
		accionar();
		mostrar();
	}
	
	public void inicializar() {
		String[] listado = {"Opcion 1", "Opcion 2", "Opcion 3"};
		Integer[] listadoInt = {1, 2, 3};
		this.lista = new JComboBox<String>(listado);
		this.listaInt = new JComboBox<Integer>(listadoInt);
		this.lblCabeza = new JLabel("Programa Calculadora");
		this.lblNum1 = new JLabel("Por favor digite el primer numero");
		this.lblNum2 = new JLabel("Por favor digite el segundo numero");
		this.txtNum1 = new JTextField();
		this.txtNum2 = new JTextField();
		this.btnSum = new JButton("+");
		this.btnRes = new JButton("-");
		this.btnMul = new JButton("*");
		this.btnDiv = new JButton("/");
		this.btnSin = new JButton("sin");
		this.btnCos = new JButton("cos");
		this.btnRaiz = new JButton("raiz cuadrada");
		this.btnRaizEnesima = new JButton("raiz enesima");
		this.btnFac = new JButton("!");
		this.btnLog = new JButton("log");
		this.btnExp = new JButton("exp");
		this.lblResul = new JLabel("El resultado de la operacion es: ");
		this.lblResultado = new JLabel(" ");
		this.jmb = new JMenuBar();
		this.jarchivo = new JMenu("Archivo");
		this.jedicion = new JMenu("Edición");
		this.jiabrir = new JMenuItem("Abrir");
		this.jisalir = new JMenuItem("Salir");
		this.jicopiar = new JMenuItem("Copiar");
		this.jipegar = new JMenuItem("Pegar");
		Object[][] datos = {{"1", "2", "3"}, {"Pedro", "Juan", "Maria"}, {1, 2, 3}};
		String[] nombres = {"Nombre 1", "Nombre 2", "Nombre 3"};
		this.tabla = new JTable(datos, nombres);
	}
	
	public void dimensionar() {
		this.setLayout(null);
		this.lblCabeza.setBounds(150, 10, 490, 20);
		this.lblNum1.setBounds(10, 40, 200, 20);
		this.txtNum1.setBounds(250, 40, 100, 20);
		this.lblNum2.setBounds(10, 70, 200, 20);
		this.txtNum2.setBounds(250, 70, 100, 20);
		this.btnSum.setBounds(10, 125, 50, 50);
		this.btnRes.setBounds(100, 125, 50, 50);
		this.btnMul.setBounds(190, 125, 50, 50);
		this.btnDiv.setBounds(280, 125, 50, 50);
		this.btnSin.setBounds(40, 200, 100, 50);
		this.btnCos.setBounds(190, 200, 100, 50);
		this.btnRaiz.setBounds(10, 275, 150, 50);
		this.btnRaizEnesima.setBounds(200, 275, 150, 50);
		this.btnFac.setBounds(10, 350, 50, 50);
		this.btnLog.setBounds(100, 350, 100, 50);
		this.btnExp.setBounds(250, 350, 100, 50);
		this.lblResul.setBounds(40, 430, 200, 20);
		this.lblResultado.setBounds(250, 430, 100, 20);
		this.lista.setBounds(10, 460, 100, 50);
		this.listaInt.setBounds(150, 460, 100, 50);
		this.tabla.setBounds(380, 10, 200, 100);
	}
	
	public void adicionar() {
		this.add(lblCabeza);
		this.add(txtNum1);
		this.add(lblNum1);
		this.add(txtNum2);
		this.add(lblNum2);
		this.add(btnSum);
		this.add(btnRes);
		this.add(btnMul);
		this.add(btnDiv);
		this.add(btnSin);
		this.add(btnCos);
		this.add(btnRaiz);
		this.add(btnRaizEnesima);
		this.add(btnFac);
		this.add(btnLog);
		this.add(btnExp);
		this.add(lblResul);
		this.add(lblResultado);
		this.jarchivo.add(this.jiabrir);
		this.jarchivo.add(this.jisalir);
		this.jedicion.add(this.jicopiar);
		this.jedicion.add(this.jipegar);
		this.jmb.add(this.jarchivo);
		this.jmb.add(this.jedicion);
		this.setJMenuBar(this.jmb);
		this.add(this.lista);
		this.add(this.listaInt);
		this.add(this.tabla);
		}
	
	public void accionar() {
		this.btnSum.addActionListener(this);
		this.btnRes.addActionListener(this);
		this.btnMul.addActionListener(this);
		this.btnDiv.addActionListener(this);
		this.jiabrir.addActionListener(this);
		this.lista.addItemListener(this);
		this.listaInt.addItemListener(this);
	}
	
	public void mostrar() {
		this.setSize(680,700);
		this.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == lista) {
			System.out.println(e.getItem());
		}else if (e.getSource() == listaInt) {
			System.out.println(e.getItem());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Operaciones op = new Operaciones();
		if (e.getSource() == this.btnSum) {
			try {
				lblResultado.setText("" + op.sumar(Integer.parseInt(this.txtNum1.getText()), Integer.parseInt(this.txtNum2.getText())));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else if (e.getSource() == this.btnRes) {
			try {
				lblResultado.setText("" + op.restar(Integer.parseInt(this.txtNum1.getText()), Integer.parseInt(this.txtNum2.getText())));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else if (e.getSource() == this.btnMul) {
			try {
				lblResultado.setText("" + op.multiplicar(Integer.parseInt(this.txtNum1.getText()), Integer.parseInt(this.txtNum2.getText())));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if (e.getSource() == this.btnDiv) {
			try {
				lblResultado.setText("" + op.dividir(Integer.parseInt(this.txtNum1.getText()), Integer.parseInt(this.txtNum2.getText())));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == this.jiabrir) {
			try {
				VentanaCalculadora2 vn2 = new VentanaCalculadora2();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
