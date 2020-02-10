package GUI;

import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import ProsjektKlasse.*;


//Denne klassen er et panel, som inneholder komponentene som tekstfelter, knapper og utskriftsområde
//Denne er for å registrere bilforsikringer

public class BilGui extends JPanel
{
    private JLabel kundenrlabel, fornavnlabel, etternavnlabel, regnrlabel, merkelabel,
                    regaarlabel, kjorelengdelabel, prisprkmlabel, bonuslabel, premielabel, 
                    betingelselabel, beloplabel, modelllabel, forsikringnrlabel;
    
    private JTextField forsikringnrfelt, kundenrfelt, fornavnfelt,etternavnfelt, regnrfelt, merkefelt,
                    regaarfelt, kjorelengdefelt, prisprkmfelt, bonusfelt, premiefelt, belopfelt, modellfelt, betingelsefelt;
    
    private JButton registrerBilforsikring, tilbake, sokMedFnrknapp, fjernForsikringknapp, visalleforsikringer;
    private JTextArea utskrift;
    private JScrollPane scroll;
     
    Knappelytter lytter;
    
    JFrame parent;
    
    KundeReg kunderegister;
    
    public BilGui(JFrame parent, KundeReg register)
    {
        
        kunderegister = register;
        
        this.parent = parent;
        
        lytter = new Knappelytter();
        
        //Initialiserer labelene
       
        
        kundenrlabel = new JLabel("Kundenr:");
        fornavnlabel = new JLabel("Fornavn:");
        etternavnlabel = new JLabel("Etternavn:");
        premielabel = new JLabel("Premie:");
        beloplabel = new JLabel("Beløp");
        betingelselabel = new JLabel("Betingelser");
        regnrlabel = new JLabel("Reg.nr:");
        merkelabel = new JLabel("Merke:");
        modelllabel = new JLabel("Modell:");
        regaarlabel = new JLabel("Reg.år:");
        kjorelengdelabel = new JLabel("Kjørelengde(km):");
        prisprkmlabel = new JLabel("Pris pr km:");
        bonuslabel = new JLabel("Bonus (%)");
        forsikringnrlabel = new JLabel("Forsikringnr: ");
 
        //Initialiserer TextFieldene
        kundenrfelt = new JTextField(20);
        fornavnfelt = new JTextField(20); 
        etternavnfelt = new JTextField(20); 
        premiefelt = new JTextField(20);
        belopfelt = new JTextField(20);
        betingelsefelt = new JTextField(20);
        regnrfelt = new JTextField(20);
        merkefelt = new JTextField(20);
        modellfelt = new JTextField(20);
        regaarfelt = new JTextField(20); 
        kjorelengdefelt = new JTextField(20); 
        prisprkmfelt = new JTextField(20);
        bonusfelt = new JTextField(20);
        forsikringnrfelt = new JTextField(20);
        
        //Initialiserer og gir knappene en addactionlistener
        registrerBilforsikring = new JButton("Registrer Bilforsikring");
        registrerBilforsikring.addActionListener(lytter);
        tilbake = new JButton("Tilbake");
        tilbake.addActionListener(lytter);
        sokMedFnrknapp = new JButton("Søk med fnr");
        sokMedFnrknapp.addActionListener(lytter);
        fjernForsikringknapp = new JButton("Fjern forsikring");
        fjernForsikringknapp.addActionListener(lytter);
        visalleforsikringer  = new JButton("Vis alle forsikringer");
        visalleforsikringer.addActionListener(lytter);
        
        //Lager utskriftsområde
        utskrift = new JTextArea();
        utskrift.setEditable(false);
        utskrift.setColumns(20);
        utskrift.setRows(30);
        scroll = new JScrollPane();
        scroll.setMinimumSize(new Dimension(200, 200));
        scroll.setPreferredSize(new Dimension(300, 300));
        scroll.setViewportView(utskrift);
        
        komponenter();
    }
    
