package GUI;

import ProsjektKlasse.*;
import ProsjektKlasse.Kunde;
import ProsjektKlasse.KundeReg;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

//Denne klassen er et panel, som inneholder komponentene som tekstfelter, knapper og utskriftsområde
//Denne er for å finne ulike type informasjon om en kunde.

public class Historikk extends JPanel
{
    
    private JLabel  kundenrlabel, fornavnlabel, etternavnlabel;
    private JTextField kundenrfelt, fornavnfelt, etternavnfelt;
    private JButton btnSok,  btnTilbake, btnVisAlle,visKundensForsikringer;
    private JTextArea utskrift;
    private JScrollPane scroll;
    
    
    KundeReg kunderegister;
    
    List<Kunde> kundeliste;
    
    Knappelytter lytter;
    JFrame parent;
    public Historikk(JFrame parent, KundeReg register)
    {
        
        kunderegister = register;
        this.parent = parent;
        
        lytter = new Knappelytter();
        
        kundenrlabel = new JLabel("Kundenr:");
        fornavnlabel = new JLabel("Fornavn:");
        etternavnlabel = new JLabel("Etternavn:");
        
        kundenrfelt = new JTextField(10);
        fornavnfelt = new JTextField(10);
        etternavnfelt = new JTextField(10);
        
        btnSok = new JButton("Søk");
        btnSok.addActionListener(lytter);
        btnTilbake = new JButton("Tilbake");
        btnTilbake.addActionListener(lytter);
        btnVisAlle = new JButton("Aktive kunder");
        btnVisAlle.addActionListener(lytter);
        visKundensForsikringer = new JButton("Kundens forsikringer");
        visKundensForsikringer.addActionListener(lytter);
        
       
        utskrift = new JTextArea();
        utskrift.setColumns(2);
        utskrift.setRows(20);
        utskrift.setEditable(false);
        scroll = new JScrollPane();
        scroll.setViewportView(utskrift);
                
        scroll.setMinimumSize(new Dimension(40, 40));       
        scroll.setPreferredSize(new Dimension(150, 150));

        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
                    .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(btnSok)
                    .addGap(18, 18, 18)
                    .addComponent(btnVisAlle)
                    .addGap(18, 18, 18)
                    .addComponent(visKundensForsikringer)
                    .addGap(18, 18, 18)
                    .addComponent(btnTilbake))
                    
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
                    .addComponent(kundenrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            
                            
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                        
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(etternavnlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                    .addGap(100, 100, 100))))
                        
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                    .addGap(50,50,50))) 
        );
                 layout.setVerticalGroup(
                     layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(kundenrlabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fornavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fornavnlabel)
                    .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(etternavnlabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                    
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTilbake)
                    .addComponent(btnVisAlle)
                    .addComponent(visKundensForsikringer)
                    .addComponent(btnSok))
                            
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        
        
    }
    
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    //Søkefunksjon, med enten kundenummer,fornavn eller etternavn
    public void sokefunksjon()
    {
        try
        {
            Iterator<Kunde> iter = kunderegister.deaktivertIterator();
            Kunde kunde;
            if(kundenrfelt.getText().length() > 0)
            {
                int knr = Integer.parseInt(kundenrfelt.getText());
                while(iter.hasNext())
                {
                    kunde = iter.next();
                    if(kunde.getKundeNr() == knr)
                    {
                        utskrift.setText(kunde.toString());
                    }
                }
            }
            else if(fornavnfelt.getText().length()>0)
            {
                String fornavn = fornavnfelt.getText();
                while(iter.hasNext())
                {
                    kunde = iter.next();
                    if(fornavn.equals(kunde.getFornavn()))
                        utskrift.setText(kunde.toString());
                }
            }
            else if(etternavnfelt.getText().length() >0)
            {
                String etternavn = etternavnfelt.getText();
                while(iter.hasNext())
                {
                    kunde = iter.next();
                    if(etternavn.equals(kunde.getEtternavn()))
                        utskrift.setText(kunde.toString());
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Du må skrive inn kundenr for å søke på en kunde");
            }
        }
        catch(NumberFormatException nfe)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke kunden i registeret."
                    + "\nPrøv igjen");
        }
    }
    
    public void finnKundensForsikringer()
    {
     try
     {
        if(kundenrfelt.getText().length() > 0)
        {
            int knr = Integer.parseInt(kundenrfelt.getText());
            utskrift.setText(kunderegister.tidligereKundeSineForsikringer(knr) + "\n");
        }
        else
            visMelding("Du må fylle inn kundenr feltet");
     }
     catch(NumberFormatException nfe)
     {
         visMelding("Feil i tallformat."
                 + "\nPrøv igjen");
     }
    }
    
    public void visAlleDeaktiverteKunder()
    {
        utskrift.setText(kunderegister.visAlleDeaktiverteKunder());
    }
    
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == btnSok)
            {
                sokefunksjon();
            }
            else if(e.getSource() == visKundensForsikringer)
            {
                finnKundensForsikringer();
            }
            else if(e.getSource() == btnTilbake)
            {
                parent.dispose();
                StartGui gui = new StartGui(kunderegister);
            }
            else if(e.getSource() == btnVisAlle)
            {
                visAlleDeaktiverteKunder();
            }
        }
    }
}
