/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 39334
 */
public class ThreadInvio extends Thread {

    private DatiCondivisi dati;
    private DatagramSocket server;
    private byte[] responseBuffer;
    DatagramPacket packet;
    private int conta;

    public ThreadInvio(DatiCondivisi d) throws SocketException {
        server = new DatagramSocket(12345);
        responseBuffer = new byte[1500];
        packet = new DatagramPacket(responseBuffer, responseBuffer.length);
        this.dati = d;
        this.conta = 0;
    }

    public void Run() {
        while (true) {
            if (dati.SizeOfMessaggioInviati() > conta) {
                try {
                    invia();
                    conta++;
                } catch (IOException ex) {
                    Logger.getLogger(ThreadAscolto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void invia() throws IOException {
        responseBuffer = dati.getInvia(conta).getBytes();
        DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
        responsePacket.setAddress(packet.getAddress());
        responsePacket.setPort(packet.getPort());
        server.send(responsePacket);
    }
}
