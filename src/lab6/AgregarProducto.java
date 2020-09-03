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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ingri
 */
public class AgregarProducto{
    JFrame ventanaPrincipal;
    String nombre;
    Interno.Tienda tienda;
    JTextField txtNombre, txtPrecio;
    JComboBox cbTipo;
    JButton btnAgregarProducto;

    public AgregarProducto(Interno.Tienda tienda) {
        this.nombre = nombre;
        this.tienda = new Interno.Tienda(nombre);
        configurarVentana();
        addLabel(new JLabel(), "Agregar Producto", 50, 50, 400, 40, 30);
        addLabel(new JLabel(), "Nombre:", 100, 100, 200, 30, 15);
        addTextField(txtNombre, "", 350, 100, 200, 30);
        addLabel(new JLabel(), "Precio:", 100, 150, 200, 30, 15);
        addTextField(txtPrecio, "", 350, 150, 200, 30);
        addLabel(new JLabel(), "Tipo:", 100, 200, 200, 30, 15);
        String[] opciones = {"Comida", "Limpieza"};
        addComboBox(cbTipo,opciones, 350, 200, 200, 30);
        addButton("Agregar Producto",200,250,200,30);
    }

    private void configurarVentana() {
        ventanaPrincipal.setTitle(nombre);
        ventanaPrincipal.setSize(600, 400);//x,y
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setLayout(null); //new FlowLayout()
        ventanaPrincipal.setLocationRelativeTo(null);
    }

    private void addLabel(JLabel label, String texto, int x, int y, int ancho, int altura, int tamano) {
        label = new JLabel(texto);
        label.setBounds(x, y, ancho, altura); //x,y,width,heigth
        label.setFont(new Font("Verdana", Font.PLAIN, tamano));
        label.setForeground(new Color(0, 0, 0));
        ventanaPrincipal.add(label);
        ventanaPrincipal.repaint();
    }

    private void addTextField(JTextField txt, String texto, int x, int y, int ancho, int altura) {
        txt = new JTextField(texto);
        txt.setBounds(x, y, ancho, altura); //x,y,width,heigth
        txt.setForeground(new Color(0, 0, 0));
        ventanaPrincipal.add(txt);
        ventanaPrincipal.repaint();
    }

    private void addComboBox(JComboBox cb, String[] opciones, int x, int y, int ancho, int altura) {
        cb = new JComboBox(opciones);
        cb.setSelectedIndex(0);
        cb.setBounds(x,y,ancho,altura);
        ventanaPrincipal.add(cb);
        ventanaPrincipal.repaint();
    }

    private void addButton(String texto, int x, int y, int ancho, int altura) {
        this.btnAgregarProducto = new JButton(texto);
        this.btnAgregarProducto.setBounds(x,y,ancho,altura);
        ventanaPrincipal.add(this.btnAgregarProducto);
        ventanaPrincipal.repaint();
        this.btnAgregarProducto.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            tienda.agregarProducto(txtNombre.getText(), Double.parseDouble(txtPrecio.getText()), cbTipo.getSelectedIndex()+1);
            ventanaPrincipal.setVisible(false);
            ventanaPrincipal.dispose();
         }
        });
    }


}
