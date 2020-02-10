package ProsjektKlasse;

import GUI.StartGui;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.UIManager.*;


public class Main {
    
    private static KundeReg register;
    
    public static void main(String args[]) {
        
        register = new KundeReg();
        
       try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
       catch (ClassNotFoundException ex) 
       {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       catch (InstantiationException ex) 
       {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       catch (IllegalAccessException ex)
       {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       catch (javax.swing.UnsupportedLookAndFeelException ex) 
       {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
 
         
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartGui gui = new StartGui(register);
                gui.setVisible(true);
                gui.setLocationRelativeTo(null);
            }
        });
    }
}
