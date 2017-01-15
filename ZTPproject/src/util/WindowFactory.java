package util;

import windows.AddGenreWindow;
import windows.AddMovieWindow;
import windows.CustomWindowInterface;
import windows.LoginWindow;
import windows.RemoveGenreWindow;
import windows.RemoveMovieWindow;
import windows.ReturnsMovieWindow;
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
            case "RETURN_MOVIE":
                return ReturnsMovieWindow.getInstance();
            case "TRANSACTION":
                return TransactionWindow.getInstance();
            case "ADD_GENRE":
                return AddGenreWindow.getInstance();
            case "REMOVE_GENRE":
                return RemoveGenreWindow.getInstance();
            case "LOGIN":
                return LoginWindow.getInstance();
            default:
                return null;
        }

    }
}
