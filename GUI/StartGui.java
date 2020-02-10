package GUI;

import ProsjektKlasse.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.UIManager.*; 
import java.awt.event.WindowAdapter;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
 
public class StartGui extends JFrame
{
     
    private JLabel dapaneLabel;
    private JButton btnRegK, btnAdminK, btnAdminF, btnAdminS, btninfo, btnHist;
    Knappelytter lytter;
    
    KundeReg kunderegister;
     
    public StartGui(KundeReg register){
        super("Dapane");
         
        lytter = new Knappelytter();
        kunderegister = register;
        
        Icon logo = new ImageIcon( getClass().getResource("dapanelogo1.png"));
        
        dapaneLabel = new JLabel(logo, SwingConstants.CENTER);
        dapaneLabel.setFont( new Font("Tahoma", Font.BOLD, 18) );
        dapaneLabel.setHorizontalAlignment(JLabel.CENTER);
        
        btnRegK = new JButton();
        btnAdminK = new JButton();
        btnAdminF = new JButton();
        btnAdminS = new JButton();
        btninfo = new JButton();
        btnHist = new JButton();
        
        btnRegK.setText("Registrer Kunde");
        btnAdminK.setText("Administrer Kunde");
        btnAdminF.setText("Administrer Forsikring");
        btnAdminS.setText("Administrer Skademelding");
        btninfo.setText("Inntekter og utgifter");
        btnHist.setText("Historikk");
     
        btnRegK.addActionListener(lytter);
        btnAdminK.addActionListener(lytter);
        btnAdminF.addActionListener(lytter);
        btnAdminS.addActionListener(lytter);
        btninfo.addActionListener(lytter);
        btnHist.addActionListener(lytter);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        kunderegister.skrivtilfil();
        
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
        
        //
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
             .addGroup(layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()    
             .addGap(120, 120, 120)
             .addComponent(dapaneLabel))
                
             .addGroup(layout.createSequentialGroup()
             .addGap(30, 30, 30)
                     
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
             .addComponent(btnRegK, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(btnAdminF, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(btnHist, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
             .addGap(18, 26, Short.MAX_VALUE)
        
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
             .addComponent(btnAdminK, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(btnAdminS, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(btninfo, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
             .addGap(30, 30, 30))
        );
            //Setter vertikale plasseringer på komponentene
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(dapaneLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnRegK, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAdminK, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
         
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(btnAdminF, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAdminS, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(btnHist, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addComponent(btninfo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
    }
     
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btnRegK)
            {
                dispose();
                KunderegGui kundereggui = new KunderegGui(kunderegister);
            }
                    
            else if(e.getSource() == btnAdminK)
            {
                dispose();
                KundeAdminGui kundeadminGui = new KundeAdminGui(kunderegister);
             
            }

            else if(e.getSource() == btnAdminF)
            {
                dispose();
                HovedForsikringGui forsikringadminGui = new HovedForsikringGui(kunderegister);
                //BaatforsikringAdminGui baatforsikringadmingui = new BaatforsikringAdminGui();
            }
            
            else if(e.getSource() == btnAdminS)
            {
                dispose();
                SkademeldingGui gui = new SkademeldingGui(kunderegister);
            }
            else if(e.getSource() == btninfo)
            {
                dispose();
                TotaleBelopVindu vindu = new TotaleBelopVindu(kunderegister);
            }
            else if(e.getSource() == btnHist)
            {
                dispose();
                HistorikkVindu gui = new HistorikkVindu(kunderegister);
            }
        }
    }
}