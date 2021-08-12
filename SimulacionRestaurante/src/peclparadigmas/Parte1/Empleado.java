/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Empleado extends Thread {

    private final String id;
    private final Estanteria mostradorPedidos;
    private final Estanteria mesaPlatos;
    private String pedido = "";
    private boolean running = true;
    private final Log log;
   
    
    public Empleado(String id, Estanteria mostradorPedidos, Estanteria mesaPlatos) throws IOException {
        this.id = id;
        this.mostradorPedidos = mostradorPedidos;
        this.mesaPlatos = mesaPlatos;
        this.log = new Log();
    }

    @Override
    public void run() {

        int rand;
        while (true) {
            //introducimos un sleep en el while para que pueda ejecutar el metodo de cambiarEstado()
            try {
                sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(running){
            try {
                pedido = mostradorPedidos.getPedido();
                log.guardar(id + " coge el pedido "+ pedido + " del mostrador de pedidos");
                rand = (int) (300 + 400 * Math.random());
                sleep(rand);
                log.guardar(id + " deja el pedido "+ pedido + " en la mesa de pedidos");
                mesaPlatos.insertarPedido(pedido);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }   catch (IOException ex) {
                    Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }

    }

    public String getPedido() {
        return pedido;
    }
   public void cambiarEstado() {
        this.running = !running;
    }

}
