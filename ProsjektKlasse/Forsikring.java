package ProsjektKlasse;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.awt.Font;


public abstract class Forsikring implements Serializable 
{
    private int premie;
    private Date opprFDato;
    private int fBelop;
    private String betingelser;
    private int forsikringnr;
    static int nestenr = 1;
    List<Integer> skademeldingliste = new ArrayList<>();
    Kunde kunde;
    
    public Forsikring(Kunde k,int fBelop, String betingelser) {
        this.fBelop = fBelop;
        this.betingelser = betingelser;
        System.out.println(nestenr);
        forsikringnr = nestenr++;
        this.kunde = k;
        
        opprFDato = new Date();
    }
     
    //Set-metoder
    
    public void setKunde(Kunde kunde)
    {
        this.kunde = kunde;
    }
    public void setPremie(int premie) {
        this.premie = premie;
    }
    
    public void setOpprFDato(Date opprFDato) {
        this.opprFDato = opprFDato;
    }
 
    public void setfBelop(int fBelop) {
        this.fBelop = fBelop;
    }
 
    public void setBetingelser(String betingelser) {
        this.betingelser = betingelser;
    }
     
    //Get-metoder
    public Kunde getKunde()
    {
        return kunde;
    }
    public int getPremie() {
        return premie;
    }
 
    public Date getOpprFDato() {
        return opprFDato;
    }
 
    public int getfBelop() {
        return fBelop;
    }
 
    public String getBetingelser() {
        return betingelser;
    }
    
    public int getForsikringnr()
    {
        return forsikringnr;
    }
    
    public List<Integer> getSkademeldingListe()
    {
        return skademeldingliste;
    }
    
    
    public void leggTilSkademeldingIForsikring(int i)
    {
        skademeldingliste.add(i);
    }
    
    public String getForsikringstype()
    {
        
        if(this instanceof BilForsikring)
        {
            return "Bilforsikring";
        }
        else if(this instanceof Baatforsikring)
        {
            return "Baatforsikring";
        }
        else if(this instanceof FritidsboligForsikring)
        {
            return "Fritidsboligforsikring";
        }
        else if(this instanceof ReiseForsikring)
        {
            return "Reiseforsikring";
        }
        else
            return "Husinnboforsikring";
        
    }
    
    public Forsikring getFtype()
    {
        
        if(this instanceof BilForsikring)
        {
            return this;
        }
        else if(this instanceof Baatforsikring)
        {
            return this;
        }
        else if(this instanceof FritidsboligForsikring)
        {
            return this;
        }
        else if(this instanceof ReiseForsikring)
        {
            return this;
        }
        else
            return this;
        
    }
    
    public String toString()
    {   
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy"); //Formaterer Dato
       
        String tekst = "\nForsikringnummer: " + forsikringnr;
        tekst += "\nKundenr: " + kunde.getKundeNr();
        tekst += "\nStartdato: " + format.format(opprFDato) + "\n";
        tekst += "Premie: " + premie + "\n";
        tekst += "Beløp: " + fBelop + "\n";
        tekst += "Betingelser: " + betingelser + "\n";
        
        return tekst;
    }
}
