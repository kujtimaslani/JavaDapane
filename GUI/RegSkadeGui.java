package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ProsjektKlasse.*;

public class RegSkadeGui extends JPanel{
    private JLabel forsikringnrlabel, typeskadelabel, skadebeskrlabel, skadetakstlabel, utbetaltlabel;
    private JLabel skadeskjemalabel, skadebildelabel, vitnenavnlabel, vitnetlflabel, radioboxlabel;
    
    private JTextField forsikringnrfelt, skadebeskrfelt, skadetakstfelt, utbetaltfelt;
    private JTextField vitnenavnfelt, vitnetlffelt;
    
    private JButton regSkade, tilbake;
    
    private JTextArea utskrift;
    
    
    
    private JRadioButton bil, baat, fritidsbolig, reise, husinnbo;
    private ButtonGroup forsikringstyper;
    
    private JPanel bilskadepanel;
    
    private JScrollPane scroll;
    
    
    
    String skadetype;
    ALytter alytter;
    JFrame parent;
    
    KundeReg kunderegister;
    public RegSkadeGui(JFrame parent, KundeReg register){
        
        kunderegister = register;
        this.parent = parent;
        
        skadetype = "";
        
        alytter = new ALytter();
        
        bilskadepanel = new JPanel();
        
        //init label
        
        bil = new JRadioButton();
        baat = new JRadioButton();
        fritidsbolig = new JRadioButton();
        reise = new JRadioButton();
        husinnbo = new JRadioButton();
        
        bil.setText("Bil");
        bil.setHorizontalTextPosition(SwingConstants.LEFT);
        baat.setText("Båt");
        baat.setHorizontalTextPosition(SwingConstants.LEFT);
        fritidsbolig.setText("Fritidsbolig");
        fritidsbolig.setHorizontalTextPosition(SwingConstants.LEFT);
        reise.setText("Reise");
        reise.setHorizontalTextPosition(SwingConstants.LEFT);
        husinnbo.setText("Hus&innbo");
        husinnbo.setHorizontalTextPosition(SwingConstants.LEFT);
        
        
        forsikringstyper = new ButtonGroup();
        forsikringstyper.add(bil);
        forsikringstyper.add(baat);
        forsikringstyper.add(fritidsbolig);
        forsikringstyper.add(reise);
        forsikringstyper.add(husinnbo);
        
       
        forsikringnrlabel = new JLabel("Forsikringnr:");
        
        typeskadelabel = new JLabel("Skadetype:");
        skadebeskrlabel = new JLabel("Skadebeskrivelse");
        skadetakstlabel = new JLabel("Skadetakst");
        utbetaltlabel = new JLabel("Utbetalt erstatning");
        radioboxlabel = new JLabel("Velg forsikring, skaden skal registreres på:");
        
        //Bilskade
        skadeskjemalabel = new JLabel("Skademeld.skjema"); 
        skadebildelabel = new JLabel("Bilder av skade"); 
        vitnenavnlabel = new JLabel("Navn (vitne):");
        vitnetlflabel = new JLabel("Tlf (vitne):");
        
        bilskadepanel.add(vitnenavnlabel);
        bilskadepanel.add(vitnetlflabel);
        
        //init felt
         
        forsikringnrfelt = new JTextField(15);
        skadebeskrfelt = new JTextField(30);
        skadetakstfelt = new JTextField(15);
        utbetaltfelt = new JTextField(15);
        
        //bilskade
        vitnenavnfelt = new JTextField(15);
        vitnetlffelt = new JTextField(15);
        
        //init knapper og combo + lytter
        regSkade = new JButton("Registrer Skade");
        tilbake = new JButton("Tilbake");
        regSkade.addActionListener(alytter);
        tilbake.addActionListener(alytter);
        
        //Lager utskriftsomraade
        utskrift = new JTextArea();
        utskrift.setEditable(false);
        utskrift.setColumns(20);
        utskrift.setRows(2);
        scroll = new JScrollPane();
        scroll.setViewportView(utskrift);
        
        komponenter();
        
    }
    
    //Inneholder komponenter, og deres plasseringer
    public void komponenter()
    {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
                    .addGroup(layout.createSequentialGroup()
                     .addGap(170, 170, 170)
                     .addComponent(regSkade)
                     .addGap(18, 18, 18)
                     .addComponent(tilbake))
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                             
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(forsikringnrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(radioboxlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                             
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(skadebeskrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(skadebeskrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(utbetaltlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(utbetaltfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            
                            
                            
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                   
                                    
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(bil, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                    .addComponent(baat, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fritidsbolig, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(reise, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(husinnbo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))      
                                   
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(skadetakstlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(skadetakstfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(radioboxlabel)
                    .addGap(30, 30, 30)
                    .addComponent(bil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(baat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fritidsbolig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(reise, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(husinnbo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(forsikringnrlabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
               .addComponent(skadebeskrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               .addComponent(skadebeskrlabel))
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
               .addComponent(utbetaltfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               .addComponent(utbetaltlabel)
               .addComponent(skadetakstfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               .addComponent(skadetakstlabel))
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)     
                
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tilbake)
                .addComponent(regSkade))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }
    
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    //Funker
    public void registrerSkade()
    {
        try
        {
        
            if(bil.isSelected())
            {
                skadetype = "Bilforsikring";
            }
            else if(baat.isSelected())
            {
                skadetype = "Baatforsikring";
            }
            else if(fritidsbolig.isSelected())
            {
                 skadetype = "Fritidsboligforsikring";
            }
            else if(reise.isSelected())
            {
                 skadetype = "Reiseforsikring";
            }
            else if(husinnbo.isSelected())
            {
                 skadetype = "Husinnboforsikring";
            }
            else
                visMelding("Du må velge en type forsikring, du skal regitrere skade for");
        
        int fnr = Integer.parseInt(forsikringnrfelt.getText());
        String skadebeskrivelse = skadebeskrfelt.getText();
        int takst = Integer.parseInt(skadetakstfelt.getText());
        int erstatning = Integer.parseInt(utbetaltfelt.getText());
        
        if(forsikringnrfelt.getText().length()>0 && skadebeskrivelse.length()>0
                &&skadetakstfelt.getText().length()>0 && utbetaltfelt.getText().length()>0)
        {
            Forsikring forsikring = kunderegister.finnForsikringMedFnr(fnr);
        
            if(forsikring.getForsikringstype().equals(skadetype)) 
            {
                Skademelding skademelding = new Skademelding(forsikring, skadetype, skadebeskrivelse,takst, erstatning);
            
                kunderegister.registrerNySkademelding(fnr, skademelding);
            
                utskrift.setText("Skademeldingen er nå registrert på " + forsikring.getKunde().getFornavn() 
                                 + "\nPå forsikring nummer: "  + forsikring.getForsikringnr());
            
                skademelding.getForsikring().getKunde().leggTilUtbetalteErstatninger(erstatning);
            }
            else
                visMelding("Du har ikke forsikring, for denne skaden");
        }
        else
            visMelding("Du må fylle ut alle feltene."
                    + "\nPrøv igjen");
        }
        catch(NumberFormatException nfe)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke forsikring i registerer"
                    + "\nPrøv igjen!");
        }
    }
    
    private class ALytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == regSkade)
            {
                registrerSkade();
            }
            else if(e.getSource() == tilbake)
            {
                parent.dispose();
                StartGui gui = new StartGui(kunderegister);
            }
        }
    }
}

