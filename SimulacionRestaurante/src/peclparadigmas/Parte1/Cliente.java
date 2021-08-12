/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte1;

import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Cliente extends Thread {

    private final String id;
    private final Estanteria mostradorPedidos;
    private final Log log;
    
    public Cliente(String id, Estanteria mostradorPedidos) throws IOException {
        this.id = id;
        this.mostradorPedidos = mostradorPedidos;
        this.log = new Log();
        
        
    }

    @Override
    public void run() {
        String pedido;
        int rand;
            try {
                pedido = id + "- P" + "1";
                mostradorPedidos.insertarPedido(pedido);
              log.guardar(id + " deja el pedido "+ pedido + " en el mostrador de pedidos");
                rand = (int) (500 + 500 * Math.random());
                sleep(rand);
                pedido = id + "- P" + "2";
                log.guardar(id + " deja el pedido "+ pedido + " en el mostrador de pedidos");
                mostradorPedidos.insertarPedido(pedido);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            } catch (IOException ex) {
            
        }
    }
}