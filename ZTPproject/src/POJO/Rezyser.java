package POJO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "REZYSER", schema = "ROOT"
)
public class Rezyser implements java.io.Serializable {

    private int idRezysera;
    private String imie;
    private String nazwisko;
    private Date dataUrodzenia;
    private Date dataZgonu;
    private String pochodzenie;

    public Rezyser() {
    }

    public Rezyser(int idRezysera, String nazwisko) {
        this.idRezysera = idRezysera;
        this.nazwisko = nazwisko;
    }

    public Rezyser(int idRezysera, String imie, String nazwisko, Date dataUrodzenia, Date dataZgonu, String pochodzenie) {
        this.idRezysera = idRezysera;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dataZgonu = dataZgonu;
        this.pochodzenie = pochodzenie;
    }

    @Id

    @Column(name = "ID_REZYSERA", nullable = false, precision = 5, scale = 0)
    public int getIdRezysera() {
        return this.idRezysera;
    }

    public void setIdRezysera(int idRezysera) {
        this.idRezysera = idRezysera;
    }

    @Column(name = "IMIE", length = 20)
    public String getImie() {
        return this.imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Column(name = "NAZWISKO", nullable = false, length = 30)
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

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ZGONU", length = 10)
    public Date getDataZgonu() {
        return this.dataZgonu;
    }

    public void setDataZgonu(Date dataZgonu) {
        this.dataZgonu = dataZgonu;
    }

    @Column(name = "POCHODZENIE", length = 30)
    public String getPochodzenie() {
        return this.pochodzenie;
    }

    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }
}
