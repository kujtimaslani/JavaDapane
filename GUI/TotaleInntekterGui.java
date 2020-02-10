package GUI;

import java.awt.event.*;
import javax.swing.*;
import ProsjektKlasse.*;
import java.awt.Toolkit;

//Panel for Inntekter og Utgifter, plasseringer for komponenter

public class TotaleInntekterGui extends JPanel{
    private JLabel kundenrlabel, forsikringnrlabel, typeforsikringlabel;
    
    private JTextField forsikringnrfelt, kundenrfelt;
    
    private JButton visAlleutbelalteErs, vispremieinntekter, erstatningtilkunde, totalepremieinntekterpaakunde,tilbake;
    private JTextArea utskrift;
    
    private JScrollPane scroll;
    
    String skadetype;
    ALytter alytter;
    JFrame parent;
    KundeReg kunderegister;
    
    public TotaleInntekterGui(JFrame parent,KundeReg register){
        
        kunderegister = register;
        this.parent = parent;
        skadetype = "";
        
        alytter = new ALytter();
        
        kundenrlabel = new JLabel("Kundenr: ");
        kundenrlabel.setToolTipText("Kunde nummer for en kunde");
        typeforsikringlabel = new JLabel("Velg type forsikring: ");
        
        kundenrfelt = new JTextField(15);
        
        //init knapper og combo + lytter
        visAlleutbelalteErs = new JButton("Totale erstatningsutgifter");
        vispremieinntekter = new JButton("Totale premieinntekter");
        erstatningtilkunde = new JButton("Erstatning til kunde");
        totalepremieinntekterpaakunde = new JButton("Total premie fra kunde");
        tilbake = new JButton("Tilbake");
        
        visAlleutbelalteErs.addActionListener(alytter);
        vispremieinntekter.addActionListener(alytter);
        erstatningtilkunde.addActionListener(alytter);
        totalepremieinntekterpaakunde.addActionListener(alytter);
        tilbake.addActionListener(alytter);
        
        //Lager utskriftsomraade
        utskrift = new JTextArea();
        utskrift.setEditable(false);
        utskrift.setColumns(20);
        utskrift.setRows(2);
        scroll = new JScrollPane();
        scroll.setViewportView(utskrift);
        
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        //Setter horisontale plasseringer
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
                    .addGroup(layout.createSequentialGroup()
                     .addGap(20, 20, 20)
                     .addComponent(erstatningtilkunde)
                     .addGap(20, 20, 20)
                     .addComponent(totalepremieinntekterpaakunde)
                     .addGap(20, 20, 20)
                     .addComponent(visAlleutbelalteErs))
                    
                    .addGroup(layout.createSequentialGroup()
                     .addGap(30, 30, 30)
                     .addComponent(tilbake)
                     .addGap(30, 30, 30)
                     .addComponent(vispremieinntekter))
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                             
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(kundenrlabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
                    .addGap(50, 50, 50))))
                        
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))))
                );
                    //Setter vertikale plasseringer
                     layout.setVerticalGroup(
                     layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           
                     .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                     .addGap(30, 30, 30)
                     .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(kundenrlabel)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50))
                    
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)     
                
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(erstatningtilkunde)
                    .addComponent(totalepremieinntekterpaakunde)
                    .addComponent(visAlleutbelalteErs))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                    
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tilbake)
                    .addComponent(vispremieinntekter))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                    
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
                );
    }
    
    
    
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    public void erstatningerTilKunde()
    {
        try
        {
            int knr = Integer.parseInt(kundenrfelt.getText());
            int utbetalt = kunderegister.totalUtbetaltErstatningTilKunde(knr);
        
            utskrift.setText("Dapane har betalt " + utbetalt + "kr i erstatning til denne kunden");
        }
        catch(NumberFormatException nfe)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen!");
        }
        catch(NullPointerException npe)
        {
            visMelding("Finner ikke kunde i registeret."
                    + "\nPrøv igjen!");
        }
    }
    
    public void premieFraKunde()
    {
        try
        {
            int knr = Integer.parseInt(kundenrfelt.getText());
            int totaltpremie = kunderegister.finnKundeMedKundenr(knr).getAarligPremie();
            utskrift.setText("Dapane har mottat " + totaltpremie + "kr i premie totalt fra denne kunden");
        }
        catch(NumberFormatException nfe)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen!");
        }
        catch(NullPointerException npe)
        {
            visMelding("Denne kunden er ikke registrert");
        }
    }
    
    public void totalUtbetaltErstatning()
    {
        int totalterstatning = kunderegister.totalUtbetaltErstatning();
        utskrift.setText("Dapane har totalt betalt " + totalterstatning + "kr i erstatninger" );
    }
    
    public void totalPremieInntekt()
    {
        int totalpremie= kunderegister.totalPremieInntekt();
        utskrift.setText("Dapane har totalt mottat " + totalpremie+ "kr i premie fra kunder" );
    }
  
    private class ALytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == erstatningtilkunde)
            {
                erstatningerTilKunde();
            }
            else if(e.getSource() == totalepremieinntekterpaakunde)
            {
                premieFraKunde();
            }
            else if(e.getSource() == vispremieinntekter)
            {
                totalPremieInntekt();
            }
            else if(e.getSource() == visAlleutbelalteErs)
            {
                totalUtbetaltErstatning();
            }
            else if(e.getSource() == tilbake)
            {
                parent.dispose();
                StartGui gui = new StartGui(kunderegister);
            }
        }
    }
}


