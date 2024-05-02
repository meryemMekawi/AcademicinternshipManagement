package stage.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import stage.entities.Cadre;
import stage.entities.Encadrant;
import stage.entities.Stagiaire;

/**
 * Session Bean implementation class CadreSession
 */
@Stateless
@LocalBean
public class CadreSession implements CadreSessionLocal {
    @PersistenceContext(unitName = "dbstagiaire") 
	EntityManager em;
	
    public CadreSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCadre(Cadre a) {
		em.persist(a);
	}

	@Override
	public void deleteCadre(int Id) {
		Cadre cadre = em.find(Cadre.class, Id);
		em.remove(cadre);
	}

	@Override
	public void updateCadre(Cadre a) {
		em.merge(a);
	}

	@Override
	public List<Cadre> getAllCadre() {
		Query query = em.createQuery("select c from Cadre c");
		return query.getResultList();
	}
	@Override
	public String getNomById(int cadreId) {
	    Query query = em.createQuery("SELECT c.nom FROM Cadre c WHERE c.id = :cadreId");
	    query.setParameter("cadreId", cadreId);

	    List<String> resultList = query.getResultList();
	    if (!resultList.isEmpty()) {
	        return resultList.get(0); // Retourne le nom du cadre correspondant à l'ID
	    } else {
	        return null; // Si aucun nom de cadre correspondant n'est trouvé
	    }
	}
	@Override
	public Cadre getCadreByNom(String nomCadre) {
	    Query query = em.createQuery("SELECT c FROM Cadre c WHERE c.nom = :nomCadre");
	    query.setParameter("nomCadre", nomCadre);

	    List<Cadre> resultList = query.getResultList();
	    if (!resultList.isEmpty()) {
	        return resultList.get(0); // Retourne le cadre correspondant au nom
	    } else {
	        return null; // Si aucun cadre correspondant n'est trouvé
	    }
	}
	@Override
	public Cadre getCadreById(int cadreID) {
		// TODO Auto-generated method stub
		return em.find(Cadre.class, cadreID);
	}
}

