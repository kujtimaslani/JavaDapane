package ProsjektKlasse;

import java.util.*;
import java.io.*;

public class Kunde implements Serializable {
     
    private Date opprDato;
    private int kundeNr;
    static int nestenr = 1;
    private String fornavn;
    private String etternavn; 
    private String adresse;
    private int postnr;
    private String poststed;
    private int aarligPremie;
    private boolean aktiv;
    private boolean totalKunde; 
    private int utbetalteErstatninger;
    List<Forsikring> forsikringliste;
    
    public Kunde(String fornavn, String etternavn, String adresse, 
      int postnr , String poststed) {
         
        this.opprDato = opprDato;
       
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.postnr = postnr;
        this.poststed = poststed;
        
        opprDato = new Date();
        kundeNr = nestenr++;
        forsikringliste = new ArrayList<>();
    }
     
    //Set-metoder
 
    public void setOpprDato(Date opprDato) {
        this.opprDato = opprDato;
    }
 
    public void setKundeNr(int kundeNr) {
        this.kundeNr = kundeNr;
    }
 
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
 
    public void setEtternavn(String etternavn)
    {
        this.etternavn = etternavn;
    }
 
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
 
    public void setPostnr(int postnr) {
        this.postnr = postnr;
    }
 
    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }
 
    public void setAarligPremie(int aarligPremie) 
    {
        this.aarligPremie = aarligPremie;
    }
 
    public void setTotalKunde(boolean totalKunde)
    {
        this.totalKunde = totalKunde;
    }
 
    public void setAktiv(boolean status)
    {
        this.aktiv = status;
    }
    
    public void setUtbetalteErstatninger(int utbetalteErstatninger) {
        this.utbetalteErstatninger = utbetalteErstatninger;
    }
    
    public void setForsikringTilKunde(Forsikring f)
    {
        forsikringliste.add(f);
    }   
  
    
    //Get-metoder
     public List<Forsikring> getForsikringListe() 
     {
            return forsikringliste;
     }

    public int getKundeNr()
    {
        return kundeNr;
    }
     
    public Date getOpprDato() {
        return opprDato;
    }
 
    public String getFornavn() {
        return fornavn;
    }
 
    public String getEtternavn() {
        return etternavn;
    }
 
    public String getAdresse() {
        return adresse;
    }
 
    public int getPostnr() {
        return postnr;
    }
    
    public String getPoststed() {
        return poststed;
    }
    
    //Hente årlig premie på en kunde
    public int getAarligPremie() {
        
        if(isTotalKunde())
        {
            return settTotalKundeRabatt();
        }
        else
        {
            return aarligPremie;
        }
    }
 
    public boolean isTotalKunde()
    {
        return totalKunde;
    }
    
    public boolean isAktiv()
    {
        return aktiv;
    }
    
    public void leggTilUtbetalteErstatninger(int belop)
    {
        utbetalteErstatninger += belop;
    }
    
    
    public int getUtbetalteErstatninger() {
        return utbetalteErstatninger;
    }
    
   
    //Legger tilpaa aarlig premie
    public void leggTilAarligPremie(int belop)
    {
        aarligPremie += belop;
    }
    
    //Reduserer aarlig premie
    public void reduserAarligPremie(int belop)
    {
        aarligPremie -= belop;
    }
    
    //Setter rabatt på kunde om han er totalkunde
    public int settTotalKundeRabatt()
    {
        int rabatt = aarligPremie;
        rabatt = rabatt * 10/100;
        int redusertAarligPremie = aarligPremie - rabatt;
        return redusertAarligPremie;
    }
    
    //Returner antall forsikringer på en kunde
    public int getAntallForsikringerPaaKunde()
    {
        return forsikringliste.size();
    }
    
    public String toStringForsikringer()
    {
        Iterator<Forsikring> i = forsikringliste.iterator();
        StringBuilder sb = new StringBuilder();
        while(i.hasNext()){
            sb.append(i.next().toString());
        }
        return sb.toString();
    }
    
    public String toString()
    {
        String tekst = "Kundenr: " + kundeNr + "\n";
        tekst += "Fornavn: " + fornavn + "\n";
        tekst += "Etternavn: " + etternavn + "\n";
        tekst += "Adresse: " + adresse + "\n";
        tekst += "Postnr: " + postnr + "\n\n";
        return tekst;
    }
    
}  
