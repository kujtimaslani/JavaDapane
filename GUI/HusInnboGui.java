package GUI;

import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import ProsjektKlasse.*;

public class HusInnboGui extends JPanel {
    
    private JLabel kundenrlabel,forsikringnrlabel, boligadresselabel, postnrlabel, poststedlabel, byggeaarlabel,
                    boligtypelabel, byggematerialelabel, kvmlabel, belopbygninglabel, belopinnbolabel, 
                    betingelselabel, beloplabel;
    
    private JTextField kundenrfelt, forsikringnrfelt, boligadressefelt, postnrfelt, poststedfelt,
                    byggeaarfelt, boligtypefelt, byggematerialefelt, kvmfelt, belopbygningfelt, belopinnbofelt,
                    belopfelt, betingelsefelt;
    
    private JButton registrerforsikring, tilbake, sokMedFnr, fjernforsikring, visalle;
    private JTextArea utskrift;
    private JScrollPane scroll;
     
    Knappelytter lytter;
     
    KundeReg kunderegister;
    JFrame parent;
    
    public HusInnboGui(JFrame parent, KundeReg register){
        
        lytter = new Knappelytter();
        kunderegister = register;
        this.parent = parent;
        
        //Initialiserer labelene
       
        kundenrlabel = new JLabel("Kundenr:");
        beloplabel = new JLabel("Beløp");
        betingelselabel = new JLabel("Betingelser");
        belopinnbolabel = new JLabel("Beløp innbo:");
        boligadresselabel = new JLabel("Adresse:");
        postnrlabel = new JLabel("Postnr:");
        poststedlabel = new JLabel("Poststed:");
        byggeaarlabel = new JLabel("Byggeår:");
        boligtypelabel = new JLabel("Boligtype:");
        byggematerialelabel = new JLabel("Byggemateriale:");
        kvmlabel = new JLabel("Kvadratmeter: ");
        belopbygninglabel = new JLabel("Beløp bygning");
        forsikringnrlabel = new JLabel("Forsikringnr");
 
        //Initialiserer TextFieldene
        kundenrfelt = new JTextField(10);
        belopfelt = new JTextField(10);
        betingelsefelt = new JTextField(10);
        belopinnbofelt = new JTextField(10);
        boligadressefelt = new JTextField(10);
        postnrfelt = new JTextField(10);
        poststedfelt = new JTextField(10);
        byggeaarfelt = new JTextField(10);
        boligtypefelt = new JTextField(10);
        byggematerialefelt = new JTextField(10);
        kvmfelt = new JTextField(10);
        belopbygningfelt = new JTextField(10);
        forsikringnrfelt = new JTextField(10);
        
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
        
        //Lager utskriftsomrÃƒÂ¥de
        utskrift = new JTextArea(15,35);
        utskrift.setEditable(false);
        scroll = new JScrollPane(utskrift);
        
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
                                    .addComponent(poststedlabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(poststedfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                              .addGroup(layout.createSequentialGroup()
                                    .addComponent(boligtypelabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(boligtypefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                               
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
                                .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                             
                             .addGroup(layout.createSequentialGroup()
                                .addComponent(boligadresselabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boligadressefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kvmlabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kvmfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            
                            
                            
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                    
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(belopinnbolabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(belopinnbofelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                    
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(postnrlabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(postnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                   
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(byggeaarlabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(byggeaarfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                   
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(beloplabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(belopfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))     
                                    
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(byggematerialelabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(byggematerialefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                    
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(belopbygninglabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(belopbygningfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(50, 50, 50))))
                        
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        
                                        .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                
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
                    .addComponent(belopinnbofelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(belopinnbolabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
               
                
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(boligadressefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(boligadresselabel)
                    .addComponent(postnrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(postnrlabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)     
                
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(poststedfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(poststedlabel)
                    .addComponent(byggeaarfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(byggeaarlabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(boligtypefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(boligtypelabel)
                    .addComponent(byggematerialefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(byggematerialelabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(kvmfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(kvmlabel)
                    .addComponent(belopbygningfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(belopbygninglabel))
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
        JOptionPane.showMessageDialog(parent, melding);
    }
    
    public void registrerNyHusinnboforsikring()
    {
        try
        {
        int kundenr = Integer.parseInt(kundenrfelt.getText());
        int belop = Integer.parseInt(belopfelt.getText());
        int belopinnbo = Integer.parseInt(belopinnbofelt.getText());
        String betingelse = betingelsefelt.getText();
        String adresse = boligadressefelt.getText();
        int postnr = Integer.parseInt(postnrfelt.getText());
        String poststed = poststedfelt.getText();
        int byggeaar = Integer.parseInt(byggeaarfelt.getText());
        String boligtype = boligtypefelt.getText();
        String byggemateriale = byggematerialefelt.getText();
        int kvm = Integer.parseInt(kvmfelt.getText());
        int belopBygning = Integer.parseInt(belopbygningfelt.getText());
       
        if(postnrfelt.getText().length()>0 && kundenrfelt.getText().length()>0 && belopfelt.getText().length()>0
                &&betingelse.length()>0 && adresse.length()>0 && poststed.length()>0 && boligtype.length()>0
                &&byggeaarfelt.getText().length()>0 && byggemateriale.length()>0 && kvmfelt.getText().length()>0
                &&belopbygningfelt.getText().length()>0 && belopinnbofelt.getText().length()>0)
        {
        Kunde k = kunderegister.finnKundeMedKundenr(kundenr);
        
        Forsikring f = new HusInnboForsikring( k,  adresse,  postnr, poststed, 
                         byggeaar, boligtype, byggemateriale , kvm, belopBygning, belopinnbo,
                         belop, betingelse);
        
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
            visMelding("Feil i tallformat"
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke kunde."
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
            visMelding("Feil i tallformat-"
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke kunde."
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
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen!");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke forsikringen i registerer");
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
                registrerNyHusinnboforsikring();
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
