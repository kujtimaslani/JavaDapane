package GUI;

import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import ProsjektKlasse.*;

public class KunderegGui extends JFrame
{
    private JLabel  fornavnlabel, etternavnlabel, adresselabel, postnrlabel,
            poststedlabel;
    
    private JTextField fornavnfelt, etternavnfelt, adressefelt, postnrfelt,
            poststedfelt;
    
    private JButton registrerkunde, tilbake;
    private JTextArea utskrift;
    private JScrollPane scroll;
    KundeReg kunderegister;
    
    Knappelytter lytter;
     
    public KunderegGui(KundeReg register)
    {
        super("Registrer kunde");
        
        kunderegister = register;
        
        lytter = new Knappelytter();
        
        //Initialiserer labelene
       
        fornavnlabel = new JLabel("Fornavn:");
        etternavnlabel = new JLabel("Etternavn:");
        adresselabel = new JLabel("Adresse");
        postnrlabel = new JLabel("Postnr");
        poststedlabel = new JLabel("Poststed");
        
 
        //Initialiserer TextFieldene
        
        fornavnfelt = new JTextField(20); 
        etternavnfelt = new JTextField(20);
        adressefelt = new JTextField(20);
        postnrfelt = new JTextField(20);
        poststedfelt = new JTextField(20);
        
        
        //Initialiserer og gir knappene en addactionlistener
        registrerkunde = new JButton("Registrer kunde");
        registrerkunde.addActionListener(lytter);
        tilbake = new JButton("Tilbake");
        tilbake.addActionListener(lytter);
        
        //Lager utskriftsområde
        utskrift = new JTextArea();
        utskrift.setEditable(false);
        utskrift.setColumns(20);
        utskrift.setRows(2);
        scroll = new JScrollPane();
        scroll.setViewportView(utskrift);
        
        setIcon();
        komponenter();
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    //Setter ikon på vinduet
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dapaneicon.png")));
    }
    
    private void komponenter()
    {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
                    .addGroup(layout.createSequentialGroup()
                     .addGap(170, 170, 170)
                     .addComponent(registrerkunde)
                     .addGap(18, 18, 18)
                     .addComponent(tilbake))
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    
                    .addGroup(layout.createSequentialGroup()
                     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                             
                             
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fornavnlabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fornavnfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            
                             .addGroup(layout.createSequentialGroup()
                                .addComponent(adresselabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adressefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(poststedlabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(poststedfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            
                            
                            
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                    
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(postnrlabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(postnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                        
                                   .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(etternavnlabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(50, 50, 50))))
                        
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                
                
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fornavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fornavnlabel)
                    .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(etternavnlabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(adressefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(adresselabel)
                    .addComponent(postnrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(postnrlabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(poststedfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(poststedlabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tilbake)
                    .addComponent(registrerkunde))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }
    
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    public void registrerKunde()
    {
        try
        {
            String fornavn = fornavnfelt.getText();
            String etternavn = etternavnfelt.getText();
            String adresse = adressefelt.getText();
            int postnr = Integer.parseInt(postnrfelt.getText());
            String poststed = poststedfelt.getText();
        
                if(!fornavn.equals("") && !etternavn.equals("") && !adressefelt.equals("")
                    && postnr != 0 && !poststed.equals(""))
                {
           
                        if(postnrfelt.getText().length() == 4)
                        {
                            Kunde nykunde = new Kunde(fornavn, etternavn, adresse, postnr, poststed);
                            kunderegister.addKunde(nykunde);
                            utskrift.setText("Kunder er nå registrert med kundenummer: " + nykunde.getKundeNr() );
                        }
                        else
                        {
                            visMelding("Postnr må inneholde 4 siffer");
                        }
                }
                else
                    visMelding("Du må fylle ut alle feltene");
            }
        catch(NumberFormatException nfee)
        {
            visMelding("Feil i tallformat");
        }
    }
     
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == registrerkunde)
            {
                registrerKunde();
            }
            else if(e.getSource() == tilbake)
            {
                dispose();
                StartGui gui = new StartGui(kunderegister);
            }
        }
    }
}