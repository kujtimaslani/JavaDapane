package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ProsjektKlasse.*;

public class HistorikkVindu extends JFrame{
    
    private JPanel innhold;
    private CardLayout cardlayout;
    private JLabel dapanelabel;
    
    KundeReg kunderegister;
    
    public HistorikkVindu(KundeReg register){
        super("Historikk");
        
        kunderegister = register;
        
        dapanelabel = new JLabel("Dapane");
        dapanelabel.setFont( new Font("Tahoma", Font.BOLD, 18) );
        dapanelabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel dapane = new JPanel(new BorderLayout());
        dapane.add(dapanelabel, BorderLayout.PAGE_START);
        
        innhold = new JPanel();
        cardlayout = new CardLayout();
        innhold.setLayout(cardlayout);
        
        Historikk historikk = new Historikk(this,kunderegister);
        innhold.setBorder(BorderFactory.createTitledBorder("Historikk"));
        innhold.add(historikk, "historikk");
        
        Container c = getContentPane();
        c.add(dapane, BorderLayout.PAGE_START);
        c.add(innhold);
        
        setVisible(true);
        pack();
        setIcon();
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    
    //Setter ikon på vinduet
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dapaneicon.png")));
    }
    
}
