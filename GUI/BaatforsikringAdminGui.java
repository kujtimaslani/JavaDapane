package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ProsjektKlasse.*;

//Denne klassen er et panel, som inneholder komponentene som tekstfelter, knapper og utskriftsområde
//Denne er for å registrere båtforsikringer
public class BaatforsikringAdminGui extends JPanel {

    private JLabel kundenrlabel, forsikringnrlabel, fornavnlabel, etternavnlabel, regnrlabel, merkelabel,
            modelllabel, aarsmodelllabel, lengdelabel, motortypelabel, motorstyrkelabel,
            beloplabel, betingelselabel;

    private JTextField kundenrfelt, forsikringnrfelt, fornavnfelt, etternavnfelt, regnrfelt, merkefelt,
            modellfelt, aarsmodellfelt, lengdefelt, motortypefelt, motorstyrkefelt, belopfelt, betingelsefelt;

    private JButton registrerforsikring, tilbake, fjernforsikring, sokMedFnr, visalle;
    private JTextArea utskrift;
    private JScrollPane scroll;

    Knappelytter lytter;
    KundeReg kunderegister;

    JFrame parent;
    
    public BaatforsikringAdminGui(JFrame parent, KundeReg register) {

        kunderegister = register;
        this.parent = parent;
        lytter = new Knappelytter();

        //Initialiserer labelene
        kundenrlabel = new JLabel("Kundenr:");
        forsikringnrlabel = new JLabel("Forsikringsnr");
        fornavnlabel = new JLabel("Fornavn:");
        etternavnlabel = new JLabel("Etternavn:");
        regnrlabel = new JLabel("Reg.nr");
        merkelabel = new JLabel("Merke");
        modelllabel = new JLabel("Modell");
        aarsmodelllabel = new JLabel("Årsmodell");
        lengdelabel = new JLabel("Lengde");
        motortypelabel = new JLabel("Motortype");
        motorstyrkelabel = new JLabel("Motorstyrke:");
        beloplabel = new JLabel("Beløp:");
        betingelselabel = new JLabel("Betingelser:");

        //Feltene
        kundenrfelt = new JTextField(15);
        forsikringnrfelt = new JTextField(15);
        belopfelt = new JTextField(15);
        betingelsefelt = new JTextField(15);
        fornavnfelt = new JTextField(15);
        etternavnfelt = new JTextField(15);
        regnrfelt = new JTextField(15);
        merkefelt = new JTextField(15);
        modellfelt = new JTextField(15);
        aarsmodellfelt = new JTextField(15);
        lengdefelt = new JTextField(15);
        motortypefelt = new JTextField(15);
        motorstyrkefelt = new JTextField(15);

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

        scroll = new JScrollPane();
        utskrift = new JTextArea();
        utskrift.setEditable(false);
        scroll.setMinimumSize(new Dimension(40, 40));
        scroll.setPreferredSize(new Dimension(150, 150));
        scroll.setViewportView(utskrift);

        komponenter();
    }
    
    //Inneholder alle komponentene og plasseringene deres i vinduet
    public void komponenter() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        
                        .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(registrerforsikring)
                        .addGap(18, 18, 18)
                        .addComponent(sokMedFnr)
                        .addGap(18, 18, 18)
                        .addComponent(fjernforsikring)
                        .addGap(18, 18, 18)
                        .addComponent(visalle)
                        .addGap(18, 18, 18)
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
                        .addComponent(merkelabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(merkefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                        .addComponent(motortypelabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(motortypefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                                
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
                        .addComponent(modelllabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modellfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(aarsmodelllabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aarsmodellfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(beloplabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(belopfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lengdelabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lengdefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(motorstyrkelabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(motorstyrkefelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(fornavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fornavnlabel)
                        .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(etternavnlabel))
                               
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(merkefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(merkelabel)
                        .addComponent(modellfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(modelllabel))
                               
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(regnrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(regnrlabel)
                        .addComponent(aarsmodellfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(aarsmodelllabel))
                               
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(betingelsefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(betingelselabel)
                        .addComponent(lengdefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lengdelabel))
                               
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(motortypefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(motortypelabel)
                        .addComponent(motorstyrkefelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(motorstyrkelabel))
                               
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
    
    public void registrerNyBaatforsikring() {
        
        try
        {
            int kundenr = Integer.parseInt(kundenrfelt.getText());
            String fornavn = fornavnfelt.getText();
            String etternavn = etternavnfelt.getText();
            String regnr = regnrfelt.getText();
            String merke = merkefelt.getText();
            String modell = modellfelt.getText();
            int regaar = Integer.parseInt(aarsmodellfelt.getText());
            int kjorelengde = Integer.parseInt(lengdefelt.getText());
            String motortype = motortypefelt.getText();
            int motorstyrke = Integer.parseInt(motorstyrkefelt.getText());
            int belop = Integer.parseInt(belopfelt.getText());
            String betingelser = betingelsefelt.getText();
        
       if(kundenrfelt.getText().length()>0 && belopfelt.getText().length()>0 && aarsmodellfelt.getText().length()>0
                &&betingelser.length()>0 && fornavn.length()>0 && etternavn.length()>0 && regnr.length()>0
                &&merke.length()>0 && modell.length()>0 && lengdefelt.getText().length()>0
                &&motorstyrkefelt.getText().length()>0 && motortypefelt.getText().length()>0)
        {
            Kunde k = kunderegister.finnKundeMedKundenr(kundenr);

            Forsikring f = new Baatforsikring(k, fornavn, etternavn, regnr,
                    merke, modell, regaar, kjorelengde, motortype, motorstyrke,
                    belop, betingelser);

            f.setPremie(belop);
            f.getKunde().leggTilAarligPremie(belop);
        
            kunderegister.leggTilForsikringPaaKunde(kundenr, f);
            utskrift.setText("Forsikringen er satt på knr: " + k.getKundeNr()
                    + " med forsikringnr " + f.getForsikringnr());
        }
        else
           visMelding("Du må fylle ut alle feltene"
                   + "\nPrøv igen");
        }
        catch(NumberFormatException nfee)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke kunden"
                    + "\nPrøv igjen");
        }
    }
    
    //funker
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
            visMelding("Feil i tallformat"
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke kunden.");
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
                    + "\nPrøv igjen");
        }
        catch(NullPointerException npe)
        {
            visMelding("Denne kunden eksisterer ikke"
                    + "\nPrøv igjen");
        }
        
    }
    
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

    private class Knappelytter implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sokMedFnr) {
                finnForsikringMedFnr();
            }
            else if (e.getSource() == registrerforsikring) {
                registrerNyBaatforsikring();
            }
            else if (e.getSource() == fjernforsikring) {
                fjernForsikringMedFnr();
            }
            else if (e.getSource() == visalle) {
                visAlleForsikringer();
            }
            else if (e.getSource() == tilbake) {
                parent.dispose();
                StartGui gui = new StartGui(kunderegister);
            }
        }
    }
}
