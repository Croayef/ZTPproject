package windows;

import javax.swing.JPanel;

public class CarrierWindow extends JPanel implements CustomWindowInterface {
    private static CarrierWindow instance;

    private CarrierWindow() {

        //robimy okienko ale jeszcze nie wiem jak
    }

    ;
    
    public static CarrierWindow getInstance() {
        if (instance == null) {
            instance = new CarrierWindow();
        }
        return instance;
    }
}
