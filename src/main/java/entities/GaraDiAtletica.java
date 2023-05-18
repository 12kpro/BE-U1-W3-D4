package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class GaraDiAtletica  extends Evento{
    @ManyToMany
    @JoinTable(name = "partecipanti_atletica", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Persona> persone = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "persona", referencedColumnName = "id")
    private Persona vincitore;

    public GaraDiAtletica(String titolo, String descrizione, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> persone, Persona vincitore) {
        super(titolo, descrizione, dataEvento, tipoEvento, numeroMassimoPartecipanti, location);
        this.persone = persone;
        this.vincitore = vincitore;
    }
}
