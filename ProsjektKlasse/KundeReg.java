package ProsjektKlasse;

import java.util.*;
import javax.swing.*;
import java.io.*;
import ProsjektKlasse.Kunde;

public class KundeReg implements Serializable
{
    List<Kunde> kundeliste;
    List<Forsikring> forsikringliste;
    List<Skademelding> skademeldingliste;
    List<Kunde> ikkeaktivkundeliste; //Lagrer alle ikke aktive kunder
    
    
    
    public KundeReg()
    {
         kundeliste = new LinkedList<>();
         forsikringliste = new LinkedList<>();
         skademeldingliste = new LinkedList<>();
         ikkeaktivkundeliste = new LinkedList<>();
         
         
         lesFil();
    }
    
    //Kundeliste sine metoder
    //Funker
    public void addKunde(Kunde k)
    {
        kundeliste.add(k);
        k.setAktiv(true);
    }
    
    //Get metode for alle listene
    public List<Kunde> getKundeliste(){
        return kundeliste;
    }
    public List<Kunde> getIkkeaktivekundeliste(){
        return ikkeaktivkundeliste;
    }
    public List<Forsikring> getForsikringliste(){
        return forsikringliste;
    }
    public List<Skademelding> getSkademeldingliste(){
        return skademeldingliste;
    }
    
    
    //Fjerner kunde med gitt knr
    public void fjernKundeMedKundenr(int nr)
    {
        Iterator<Kunde> iter = kIterator();
        Kunde kunde;
        
        while(iter.hasNext())
        {
            kunde = iter.next();
            if(kunde.getKundeNr() == nr)
            {
                ikkeaktivkundeliste.add(kunde);
                kunde.setAktiv(false);
                kundeliste.remove(kunde);
            }
        }
    } 
    
    
    
    
    //Går igjennom kundelista
    public Iterator<Kunde> kIterator()
    {
        return kundeliste.iterator();
    }
    public Iterator<Kunde> deaktivertIterator()
    {
        return ikkeaktivkundeliste.iterator();
    }
    //Går igjennom forsikringliste
     public Iterator<Forsikring> fIterator()
    {
        return forsikringliste.iterator();
    }
    //Går igjennom skademeldingliste 
    public Iterator<Skademelding> sIterator()
    {
        return skademeldingliste.iterator();
    }
     

    //Returnerer kunde med et gitt kundernr
    public Kunde finnKundeMedKundenr(int knr)
    {
        Iterator<Kunde> iter = kIterator();
        Kunde kunde;
        
        try
        {
            while(iter.hasNext())
            {
                kunde = iter.next();
                if(kunde.getKundeNr() == knr)
                {
                    return kunde;
                }
            }
            
        }
        catch(NoSuchElementException nsee)
        {
            JOptionPane.showMessageDialog(null, "Finner ingen ");
        }
        
        return null;
    }
    
    //Metode for å finne kunde med fornavn
    public Kunde finnKundeMedFornavn(String fornavn)
    {
        Iterator<Kunde> iter = kIterator();
        Kunde kunde;
        
        try
        {
            while(iter.hasNext())
            {
                kunde = iter.next();
                if(kunde.getFornavn().equals(fornavn))
                {
                    return kunde;
                }
            }
            
        }
        catch(NoSuchElementException nsee)
        {
            JOptionPane.showMessageDialog(null, "Finner ingen ");
        }
        
        return null;
    }
    
    //Metode for å finne kunde med etternavn
    public Kunde finnKundeMedEtternavn(String etternavn)
    {
        Iterator<Kunde> iter = kIterator();
        Kunde kunde;
        
        try
        {
            while(iter.hasNext())
            {
                kunde = iter.next();
                if(kunde.getEtternavn().equals(etternavn))
                {
                    return kunde;
                }
            }
            
        }
        catch(NoSuchElementException nsee)
        {
            JOptionPane.showMessageDialog(null, "Finner ingen ");
        }
        
        return null;
    }
    
