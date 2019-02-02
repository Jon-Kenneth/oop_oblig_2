package no.hiof.jonkenneth;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Koden som gjør at man kan velge i kommandolinjen hvilken oppgave som skal gjøres har jeg tatt med fra forrige oblig.
        //Det omfatter en del av koden i main og metoden velgHandling().

        System.out.println("\nOBS: Norske bokstaver vises ikke alltid riktig.\n");

        Scanner scanner = new Scanner(System.in);

        //Brukeren velger hvilken handling som skal utføres
        String valgtHandling = velgHandling(scanner);

        //Utfører valgt handling
        switch (valgtHandling) {
            case "oppgave345":
                oppgave345();
                break;

            case "oppgave6":
                oppgave6();
                break;

            case "oppgave78":
                oppgave78();
                break;

            case "oppgave910":
                oppgave910();
                break;

            default:
                System.out.println("Ugyldig valg");
                break;
        }

        //Ferdig med scanner
        scanner.close();
    }

    public static String velgHandling(Scanner scanner){

        //Ber brukeren om å velge ønsket handling
        String beskjed = "\nVelg handling ved å skrive en av følgende valg og trykke enter.\n";
        beskjed += "\noppgave345\noppgave6\noppgave78\noppgave910";

        System.out.println(beskjed);

        String valgtHandling = scanner.nextLine();

        return valgtHandling;
    }

    public static void oppgave345(){
        Tvserie gOT = new Tvserie("Game of Thrones", "Dette er en kul serie om drager og sånt", 2011, 5, 4);

        gOT.leggTilEpisode("Winter is coming", 1, 1, 60);
        gOT.leggTilEpisode("What is dead may never die", 2, 3, 64);
        gOT.leggTilEpisode("Mhysa", 3, 10);//Test uten spilletid
        gOT.leggTilEpisode("Garden of bones", 2, 4, 63);
        gOT.leggTilEpisode("The ghost of Harrenhal", 2, 5, 62);
        gOT.leggTilEpisode("The old gods and the new", 4, 6, 61);
        gOT.leggTilEpisode("No one", 5, 8, 58);
        gOT.leggTilEpisode("The broken man", 5, 7, 50);
        gOT.leggTilEpisode("Blood of my blood", 5, 6, 40);

        System.out.println(gOT.toString());
        ArrayList<Episode> alleEpisoder = gOT.getEpisoder();
        System.out.println(gOT.episodeArrayListToString(alleEpisoder));
    }

    public static void oppgave6(){
        Tvserie enTvserie = new Tvserie("Tittel", "Beskrivelse, beskrivelse og beskrivelse", 1980, 3, 1);

        //Genererer Sesonger og episoder
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 20; j++){
                enTvserie.leggTilEpisode("Episode " + j, i, j, 60);
            }
        }

        //Henter arraylist med valgt sesong og skriver ut
        ArrayList<Episode> sesong4 = enTvserie.episoderISesongList(4);
        System.out.println("\nEpisoder fra sesong 4:" + enTvserie.episodeArrayListToString(sesong4));
    }

    public static void oppgave78(){
        Tvserie enTvserie = new Tvserie("Tittel", "Beskrivelse, beskrivelse og beskrivelse", 1980, 3, 1);

        //Genererer Sesonger og episoder med tilfeldig spilletid mellom 20 og 30
        Random random = new Random();
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 20; j++){
                enTvserie.leggTilEpisode("Episode " + j, i, j, (random.nextInt(10) + 21));
            }
        }

        //Skriver ut gjennomsnittlig spilletid
        System.out.println("\nGjennomsnittlig spilletid for hele TV-serien er: " + enTvserie.getGjennomsnittligSpilletid());
    }

    public static void oppgave910(){

        Tvserie gOT = new Tvserie("Game of Thrones", "Dette er en kul serie om drager og sånt", 2011, 5, 4);

        gOT.leggTilEpisode("Winter is coming", 1, 1, 60);
        gOT.leggTilEpisode("What is dead may never die", 2, 3, 64);
        gOT.leggTilEpisode("Mhysa", 3, 10);//Test uten spilletid
        gOT.leggTilEpisode("Garden of bones", 2, 4, 63);
        gOT.leggTilEpisode("The ghost of Harrenhal", 2, 5, 62);
        gOT.leggTilEpisode("The old gods and the new", 4, 6, 61);
        gOT.leggTilEpisode("No one", 5, 8, 58);

        //Disse episodene har ugyldige sesonger
        gOT.leggTilEpisode("The broken man", 0, 7, 50);
        gOT.leggTilEpisode("Blood of my blood", 8, 6, 40);
    }
}
