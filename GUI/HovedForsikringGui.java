package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ProsjektKlasse.*;

public class HovedForsikringGui extends JFrame
{
    
    private JComboBox<String> combobox;
    private JPanel innhold;
    private CardLayout cardlayout;
    private JLabel dapanelabel;
    Itemlistener lytter;
    private JButton tilbake;
    
    KundeReg kunderegister;
    public HovedForsikringGui(KundeReg register)
    {
        super("Forsikringer");
        
        kunderegister = register;
        String [] array = {"Fritidsbolig", "BilForsikring", "Baatforsikring", "Reiseforsikring", "Hus&Innboforsikring" };
        combobox = new JComboBox<>(array);
        
        dapanelabel = new JLabel("Dapane");
        dapanelabel.setFont( new Font("Tahoma", Font.BOLD, 18) );
        dapanelabel.setHorizontalAlignment(JLabel.CENTER);
        lytter = new Itemlistener();
        combobox.addItemListener(lytter);
        tilbake = new JButton("Tilbake");
        
        JPanel comboboxPanel = new JPanel();
        comboboxPanel.add(combobox);
        
        JPanel box = new JPanel( new BorderLayout() );
        box.add(dapanelabel, BorderLayout.PAGE_START);
        box.add(comboboxPanel);
        
        //Panelet som inneholder alle forsikringguiene
        innhold = new JPanel();
        cardlayout = new CardLayout();
        innhold.setLayout(cardlayout);
        
        FritidsboligGui fritidsbolig = new FritidsboligGui(this, kunderegister);
        fritidsbolig.setBorder( BorderFactory.createTitledBorder("Fritidsbolig") );
        innhold.add(fritidsbolig, "Fritidsbolig");
        
        BilGui bilgui = new BilGui(this, kunderegister);
        bilgui.setBorder(BorderFactory.createTitledBorder("Bilforsikring"));
        innhold.add(bilgui, "Bilforsikring");
        
        BaatforsikringAdminGui baatgui = new BaatforsikringAdminGui(this,kunderegister);
        baatgui.setBorder(BorderFactory.createTitledBorder("Baatforsikring"));
        innhold.add(baatgui, "Baatforsikring");
        
        ReiseGui reisegui = new ReiseGui(this, kunderegister);
        reisegui.setBorder(BorderFactory.createTitledBorder("Reiseforsikring"));
        innhold.add(reisegui, "Reiseforsikring");
        
        HusInnboGui higui = new HusInnboGui(this, kunderegister);
        higui.setBorder(BorderFactory.createTitledBorder("Hus&Innbo-forsikring"));
        innhold.add(higui, "Hus&Innboforsikring");
        
        
        
        //Her starter containainern------------------------------
        Container c = getContentPane();
        c.add(box, BorderLayout.PAGE_START);
        c.add(innhold);
        
        setIcon();
        
        setVisible(true);
        setSize(700,700);
        
        setLocationRelativeTo(null);
        setResizable(false); //Kan ikkeendre størrelse på vindu
    }
    
   //Setter ikon på vinduet
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dapaneicon.png")));
    }
    
    
    private class Itemlistener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            if(combobox.getSelectedItem().equals("Fritidsbolig"))
            {
                cardlayout.show(innhold, "Fritidsbolig");
            }
            else if(combobox.getSelectedItem().equals("BilForsikring"))
            {
                cardlayout.show(innhold, "Bilforsikring");
            }
            else if(combobox.getSelectedItem().equals("Baatforsikring"))
            {
                cardlayout.show(innhold, "Baatforsikring");
            }
            else if(combobox.getSelectedItem().equals("Reiseforsikring"))
            {
                cardlayout.show(innhold, "Reiseforsikring");
            }
            else if(combobox.getSelectedItem().equals("Hus&Innboforsikring"))
            {
                cardlayout.show(innhold, "Hus&Innboforsikring");
            }
        }
    }
    
}
