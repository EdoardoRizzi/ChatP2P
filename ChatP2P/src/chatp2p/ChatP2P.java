/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 39334
 */
public class ChatP2P {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatiCondivisi d = new DatiCondivisi();
        try {
            ThreadAscolto ta = new ThreadAscolto(d);
            ThreadInvio ti = new ThreadInvio(d);
            ThreadGestioneMessaggio tgm = new ThreadGestioneMessaggio(d);
            ThreadGrafica tg = new ThreadGrafica(d);
            FramChat fc = new FramChat(d);

            ta.start();
            ti.start();
            tgm.start();
            tg.start();
        } catch (SocketException ex) {
            Logger.getLogger(FramChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
