package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILM", schema = "ROOT"
)
public class Film implements java.io.Serializable {

    private int idFilmu;
    private String tytul;
    private Short rokProdukcji;
    private Long ilosc;
    private Integer idRezysera;
    private Integer idNosnika;

    public Film() {
    }

    public Film(int idFilmu, String tytul) {
        this.idFilmu = idFilmu;
        this.tytul = tytul;
    }

    public Film(int idFilmu, String tytul, Short rokProdukcji, Long ilosc, Integer idRezysera, Integer idNosnika) {
        this.idFilmu = idFilmu;
        this.tytul = tytul;
        this.rokProdukcji = rokProdukcji;
        this.ilosc = ilosc;
        this.idRezysera = idRezysera;
        this.idNosnika = idNosnika;
    }

    @Id

    @Column(name = "ID_FILMU", nullable = false, precision = 5, scale = 0)
    public int getIdFilmu() {
        return this.idFilmu;
    }

    public void setIdFilmu(int idFilmu) {
        this.idFilmu = idFilmu;
    }

    @Column(name = "TYTUL", nullable = false, length = 35)
    public String getTytul() {
        return this.tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    @Column(name = "ROK_PRODUKCJI", precision = 4, scale = 0)
    public Short getRokProdukcji() {
        return this.rokProdukcji;
    }

    public void setRokProdukcji(Short rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    @Column(name = "ILOSC", precision = 10, scale = 0)
    public Long getIlosc() {
        return this.ilosc;
    }

    public void setIlosc(Long ilosc) {
        this.ilosc = ilosc;
    }

    @Column(name = "ID_REZYSERA", precision = 5, scale = 0)
    public Integer getIdRezysera() {
        return this.idRezysera;
    }

    public void setIdRezysera(Integer idRezysera) {
        this.idRezysera = idRezysera;
    }

    @Column(name = "ID_NOSNIKA", precision = 5, scale = 0)
    public Integer getIdNosnika() {
        return this.idNosnika;
    }

    public void setIdNosnika(Integer idNosnika) {
        this.idNosnika = idNosnika;
    }
}
