/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Usuario
 */
public interface InterfazRemota extends Remote{
    
    String getMostradorPedidos() throws RemoteException;
    String getMesaPlatos() throws RemoteException;
    
    
}
