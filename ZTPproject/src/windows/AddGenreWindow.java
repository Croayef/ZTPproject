package windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddGenreWindow extends JPanel implements CustomWindowInterface {

    private static AddGenreWindow instance;
    private JLabel nameLabel;
    private JLabel outcomeLabel;
    private JTextField newGenreName;
    private JButton addGenreButton;

    private AddGenreWindow() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Dodaj Gatunek"));

        nameLabel = new JLabel("Nazwa: ");
        newGenreName = new JTextField(20);
        addGenreButton = new JButton("Dodaj");
        outcomeLabel = new JLabel();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(nameLabel, constraints);
        constraints.gridx = 1;
        this.add(newGenreName, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(addGenreButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(outcomeLabel, constraints);

    }

    public static AddGenreWindow getInstance() {
        if (instance == null) {
            instance = new AddGenreWindow();
        }
        return instance;
    }

    public JButton getAddGenreButton() {
        return this.addGenreButton;
    }
    
    public void clear() {
        this.nameLabel.setText("");
    }
    
}
