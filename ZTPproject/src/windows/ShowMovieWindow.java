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
    private JLabel showMovieeError;
    private JLabel showMovieSucces;
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

        // SCROLL VIEWER
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(moviesTable);
        
        //ERROR LABEL
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(showMovieeError, constraints);
        showMovieeError.setVisible(true);
        showMovieeError.setForeground(new Color(255, 0, 51));

        //BUTTON
        constraints.gridy = 1;
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(showMovieButton, constraints);
        
        //SUCCESS LABEL
        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(showMovieSucces, constraints);
        showMovieSucces.setVisible(true);
        showMovieSucces.setForeground(new Color(0, 204, 0));

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

    public JLabel getShowMovieeError() {
        return showMovieeError;
    }

    public JLabel getShowMovieSucces() {
        return showMovieSucces;
    }
    
}
