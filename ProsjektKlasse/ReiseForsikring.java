package ProsjektKlasse;

import java.util.Date;
import java.util.*;
import java.io.*;
 
public class ReiseForsikring extends Forsikring
{
     
    private String fOmraade;
    
 
    public ReiseForsikring(Kunde k, String fOmraade, int fBelop, String betingelser) 
    {
        super(k, fBelop, betingelser);
        this.fOmraade = fOmraade;
        
    }
     
    //Set-metoder
    public void setfOmraade(String fOmraade) {
        this.fOmraade = fOmraade;
    }
 
    
     
    //Get-metoder
    public String getfOmraade() {
        return fOmraade;
    }
 
   
     
    
    public String toString()
    {
         
        String tekst =  "Type forsikring: Reiseforsikring" +
                         super.toString() +
                         "\nOmraade: " + fOmraade + "\n";
                         
                         
        return tekst;
    }
}
