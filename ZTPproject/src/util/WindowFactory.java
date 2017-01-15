package util;

import windows.AddMovieWindow;
import windows.CustomWindowInterface;
import windows.RemoveGenreWindow;
import windows.RemoveMovieWindow;
import windows.ShowMovieWindow;
import windows.TransactionWindow;

public class WindowFactory {

    public CustomWindowInterface getWindow(String windowType) {
        switch (windowType.toUpperCase()) {
            case "ADD_MOVIE":
                return AddMovieWindow.getInstance();
            case "SHOW_MOVIE":
                return ShowMovieWindow.getInstance();
            case "REMOVE_MOVIE":
                return RemoveMovieWindow.getInstance();
            case "REMOVE_GENRE":
                return RemoveGenreWindow.getInstance();
            case "TRANSACTION":
                return TransactionWindow.getInstance();
            default:
                return null;
        }

    }
}
