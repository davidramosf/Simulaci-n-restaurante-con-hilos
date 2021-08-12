/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Estanteria {

    private final String nombre;
    private final Semaphore lleno;
    private final ArrayList<String> listaPedidos;
    private final Semaphore vacio = new Semaphore(0);
    private final Semaphore em = new Semaphore(1);
    
    

    public Estanteria(String nombre, int max) throws IOException {
        this.nombre = nombre;
        this.lleno = new Semaphore(max);
        listaPedidos = new ArrayList<>();
        
    }

    public void insertarPedido(String pedido) {
        try {
            
            lleno.acquire();
            em.acquire();
            listaPedidos.add(pedido);
            
            }
         catch (InterruptedException ie) {
            System.out.println(ie);
        } finally {
            em.release();
            vacio.release();
        }

    }

    public String getPedido() {
        String pedido = "";

        try {
            vacio.acquire();
            em.acquire();

            pedido = listaPedidos.get(0);
            listaPedidos.remove(0);
            
                
            }
         catch (InterruptedException ie) {
            System.out.println(ie);
        } finally {
            em.release();
            lleno.release();

        }
        return pedido;

    }
    public ArrayList getListaPedidos(){
    
        return listaPedidos;
    }
    
    public void abrir(){
        em.release();
    }
    
    public void cerrar(){
        try {
            em.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Estanteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
