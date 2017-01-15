package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADRES", schema = "ROOT"
)
public class Adres implements java.io.Serializable {

    private int idAdresu;
    private String ulica;
    private String nrDomu;
    private Integer nrLokalu;
    private String kodPocztowy;
    private String miejscowosc;

    public Adres() {
    }

    public Adres(int idAdresu) {
        this.idAdresu = idAdresu;
    }

    public Adres(int idAdresu, String ulica, String nrDomu, Integer nrLokalu, String kodPocztowy, String miejscowosc) {
        this.idAdresu = idAdresu;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
    }

    @Id

    @Column(name = "ID_ADRESU", nullable = false, precision = 5, scale = 0)
    public int getIdAdresu() {
        return this.idAdresu;
    }

    public void setIdAdresu(int idAdresu) {
        this.idAdresu = idAdresu;
    }

    @Column(name = "ULICA", length = 40)
    public String getUlica() {
        return this.ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Column(name = "NR_DOMU", length = 10)
    public String getNrDomu() {
        return this.nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    @Column(name = "NR_LOKALU", precision = 5, scale = 0)
    public Integer getNrLokalu() {
        return this.nrLokalu;
    }

    public void setNrLokalu(Integer nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    @Column(name = "KOD_POCZTOWY", length = 6)
    public String getKodPocztowy() {
        return this.kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Column(name = "MIEJSCOWOSC", length = 30)
    public String getMiejscowosc() {
        return this.miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }
}
