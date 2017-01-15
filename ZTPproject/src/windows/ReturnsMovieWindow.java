package windows;

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

    public ReturnsMovieWindow() {
        scrollPane = new JScrollPane();
        returnsMovieButton = new JButton("Zwróć");
        returnsmoviesTable = new javax.swing.JTable();
        returnsmoviesTable.setAutoCreateRowSorter(true);

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // SCROLL VIEWER
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(returnsmoviesTable);

        //BUTTON
        constraints.gridy = 1;
        constraints.gridx = 1;
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

    public JButton getReturnsmovieButton() {
        return returnsMovieButton;
    }
}
