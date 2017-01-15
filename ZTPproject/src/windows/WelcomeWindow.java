package windows;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeWindow extends JPanel implements CustomWindowInterface {

    private static WelcomeWindow instance;
    
    public WelcomeWindow() {
        
        JLabel welcomeLabel = new JLabel("Witamy w wypożyczalni!");
        JLabel successLabel = new JLabel("Zalogowano pomyślnie");
        welcomeLabel.setFont(new Font(welcomeLabel.getName(), Font.PLAIN, 25));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        this.add(welcomeLabel, c);
        c.gridy = 1;
        this.add(successLabel, c);
        
    }
    
     public static WelcomeWindow getInstance() {
        if (instance == null) {
            instance = new WelcomeWindow();
        }
        return instance;
    }
     
     public void clear() {
        
    }
    
}
