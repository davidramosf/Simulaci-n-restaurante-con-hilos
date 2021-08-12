/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte2;

import java.io.IOException;
import java.rmi.Naming;
import peclparadigmas.Parte1.Interfaz;

/**
 *
 * @author Usuario
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            
        Interfaz interfaz = new Interfaz();
        Implementador imp = new Implementador(interfaz);
            Naming.rebind("//127.0.0.1/Restaurante", imp);
            System.out.println("El objeto Restaurante ha quedado registrado");
            
        }catch(IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
            System.exit(0);
        }
    }
    
}
