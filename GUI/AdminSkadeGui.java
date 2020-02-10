package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ProsjektKlasse.*;

//Denne klassen inneholder guien, for å kunne administrere på registrerte skademelding
//Ulike søkefunksjoner for å hente ut lagret data om skademeldinger
public class AdminSkadeGui extends JPanel{
    private JLabel dapanelabel, kundenrlabel, forsikringnrlabel, typeskadelabel, skadenrlabel, radioboxlabel;
    
    private JTextField kundenrfelt, forsikringnrfelt,  skadenrfelt;
    
    private JButton sok, visalle, tilbake, sokMedSkadetype;
    private JRadioButton bil, baat, fritidsbolig, reise, husinnbo;
    
    private JTextArea utskrift;
    private JScrollPane scroll;
    String skadetype;
    
    ALytter alytter;
    
    KundeReg kunderegister;
    String tekst;
    JFrame parent;
    
    public AdminSkadeGui(JFrame parent, KundeReg register){
        
        kunderegister = register;
        this.parent = parent;
        
        skadetype ="";
        
        alytter = new ALytter();
        
        tekst = "";
        
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
        husinnbo.setText("Hus&Innbo");
        husinnbo.setHorizontalTextPosition(SwingConstants.LEFT);
        
        
        //init label
        dapanelabel = new JLabel("Dapane");
        kundenrlabel = new JLabel("Kundenr:"); 
        forsikringnrlabel = new JLabel("Forsikringnr:");
        typeskadelabel = new JLabel("Skadetype:");
        skadenrlabel = new JLabel("Skade.nr");
        radioboxlabel = new JLabel("Finn skademeldinger, på: ");
        
        //init felt
        kundenrfelt = new JTextField(15); 
        forsikringnrfelt = new JTextField(15);
        
        skadenrfelt = new JTextField(15);
        
        //init knapper og combo + lytter
        sok = new JButton("Søk");
        tilbake = new JButton("Tilbake");
        sok.addActionListener(alytter);
        tilbake.addActionListener(alytter);
        visalle = new JButton("Vis Alle");
        visalle.addActionListener(alytter);
        sokMedSkadetype= new JButton("Søk skademld på skadetype");
        sokMedSkadetype.addActionListener(alytter);
        
       
        
        //Lager utskriftsomrÃ¥de
        utskrift = new JTextArea();
        utskrift.setEditable(false);
        utskrift.setColumns(20);
        utskrift.setRows(2);
        scroll = new JScrollPane();
        scroll.setViewportView(utskrift);
        
        komponenter();
        
    }
    
    //Innholder alle komponentene, og plasseringene deres for guien
    public void komponenter()
    {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(sok)
                    .addGap(18, 18, 18)
                    .addComponent(sokMedSkadetype)
                    .addGap(18, 18, 18)
                    .addComponent(visalle)
                    .addGap(18, 18, 18)
                    .addComponent(tilbake))
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)     
                       
                    .addGroup(layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(dapanelabel))
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                             
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(skadenrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(skadenrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                             
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(kundenrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                     
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(radioboxlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                            
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(forsikringnrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                    .addGap(50, 50, 50))))
                            
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(bil, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                    .addComponent(baat, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fritidsbolig, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(reise, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(husinnbo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        
                    .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
                );
                    layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(dapanelabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(skadenrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(skadenrlabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(kundenrlabel)
                    .addComponent(forsikringnrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(forsikringnrlabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(radioboxlabel)
                    .addGap(30, 30, 30)
                    .addComponent(bil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(baat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fritidsbolig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(reise, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(husinnbo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tilbake)
                    .addComponent(sokMedSkadetype)
                    .addComponent(visalle)
                    .addComponent(sok))
                        
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
                );
        
    }
    
    //Hjelpe metode, for å skrive ut en feilmelding til brukeren
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    //Finner en skademelding med et gitt kundenummer
    public void finnSkadeMedSkadenr()
    {
        try
        {
            int skadenr = Integer.parseInt(skadenrfelt.getText());
        
            Skademelding sk = kunderegister.finnSkadeMedSkadenr(skadenr);
            utskrift.setText(sk.toString());
        }
        catch(NumberFormatException nfee)
        {
            visMelding("Feil i tallformat!"
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke skade med dette skadenummer i registeret"
                    + "\nPrøv igjen");
        }
    }
    
    //Skriver ut alle skadmeldinger, registrert på en gitt type forsikring
    public void finnSkadeEtterSkadetype()
    {
        if(bil.isSelected())
        {
            skadetype = "Bilforsikring";
        }
        else if(baat.isSelected())
        {
            skadetype = "Båtforsikring";
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
        {
            skadetype = "";
        }
        
        utskrift.setText(kunderegister.finnSkadeEtterSkadetype(skadetype));
    }
    
    //Denne metoden viser alle registrerte skademeldinger
    public void visAlleSkademeldinger()
    {
        utskrift.setText(kunderegister.visAlleSkader());
    }
    
    
    
    private class ALytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() == sok)
            {
                finnSkadeMedSkadenr();
            }
            else if(e.getSource() == sokMedSkadetype)
            {
                finnSkadeEtterSkadetype();
            }
            else if(e.getSource() == visalle)
            {
                visAlleSkademeldinger();
            }
            else if(e.getSource() == tilbake)
            {
                parent.dispose();
                StartGui gui = new StartGui(kunderegister);
            }
            
        }
    }
    
    
}

