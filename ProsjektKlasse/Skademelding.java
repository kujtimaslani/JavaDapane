package ProsjektKlasse;

import java.util.Date;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

//Skademelding klasse
public class Skademelding implements Serializable {

    private Date datoSkade;
    private String typeSkade;
    private String skadeBeskr;
    private int skadeTakst;
    private int utbetaltErstatning;
    private Forsikring forsikring;
    private int skadenr;
    static int nestenr = 1;
    private int antSkademeldinger;

    public Skademelding(Forsikring forsikring, String typeSkade,
            String skadeBeskr, int skadeTakst, int utbetaltErstatning)
    {
        this.forsikring = forsikring;
        this.typeSkade = typeSkade;
        this.skadeBeskr = skadeBeskr;
        this.skadeTakst = skadeTakst;
        this.utbetaltErstatning = utbetaltErstatning;
        datoSkade = new Date();
        skadenr = nestenr++;
        antSkademeldinger++;
    }

    //Set-metoder
    public void setForsikring(Forsikring forsikring) {
        this.forsikring = forsikring;
    }

    public void setDatoSkade(Date datoSkade) {
        this.datoSkade = datoSkade;
    }

    public void setSkadenr(int skadenr) {
        this.skadenr = skadenr;
    }

    public void setTypeSkade(String typeSkade) {
        this.typeSkade = typeSkade;
    }

   
     public void setSkadeBeskr(String skadeBeskr) {
     this.skadeBeskr = skadeBeskr;
     }
 
    public void setSkadeTakst(int skadeTakst) {
        this.skadeTakst = skadeTakst;
    }

    public void setUtbetaltErstatning(int utbetaltErstatning) {
        this.utbetaltErstatning = utbetaltErstatning;
    }

    public void leggtilAntSkademld()
    {
        antSkademeldinger++;
    }
    
    //Get-metoder
    public int getAntSkademeldinger()
    {
        return antSkademeldinger;
    }
    
    public Forsikring getForsikring() {
        return forsikring;
    }

    public Date getDatoSkade() {
        return datoSkade;
    }

    public int getSkadenr() {
        return skadenr;
    }

    public String getTypeSkade() {
        return typeSkade;
    }

    
    public String getSkadeBeskr() {
        return skadeBeskr;
    }

    
    public int getSkadeTakst() {
        return skadeTakst;
    }

    public int getUtbetaltErstatning() {
        return utbetaltErstatning;
    }

    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy"); //Formaterer Dato

        String tekst = "Skadenummer: " + skadenr
                + "\nDato: " + format.format(datoSkade)
                + "\nType Skade: " + typeSkade
                + "\nBeskrivelse av skade: " + skadeBeskr
                + "\nTakstbeløp: " + skadeTakst
                + "\nUtbetalt erstatning: " + utbetaltErstatning + "\n\n";

        return tekst;
    }
}
