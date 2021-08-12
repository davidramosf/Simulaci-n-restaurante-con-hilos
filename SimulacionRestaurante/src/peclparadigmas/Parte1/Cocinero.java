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
public class Cocinero extends Thread {

    private final String id;
    private final Estanteria mesaPlato;
    private String pedido = "";
    private final Log log;

    public Cocinero(String id, Estanteria mesaPlato) throws IOException {
        this.id = id;
        this.mesaPlato = mesaPlato;
        this.log = new Log();
    }

    @Override
    public void run() {
        int rand;
        
        while (true) {            
            try {
                pedido = mesaPlato.getPedido();
                log.guardar(id + " coge el pedido "+ pedido + " de la mesa de platos");
                rand = (int) (1500 + 500 * Math.random());
                sleep(rand);
                log.guardar(id + " Cocinado pedido"+ pedido);
            } catch (InterruptedException | IOException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }                            
        }
    }

    public String getPedido() {
        return pedido;
    }
}
