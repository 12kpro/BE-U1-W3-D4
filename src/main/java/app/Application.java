package app;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.*;
import lombok.extern.slf4j.Slf4j;
import utils.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
public class Application {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		try {
			EntityManager em = emf.createEntityManager();

			PersonaDAO pDAO = new PersonaDAO(em);
			LocationDAO lDAO = new LocationDAO(em);
			EventoDAO eDAO = new EventoDAO(em);
			PartecipazioneDAO partDAO = new PartecipazioneDAO(em);

			Persona persona = new Persona("Mauro", "Simoni", "spam@12kpro.net", LocalDate.of(1979, 4, 10),
					Sesso.Maschio);
			//pDAO.save(persona);


			Location l1 = new Location("Fontanafredda", "Pordenone");
			Location l2 = new Location("Venezia", "Venezia");
			//lDAO.save(l1);
			//lDAO.save(l2);

			//Evento evento = new Evento("concerto elvenking", "Concerto elvenking Fontanafredda", LocalDate.now(), TipoEvento.PUBBLICO, 250, l1);

			Concerto c1 = new Concerto("concerto elvenking", "Concerto elvenking Fontanafredda", LocalDate.now(),
					TipoEvento.PUBBLICO, 250, l1, Genere.ROCK,true);
			Concerto c2 = new Concerto("concerto Pink Floyd", "Concerto Pink Floyd a Venezia", LocalDate.now(),
					TipoEvento.PUBBLICO, 250, l1, Genere.ROCK,false);
			//eDAO.save(c1);
			//eDAO.save(c2);

			//Partecipazione partecipazione = new Partecipazione(persona, evento, Stato.DA_CONFERMARE);
			//partDAO.save(partecipazione);

			log.info(eDAO.getConcertiInStreaming(false).toString());
			//log.info(eDAO.getById(UUID.fromString("128fd318-0c61-4b60-9470-618d3cbfcfaf")).getPartecipazione().toString());
			// log.info(ev.getById(UUID.fromString("9d77551d-f970-4809-8116-3fc64972c8ba")));
			//System.out.println(ev.getById(UUID.fromString("9d77551d-f970-4809-8116-3fc64972c8ba")));
			//ev.delete(UUID.fromString("935ebec4-7598-4ce6-8821-81d564a833d7"));
		} catch (ExceptionInInitializerError e) {
			log.error(e.getMessage());
		} finally {
			emf.close();
		}
	}
}
