package displayers;

import POJO.Film;
import POJO.Gatunek;
import POJO.GatunekFilmId;
import POJO.Nosnik;
import POJO.Rezyser;
import java.util.List;
import java.util.Vector;

public class FilmBasic extends FilmDisplayer {

    protected Vector prepareTable() {
        Vector<String> tableHeaders = new Vector<>();
        tableHeaders.add("Id");
        tableHeaders.add("Tytuł");
        tableHeaders.add("Rok Produkcji");
        tableHeaders.add("Reżyser");
        tableHeaders.add("Nośnik");
        tableHeaders.add("Dostępność");
        return tableHeaders;
    }

    protected Vector showData(List<Film> movies, List<Rezyser> directors, List<Nosnik> carriers, List<Gatunek> genres, List<GatunekFilmId> movieGenres) {
        Vector tableData = new Vector();
        if (!movies.isEmpty()) {
            for (Film o : movies) {
                Vector<Object> oneRow = new Vector<>();
                oneRow.add(o.getIdFilmu());
                oneRow.add(o.getTytul());
                oneRow.add(o.getRokProdukcji());
                for (Rezyser r : directors) {
                    if (r.getIdRezysera() == o.getIdRezysera()) {
                        oneRow.add(r.getNazwisko());
                        break;
                    }
                }
                for (Nosnik n : carriers) {
                    if (n.getIdNosnika() == o.getIdNosnika()) {
                        oneRow.add(n.getTyp());
                        break;
                    }
                }
                if (o.getIlosc() > 0) {
                    oneRow.add("Dostępny");
                } else {
                    oneRow.add("Niedostępny");
                }
                tableData.add(oneRow);
            }
        }
        return tableData;

    }
}
