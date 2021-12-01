/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

/**
 *
 * @author 39334
 */
public class ThreadGestioneMessaggio extends Thread {

    private DatiCondivisi dati;
    private int conta;
    private String[] s;

    public ThreadGestioneMessaggio(DatiCondivisi d) {
        this.dati = d;
        this.conta = 0;
    }

    @Override
    public void run() {
        while (true) {
            if (dati.SizeOfMessaggiRicevuti() > conta) {
                s = dati.getRicevuti(conta).split(";");
                switch (s[0]) {
                    case "c":
                        if (dati.isRichiestaConnessione() == false) {
                            if (dati.isConnesso() == false) {
                                dati.setRichiestaConnessione(true);
                                dati.setAckConnessione(true);
                                dati.setDestinationIP(s[1]);
                            }
                        }
                        break;
                    case "y":
                        if (dati.isAckConnessione()) {
                            dati.setConnesso(true);
                        }
                        break;
                    case "n":
                        if (dati.isAckConnessione() == false) {

                        }
                        break;
                    case "m":
                        if (dati.isConnesso()) {
                            dati.AggiungiAMessaggiRicevuti(s[1]);
                        }
                        break;
                    case "d":
                        if (dati.isConnesso()) {
                            dati.setConnesso(false);
                        }
                        break;
                }
                conta++;
            }
        }
    }

}
