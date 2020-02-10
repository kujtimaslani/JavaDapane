package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ProsjektKlasse.*;

public class SkademeldingGui extends JFrame{
    
    private JRadioButton reg, admin;
    private ButtonGroup radiogruppe;
    private JPanel innhold;
    private CardLayout cardlayout;
    ILytter ilytter;
    private JLabel dapanelabel;
    
    KundeReg kunderegister;
    
    public SkademeldingGui(KundeReg register){
        super("Skademelding");
        
        kunderegister = register;
        dapanelabel = new JLabel("Dapane");
        dapanelabel.setFont( new Font("Tahoma", Font.BOLD, 18) );
        dapanelabel.setHorizontalAlignment(JLabel.CENTER);
        
        ilytter = new ILytter();
        
        reg = new JRadioButton("Registrer");
        reg.addItemListener(ilytter);
        admin = new JRadioButton("Administrer");
        admin.addItemListener(ilytter);
        
        radiogruppe = new ButtonGroup();
        radiogruppe.add(reg);
        radiogruppe.add(admin);
        
        JPanel box = new JPanel();
        box.add(reg);
        box.add(admin);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(dapanelabel, BorderLayout.PAGE_START);
        panel.add(box);
        
        
        innhold = new JPanel();
        cardlayout = new CardLayout();
        innhold.setLayout(cardlayout);
        
        RegSkadeGui regskade = new RegSkadeGui(this,kunderegister);
        innhold.setBorder(BorderFactory.createTitledBorder("Registrer skade"));
        innhold.add(regskade, "Registrer Skade");
        
        AdminSkadeGui adminskade = new AdminSkadeGui(this,kunderegister);
        innhold.setBorder(BorderFactory.createTitledBorder("Administrer skademelding"));
        innhold.add(adminskade, "Søk");
        
        Container c = getContentPane();
        c.add(panel, BorderLayout.PAGE_START);
        c.add(innhold);
        
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
    
    
    
    private class ILytter implements ItemListener{
        public void itemStateChanged(ItemEvent e)
        {
                if(reg.isSelected())
                {
                    cardlayout.show(innhold, "Registrer Skade");
                }
                else if(admin.isSelected())
                {
                    cardlayout.show(innhold, "Søk");
                }
        }
    }
}
