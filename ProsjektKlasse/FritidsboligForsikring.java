package ProsjektKlasse;

import java.util.Date;

 
public class FritidsboligForsikring extends Forsikring
{
     
    private String boligadr;
    private int postnr;
    private String poststed;
    private int byggeaar;
    private String boligtype;
    private String byggemateriale;
    private int kvm;
    private int belopbygning;
    private int belopinnbo;
    private String utleie;
    private String boligeiernavn;
    
    public FritidsboligForsikring(Kunde k, String boligadr, int postnr, String poststed, int byggeaar, String boligtype, 
                                 String byggemateriale, int kvm, int belopbygning, 
                                 int belopinnbo, String utleie, int fBelop, 
                                 String betingelser)
    {
        super(k, fBelop, betingelser);
        this.boligeiernavn = boligeiernavn;
        this.boligadr = boligadr;
        this.postnr = postnr;
        this.poststed = poststed;
        this.byggeaar = byggeaar;
        this.boligtype = boligtype;
        this.byggemateriale = byggemateriale;
        this.kvm = kvm;
        this.belopbygning = belopbygning;
        this.belopinnbo = belopinnbo;
        this.utleie = utleie;
    }
     
    //Get- og set metoder
 
    public String getBoligadr(){
            return boligadr;
    }
 
    public void setBoligadr(String boligadr){
            this.boligadr = boligadr;
    }
 
    public int getPostnr(){
            return postnr;
    }
 
    public void setPostnr(int postnr){
            this.postnr = postnr;
    }
 
    public String getPoststed(){
            return poststed;
    }
 
    public void setPoststed(String poststed){
            this.poststed = poststed;
    }
 
    public int getByggeaar(){
            return byggeaar;
    }
 
    public void setByggeaar(int byggeaar){
            this.byggeaar = byggeaar;
    }
 
    public String getBoligtype(){
            return boligtype;
    }
 
    public void setBoligtype(String boligtype){
            this.boligtype = boligtype;
    }
 
    public String getByggemateriale(){
            return byggemateriale;
    }
 
    public void setByggemateriale(String byggemateriale){
            this.byggemateriale = byggemateriale;
    }
 
 
    public int getKvm(){
            return kvm;
    }
 
    public void setKvm(int kvm){
            this.kvm = kvm;
    }
 
    public int getBelopbygning(){
            return belopbygning;
    }
 
    public void setBelopbygning(int belopbygning){
            this.belopbygning = belopbygning;
    }
 
    public double getBelopinnbo(){
            return belopinnbo;
    }
 
    public void setBelopinnbo(int belopinnbo){
            this.belopinnbo = belopinnbo;
    }
 
    public String getUtleie(){
            return utleie;
    }
 
    public void setUtleie(String utleie){
            this.utleie = utleie;
    }
    
    public String toString()
    {
        String tekst =  "Type forsikring: Fritidsboligforsikring" +
                         super.toString() +
                        "Boligadr: " + boligadr +
                        "\nPostnr: " + postnr +
                        "\nPoststed: " + poststed +
                        "\nByggeår: " + byggeaar +
                        "\nBoligtype: " + boligtype +
                        "\nByggemateriale: " + byggemateriale + 
                        "\nKvm: " + kvm + 
                        "\nBelopbygning: " + belopbygning +
                        "\nBelopinnbo: " + belopinnbo + 
                        "\nUtleie" + utleie + "\n";
        return tekst;
    }
}