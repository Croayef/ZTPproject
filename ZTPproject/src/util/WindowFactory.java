package util;

import windows.CarrierWindow;
import windows.CarrierWindow;
import windows.CustomWindowInterface;
import windows.CustomWindowInterface;
import windows.DirectorWindow;
import windows.DirectorWindow;
import windows.GenreWindow;
import windows.GenreWindow;
import windows.MovieWindow;
import windows.MovieWindow;

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
