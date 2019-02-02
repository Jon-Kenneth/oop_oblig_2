package no.hiof.jonkenneth;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tvserie {



    /*---------------------------------------VARIABLER-----------------------------------------*/
    private String tittele;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episoder;
    private double gjennomsnittligSpilletid;
    private int antallSesonger = 1;
    /*-----------------------------------SLUTT-VARIABLER---------------------------------------*/



    /*-------------------------------------KONSTRUKTØRER-------------------------------------*/
    public Tvserie(String tittel, String beskrivelse, int aar, int maaned, int dag){
        this.setTittel(tittel);
        this.setBeskrivelse(beskrivelse);
        this.setUtgivelsesdato(aar, maaned, dag);
        this.episoder = new ArrayList<>();
    }
    /*-------------------------------------SLUTT-KONSTRUKTØRER---------------------------------*/



    /*------------------------------------------------GETSET----------------------------------------*/
    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(int aar, int maaned, int dag) {
        this.utgivelsesdato = LocalDate.of(aar, maaned, dag);
    }
    public ArrayList<Episode> getEpisoder(){
        return this.episoder;
    }

    public double getGjennomsnittligSpilletid(){
        //Velger å oppdatere gjenomsnitt her også, i tilfelle spilletid har blitt forandret etter at en episode har blitt lagt til
        oppdaterGjennomsnittligSpilletid();
        return gjennomsnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }
    /*------------------------------------------SLUTT--GETSET---------------------------------------*/



    /*-----------------------------------------METODER------------------------------------------*/
    public void leggTilEpisode(String tittel, int sesong, int episodenummer, int spilletid){

        //Legger til episode hvis sesongnummer ikke er for høy eller lfor lav
        if(sesong > antallSesonger + 1){
            System.out.println("Du kan ikke hoppe over en sesong. Nåværende anntall sesonger er: " + antallSesonger);
        }
        else if(sesong < 1){
            System.out.println("Du kan ikke legge til en sesong med nummer mindre enn 1");
        }
        else{
            Episode episoden = new Episode(tittel, sesong, episodenummer, spilletid);
            episoder.add(episoden);
            oppdaterGjennomsnittligSpilletid();

            //Oppdaterer anntall sesonger hvis den nye er 1 mer
            if(sesong > antallSesonger){
                antallSesonger = sesong;
            }
        }
    }

    //Legger til episode uten spilletid. Setter 0 som default
    public void leggTilEpisode(String tittel, int sesong, int episodenummer) {
        leggTilEpisode(tittel, sesong, episodenummer, 0/*Default*/);
    }

    private void oppdaterGjennomsnittligSpilletid(){
        int episoderUtenSpilletid = 0;
        //Henter første spilletid før loopen for å ikke starte med 0. Dette for å unngå å dele med 0
        gjennomsnittligSpilletid = episoder.get(0).getSpilletid();

        if (episoder.get(0).getSpilletid() == 0) {episoderUtenSpilletid += 1;}
        else{gjennomsnittligSpilletid = episoder.get(0).getSpilletid();}

        for(int i = 1; i < episoder.size(); i++) {
            if (episoder.get(i).getSpilletid() == 0) {
                episoderUtenSpilletid += 1;
            }
            else{
                //Beregner nytt gjennomsnitt for hver runde i løkken.
                //Litt vanskelig å forklare regnestykket, men konseptet er at spilletiden i nåværende runde vektes før den regnes sammen med gjennomsnittet fra tidligere runder.
                //Det tas høyde for eventuelle episoder der spilletid ikke er oppgitt slik at de ikke er med i beregningen.
                gjennomsnittligSpilletid = (gjennomsnittligSpilletid * (i - episoderUtenSpilletid) + episoder.get(i).getSpilletid()) / (i + 1 - episoderUtenSpilletid);
            }
        }
    }

    public String toString(){
        String returnString = "";

        returnString += "\nTittel: " + getTittel();
        returnString += "\nBeskrivelse: " + getBeskrivelse();
        returnString += "\nUtgivelsesdato: " + getUtgivelsesdato().toString();

        return returnString;
    }

    public ArrayList<Episode> episoderISesongList(int sesong){
        ArrayList<Episode> episoder = new ArrayList<>();

        for(Episode episoden : this.episoder){
            if(episoden.getSesong() == sesong){
                episoder.add(episoden);
            }
        }

        if(episoder.isEmpty()){
            System.out.println("\nSesongen finnes ikke.");
            //Ulogisk å returnere en tom liste,
            // men vet ikke hvordan jeg kan få en metode til å godta muligheten for å ikke returnere noe.
            // Hvis det i det hele tatt er mulig da.
            return episoder;
        }
        else {
            return episoder;
        }
    }

    public String episodeArrayListToString(ArrayList<Episode> episoder){
        String returnString = "";

        for(Episode episoden : episoder){
            returnString += "\n" + episoden.toString();
        }

        return returnString;
    }
    /*----------------------------------------SLUTT-METODER----------------------------------------*/



}
/*------------------------------------------SLUTT-CLASS-TVSERIE---------------------------------------*/


