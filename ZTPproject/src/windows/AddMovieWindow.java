package windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddMovieWindow extends JPanel implements CustomWindowInterface {

    private static AddMovieWindow instance;
    private JLabel nameLabel;
    private JLabel yearLabel;
    private JLabel quantityLabel;
    private JLabel carrierLabel;
    private JLabel directorLabel;
    private JLabel genresLabel;
    private JTextField newMovieName;
    private JTextField newMovieYear;
    private JTextField newMovieQuantity;
    private JComboBox<String> newMovieCarrier;
    private JComboBox<String> newMovieDirector;
    private JScrollPane genreListScrollPane;
    private JList<String> genreList;
    private JButton addMovieButton;

    private AddMovieWindow() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Dodaj Film"));

        nameLabel = new JLabel("Nazwa: ");
        yearLabel = new JLabel("Rok produkcji: ");
        quantityLabel = new JLabel("Ilość: ");
        carrierLabel = new JLabel("Nośnik: ");
        directorLabel = new JLabel("Reżyser: ");
        genresLabel = new JLabel("Gatunki: ");
        newMovieName = new JTextField(20);
        newMovieYear = new JTextField(4);
        newMovieQuantity = new JTextField(4);
        newMovieCarrier = new JComboBox<String>();
        newMovieDirector = new JComboBox<>();
        genreList = new JList<>();
        genreList.setBounds(0, 0, 300, 300);
        genreListScrollPane = new JScrollPane(genreList);
        addMovieButton = new JButton("Dodaj Film");
        setComponensPositions();

    }

    private void setComponensPositions() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(nameLabel, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        this.add(newMovieName, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(yearLabel, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(newMovieYear, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(quantityLabel, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(newMovieQuantity, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        this.add(carrierLabel, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(newMovieCarrier, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        this.add(directorLabel, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(newMovieDirector, constraints);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(genresLabel);
        constraints.gridy = 1;
        constraints.gridheight = 3;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx=1;
        constraints.weighty=1;
        this.add(genreListScrollPane, constraints);
        constraints.weightx=0;
        constraints.weighty=0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.NONE;
        this.add(addMovieButton, constraints);
    }

    public static AddMovieWindow getInstance() {
        if (instance == null) {
            instance = new AddMovieWindow();
        }
        return instance;
    }

    public JList<String> getGenreList() {
        return this.genreList;
    }
    
    public JComboBox<String> getCarriers() {
        return this.newMovieCarrier;
    }
    
    public JComboBox<String> getDirectors() {
        return this.newMovieDirector;
    }

    public JButton getAddMovieButton() {
        return this.addMovieButton;
    }

    public JTextField getNewMovieName() {
        return newMovieName;
    }

    public JTextField getNewMovieYear() {
        return newMovieYear;
    }

    public JTextField getNewMovieQuantity() {
        return newMovieQuantity;
    }

    public void clear() {
        this.newMovieName.setText("");
        this.newMovieYear.setText("");
        this.newMovieQuantity.setText("");
        this.newMovieCarrier.setSelectedIndex(-1);
        this.newMovieDirector.setSelectedIndex(-1);
    }
    
}