    //Sender med et kundenummer som parameter, for å finne dens forsikringer
    public String tidligereKundeSineForsikringer(int knr)
    {
        Iterator<Kunde> iter = deaktivertIterator();
        Kunde kunde;
        String tekst ="";
        while(iter.hasNext())
        {
            kunde = iter.next();
            if(kunde.getKundeNr() == knr)
            {
                tekst += kunde.toStringForsikringer();
            }
        }
        return tekst;
    }
    
    //Viser alle kunder i kundelista
    public String visAlleKunder()
    {
        String tekst = "";
        for(Kunde kunde : kundeliste)
        {
            tekst += kunde.toString();
        }
        
        return tekst;
    }
    
    //Viser alle inaktive kunder i systemet
    public String visAlleDeaktiverteKunder()
    {
        String tekst = "";
        for(Kunde kunde: ikkeaktivkundeliste)
        {
            tekst += kunde.toString();
        }
        
        return tekst;
    }
    
    
    
    
    //Legger til forsikring på kunde
    public void leggTilForsikringPaaKunde(int knr, Forsikring f)
    {
        Kunde kunde = finnKundeMedKundenr(knr);
        kunde.setForsikringTilKunde(f);
        
        if(kunde.getAntallForsikringerPaaKunde() >= 3)
        {
            kunde.setTotalKunde(true);
        }
        else
            kunde.setTotalKunde(false);
        
       
        forsikringliste.add(f);
    }
    
     public void fjernForsikringMedForsikringsnr(int forsikringsnr)
     {
        Iterator<Forsikring> iter = fIterator();
        Forsikring forsikring;
        
        //Kjører igjennom lista
        while(iter.hasNext())
        {
            forsikring = iter.next();
            if(forsikring.getForsikringnr() == forsikringsnr)
            {
                iter.remove(); //Fjerner elementet fra lista
            }
        }
    }
    
    //Finner forsikring med et gitt fnr
    public Forsikring finnForsikringMedFnr(int fnr)
    {
        Iterator<Forsikring> iter = fIterator();
        Forsikring forsikring;
        
        while(iter.hasNext())
        {
            forsikring = iter.next();
            if(forsikring.getForsikringnr() == fnr)
            {
                return forsikring;
            }
        }
        return null;
    }
    
    //Finner antall registrerte forsikinger totalt
    public int finnAntallForsikringer()
    {
        Iterator<Forsikring> iter = fIterator();
        int i = 0;
        while(iter.hasNext())
        {
            i++;
        }
        
        return i;
    }
    
    
    //Returnerer en boolean verdi, for å sjekke om forsikringen er gyldig
    public boolean gyldigForsikring(int fnr)
    {
        Forsikring f = finnForsikringMedFnr(fnr);
        
        if(f.getForsikringstype().equals("Bilforsikring"))
            return true;
        else if(f.getForsikringstype().equals("Baatforsikring"))
            return true;
        else if(f.getForsikringstype().equals("Fritidsboligforsikring"))
            return true;
        else if(f.getForsikringstype().equals("Reiseforsikring"))
            return true;
        else if(f.getForsikringstype().equals("Husinnboforsikring"))
            return true;
        else
            return false;
    }
    
    //Setter premie på bil, sender med forsikringbeløpet og bonusen
    public int setPremieBilForsikring(int belop, int bonus)
    {
        int premie = belop * bonus/100;
        
        return premie;
    }
    
    
    public String visAlleForsikringer()
    {
        String tekst = "";
        for(Forsikring f : forsikringliste)
        {
            tekst += f.toString() + "\n";
        }
        return tekst;
    }
    
    
    //Skademeldingreg metoder-------------------------------------------------
    
