package POJO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRACOWNIK", schema = "ROOT"
)
public class Pracownik implements java.io.Serializable {

    private int idPracownika;
    private String imie;
    private String nazwisko;
    private Date dataZatrudnienia;
    private Integer idStanowiska;
    private Integer idOddzialu;
    private String login;
    private String haslo;

    public Pracownik() {
    }

    public Pracownik(int idPracownika, String login, String haslo) {
        this.idPracownika = idPracownika;
        this.login = login;
        this.haslo = haslo;
    }

    public Pracownik(int idPracownika, String imie, String nazwisko, Date dataZatrudnienia, Integer idStanowiska, Integer idOddzialu, String login, String haslo) {
        this.idPracownika = idPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZatrudnienia = dataZatrudnienia;
        this.idStanowiska = idStanowiska;
        this.idOddzialu = idOddzialu;
        this.login = login;
        this.haslo = haslo;
    }

    @Id

    @Column(name = "ID_PRACOWNIKA", nullable = false, precision = 5, scale = 0)
    public int getIdPracownika() {
        return this.idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
    }

    @Column(name = "IMIE", length = 20)
    public String getImie() {
        return this.imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Column(name = "NAZWISKO", length = 25)
    public String getNazwisko() {
        return this.nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ZATRUDNIENIA", length = 10)
    public Date getDataZatrudnienia() {
        return this.dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    @Column(name = "ID_STANOWISKA", precision = 5, scale = 0)
    public Integer getIdStanowiska() {
        return this.idStanowiska;
    }

    public void setIdStanowiska(Integer idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    @Column(name = "ID_ODDZIALU", precision = 5, scale = 0)
    public Integer getIdOddzialu() {
        return this.idOddzialu;
    }

    public void setIdOddzialu(Integer idOddzialu) {
        this.idOddzialu = idOddzialu;
    }

    @Column(name = "LOGIN", nullable = false, length = 20)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "HASLO", nullable = false, length = 20)
    public String getHaslo() {
        return this.haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
