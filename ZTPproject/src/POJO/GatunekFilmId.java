package POJO;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GatunekFilmId implements java.io.Serializable {

    private int idGatunku;
    private int idFilmu;

    public GatunekFilmId() {
    }

    public GatunekFilmId(int idGatunku, int idFilmu) {
        this.idGatunku = idGatunku;
        this.idFilmu = idFilmu;
    }

    @Column(name = "ID_GATUNKU", nullable = false, precision = 5, scale = 0)
    public int getIdGatunku() {
        return this.idGatunku;
    }

    public void setIdGatunku(int idGatunku) {
        this.idGatunku = idGatunku;
    }

    @Column(name = "ID_FILMU", nullable = false, precision = 5, scale = 0)
    public int getIdFilmu() {
        return this.idFilmu;
    }

    public void setIdFilmu(int idFilmu) {
        this.idFilmu = idFilmu;
    }
}
