package windows;

public class WindowFactory {

    public CustomWindowInterface getWindow(String windowType) {
        switch(windowType.toUpperCase()){
            case "FILM":
                return MovieWindow.getInstance();
            case "REZYSER":
                return DirectorWindow.getInstance();
            case "NOSNIK":
                return CarrierWindow.getInstance();                
            case "GATUNEK":
                return GenreWindow.getInstance();
            default:
                return null;
        }
        
    }

}
