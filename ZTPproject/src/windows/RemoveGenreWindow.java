package windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RemoveGenreWindow extends JPanel implements CustomWindowInterface {

    private static RemoveGenreWindow instance;
    private JLabel removegenreLabel;
    private JButton removegenreButton;
    private JScrollPane scrollPane;
    private JTable removegenreTable;

    private RemoveGenreWindow() {
        removegenreLabel = new JLabel();
        removegenreButton = new JButton("Usuń");
        scrollPane = new JScrollPane();
        removegenreTable = new JTable();

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // SCROLL VIEWER
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        this.add(scrollPane, constraints);
        scrollPane.setViewportView(removegenreTable);

        //BUTTON
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.PAGE_START;
        this.add(removegenreButton, constraints);

        //ERROR LABEL
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.PAGE_END;
        this.add(removegenreLabel, constraints);
        removegenreLabel.setVisible(false);

        // BORDER
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "USUŃ FILM"));

    }

    public static RemoveGenreWindow getInstance() {
        if (instance == null) {
            instance = new RemoveGenreWindow();
        }
        return instance;
    }

    public JLabel getRemovegenreLabel() {
        return removegenreLabel;
    }

    public JTable getRemovegenreTable() {
        return removegenreTable;
    }
}
