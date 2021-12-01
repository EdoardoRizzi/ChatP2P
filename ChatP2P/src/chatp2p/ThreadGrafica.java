/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 39334
 */
public class ThreadGrafica extends Thread {

    DatiCondivisi dati;

    public ThreadGrafica(DatiCondivisi dati) {
        this.dati = dati;
    }

    public void run() {
        while (true) {
            String[] m = dati.getRicevuti(dati.SizeOfMessaggiRicevuti()).split(";");
            String s = m[1];
            dati.frame.SetTxt(s);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
