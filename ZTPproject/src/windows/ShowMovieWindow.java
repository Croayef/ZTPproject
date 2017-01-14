/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowMovieWindow  extends JPanel implements CustomWindowInterface {
    private JTable moviesTable;
    private JScrollPane scrollPane;
    private JButton showMovieButton;
    private static ShowMovieWindow instance;
    
    public ShowMovieWindow() {
            
        scrollPane = new JScrollPane();
        showMovieButton = new JButton("Zamów");
        moviesTable = new javax.swing.JTable();
        moviesTable.setAutoCreateRowSorter(true);
        moviesTable.setModel(
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
        scrollPane.setViewportView(moviesTable);

        //BUTTON
        constraints.gridy=1; 
        constraints.gridx=1; 
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(showMovieButton, constraints);    

        // BORDER
        this.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Dostępne pozycje"));

    }

    public static ShowMovieWindow getInstance() {
        if (instance == null) {
            instance = new ShowMovieWindow();
        }
        return instance;
    }    

    public JButton getshowmovieButton() {
        return showMovieButton;
    }
}
