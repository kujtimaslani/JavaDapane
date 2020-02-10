package ProsjektKlasse;

import java.util.Date;
import java.util.*;
import java.io.*;
 
public class HusInnboForsikring extends Forsikring {
     
    private String boligadr;
    private int postnr;
    private String poststed;
    private int byggeaar;
    private String boligtype; 
    private String byggemateriale;
    private int belopBygg;
    private int belopInnbo;
    private int kvm;
    
    public HusInnboForsikring(Kunde k, String boligadr, int postnr, String poststed, int byggeaar, String boligtype, 
    String byggemateriale, int kvm , int belopBygg, int belopInnbo, int fBelop, String betingelser) 
    {
        super(k, fBelop, betingelser);
        this.boligadr = boligadr;
        this.postnr = postnr;
        this.poststed = poststed;
        this.byggeaar = byggeaar;
        this.boligtype = boligtype;
        this.byggemateriale = byggemateriale;
        this.kvm = kvm;
        this.belopBygg = belopBygg;
        this.belopInnbo = belopInnbo;
    }
     
    //Set-metoder
    public void setBoligadr(String boligadr) {
        this.boligadr = boligadr;
    }
 
    public void setPostnr(int postnr) {
        this.postnr = postnr;
    }
    
    public void setKvm(int kvm) {
        this.kvm = kvm;
    }
 
    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }
 
    public void setByggeaar(int byggeaar) {
        this.byggeaar = byggeaar;
    }
 
    public void setBoligtype(String boligtype) {
        this.boligtype = boligtype;
    }
 
    public void setByggemateriale(String byggemateriale) {
        this.byggemateriale = byggemateriale;
    }
    
 
    public void setBelopBygg(int belopBygg) {
        this.belopBygg = belopBygg;
    }
 
    public void setBelopInnbo(int belopInnbo) {
        this.belopInnbo = belopInnbo;
    }
     
    //Get-metoder
    public String getBoligadr() {
        return boligadr;
    }
 
    public int getPostnr() {
        return postnr;
    }
 
    public String getPoststed() {
        return poststed;
    }
 
    public int getByggeaar() {
        return byggeaar;
    }
 
    public String getBoligtype() {
        return boligtype;
    }
 
    public String getByggemateriale() {
        return byggemateriale;
    }
    
    public int getKvm()
    {
        return kvm;
    }
 
    public int getBelopBygg() {
        return belopBygg;
    }
 
    public int getBelopInnbo() {
        return belopInnbo;
    }
    
   public String toString()
    {
        String tekst =  "Type forsikring: Hus&Innboforsikring" +
                         super.toString() +
                        "Boligadr: " + boligadr +
                        "\nPostnr: " + postnr +
                        "\nPoststed: " + poststed +
                        "\nByggeår: " + byggeaar +
                        "\nBoligtype: " + boligtype +
                        "\nByggemateriale: " + byggemateriale + 
                        "\nKvm: " + kvm + 
                        "\nBelopbygning: " + belopBygg +
                        "\nBelopinnbo: " + belopInnbo+ "\n";
        return tekst;
    }
}