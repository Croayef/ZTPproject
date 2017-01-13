package windows;

public class GenreWindow implements CustomWindowInterface {

    private static GenreWindow instance;

    private GenreWindow() {

        //robimy okienko ale jeszcze nie wiem jak
    }

    ;
    
    public static GenreWindow getInstance() {
        if (instance == null) {
            instance = new GenreWindow();
        }
        return instance;
    }
}
