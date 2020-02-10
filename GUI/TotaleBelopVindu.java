package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ProsjektKlasse.*;

//Inneholder panelet TotaleInntekterVindu
public class TotaleBelopVindu extends JFrame
{
    private JLabel dapanelabel;
    
    private JPanel innhold;
    private CardLayout cardlayout;

    
    KundeReg kunderegister;
    
    public TotaleBelopVindu(KundeReg register){
        super("Inntekter og Utgifter");
        
        kunderegister = register;
        
        dapanelabel = new JLabel("Dapane");
        dapanelabel.setFont( new Font("Tahoma", Font.BOLD, 18) );
        dapanelabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel tittel = new JPanel();
        tittel.add(dapanelabel);
        
        
        innhold = new JPanel();
        cardlayout = new CardLayout();
        innhold.setLayout(cardlayout);
        
        TotaleInntekterGui vindu = new TotaleInntekterGui(this, kunderegister);
        innhold.setBorder(BorderFactory.createTitledBorder("Inntekter og utgifter"));
        innhold.add(vindu, "inntekter&utgifter");
        
        
        Container c = getContentPane();
        c.add(tittel, BorderLayout.PAGE_START);
        c.add(innhold);
        
        cardlayout.show(innhold, "inntekter&utgifter");
        
        setIcon();
        setVisible(true);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
    
    //Setter ikon på vinduet
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dapaneicon.png")));
    }
    
}
