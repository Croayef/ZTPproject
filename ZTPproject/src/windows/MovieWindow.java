package windows;

import javax.swing.JPanel;

public class MovieWindow extends JPanel implements CustomWindowInterface {
    
    private static MovieWindow instance;

    private MovieWindow() {

        //robimy okienko ale jeszcze nie wiem jak
    }

    ;
    
    public static MovieWindow getInstance() {
        if (instance == null) {
            instance = new MovieWindow();
        }
        return instance;
    }
    
}
