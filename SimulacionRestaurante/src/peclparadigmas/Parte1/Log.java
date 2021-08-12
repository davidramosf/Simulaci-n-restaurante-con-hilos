/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclparadigmas.Parte1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario
 */
public class Log {

    private BufferedWriter bw;
    private final File ruta;
    private final Lock cerrojo = new ReentrantLock();

    public Log() throws IOException{
        this.ruta = new File("evoluciónRestaurante.txt");
        this.open(true);
    }

    private void open(boolean append) throws IOException {
        this.bw = new BufferedWriter(new FileWriter(this.ruta.getAbsolutePath(), append));
    }

    public void guardar(String msg) throws IOException {
        try {
            cerrojo.lock();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formatoFecha = sdf.format(new Date());
            this.open(true);
            this.bw.write("[" + formatoFecha + "] " + msg + "\n");
            this.close();
            
        } catch (IOException ie) {

        } finally { 
            cerrojo.unlock();            
        }
    }

    public void close() throws IOException {
        this.bw.close();
    }
}
