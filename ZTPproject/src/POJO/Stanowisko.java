package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STANOWISKO", schema = "ROOT"
)
public class Stanowisko implements java.io.Serializable {

    private int idStanowiska;
    private String nazwa;
    private Integer pensja;

    public Stanowisko() {
    }

    public Stanowisko(int idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    public Stanowisko(int idStanowiska, String nazwa, Integer pensja) {
        this.idStanowiska = idStanowiska;
        this.nazwa = nazwa;
        this.pensja = pensja;
    }

    @Id

    @Column(name = "ID_STANOWISKA", nullable = false, precision = 5, scale = 0)
    public int getIdStanowiska() {
        return this.idStanowiska;
    }

    public void setIdStanowiska(int idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    @Column(name = "NAZWA", length = 20)
    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Column(name = "PENSJA", precision = 5, scale = 0)
    public Integer getPensja() {
        return this.pensja;
    }

    public void setPensja(Integer pensja) {
        this.pensja = pensja;
    }
}
