/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interno;

/**
 *
 * @author ingri
 */
public class Tienda {
    private String nombre;
    private Producto[] catalogo;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.catalogo =  new Producto[20];
    }
    
    public boolean agregarProducto(String nombre, double precio, int tipo){
        int i = encontrarVacio();
        if(i == -1) return false;
        this.catalogo[i] = new Producto(nombre, precio, i, tipo);
        return true;
    }
    
    private int encontrarVacio(){
        for(int i = 0; i< this.catalogo.length; i++){
            if(this.catalogo[i]==null){
                return i;
            }
        }
        return -1;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the catalogo
     */
    public Producto[] getCatalogo() {
        return catalogo;
    }

    /**
     * @param catalogo the catalogo to set
     */
    public void setCatalogo(Producto[] catalogo) {
        this.catalogo = catalogo;
    }
    
    
    
}
