package displayers;

import java.util.List;
import javax.swing.JTable;
import POJO.Film;
import POJO.Rezyser;
import POJO.Gatunek;
import POJO.GatunekFilmId;
import POJO.Nosnik;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public abstract class FilmDisplayer {

    public void showFilmy(JTable movieTable, List<Film> movies, List<Rezyser> directors, List<Nosnik> carriers, List<Gatunek> genres, List<GatunekFilmId> movieGenres) {

        movieTable.setModel(new DefaultTableModel(showData(movies, directors, carriers, genres, movieGenres), prepareTable()) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        });

    }

    protected abstract Vector prepareTable();

    protected abstract Vector showData(List<Film> movies, List<Rezyser> directors, List<Nosnik> carriers, List<Gatunek> genres, List<GatunekFilmId> movieGenres);
}
