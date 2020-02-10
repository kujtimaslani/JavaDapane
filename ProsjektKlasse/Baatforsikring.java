package ProsjektKlasse;

import java.util.Date;
 
public class Baatforsikring extends Forsikring 
{
    
    private String fornavn;
    private String etternavn;
    private String regnr;
    private String merke;
    private String modell;
    private int aarsmodell;
    private int lengde;
    private String motortype;
    private int motorstyrke;
 
    //Konstruktør
    public Baatforsikring(Kunde k,String fornavn, String etternavn, String regnr, String merke, String modell,
                    int aarsmodell, int lengde, String motortype, int motorstyrke, int fBelop, String betingelser) {
        super(k, fBelop, betingelser);
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.regnr = regnr;
        this.merke = merke;
        this.modell = modell;
        this.aarsmodell = aarsmodell;
        this.lengde = lengde;
        this.motortype = motortype;
        this.motorstyrke = motorstyrke;
    }
     
    //Get og Set metoder
 
    public String getFornavn() {
        return fornavn;
    }
 
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
 
    public String getEtternavn() 
    {
        return etternavn;
    }
    public void setEtternavn(String etternavn) 
    {
        this.etternavn = etternavn;
    }
 
    public String getRegnr() 
    {
        return regnr;
    }
    public void setRegnr(String regnr) 
    {
        this.regnr = regnr;
    }
 
    public String getMerke() 
    {
        return merke;
    }
    public void setMerke(String merke) 
    {
        this.merke = merke;
    }
 
    public String getModell() 
    {
        return modell;
    }
    public void setModell(String modell) 
    {
        this.modell = modell;
    }
 
    public int getAarsmodell() 
    {
        return aarsmodell;
    }
    public void setAarsmodell(int aarsmodell) 
    {
        this.aarsmodell = aarsmodell;
    }
 
    public int getLengde() 
    {
        return lengde;
    }
    public void setLengde(int lengde) 
    {
        this.lengde = lengde;
    }
 
    public String getMotortype() 
    {
        return motortype;
    }
    public void setMotortype(String motortype) 
    {
        this.motortype = motortype;
    }
 
    public int getMotorstyrke() 
    {
        return motorstyrke;
    }
 
    public void setMotorstyrke(int motorstyrke) 
    {
        this.motorstyrke = motorstyrke;
    }
     
     
    //toString metode for Båtforsikringen
    public String toString()
    {   
        String tekst = "Type forsikring: Baatforsikring" 
                + super.toString()
                + "\nNavn: " + fornavn + etternavn
                + "\nRegistreringsnr: " + regnr
                + "\nMerke: " + merke
                + "\nModell: " + modell
                + "\nAarsmodell: " + aarsmodell
                + "\nLengde: " + lengde
                + "\nMotortype: " + motortype
                + "\nMotorstykre: " + motorstyrke;
         
        return tekst;
    }   
}//End of Baatforsikring