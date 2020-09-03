/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ingri
 */
public class Tienda extends JFrame implements ActionListener {

    String nombre;
    Interno.Tienda tienda;
    JLabel lblNombreTienda;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.tienda = new Interno.Tienda(nombre);
        configurarVentana();
        addLabel(lblNombreTienda, this.nombre, 50, 50, 400, 40, 30);
        botonAgregarProducto();
    }

    private void configurarVentana() {
        this.setTitle(this.nombre);
        this.setSize(800, 600);//x,y
        this.setVisible(true);
        this.setLayout(null); //new FlowLayout()
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addLabel(JLabel label, String texto, int x, int y, int ancho, int altura, int tamano) {
        label = new JLabel(texto);
        label.setBounds(x, y, ancho, altura); //x,y,width,heigth
        label.setFont(new Font("Verdana", Font.PLAIN, tamano));
        label.setForeground(new Color(0, 0, 0));
        this.add(label);
    }

    private void botonAgregarProducto() {
        JButton btn = new JButton("Agregar Producto");
        btn.setBounds(600, 50, 150, 50);
        this.add(btn);
        this.repaint();
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AgregarProducto(tienda);
                for (int i = 0; i < tienda.getCatalogo().length; i++) {
                    if (tienda.getCatalogo()[i] == null) {
                        break;
                    }
                    int y = 100 * (i + 1);
                    addLabel(lblNombreTienda, tienda.getCatalogo()[i].getNombre(), 50, y, 400, 15, 10);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
