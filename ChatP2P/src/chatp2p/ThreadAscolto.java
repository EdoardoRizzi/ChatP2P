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
 * @author rizzi_edoardo
 */
public class ThreadAscolto extends Thread {

    private DatagramSocket server;
    private byte[] buffer;
    DatagramPacket packet;

    public ThreadAscolto() throws SocketException {
        server = new DatagramSocket(12345);
        buffer = new byte[1500];
        packet = new DatagramPacket(buffer, buffer.length);
    }
    
    public void Run(){
        while(true)
        {
            try {
                Ricevi();
            } catch (IOException ex) {
                Logger.getLogger(ThreadAscolto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }

    public void Ricevi() throws IOException {
        server.receive(packet);

        byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra

        String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());

        System.out.println(messaggioRicevuto);
    }

    public void Invia(String risposta) throws IOException {
        
        byte[] responseBuffer = risposta.getBytes();

        DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

        responsePacket.setAddress(packet.getAddress());

        responsePacket.setPort(packet.getPort());

        server.send(responsePacket);

    }
}
