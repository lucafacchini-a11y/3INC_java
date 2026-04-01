/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjpokemon;

/**
 *
 * @author luca.facchini
 */
public class Pokemon {
    
     private String nome;
    private String tipo;
    private int livello;
    private int puntiVita;
    private String codicePokemon;
    private int nMosse;
    private String[] mosse;
    private ArrayInt punteggio;
    private int[] dannoM;

    public Pokemon(String nome, String tipo, int livello, int puntiVita) {
        this.nome = nome;
        this.tipo = tipo;
        this.livello = livello;
        this.puntiVita = puntiVita;
        codicePokemon = generaCodice();
        mosse = new String[4];
        this.punteggio = new ArrayInt(10);
        dannoM = new int[mosse.length];

    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLivello() {
        return livello;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public String getCodicePokemon() {
        return codicePokemon;
    }

    private String generaCodice() {
        String txt = "";
        txt += nome.substring(0, 2);
        txt += tipo.substring(tipo.length() - 2);
        txt += livello;
        return txt;
    }

    public String attacca(Pokemon p) {
        String risultato = "Hai vinto";
        if (p.livello > livello) {
            risultato = "hai perso";
        } else if (p.livello == livello) {
            risultato = "pareggio";
        }
        return risultato;
    }

    public boolean aggiungi(String mos, int dannoMossa) {
        boolean controllo = false;
        if (nMosse < mosse.length) {
            mosse[nMosse] = mos;
            dannoM[nMosse] = dannoMossa;
            nMosse++;
            controllo = true;
        }
        return controllo;
    }

    public String stampaMosse() {
        String txt = "";
        for (int i = 0; i < nMosse; i++) {
            txt += "Mossa numero " + i + " , " + mosse[i] + " Danno: " + dannoM[i] + "\n";
        }
        return txt;
    }

    public boolean aggiungiPunti(int punt) {
        return punteggio.addElem(punt);
    }

    public String stampaStorico() {
        String txt = "";
        int[] arr = punteggio.getArr();
        for (int i = 0; i < punteggio.size(); i++) {
            txt += "Partita " + i + ": " + punteggio.getArr()[i] + " Punti\n";
        }
        return txt;
    }

    public int migliorPunteggio() {
        return punteggio.max();
    }

    public double mediaPunti() {
        return punteggio.media();
    }

    public boolean haBattutoRecord(int punti) {
        return punteggio.isMax(punti);
    }

    public int partiteVinte() {
        int vinto = 0;
        for (int i = 0; i < punteggio.size(); i++) {
            if (punteggio.get(i) > 50) {
                vinto++;
            }
        }
        return vinto;
    }

    public int potenzaAttacco(int indiceMossa) {
        return dannoM[indiceMossa] + livello;
    }

    public int calcolaPuntiPartita(int potenza) {
        return potenza * 2;
    }

    public void combatti(Pokemon avversario, int mossaMia, int mossaAvversario) {
    //  Calcolo potenza (senza this)
    int miaPotenza = potenzaAttacco(mossaMia);
    int suaPotenza = avversario.potenzaAttacco(mossaAvversario);

    //  Calcolo punti base (senza this)
    int mieiPunti = calcolaPuntiPartita(miaPotenza);
    int suoiPunti = avversario.calcolaPuntiPartita(suaPotenza);

    // Bonus al vincitore
    if (miaPotenza > suaPotenza) {
        mieiPunti += 20;
    }
   
    if (suaPotenza > miaPotenza) {
        suoiPunti += 20;
    }

    // ognuno dei due pokemo n registra i propi punti
    aggiungiPunti(mieiPunti);        
    avversario.aggiungiPunti(suoiPunti);
}

    public String analisiPokemon() {
        String txt = "";
        txt += "Pokemon: " + nome + "\n";
        txt += "Miglior Punteggio: " + migliorPunteggio() + "\n";
        txt += "Media Punti: " + mediaPunti() + "\n";
        txt += "Partite Vinte: " + partiteVinte() + "\n";
        return txt;

    }

    public String stampa() {
        String txt = "";
        txt += "nome: " + nome + "\n";
        txt += "tipo: " + tipo + "\n";
        txt += "livello: " + livello + "\n";
        txt += "puntiVita: " + puntiVita + "\n";
        txt += "codicePokemon: " + generaCodice().toUpperCase();
        return txt;
    }
}
