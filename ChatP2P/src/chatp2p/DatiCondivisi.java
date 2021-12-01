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
    private final Object syncDestinationIP;
    private final Object syncSourceIP;

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
        this.syncDestinationIP = new Object();
        this.syncSourceIP = new Object();
    }
    
    public void AggiungiAMessaggiInviati(String s){
        synchronized(InvioMessaggio){
            MessaggioInviati.add(s);
        }
    }
    
    public void AggiungiAMessaggiRicevuti(String s){
        synchronized(RiceviMessaggio){
            MessaggiRicevuti.add(s);
        }
    }
    
    //restituisce il messaggio nella posizione voluta
    public String getInvia(int pos){
        synchronized(InvioMessaggio){
            return MessaggioInviati.get(pos).toString();
        }
    }
    //restituisce il messaggio nella posizione voluta
    public String getRicevuti(int pos){
        synchronized(RiceviMessaggio){
            return MessaggiRicevuti.get(pos).toString();
        }
    }
    //restituisce la dimensione dell'array
    public int SizeOfMessaggioInviati(){
        synchronized(InvioMessaggio){
            return MessaggioInviati.size();
        }
    }
    //restituisce la dimensione dell'array
    public int SizeOfMessaggiRicevuti(){
        synchronized(RiceviMessaggio){
            return MessaggiRicevuti.size();
        }
    }

    public boolean isConnesso() {
        synchronized(syncConnesso){
            return Connesso;
        }  
    }

    public void setConnesso(boolean Connesso) {
        synchronized(syncConnesso){
            this.Connesso = Connesso;
        }
    }

    public boolean isInAttesaDiConnessione() {
        synchronized(syncInAttesaDiConnessione){
            return InAttesaDiConnessione;
        }
    }

    public void setInAttesaDiConnessione(boolean InAttesaDiConnessione) {
        synchronized(syncInAttesaDiConnessione){
            this.InAttesaDiConnessione = InAttesaDiConnessione;
        }
    }

    public boolean isAckConnessione() {
        synchronized(syncAckConnessione){
            return AckConnessione;
        }
    }

    public void setAckConnessione(boolean AckConnessione) {
        synchronized(syncAckConnessione){
            this.AckConnessione = AckConnessione;
        }
    }

    public boolean isRichiestaConnessione() {
        synchronized(syncRichiestaConnessione){
            return RichiestaConnessione;
        }
    }

    public void setRichiestaConnessione(boolean RichiestaConnessione) {
        synchronized(syncRichiestaConnessione){
            this.RichiestaConnessione = RichiestaConnessione;
        }
    }

    public String getDestinationIP() {
        synchronized(syncDestinationIP){
            return DestinationIP;
        }
    }

    public void setDestinationIP(String DestinationIP) {
        synchronized(syncDestinationIP){
              this.DestinationIP = DestinationIP;
        }
    }

    public String getSourceIP() {
        synchronized(syncSourceIP){
            return SourceIP;
        }
    }

    public void setSourceIP(String SourceIP) {
        synchronized(syncSourceIP){
            this.SourceIP = SourceIP;
        }
    }
}
