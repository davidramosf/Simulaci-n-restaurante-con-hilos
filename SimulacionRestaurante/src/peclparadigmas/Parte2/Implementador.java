/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import peclparadigmas.Parte1.Interfaz;

/**
 *
 * @author Usuario
 */
public class Implementador extends UnicastRemoteObject implements InterfazRemota {
    Interfaz interfaz;
    
    public Implementador(Interfaz interfaz) throws RemoteException{
        this.interfaz = interfaz;
    }

    @Override
    public String getMostradorPedidos() throws RemoteException {
        return interfaz.getMostradorPedidos();
    }

    @Override
    public String getMesaPlatos() throws RemoteException {
        return interfaz.getMesaPlatos();
    }    
}
