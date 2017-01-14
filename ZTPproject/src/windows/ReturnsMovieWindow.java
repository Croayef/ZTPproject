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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ReturnsMovieWindow extends JPanel implements CustomWindowInterface {
    private JTable returnsmoviesTable;
    private JScrollPane scrollPane;
    private JButton returnsMovieButton;
    private static ReturnsMovieWindow instance;
    
    public ReturnsMovieWindow()
    {
        scrollPane = new JScrollPane();
        returnsMovieButton = new JButton("Zwróć");    
        returnsmoviesTable = new javax.swing.JTable();
        returnsmoviesTable.setAutoCreateRowSorter(true);
        returnsmoviesTable.setModel(
            new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Identyfikator", "Tytuł", "Reżyser", "Ilość"
                }
            ) 

            {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            }
        );

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // SCROLL VIEWER
        constraints.gridx=1;
        constraints.gridy=0;    
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(returnsmoviesTable);

        //BUTTON
        constraints.gridy=1; 
        constraints.gridx=1; 
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(returnsMovieButton, constraints);    

        // BORDER
        this.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Zamówione pozycje"));      
    }
    
    public static ReturnsMovieWindow getInstance() {
        if (instance == null) {
            instance = new ReturnsMovieWindow();
        }
        return instance;
    }    
        
    public JButton getshowmovieButton() {
        return returnsMovieButton;
    }
    
}
