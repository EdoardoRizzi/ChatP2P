/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatp2p;

import java.util.ArrayList;

/**
 *
 * @author 39334
 */
public class DatiCondivisi {

    //lista dei messaggi che il mittente vuole inviare
    private ArrayList MessaggioInviati;
    //lista dei messaggi che si sono ricevuti
    private ArrayList MessaggiRicevuti;

    //è attiva un chat
    private boolean Connesso;
    //inviata la richiesta di connesione in attesa di risposta
    private boolean InAttesaDiConnessione;
    //Rispota alla richiesta di connessione
    private boolean AckConnessione;
    //Richiesta di aprire una connessione
    private boolean RichiestaConnessione;

    private String DestinationIP;
    private String SourceIP;

    //OGGETTI PER SINCRONIZZAZIONE
    //oggetto per la lista MessaggiInviati
    private final Object InvioMessaggio;
    //oggetto per la lista MessaggiRicevuti
    private final Object RiceviMessaggio;
    private final Object syncConnesso;
    private final Object syncInAttesaDiConnessione;
    private final Object syncAckConnessione;
    private final Object syncRichiestaConnessione;

    public DatiCondivisi() {
        this.MessaggioInviati = new ArrayList<String>();
        this.MessaggiRicevuti = new ArrayList<String>();

        this.Connesso = false;
        this.InAttesaDiConnessione = false;
        this.AckConnessione = false;
        this.RichiestaConnessione = false;

        this.DestinationIP = "";
        this.SourceIP = "";

        this.InvioMessaggio = new Object();
        this.RiceviMessaggio = new Object();
        this.syncConnesso = new Object();
        this.syncInAttesaDiConnessione = new Object();
        this.syncAckConnessione = new Object();
        this.syncRichiestaConnessione = new Object();
    }

}
