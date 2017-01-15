package windows;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.GridBagLayout;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JPanel implements CustomWindowInterface {

    private static LoginWindow instance;
    private JPasswordField passField;
    private JButton loginButton;
    private JTextField logField;
    private Label loginLabel;
    private Label passLabel;
    private JLabel errorField;

    private LoginWindow() {

        loginLabel = new Label("Login:");//
        passField = new JPasswordField(20);//
        loginButton = new JButton("Login");//
        logField = new JTextField(20);//
        passLabel = new Label("Hasło:");//
        errorField = new JLabel("Bląd uwierzytelniania");

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // LOGIN LABEL
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(loginLabel, constraints);

        // LOGIN FIELD
        constraints.gridx = 1;
        this.add(logField, constraints);

        // PASSWORD LABEL
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(passLabel, constraints);

        // PASSWORD FIELD
        constraints.gridx = 1;
        this.add(passField, constraints);

        // ERROR LABEL
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(errorField, constraints);
        errorField.setVisible(true);
        errorField.setForeground(new Color(255, 0, 51));

        // LOGIN BUTTON
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(loginButton, constraints);

        // BORDER
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "LOGOWANIE"));
    }

    public JLabel getErrorField() {
        return errorField;
    }

    public static LoginWindow getInstance() {
        if (instance == null) {
            instance = new LoginWindow();
        }
        return instance;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