    private void komponenter()
    {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
                    .addGroup(layout.createSequentialGroup()
                     .addGap(50, 50, 50)
                     .addComponent(registrerBilforsikring)
                     .addGap(18, 18, 18)
                     .addComponent(sokMedFnrknapp)
                     .addGap(18,18,18)
                     .addComponent(fjernForsikringknapp)
                     .addGap(18,18,18)
                     .addComponent(visalleforsikringer)
                     .addGap(18,18,18)
                     .addComponent(tilbake))
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                             
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(regnrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(regnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(betingelselabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(betingelsefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                               
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(fornavnlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(fornavnfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(kundenrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(forsikringnrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                             
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(modelllabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(modellfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(prisprkmlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(prisprkmfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            
                            
                            
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                    
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(etternavnlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                    
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(merkelabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(merkefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                   
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(regaarlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(regaarfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                   
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(beloplabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(belopfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))     
                                    
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(kjorelengdelabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(kjorelengdefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                    
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(bonuslabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(bonusfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                    .addGap(50, 50, 50))))
                        
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)                    
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))))
            );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                       
                       .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(forsikringnrlabel))
                         
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(kundenrlabel)
                        .addComponent(belopfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(beloplabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fornavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fornavnlabel)
                        .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(etternavnlabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                               
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(modellfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(modelllabel)
                        .addComponent(merkefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(merkelabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)     
                
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(regnrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(regnrlabel)
                        .addComponent(regaarfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(regaarlabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(betingelsefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(betingelselabel)
                        .addComponent(kjorelengdefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(kjorelengdelabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(prisprkmfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(prisprkmlabel)
                        .addComponent(bonusfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonuslabel))
                        
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tilbake)
                        .addComponent(registrerBilforsikring)
                        .addComponent(sokMedFnrknapp)
                        .addComponent(fjernForsikringknapp)
                        .addComponent(visalleforsikringer))
                        
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                );
    }
    
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    public void registrerNyBilforsikring()
    {
        try
        {
        int kundenr = Integer.parseInt(kundenrfelt.getText());
        int belop = Integer.parseInt(belopfelt.getText());
        String betingelser = betingelsefelt.getText();
        String fornavn = fornavnfelt.getText();
        String etternavn = etternavnfelt.getText();
        String regnr = regnrfelt.getText();
        String merke = merkefelt.getText();
        String modell = modellfelt.getText();
        int regaar = Integer.parseInt(regaarfelt.getText());
        int kjorelengde  = Integer.parseInt(kjorelengdefelt.getText());
        int prisPrKM = Integer.parseInt(prisprkmfelt.getText());
        int bonus = Integer.parseInt(bonusfelt.getText());
        
        
        if(kundenrfelt.getText().length()>0 && belopfelt.getText().length()>0 && regaarfelt.getText().length()>0
                &&betingelser.length()>0 && fornavn.length()>0 && etternavn.length()>0 && regnr.length()>0
                &&merke.length()>0 && modell.length()>0 && kjorelengdefelt.getText().length()>0
                &&prisprkmfelt.getText().length()>0 && bonusfelt.getText().length()>0)
        {
            if(bonus >= 50 && bonus <=75)
            {
                Kunde k = kunderegister.finnKundeMedKundenr(kundenr);
                Forsikring f = new BilForsikring( k,  fornavn,  etternavn,  regnr, 
                                 merke,  modell, regaar,  kjorelengde,  prisPrKM,  bonus, 
                                 belop, betingelser);
        
                int premie = kunderegister.setPremieBilForsikring(belop, bonus);
                f.setPremie(premie);
        
                f.getKunde().leggTilAarligPremie(premie);
                kunderegister.leggTilForsikringPaaKunde(kundenr, f);
                utskrift.setText("Forsikringen er satt på knr: " + k.getKundeNr() +
                                 "Forsikringnr: " + f.getForsikringnr());
            }
            else
            {
                visMelding("Bonusen må være mellom 50 og 75");
            }
        }
        else
            visMelding("Du må fylle ut alle feltene!");
        }
        catch(NumberFormatException nfe)
            {
                visMelding("Feil i tallformat"
                        + "\nPrøv igjen!");
            }
            catch(NullPointerException npe)
            {
                visMelding("Finner ikke kunden i registeret"
                    + "\nPrøv igjen!");
            }
    }
    
    
    public void finnForsikringMedFnr()
    {
        try
        {
            int forsikringnr = Integer.parseInt(forsikringnrfelt.getText());
        
            Forsikring forsikring = kunderegister.finnForsikringMedFnr(forsikringnr);
            utskrift.setText(forsikring.toString() + "\n");
        }
        catch(NumberFormatException nfe)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen!");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke denne forsikringen i regiteret");
        }
    }
    
    
    public void fjernForsikringMedFnr()
    {
        try
        {
            int forsikringnr = Integer.parseInt(forsikringnrfelt.getText());
        
            kunderegister.fjernForsikringMedForsikringsnr(forsikringnr);
        
            utskrift.setText("\tForsikringen er nå fjernet");
        }
        catch(NumberFormatException nfe)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen!");
        }
    }
    
    //Vis alle forsikringer
    public void visAlleForsikringer()
    {
        //visAlleForsikringer()
        
        if(kunderegister.getForsikringliste().size() == 0)
        {
            utskrift.setText("Det er ingen registrerte forsikringer i systemet");
        }
        else
            utskrift.setText("\t\tRegistrerte forsikringer:\n\n" + kunderegister.visAlleForsikringer());
    }
     
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == registrerBilforsikring)
            {
                registrerNyBilforsikring();
            }
            else if(e.getSource() == sokMedFnrknapp)
            {
                finnForsikringMedFnr();
            }
            else if(e.getSource() == fjernForsikringknapp)
            {
                fjernForsikringMedFnr();
            }
            else if(e.getSource() == visalleforsikringer)
            {
                visAlleForsikringer();
            }
            else if(e.getSource() == tilbake)
            {
                parent.dispose();
                StartGui gui = new StartGui(kunderegister);
            }
        }
    }
}