package POJO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRANSAKCJA", schema = "ROOT"
)
public class Transakcja implements java.io.Serializable {

    private int idTransakcji;
    private Integer idKlienta;
    private Integer idPracownika;
    private Integer idFilmu;
    private Date dataTransakcji;
    private String typ;

    public Transakcja() {
    }

    public Transakcja(int idTransakcji) {
        this.idTransakcji = idTransakcji;
    }

    public Transakcja(int idTransakcji, Integer idKlienta, Integer idPracownika, Integer idFilmu, Date dataTransakcji, String typ) {
        this.idTransakcji = idTransakcji;
        this.idKlienta = idKlienta;
        this.idPracownika = idPracownika;
        this.idFilmu = idFilmu;
        this.dataTransakcji = dataTransakcji;
        this.typ = typ;
    }

    @Id

    @Column(name = "ID_TRANSAKCJI", nullable = false, precision = 5, scale = 0)
    public int getIdTransakcji() {
        return this.idTransakcji;
    }

    public void setIdTransakcji(int idTransakcji) {
        this.idTransakcji = idTransakcji;
    }

    @Column(name = "ID_KLIENTA", precision = 5, scale = 0)
    public Integer getIdKlienta() {
        return this.idKlienta;
    }

    public void setIdKlienta(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }

    @Column(name = "ID_PRACOWNIKA", precision = 5, scale = 0)
    public Integer getIdPracownika() {
        return this.idPracownika;
    }

    public void setIdPracownika(Integer idPracownika) {
        this.idPracownika = idPracownika;
    }

    @Column(name = "ID_FILMU", precision = 5, scale = 0)
    public Integer getIdFilmu() {
        return this.idFilmu;
    }

    public void setIdFilmu(Integer idFilmu) {
        this.idFilmu = idFilmu;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_TRANSAKCJI", length = 10)
    public Date getDataTransakcji() {
        return this.dataTransakcji;
    }

    public void setDataTransakcji(Date dataTransakcji) {
        this.dataTransakcji = dataTransakcji;
    }

    @Column(name = "TYP", length = 10)
    public String getTyp() {
        return this.typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
