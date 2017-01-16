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

public class ShowMovieWindow extends JPanel implements CustomWindowInterface {

    private JTable moviesTable;
    private JScrollPane scrollPane;
    private JButton showMovieButton;
    private static ShowMovieWindow instance;

    public ShowMovieWindow() {

        scrollPane = new JScrollPane();
        showMovieButton = new JButton("Zamów film");
        moviesTable = new javax.swing.JTable();
        moviesTable.setAutoCreateRowSorter(true);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);



        //BUTTON
        constraints.gridy = 1;
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(showMovieButton, constraints);
        
        // SCROLL VIEWER
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx=1;
        constraints.weighty=1;
       constraints.fill=GridBagConstraints.BOTH;
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(moviesTable);

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
    
    public JTable getTable() {
        return this.moviesTable;
    }

    public JButton getShowMovieButton() {
        return showMovieButton;
    }

    public void clear() {
        
    }
    
}
