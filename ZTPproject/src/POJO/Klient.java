package POJO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "KLIENT", schema = "ROOT"
)
public class Klient implements java.io.Serializable {

    private int idKlienta;
    private String imie;
    private String nazwisko;
    private Date dataUrodzenia;
    private Integer idAdresu;
    private String login;
    private String haslo;

    public Klient() {
    }

    public Klient(int idKlienta, String login, String haslo) {
        this.idKlienta = idKlienta;
        this.login = login;
        this.haslo = haslo;
    }

    public Klient(int idKlienta, String imie, String nazwisko, Date dataUrodzenia, Integer idAdresu, String login, String haslo) {
        this.idKlienta = idKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.idAdresu = idAdresu;
        this.login = login;
        this.haslo = haslo;
    }

    @Id

    @Column(name = "ID_KLIENTA", nullable = false, precision = 5, scale = 0)
    public int getIdKlienta() {
        return this.idKlienta;
    }

    public void setIdKlienta(int idKlienta) {
        this.idKlienta = idKlienta;
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
    @Column(name = "DATA_URODZENIA", length = 10)
    public Date getDataUrodzenia() {
        return this.dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @Column(name = "ID_ADRESU", precision = 5, scale = 0)
    public Integer getIdAdresu() {
        return this.idAdresu;
    }

    public void setIdAdresu(Integer idAdresu) {
        this.idAdresu = idAdresu;
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
