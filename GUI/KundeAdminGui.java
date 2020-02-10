package GUI;

import ProsjektKlasse.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class KundeAdminGui extends JFrame{
    
    private JLabel dapanelabel, kundenrlabel, fornavnlabel, etternavnlabel;
    private JTextField kundenrfelt, fornavnfelt, etternavnfelt;
    private JComboBox fCombobox;
    private JButton btnSok, btnOppdater, btnFjern, btnTilbake, btnVisAlle, btnVisTidligerekunder;
    private JTable utskriftTabell;
    private JScrollPane scroll;
    private String[] kolonner = new String[] {"Status" ,"Kundenr", "Ant.Forsikringer" ,"Fornavn", "Etternavn", "Oppr.dato", "Adresse", "Postnr", "Poststed", "Premie", "Totalkunde", "Mottatt beløp"};
    private TableModel tm = new TableModel();
    
    KundeReg kunderegister;
    
    List<Kunde> kundeliste;
    
    Knappelytter lytter;
    
    public KundeAdminGui(KundeReg register){
        super("Kundeadministrasjon");
        
        kunderegister = register;
        
        lytter = new Knappelytter();
        
        dapanelabel = new JLabel("Dapane");
        dapanelabel.setFont( new Font("Tahoma", Font.BOLD, 18) );
        dapanelabel.setHorizontalAlignment(JLabel.CENTER);
        kundenrlabel = new JLabel("Kundenr:");
        fornavnlabel = new JLabel("Fornavn:");
        etternavnlabel = new JLabel("Etternavn:");
        
        kundenrfelt = new JTextField();
        fornavnfelt = new JTextField();
        etternavnfelt = new JTextField();
        
        fCombobox = new JComboBox(new String[] {"Bil","Båt","Reise","Hus&Innbo","Fritidsbolig"});
        fCombobox.addActionListener(lytter);
        
        btnSok = new JButton("Søk");
        btnSok.addActionListener(lytter);
        btnFjern = new JButton("Deaktiver");
        btnFjern.addActionListener(lytter);
        btnOppdater = new JButton("Oppdater");
        btnOppdater.addActionListener(lytter);
        btnTilbake = new JButton("Tilbake");
        btnTilbake.addActionListener(lytter);
        btnVisAlle = new JButton("Aktive kunder");
        btnVisAlle.addActionListener(lytter);
        btnVisTidligerekunder = new JButton("Tidligere kunder");
        btnVisTidligerekunder.addActionListener(lytter);
        
        scroll = new JScrollPane();
        utskriftTabell = new JTable();
        
        
        scroll.setMinimumSize(new Dimension(40, 40));       
        scroll.setPreferredSize(new Dimension(150, 150));

        utskriftTabell.setModel(new DefaultTableModel(
            new Object [][] {
                {null,null, null, null, null, null, null, null, null, null, null,null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Status","Kundenr", "Ant.forsikringer","Fornavn", "Etternavn", "Oppr.dato", "Adresse", "Postnr", "Poststed", "Premie", "Totalkunde", "Mottatt beløp"
            }
                
                
        ) {
            
            boolean[] editable = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rad, int kolonne) {
                return editable [kolonne];
            }
        });
        
        utskriftTabell.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.setViewportView(utskriftTabell);
        
        komponenter();
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setIcon();
    }
    
    public void komponenter()
    {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(btnSok)
                    .addGap(18, 18, 18)
                    .addComponent(btnFjern)
                    .addGap(18, 18, 18)
                    .addComponent(btnVisAlle)
                    .addGap(18, 18, 18)
                    .addComponent(btnVisTidligerekunder)
                    .addGap(18, 18, 18)
                    .addComponent(btnTilbake))
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    
                    .addGroup(layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(dapanelabel))
                    
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
                    .addComponent(dapanelabel)
                    .addGap(30,30,30)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(kundenrfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(kundenrlabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fornavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fornavnlabel)
                    .addComponent(etternavnfelt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(etternavnlabel)
                    .addGap(50,50,50))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    
                    
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTilbake)
                    .addComponent(btnVisAlle)
                    .addComponent(btnFjern)
                    .addComponent(btnVisTidligerekunder)
                    .addComponent(btnSok)
                    .addGap(50, 50, 50))
                            
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
              );
    }
    
    //Setter ikon på vinduet
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dapaneicon.png")));
    }
    
    
    //Bare en hjelpemetode, for evt vise feilmeldinger
    public void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(null, melding);
    }
    
    //Metode for å søke etter kunde, med kundenr, fornavn eller etternavn
    public void sokefunksjon(){
    
        try
        {
            
            Object[][] objKunde = new Object[1][12] ;
            
            if (kundenrfelt.getText().length()>0){
                int kundenr = Integer.parseInt(kundenrfelt.getText());
               
               Kunde kunde  =  kunderegister.finnKundeMedKundenr(kundenr);
               
               if (kunde!=null){
               
                   if (kundenr == kunde.getKundeNr())
                   {
                       
                       if(kunde.isAktiv())
                       {
                           objKunde [0][0] ="AKTIV";
                       }
                       else
                       {
                            objKunde [0][0] = "INAKTIV";
                       }
                               
                       objKunde [0][1] =kunde.getKundeNr();
                       objKunde [0][2] =kunde.getAntallForsikringerPaaKunde();
                       objKunde [0][3] =kunde.getFornavn();
                       objKunde [0][4] =kunde.getEtternavn();
                       objKunde [0][5] =kunde.getOpprDato();
                       objKunde [0][6] =kunde.getAdresse();
                       objKunde [0][7] =kunde.getPostnr();
                       objKunde [0][8] =kunde.getPoststed();
                       objKunde [0][9] =kunde.getAarligPremie();
                       
                       if (kunde.isTotalKunde())
                            objKunde [0][10] ="JA";
                       else
                           objKunde [0][10] ="NEI";
                       
                       objKunde [0][11] =kunde.getUtbetalteErstatninger();
                   }
                    else{
                        objKunde [0][1] ="";
                        objKunde [0][2] ="";
                        objKunde [0][3] ="";
                        objKunde [0][4] ="";
                        objKunde [0][5] ="";
                        objKunde [0][6] ="";
                        objKunde [0][7] ="";
                        objKunde [0][8] ="";
                        objKunde [0][9] ="";
                        objKunde [0][10] ="";
                    }
                   
               
            tm.setDataVector(objKunde, kolonner);
            utskriftTabell.setModel(tm);

            }
            else{
                   tm.setDataVector(null, kolonner);
                utskriftTabell.setModel(tm);
            }
        }
        else if(fornavnfelt.getText().length()>0)
        {
            String fornavn = fornavnfelt.getText();
            Kunde kunde = kunderegister.finnKundeMedFornavn(fornavn);
            
            if(kunde != null)
            {
                if(kunde.isAktiv())
                {
                    objKunde [0][0] ="AKTIV";
                }
                else
                {
                    objKunde [0][0] = "INAKTIV";
                }
                               
                       objKunde [0][1] =kunde.getKundeNr();
                       objKunde [0][2] =kunde.getAntallForsikringerPaaKunde();
                       objKunde [0][3] =kunde.getFornavn();
                       objKunde [0][4] =kunde.getEtternavn();
                       objKunde [0][5] =kunde.getOpprDato();
                       objKunde [0][6] =kunde.getAdresse();
                       objKunde [0][7] =kunde.getPostnr();
                       objKunde [0][8] =kunde.getPoststed();
                       objKunde [0][9] =kunde.getAarligPremie();
                       
                       if (kunde.isTotalKunde())
                            objKunde [0][10] ="JA";
                       else
                           objKunde [0][10] ="NEI";
                       
                       objKunde [0][11] =kunde.getUtbetalteErstatninger();
                   }
                    else{
                        objKunde [0][1] ="";
                        objKunde [0][2] ="";
                        objKunde [0][3] ="";
                        objKunde [0][4] ="";
                        objKunde [0][5] ="";
                        objKunde [0][6] ="";
                        objKunde [0][7] ="";
                        objKunde [0][8] ="";
                        objKunde [0][9] ="";
                        objKunde [0][10] ="";
                    }
            tm.setDataVector(objKunde, kolonner);
            utskriftTabell.setModel(tm);
            
        }
        else if(etternavnfelt.getText().length()>0)
        {
            String etternavn = etternavnfelt.getText();
            Kunde kunde = kunderegister.finnKundeMedEtternavn(etternavn);
            
            if(kunde != null)
            {
                if(kunde.isAktiv())
                {
                    objKunde [0][0] ="AKTIV";
                }
                else
                {
                    objKunde [0][0] = "INAKTIV";
                }
                               
                       objKunde [0][1] =kunde.getKundeNr();
                       objKunde [0][2] =kunde.getAntallForsikringerPaaKunde();
                       objKunde [0][3] =kunde.getFornavn();
                       objKunde [0][4] =kunde.getEtternavn();
                       objKunde [0][5] =kunde.getOpprDato();
                       objKunde [0][6] =kunde.getAdresse();
                       objKunde [0][7] =kunde.getPostnr();
                       objKunde [0][8] =kunde.getPoststed();
                       objKunde [0][9] =kunde.getAarligPremie();
                       
                       if (kunde.isTotalKunde())
                            objKunde [0][10] ="JA";
                       else
                           objKunde [0][10] ="NEI";
                       
                       objKunde [0][11] =kunde.getUtbetalteErstatninger();
                   }
                    else{
                        objKunde [0][1] ="";
                        objKunde [0][2] ="";
                        objKunde [0][3] ="";
                        objKunde [0][4] ="";
                        objKunde [0][5] ="";
                        objKunde [0][6] ="";
                        objKunde [0][7] ="";
                        objKunde [0][8] ="";
                        objKunde [0][9] ="";
                        objKunde [0][10] ="";
                    }
            tm.setDataVector(objKunde, kolonner);
            utskriftTabell.setModel(tm);
            }
        
        else{
            if(fornavnfelt.getText().length()>0){
                fillDataTable();
                int rowCount = tm.getRowCount();
                for (int i=rowCount-1;i>=0;i--){
                  if (  !tm.getValueAt(i, 1).toString().equals(fornavnfelt.getText())){
                      tm.removeRow(i);
                  }
                }
            }
            else if (etternavnfelt.getText().length()>0){
                fillDataTable();
                int rowCount = tm.getRowCount();
                for (int i=rowCount-1;i>=0;i--){
                  if (  !tm.getValueAt(i, 2).toString().equals(fornavnfelt.getText())){
                      tm.removeRow(i);
                  }
                }
            }
            else{
                fillDataTable();
            }
        }
             
       
        }
        catch(NumberFormatException nfee)
        {
            visMelding("Feil, i tallformat"
                    + "\nPrøv igjen!");
        }
    }
    
    //Skriver ut alle aktive kunder
    private void  fillDataTable(){
        
        Object[][] objKunde = new Object[kunderegister.getKundeliste().size()][12] ;
        Iterator<Kunde> iter =  kunderegister.kIterator();
        Kunde kunde;
        int i=0;
        
        while (iter.hasNext()){
            kunde = iter.next();
            if(kunde.isAktiv())
            {
                objKunde [i][0] = "AKTIV";
            }
            else
            {
                 objKunde [i][0] = "INAKTIV";
            }
            objKunde [i][1] =kunde.getKundeNr();
            objKunde [i][2] =kunde.getAntallForsikringerPaaKunde();
            objKunde [i][3] =kunde.getFornavn();
            objKunde [i][4] =kunde.getEtternavn();           
            objKunde [i][5] =kunde.getOpprDato();
            objKunde [i][6] =kunde.getAdresse();
            objKunde [i][7] =kunde.getPostnr();
            objKunde [i][8] =kunde.getPoststed();
            objKunde [i][9] =kunde.getAarligPremie();
                       
            if (kunde.isTotalKunde())
                 objKunde [i][10] ="JA";
            else
                objKunde [i][10] ="NEI";

            objKunde [i][11] =kunde.getUtbetalteErstatninger();
        i++;
        }
        tm.setDataVector(objKunde, kolonner);
        utskriftTabell.setModel(tm);

    }
    
    private void  fillTidligerekunderDataTable(){
        
        Object[][] objKunde = new Object[kunderegister.getIkkeaktivekundeliste().size()][12] ;
        Iterator<Kunde> iter =  kunderegister.deaktivertIterator();
        Kunde kunde;
        int i=0;
        
        while (iter.hasNext()){
            kunde = iter.next();
            if(kunde.isAktiv())
            {
                objKunde [i][0] = "AKTIV";
            }
            else
            {
                 objKunde [i][0] = "INAKTIV";
            }
            objKunde [i][1] =kunde.getKundeNr();
            objKunde [i][2] =kunde.getAntallForsikringerPaaKunde();
            objKunde [i][3] =kunde.getFornavn();
            objKunde [i][4] =kunde.getEtternavn();           
            objKunde [i][5] =kunde.getOpprDato();
            objKunde [i][6] =kunde.getAdresse();
            objKunde [i][7] =kunde.getPostnr();
            objKunde [i][8] =kunde.getPoststed();
            objKunde [i][9] =kunde.getAarligPremie();
                       
            if (kunde.isTotalKunde())
                 objKunde [i][10] ="JA";
            else
                objKunde [i][10] ="NEI";

            objKunde [i][11] =kunde.getUtbetalteErstatninger();
        i++;
        }
        tm.setDataVector(objKunde, kolonner);
        utskriftTabell.setModel(tm);

    }
    
    public class TableModel extends DefaultTableModel{
    TableModel( )
             {

              }
    @Override
    public boolean isCellEditable(int row,int cols)
     {
       return false;

     }
    }
    
    public void fjernKundeMedKundenr()
    {
        try
        {
            int kundenr = Integer.parseInt(kundenrfelt.getText());
             kunderegister.fjernKundeMedKundenr(kundenr);
        }
        catch(NumberFormatException nfee)
        {
            visMelding("Feil i tallformat."
                    + "\nPrøv igjen");
        }
        
    }
    
    public void visAlleKunder()
    {
        fillDataTable();
    }
    
    
    
    
    
    
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == btnSok)
            {
                sokefunksjon();
            }
            else if(e.getSource() == btnFjern)
            {
                fjernKundeMedKundenr();
            }
            else if(e.getSource() == btnTilbake)
            {
                dispose();
                StartGui gui = new StartGui(kunderegister);
            }
            else if(e.getSource() == btnVisTidligerekunder)
            {
                fillTidligerekunderDataTable();
            }
            else if(e.getSource() == btnVisAlle)
            {
                visAlleKunder();
            }
        }
    }
}
