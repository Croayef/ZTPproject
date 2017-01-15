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

public class RemoveMovieWindow extends JPanel implements CustomWindowInterface {

    private static RemoveMovieWindow instance;
    private JButton removemovieButton;
    private JScrollPane scrollPane;
    private JTable removemovieTable;

    private RemoveMovieWindow() {
        removemovieButton = new JButton("Usuń film");
        scrollPane = new JScrollPane();
        removemovieTable = new JTable();

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // SCROLL VIEWER
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(removemovieTable);
        
        //BUTTON
        constraints.gridy = 1;
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(removemovieButton, constraints);

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

    public JButton getRemoveMovieButton() {
        return removemovieButton;
    }

    public JTable getTable() {
        return removemovieTable;
    }

    public void clear() {

    }

}
