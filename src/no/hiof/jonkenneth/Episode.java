package no.hiof.jonkenneth;

public class Episode {



    /*---------------------------------------VARIABLER-----------------------------------------*/

    private String tittel;
    private int sesong;
    private int episodenummer;
    private int spilletid;
    /*-----------------------------------SLUTT-VARIABLER---------------------------------------*/



    /*-------------------------------------KONSTRUKTØRER-------------------------------------*/
    public Episode(String tittel, int sesong, int episodenummer, int spilletid) {
        this.tittel = tittel;
        this.sesong = sesong;
        this.episodenummer = episodenummer;
        this.spilletid = spilletid;
    }

    public Episode(String tittel, int sesong, int episodenummer) {
        this.tittel = tittel;
        this.sesong = sesong;
        this.episodenummer = episodenummer;
    }
    /*-------------------------------------SLUTT-KONSTRUKTØRER---------------------------------*/



    /*------------------------------------------------GETSET----------------------------------------*/
    public int getEpisodenummer() {
        return episodenummer;
    }

    public void setEpisodenummer(int episodenummer) {this.episodenummer = episodenummer; }

    public int getSesong() {
        return sesong;
    }

    public void setSesong(int sesong) {
        this.sesong = sesong;
    }

    public String getTittel() { return tittel; }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }
    /*------------------------------------------SLUTT--GETSET---------------------------------------*/

    /*-----------------------------------------METODER------------------------------------------*/
    public String toString(){
        String returnString = "";
        returnString += "\nEpisode: S" + getSesong() + "E" + getEpisodenummer();
        returnString += "\nTittel: " + getTittel();
        int spilletid = getSpilletid();
        returnString += "\nSpilletid: ";
        returnString += spilletid != 0 ? getSpilletid() : "Ukjent";

        return returnString;
    }
    /*-----------------------------------------SLUTT-METODER------------------------------------------*/

}
/*------------------------------------------SLUTT-CLASS-EPISODE---------------------------------------*/