/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author menf
 */
public class RemoveMovieWindow extends JPanel implements CustomWindowInterface{
    
    private static RemoveMovieWindow instance;
    private JLabel removemovieError;
    private JLabel removemovieSucces;
    private JButton removemovieButton;
    private JScrollPane scrollPane;
    private JTable removemovieTable;
    
    
        private RemoveMovieWindow() {
    
    removemovieError = new JLabel("Nie można usunąć filmu!");
    removemovieSucces = new JLabel("Pomyślnie usunięto film!");
    removemovieButton = new JButton("Usuń film");
    scrollPane = new JScrollPane();
    removemovieTable  = new JTable();
            
    this.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.WEST;
    constraints.insets = new Insets(10, 10, 10, 10);
        
        // SCROLL VIEWER
        constraints.gridx=1;
        constraints.gridy=0;    
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(removemovieTable);
        
        
        //ERROR LABEL
        constraints.gridx=0;
        constraints.gridy=1; 
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(removemovieError, constraints);
        removemovieError.setVisible(true);
        removemovieError.setForeground(new Color(255, 0, 51));
        
        //BUTTON
        
        constraints.gridx=1; 
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(removemovieButton, constraints);
        
        //SUCCESS LABEL
        constraints.gridx=2;   
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(removemovieSucces, constraints);
        removemovieSucces.setVisible(true);
        removemovieSucces.setForeground(new Color(0, 204, 0));
        
        // BORDER
        this.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "USUŃ FILM"));
       
        
        }
        
        public static RemoveMovieWindow getInstance() {
        if (instance == null) {
            instance = new RemoveMovieWindow();
        }
        return instance;
    } 

    public JLabel getRemovemovieError() {
        return removemovieError;
    }

    public JLabel getRemovemovieSucces() {
        return removemovieSucces;
    }

    public JButton getRemovemovieButton() {
        return removemovieButton;
    }

    public JTable getRemovemovieTable() {
        return removemovieTable;
    }


}
