/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ActualizarInterfaz extends Thread {

    Interfaz interfaz;

    public ActualizarInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                interfaz.actualizar();
            } catch (InterruptedException ex) {
                Logger.getLogger(ActualizarInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
