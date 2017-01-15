package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOSNIK", schema = "ROOT"
)
public class Nosnik implements java.io.Serializable {

    private int idNosnika;
    private String typ;

    public Nosnik() {
    }

    public Nosnik(int idNosnika) {
        this.idNosnika = idNosnika;
    }

    public Nosnik(int idNosnika, String typ) {
        this.idNosnika = idNosnika;
        this.typ = typ;
    }

    @Id

    @Column(name = "ID_NOSNIKA", nullable = false, precision = 5, scale = 0)
    public int getIdNosnika() {
        return this.idNosnika;
    }

    public void setIdNosnika(int idNosnika) {
        this.idNosnika = idNosnika;
    }

    @Column(name = "TYP", length = 20)
    public String getTyp() {
        return this.typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
