package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GATUNEK", schema = "ROOT"
)
public class Gatunek implements java.io.Serializable {

    private int idGatunku;
    private String nazwa;

    public Gatunek() {
    }

    public Gatunek(int idGatunku) {
        this.idGatunku = idGatunku;
    }

    public Gatunek(int idGatunku, String nazwa) {
        this.idGatunku = idGatunku;
        this.nazwa = nazwa;
    }

    @Id

    @Column(name = "ID_GATUNKU", nullable = false, precision = 5, scale = 0)
    public int getIdGatunku() {
        return this.idGatunku;
    }

    public void setIdGatunku(int idGatunku) {
        this.idGatunku = idGatunku;
    }

    @Column(name = "NAZWA", length = 20)
    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
