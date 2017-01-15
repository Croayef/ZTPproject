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

public class ReturnsMovieWindow extends JPanel implements CustomWindowInterface {

    private JTable returnsmoviesTable;
    private JLabel returnsMovieError;
    private JLabel returnsMovieSuccess;
    private JScrollPane scrollPane;
    private JButton returnsMovieButton;
    private static ReturnsMovieWindow instance;

    public ReturnsMovieWindow() {
        scrollPane = new JScrollPane();
        returnsMovieButton = new JButton("Zwróć");
        returnsmoviesTable = new javax.swing.JTable();
        returnsmoviesTable.setAutoCreateRowSorter(true);
        returnsMovieError = new JLabel("Błąd zwrotu");
        returnsMovieSuccess = new JLabel("Zwrócono");
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // SCROLL VIEWER
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(returnsmoviesTable);

        //ERROR LABEL
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(returnsMovieError, constraints);
        returnsMovieError.setVisible(true);
        returnsMovieError.setForeground(new Color(255, 0, 51));
        
        
        //BUTTON
        constraints.gridy = 1;
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(returnsMovieButton, constraints);

        //SUCCESS LABEL
        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(returnsMovieSuccess, constraints);
        returnsMovieSuccess.setVisible(true);
        returnsMovieSuccess.setForeground(new Color(0, 204, 0));
        
        
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

    public JTable getTable() {
        return returnsmoviesTable;
    }
        
    public JButton getReturnsMovieButton() {
        return returnsMovieButton;
    }

    public JLabel getReturnsMovieError() {
        return returnsMovieError;
    }

    public JLabel getReturnsMovieSucces() {
        return returnsMovieSuccess;
    }
    
    public void clear(){
        
    }
    
}
