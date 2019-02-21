package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Musician;

public class MusicianHelper {

	static	EntityManagerFactory emfactory	=	
			Persistence.createEntityManagerFactory("BandHQ");
	
	public void insertMusician(Musician m) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void insertMusician(List<Musician> selectedMusiciansInList) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(selectedMusiciansInList);
		em.getTransaction().commit();
		em.close();
		
	}
	
		
		public List<Musician> showAllMusicians() {
			EntityManager em = emfactory.createEntityManager();
			List<Musician> allMusicians = em.createQuery("SELECT i FROM Musician i").getResultList();
			System.out.println("");
			return allMusicians;
		}

		public void deleteMusician(Musician toDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Musician> typedQuery = em.createQuery(
					"select m from Musician m where m.firstName = :selectedFirstName and m.lastName = :selectedLastName and m.instrument = :selectedInstrument",
					Musician.class);
			// Substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
			typedQuery.setParameter("selectedLastName", toDelete.getLastName());
			typedQuery.setParameter("selectedInstrument", toDelete.getInstrument());
			// we only want one result
			typedQuery.setMaxResults(1);

			// get the result and save it into a new list item
			Musician result = typedQuery.getSingleResult();

			// remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();

		}

		public void updateMusician(Musician toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
		
		public Musician searchForMusicianById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			Musician found = em.find(Musician.class, idToEdit);
			em.close();
			return found;
		}

		public List<Musician> searchForMusicianByName(String firstName, String lastName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Musician> typedQuery = em.createQuery("select m from Musician m where m.firstName = :selectedFirstName and m.lastName = :selectedLastName", Musician.class);
			typedQuery.setParameter("selectedFirstName", firstName);
			typedQuery.setParameter("selectedLastName", lastName);

			List<Musician> foundMusician = typedQuery.getResultList();
			em.close();
			return foundMusician;
		}

		public List<Musician> searchForMemberByInstrument(String instrumentName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Musician> typedQuery = em.createQuery("select m from Musician m where m.instrument = :selectedInstrument", Musician.class);
			typedQuery.setParameter("selectedInstrument", instrumentName);

			List<Musician> foundMusician = typedQuery.getResultList();
			em.close();
			return foundMusician;
		}
		
		public void cleanUp(){
			emfactory.close();
		
	}

	
	
	
}
