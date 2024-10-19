package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import source.Operaciones;

public class Ventana extends JFrame implements ActionListener {

    private JLabel lblPantalla;
    private JButton btnEnc, btnSum, btnRes, btnMul, btnDiv, btnSin, btnExp, btnPun, btnIgu, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnMn, btnMp, btnMs;
    private boolean encendido = false, error = false, auxiliar = false;
    private double num1, num2, res, mem;
    private String operador = "";
    private Operaciones _op = new Operaciones();

    public Ventana() {
        inicializar();
        dimensionar();
        adicionar();
        accionar();
        mostrar();
    }

    public void inicializar() {
        this.lblPantalla = new JLabel("");
        this.lblPantalla.setHorizontalAlignment(JLabel.RIGHT);
        this.lblPantalla.setBackground(Color.WHITE);
        this.lblPantalla.setBorder(BorderFactory.createLineBorder(Color.blue));
        this.lblPantalla.setFont(new Font("Arial", Font.PLAIN, 24));
        this.lblPantalla.setOpaque(true);
        this.btnEnc = new JButton("ON/OFF");
        this.btnSum = new JButton("+");
        this.btnRes = new JButton("-");
        this.btnMul = new JButton("*");
        this.btnDiv = new JButton("÷");
        this.btnIgu = new JButton("=");
        this.btnSin = new JButton("sin");
        this.btnSin.setFont(new Font("Arial", Font.PLAIN, 11));
        this.btnExp = new JButton("x²");
        this.btnMp = new JButton("M+");
        this.btnMp.setFont(new Font("Arial", Font.PLAIN, 12));
        this.btnMn = new JButton("M-");
        this.btnPun = new JButton(".");
        this.btn0 = new JButton("0");
        this.btn1 = new JButton("1");
        this.btn2 = new JButton("2");
        this.btn3 = new JButton("3");
        this.btn4 = new JButton("4");
        this.btn5 = new JButton("5");
        this.btn6 = new JButton("6");
        this.btn7 = new JButton("7");
        this.btn8 = new JButton("8");
        this.btn9 = new JButton("9");
        this.btnMs = new JButton("MS");
        this.btnMs.setFont(new Font("Arial", Font.PLAIN, 11));
    }

    public void dimensionar() {
        this.setLayout(null);        
        this.lblPantalla.setBounds(10, 30, 290, 50);
        this.lblPantalla.setBounds(10, 30, 290, 50);
        this.btnEnc.setBounds(10, 90, 110, 50);
        this.btnSum.setBounds(250, 150, 50, 110);
        this.btnRes.setBounds(250, 90, 50, 50);
        this.btnMul.setBounds(190, 90, 50, 50);
        this.btnDiv.setBounds(130, 90, 50, 50);
        this.btn7.setBounds(10, 150, 50, 50);
        this.btn8.setBounds(70, 150, 50, 50);
        this.btn9.setBounds(130, 150, 50, 50);
        this.btnSin.setBounds(190, 210, 50, 50);
        this.btn4.setBounds(10, 210, 50, 50);
        this.btn5.setBounds(70, 210, 50, 50);
        this.btn6.setBounds(130, 210, 50, 50);
        this.btnExp.setBounds(190, 150, 50, 50);
        this.btn1.setBounds(10, 270, 50, 50);
        this.btn2.setBounds(70, 270, 50, 50);
        this.btn3.setBounds(130, 270, 50, 50);
        this.btnMp.setBounds(190, 330, 50, 50);
        this.btnPun.setBounds(70, 330, 50, 50);
        this.btn0.setBounds(10, 330, 50, 50);
        this.btnIgu.setBounds(250, 270, 50, 110);
        this.btnMn.setBounds(130, 330, 50, 50);
        this.btnMs.setBounds(190, 270, 50, 50);
    }

