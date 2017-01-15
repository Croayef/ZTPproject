package POJO;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GATUNEK_FILM", schema = "ROOT"
)
public class GatunekFilm implements java.io.Serializable {

    private GatunekFilmId id;

    public GatunekFilm() {
    }

    public GatunekFilm(GatunekFilmId id) {
        this.id = id;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "idGatunku", column = @Column(name = "ID_GATUNKU", nullable = false, precision = 5, scale = 0)),
        @AttributeOverride(name = "idFilmu", column = @Column(name = "ID_FILMU", nullable = false, precision = 5, scale = 0))})
    public GatunekFilmId getId() {
        return this.id;
    }

    public void setId(GatunekFilmId id) {
        this.id = id;
    }
}
