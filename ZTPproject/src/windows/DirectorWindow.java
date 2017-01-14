package windows;

import javax.swing.JPanel;

public class DirectorWindow extends JPanel implements CustomWindowInterface {

    private static DirectorWindow instance;

    private DirectorWindow() {

        //robimy okienko ale jeszcze nie wiem jak
    }

    
    public static DirectorWindow getInstance() {
        if (instance == null) {
            instance = new DirectorWindow();
        }
        return instance;
    }
}
