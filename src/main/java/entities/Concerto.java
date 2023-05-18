package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Genere;
import utils.TipoEvento;

import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Concerto extends Evento{
    private Genere genere;
    private Boolean inStreaming;

    public Concerto(String titolo, String descrizione, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Genere genere, Boolean inStreaming) {
        super(titolo, descrizione, dataEvento, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
}
