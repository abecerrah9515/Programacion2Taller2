package Vistas;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Pantalla extends JFrame {
	
	private JLabel etiqueta1;
	private JTextField txtReg;
	private JButton btnGen, btnOrdXNom, btnOrdXEdad, btnOrdXCel;
	private JTable tabla;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private boolean ascending;
	private TableRowSorter<TableModel> sorter;
	public Pantalla() {
		inicializar();
		dimensionar();
		adicionar();
		mostrar();
		acciones();
	}
	
	public void mostrar() {
		this.setSize(340,390);
		this.setVisible(true);
	}
	
	private void acciones() {
		this.btnGen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				generarPlantilla();
				
			}
			
		});
		this.btnOrdXNom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenarPorNombre();
			}

		
		});
		
		this.btnOrdXEdad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ordenarPorEdad();
			}
		});
		this.btnOrdXCel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenarPorCelular();
			}
		});
	}
	
	private void adicionar() {
		this.add(etiqueta1);
		this.add(txtReg);
		this.add(btnGen);
		this.add(btnOrdXNom);
		this.add(btnOrdXEdad);
		this.add(btnOrdXCel);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	private void dimensionar() {
		this.setLayout(null);
		this.etiqueta1.setBounds(10, 10, 150, 20);
		this.txtReg.setBounds(90, 10, 50, 20);
		this.btnGen.setBounds(150, 10, 130, 20);
		this.btnOrdXNom.setBounds(90, 40, 160, 20);
		this.btnOrdXEdad.setBounds(90, 70, 160, 20);
		this.btnOrdXCel.setBounds(90, 100, 160, 20);
		this.scrollPane.setBounds(10, 130, 300, 200);
	}
	private void inicializar() {
	    this.etiqueta1 = new JLabel("No Registros");
	    this.txtReg = new JTextField();
	    this.btnGen = new JButton("Generar Plantilla");
	    this.btnOrdXNom = new JButton("Ordenar por Nombre");
	    this.btnOrdXEdad = new JButton("Ordenar por Edad");
	    this.btnOrdXCel = new JButton("Ordenar por Cel");

	    
	    this.modelo = new DefaultTableModel() {
	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            if (columnIndex == 2 || columnIndex == 3) { 
	                return Integer.class;
	            }
	            return super.getColumnClass(columnIndex);
	        }
	    };

	    modelo.addColumn("Nombre");
	    modelo.addColumn("Apellido");
	    modelo.addColumn("Edad");
	    modelo.addColumn("Celular");
	    this.tabla = new JTable(modelo);
	    this.scrollPane = new JScrollPane(tabla);

	    sorter = new TableRowSorter<>(modelo);
	    tabla.setRowSorter(sorter);
	    sorter.setSortKeys(null);
	}
	
	private void ordenarPorNombre() {
		this.sorter.setSortKeys(null);
		if (ascending) {
            this.sorter.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
        } else {
            this.sorter.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(0, SortOrder.DESCENDING)));
        }

        ascending = !ascending;
	}
	
	private void ordenarPorEdad() {
		this.sorter.setSortKeys(null);
		if (ascending) {
            this.sorter.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
        } else {
            this.sorter.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(2, SortOrder.DESCENDING)));
        }

        ascending = !ascending;
	}
	
	private void ordenarPorCelular() {
		this.sorter.setSortKeys(null);
		if (ascending) {
            this.sorter.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
        } else {
            this.sorter.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(3, SortOrder.DESCENDING)));
        }

        ascending = !ascending;
	}
	
	
	private void generarPlantilla() {
		
		for (int i = 1; i <= Integer.parseInt(this.txtReg.getText()); i++) {
            Object[] row = {"", "", "", ""};
            this.modelo.addRow(row);
        }
	}
	
}
