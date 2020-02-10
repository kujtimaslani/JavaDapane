package ProsjektKlasse;

import java.util.Date;
 
public class BilForsikring extends Forsikring {

    private String fornavn;
    private String etternavn;
    private String regnr;
    private String merke;
    private int regaar;
    private int kjorelengde;
    private int prisPrKM;
    private int bonus;
    private String modell;
    
    
    //Konstruktør
    public BilForsikring(Kunde k, String fornavn, String etternavn, String regnr,
            String merke, String modell, int regaar, int kjorelengde, int prisPrKM, int bonus,
            int fBelop, String betingelser) 
    {
        super(k, fBelop, betingelser);
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.regnr = regnr;
        this.merke = merke;
        this.modell = modell;
        this.regaar = regaar;
        this.kjorelengde = kjorelengde;
        this.prisPrKM = prisPrKM;
        this.bonus = bonus;
    }

    //Get og set metoder
    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public int getRegaar() {
        return regaar;
    }
    
    public void setRegaar(int regaar) {
        this.regaar = regaar;
    }
    
    public int getKjorelengde() {
        return kjorelengde;
    }

    public void setKjorelengde(int kjorelengde) {
        this.kjorelengde = kjorelengde;
    }

    public int getPrisPrKM()
    {
        return prisPrKM;
    }

    public void setPrisPrKM(int prisPrKM) {
        this.prisPrKM = prisPrKM;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String toString() {
        String tekst= "Type forsikring: Bilforsikring"
                + super.toString() 
                + "Navn: " + fornavn + " " + etternavn
                + "\nRegistreringsnr: " + regnr
                + "\nMerke: " + merke
                + "\nRegaar: " + regaar
                + "\nKjorelengde: " + kjorelengde
                + "\nPrisper KM: " + prisPrKM
                + "\nBonus: " + bonus + "\n";

        return tekst;
    }
}
