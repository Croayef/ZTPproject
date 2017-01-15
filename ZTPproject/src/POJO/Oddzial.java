package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ODDZIAL", schema = "ROOT"
)
public class Oddzial implements java.io.Serializable {

    private int idOddzialu;
    private String nazwa;
    private String lokalizacja;

    public Oddzial() {
    }

    public Oddzial(int idOddzialu) {
        this.idOddzialu = idOddzialu;
    }

    public Oddzial(int idOddzialu, String nazwa, String lokalizacja) {
        this.idOddzialu = idOddzialu;
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
    }

    @Id

    @Column(name = "ID_ODDZIALU", nullable = false, precision = 5, scale = 0)
    public int getIdOddzialu() {
        return this.idOddzialu;
    }

    public void setIdOddzialu(int idOddzialu) {
        this.idOddzialu = idOddzialu;
    }

    @Column(name = "NAZWA", length = 20)
    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Column(name = "LOKALIZACJA", length = 25)
    public String getLokalizacja() {
        return this.lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
