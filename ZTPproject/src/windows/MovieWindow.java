package windows;

public class MovieWindow implements CustomWindowInterface {
    
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
