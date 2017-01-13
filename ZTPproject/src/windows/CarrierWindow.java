package windows;

public class CarrierWindow implements CustomWindowInterface {
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
