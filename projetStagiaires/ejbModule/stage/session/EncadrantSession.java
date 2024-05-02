package stage.session;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import stage.entities.Encadrant;

/**
 * Session Bean implementation class EncadrantSession
 */
@Stateless
@LocalBean
public class EncadrantSession implements EncadrantSessionLocal {
	@PersistenceContext(unitName = "dbstagiaire") 
    EntityManager em;
    public EncadrantSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addEncadrant(Encadrant a) {
		em.persist(a);
	}

	@Override
	public void deleteEncadrant(int Id) {
		Encadrant encadrant = em.find(Encadrant.class, Id);
		em.remove(encadrant);
	}

	@Override
	public void updateEncadrant(Encadrant a) {
		em.merge(a);
	}

	@Override
	public List<Encadrant> getallEncadrant() {
		Query query= em.createQuery("select m from Encadrant m");
		return query.getResultList();
		

	}
	@Override
	public Encadrant getEncadrantById(int encadrantId) {
		// TODO Auto-generated method stub
		return em.find(Encadrant.class, encadrantId);
	}

	@Override
	public List<Encadrant> chercherParNom(String nom) {
	    Query query = em.createQuery("FROM Encadrant e WHERE e.nom = :nom");
	    query.setParameter("nom", nom);
	    return query.getResultList();
		
	}

	@Override
	public List<Encadrant> chercherParCIN(String cin) {
	    Query query = em.createQuery("FROM Encadrant e WHERE e.cin = :cin");
	    query.setParameter("cin", cin);
	    return query.getResultList();

	}

	@Override
	public List<Encadrant> getallEncadrantNonAffecter() {
		TypedQuery<Encadrant> query = em.createQuery("SELECT s FROM Encadrant s WHERE s.statut = :statut", Encadrant.class);
	    query.setParameter("statut", "Non Affecte");
	    return query.getResultList();	}}
