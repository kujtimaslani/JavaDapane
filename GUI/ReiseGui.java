package GUI;

import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import ProsjektKlasse.*;

public class ReiseGui extends JPanel
{
    private JLabel  kundenrlabel, forsikringnrlabel, premielabel, beloplabel, betingelselabel, omraadelabel
                   , fsumlabel;
    
    private JTextField kundenrfelt, forsikringnrfelt, belopfelt, betingelsefelt, omraadefelt;
    
    private JButton registrerforsikring, tilbake, fjernforsikring, sokMedFnr, visalle;
    private JTextArea utskrift;
    private JScrollPane scroll;
     
    Knappelytter lytter;
    KundeReg kunderegister; 
    JFrame parent;
    public ReiseGui(JFrame parent, KundeReg register)
    {
        
        kunderegister = register;
        this.parent = parent;
        
        lytter = new Knappelytter();
        
        //Initialiserer labelene
       
        kundenrlabel = new JLabel("Kundenr:");
        forsikringnrlabel = new JLabel("Forsikringnr:");
        beloplabel = new JLabel("Beløp:");
        betingelselabel = new JLabel("Betingelse:");
        omraadelabel = new JLabel("Dekningsområde");
        
        
        //Initialiserer TextFieldene
        kundenrfelt = new JTextField(20);
        forsikringnrfelt = new JTextField(20); 
        belopfelt = new JTextField(20); 
        betingelsefelt = new JTextField(20);
        omraadefelt = new JTextField(20);
        
        //Initialiserer og gir knappene en addactionlistener
        registrerforsikring = new JButton("Registrer forsikring");
        registrerforsikring.addActionListener(lytter);
        tilbake = new JButton("Tilbake");
        tilbake.addActionListener(lytter);
        sokMedFnr = new JButton("Søk (fnr)");
        sokMedFnr.addActionListener(lytter);
        fjernforsikring = new JButton("Fjern");
        fjernforsikring.addActionListener(lytter);
        visalle = new JButton("Vis alle");
        visalle.addActionListener(lytter);
        
        //Lager utskriftsomrÃ¥de
        utskrift = new JTextArea();
        utskrift.setEditable(false);
        utskrift.setColumns(20);
        utskrift.setRows(2);
        scroll = new JScrollPane();
        scroll.setViewportView(utskrift);
        
        komponenter();
        setVisible(true);
        
    }
    
    private void komponenter()
    {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
                    .addGroup(layout.createSequentialGroup()
                     .addGap(50, 50, 50)
                     .addComponent(registrerforsikring)
                     .addGap(18, 18, 18)
                     .addComponent(sokMedFnr)
                     .addGap(18,18,18)
                     .addComponent(fjernforsikring)
                     .addGap(18,18,18)
                     .addComponent(visalle)
                     .addGap(18,18,18)
                     .addComponent(tilbake))
                    
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    .addGroup(layout.createSequentialGroup()
                     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            
                              .addGroup(layout.createSequentialGroup()
                                    .addComponent(betingelselabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(betingelsefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                             
                             .addGroup(layout.createSequentialGroup()
                                .addComponent(kundenrlabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            
                             .addGroup(layout.createSequentialGroup()
                                .addComponent(forsikringnrlabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            
                            
                            
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                    
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(beloplabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(belopfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))     
                                     
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(omraadelabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(omraadefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(betingelsefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(betingelselabel)
                    .addComponent(omraadefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(omraadelabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tilbake)
                    .addComponent(registrerforsikring)
                    .addComponent(sokMedFnr)
                    .addComponent(fjernforsikring)
                    .addComponent(visalle))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }
    
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    public void registrerNyReiseforsikring()
    {
        try
        {
            int kundenr = Integer.parseInt(kundenrfelt.getText());
            int belop = Integer.parseInt(belopfelt.getText());
            String fOmraade = omraadefelt.getText();
            String betingelser = betingelsefelt.getText();
            
            if(omraadefelt.getText().length()>0 && kundenrfelt.getText().length()>0 && belopfelt.getText().length()>0
                &&betingelser.length()>0)        
            {
                Kunde k = kunderegister.finnKundeMedKundenr(kundenr);
        
                Forsikring f = new ReiseForsikring(k,  fOmraade, belop,  betingelser);
                f.setPremie(belop);
                f.getKunde().leggTilAarligPremie(belop);
        
                kunderegister.leggTilForsikringPaaKunde(kundenr, f);
                utskrift.setText("Forsikringen er satt på knr: " + k.getKundeNr() +
                                 " med forsikringnr " + f.getForsikringnr());
            }
            else
                visMelding("Du må fylle ut alle feltene");
        }
            catch(NumberFormatException nfe)
            {
                visMelding("Feil i tallformat."
                        + "\nPrøv igjen!");
            }
            catch(NullPointerException npe)
            {
                visMelding("Finner ikke kunden i registeret."
                        + "\nPrøv igjen");
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
            visMelding("Feil i tallformat");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke denne forsikringer i registeret."
                    + "\nPrøv igjen");
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
            visMelding("Feil i tallformat");
        }
    }
   
    
    public void visAlleForsikringer()
    {
        utskrift.setText("\t\tRegistrerte forsikringer:\n\n" + kunderegister.visAlleForsikringer());
    }
    
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == sokMedFnr)
            {
                finnForsikringMedFnr();
            }
            else if(e.getSource() == registrerforsikring)
            {
                registrerNyReiseforsikring();
            }
            else if(e.getSource() == fjernforsikring)
            {
                fjernForsikringMedFnr();
            }
            else if(e.getSource() == visalle)
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