    public void registrerNySkademelding(int fnr, Skademelding s)
    {
        Forsikring f = finnForsikringMedFnr(fnr);
        s.setForsikring(f);
        s.leggtilAntSkademld();
        skademeldingliste.add(s);
    }
    
    
    //Returner antalle registrerte skademeldinger
    public int antallSkademeldinger()
    {
        return skademeldingliste.size();
    }
    
    //finner skade med det gitte skadenummeret
    public Skademelding finnSkadeMedSkadenr(int snr)
    {
        Iterator<Skademelding> iter = sIterator();
        Skademelding skade;
        
        while(iter.hasNext())
        {
            skade = iter.next();
            if(skade.getSkadenr() == snr)
            {
                return skade;
            }
        }
        return null;
    }
    
    //Finner skade etter en gitt skadetype(forsikringstype)
    public String finnSkadeEtterSkadetype(String skadetype)
    {
        String skader = "";
        Iterator<Skademelding> iter = sIterator();
        Skademelding skade;
        while(iter.hasNext())
        {
            skade = iter.next();
            if(skade.getForsikring().getForsikringstype().equals(skadetype))
            {
                skader += skade.toString();
            }
        }
        
        return skader;
        
    }
    
     public String visAlleSkader()
    {
        String tekst = "";
        for(Skademelding s : skademeldingliste)
        {
            tekst += s.toString() + "\n";
        }
        return tekst;
    }
    
    //Totale inntekter og utgifter-------------------
    
    //Totale utbetalt utgifter
    public int totalUtbetaltErstatningTilKunde(int knr)
    {
        Kunde kunde = finnKundeMedKundenr(knr);
        
        return kunde.getUtbetalteErstatninger();
    }
    //Totalte premieintekter for forsikringsselskapet
    public int totalPremieInntekt()
    {
        int totalpremie = 0;
        Iterator<Kunde> iter = kIterator();
        Kunde kunde;
        
        while(iter.hasNext())
        {
            kunde = iter.next();
            totalpremie += kunde.getAarligPremie();
        }
        return totalpremie;
    }
    
    public int totalUtbetaltErstatning()
    {
        Iterator<Skademelding> iter = sIterator();
        Skademelding skade;
        int totalbelop = 0;
        while(iter.hasNext())
        {
            skade = iter.next();
            totalbelop += skade.getUtbetaltErstatning();
        }
        
        return totalbelop;
    }
    
    
    
    
    
    
    
    //Lese og skrive til filmetoden-------------------------------------------------------
    public void skrivtilfil()
    {
        try(ObjectOutputStream utfil = 
                new ObjectOutputStream(new FileOutputStream("src/GUI/data.dta")))
        {
            utfil.writeObject(kundeliste);
            utfil.writeObject(forsikringliste);
            utfil.writeObject(skademeldingliste);
            utfil.writeObject(ikkeaktivkundeliste);
            
            utfil.writeInt(Kunde.nestenr);
            utfil.writeInt(Forsikring.nestenr);
            utfil.writeInt(Skademelding.nestenr);
            
        }
        catch(NotSerializableException nse)
        {
            JOptionPane.showMessageDialog(null, "ikke serialisert");
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(null, "Problemer med lesing av fil");
        }
    }
    
        public void lesFil()
        {
            try(ObjectInputStream innfil = 
                new ObjectInputStream(new FileInputStream("src/GUI/data.dta")))
        {
            kundeliste = (List<Kunde>) innfil.readObject();
            forsikringliste = (List<Forsikring>) innfil.readObject();
            skademeldingliste = (List<Skademelding>) innfil.readObject();
            ikkeaktivkundeliste = (List<Kunde>) innfil.readObject();
            
            Kunde.nestenr = innfil.readInt();
            Forsikring.nestenr = innfil.readInt();
            Skademelding.nestenr = innfil.readInt();
            
        }
        catch(ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null, "Fant ikke klasse");
        }
        catch(FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(null, "Finner ikke fil");
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(null, "Problemer med fil");
        }
    }
    
    
    
    
    
    
}