    public void adicionar() {
        this.add(lblPantalla);
        this.add(btnEnc);
        this.add(btnSum);
        this.add(btnRes);
        this.add(btnMul);
        this.add(btnDiv);
        this.add(btn7);
        this.add(btn8);
        this.add(btn9);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);
        this.add(btn3);
        this.add(btn2);
        this.add(btn1);
        this.add(btn0);
        this.add(btnSin);
        this.add(btnExp);
        this.add(btnMp);
        this.add(btnMn);
        this.add(btnPun);
        this.add(btnIgu);
        this.add(btnMs);
    }

    public void accionar() {
        this.btnEnc.addActionListener(this);
        this.btnSum.addActionListener(this);
        this.btnRes.addActionListener(this);
        this.btnMul.addActionListener(this);
        this.btnDiv.addActionListener(this);
        this.btn7.addActionListener(this);
        this.btn8.addActionListener(this);
        this.btn9.addActionListener(this);
        this.btn4.addActionListener(this);
        this.btn5.addActionListener(this);
        this.btn6.addActionListener(this);
        this.btn3.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn1.addActionListener(this);
        this.btn0.addActionListener(this);
        this.btnSin.addActionListener(this);
        this.btnExp.addActionListener(this);
        this.btnMp.addActionListener(this);
        this.btnMn.addActionListener(this);
        this.btnPun.addActionListener(this);
        this.btnIgu.addActionListener(this);
        this.btnMs.addActionListener(this);
    }

    public void mostrar() {
        this.setSize(330, 430);
        this.setVisible(true);
    }

    public String sinDecimal(Double resultado) {
        String retorno = "";
        retorno = Double.toString(resultado);
        if (resultado % 1 == 0) {
            retorno = retorno.substring(0, retorno.length() - 2);
        }
        return retorno;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnEnc) {
            if (this.encendido) {
                this.encendido = false;
                this.lblPantalla.setText("");
                this.num1 = 0.0;
                this.num2 = 0.0;
                this.res = 0.0;
                this.mem = 0.0;
                this.operador = "";
            } else {
                this.encendido = true;
                this.lblPantalla.setText("0");
            }
        } else if (this.encendido) {
            if (e.getSource() == this.btn0 || e.getSource() == this.btn1 || e.getSource() == this.btn2 || e.getSource() == this.btn3 || e.getSource() == this.btn4
                    || e.getSource() == this.btn5 || e.getSource() == this.btn6 || e.getSource() == this.btn7 || e.getSource() == this.btn8 || e.getSource() == this.btn9) {
                JButton btn = (JButton) e.getSource();                
                if (this.lblPantalla.getText().equals("0") || this.auxiliar) {
                    this.lblPantalla.setText(btn.getText());
                } else {
                    this.lblPantalla.setText(this.lblPantalla.getText() + btn.getText());
                }
                this.auxiliar = false;
            } else if (e.getSource() == this.btnPun && !this.lblPantalla.getText().contains(".")) {
                this.lblPantalla.setText(this.lblPantalla.getText() + ".");                
            } else if (e.getSource() == this.btnSum || e.getSource() == this.btnRes || e.getSource() == this.btnMul || e.getSource() == this.btnDiv) {
                JButton btn = (JButton) e.getSource();                
                if (!this.operador.isEmpty()) {
                    this.num2 = Double.parseDouble(this.lblPantalla.getText());
                    
                    switch (this.operador) {
                        case "+":
                            this.num1 = _op.sumar(this.num1, this.num2);
                            break;
                        case "-":
                            this.num1 = _op.restar(this.num1, this.num2);
                            break;
                        case "*":
                            this.num1 = _op.multiplicar(this.num1, this.num2);
                            break;
                        case "÷":
                            if (this.num2 == 0) {
                                this.error = true;
                                this.lblPantalla.setText("NO SE PUEDE DIVIDIR ENTRE CERO");
                                return;
                            } else {
                                this.num1 = _op.dividir(this.num1, this.num2);
                            }
                            break;
                    }
                    this.lblPantalla.setText(sinDecimal(this.num1));
                } else {
                    this.num1 = Double.parseDouble(this.lblPantalla.getText());
                }
                this.operador = btn.getText();
                this.auxiliar = true;
            } else if (e.getSource() == this.btnIgu) {
                this.num2 = Double.parseDouble(this.lblPantalla.getText());
                this.auxiliar = true;
                switch (this.operador) {
                    case "+":
                        this.res = _op.sumar(this.num1, this.num2);
                        break;
                    case "-":
                        this.res = _op.restar(this.num1, this.num2);
                        break;
                    case "*":
                        this.res = _op.multiplicar(this.num1, this.num2);
                        break;
                    case "÷":
                        if (this.num2 == 0) {
                            this.error = true;
                            this.auxiliar = true;
                            this.num1 = 0.0;
                            this.num2 = 0.0;
                            this.res = 0.0;
                            this.operador = "";
                            this.error = false;
                            this.lblPantalla.setText("NO SE PUEDE DIVIDIR ENTRE CERO");
                            return;
                        } else {
                            this.res = _op.dividir(this.num1, this.num2);
                        }
                        break;
                    default:
                        break;
                }
                if (this.error) {
                    this.lblPantalla.setText("NO SE PUEDE DIVIDIR ENTRE CERO");
                } else if(this.auxiliar) {
                    this.lblPantalla.setText(sinDecimal(this.res));
                }
                this.num1 = 0.0;
                this.num2 = 0.0;
                this.res = 0.0;
                this.operador = "";
                this.error = false;
                this.auxiliar = true;
            } else if (e.getSource() == this.btnSin) {
                double angulo = Double.parseDouble(this.lblPantalla.getText());
                this.res = _op.seno(angulo);
                this.lblPantalla.setText(sinDecimal(this.res));
                this.auxiliar = true;
            } else if (e.getSource() == this.btnExp) {
                double x = Double.parseDouble(this.lblPantalla.getText());
                this.res = _op.exponencial(x);
                this.lblPantalla.setText(sinDecimal(this.res));
                this.auxiliar = true;
            } else if (e.getSource() == this.btnMp) {
            	this.res = _op.sumar(Double.parseDouble(this.lblPantalla.getText()), mem);
            	this.lblPantalla.setText(sinDecimal(res));
            	this.auxiliar = true;
            } else if (e.getSource() == this.btnMn) {
                this.res = _op.restar(Double.parseDouble(this.lblPantalla.getText()), mem);
                this.lblPantalla.setText(sinDecimal(res));
                this.auxiliar = true;
            } else if (e.getSource() == this.btnMs) {
                this.mem = Double.parseDouble(this.lblPantalla.getText());
                this.auxiliar = true;
            }
        }
    }
}
