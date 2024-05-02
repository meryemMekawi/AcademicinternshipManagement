package stage.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import stage.entities.Cadre;
import stage.entities.Compte;

/**
 * Session Bean implementation class CompteSession
 */
@Stateless
@LocalBean
public class CompteSession implements CompteSessionLocal {
	@PersistenceContext(unitName = "dbstagiaire") 
    EntityManager em;
    public CompteSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCompte(Compte a) {
		em.persist(a);
	}

	@Override
	public void deleteCompte(int Id) {
		Compte compte = em.find(Compte.class, Id);
		em.remove(compte);
	}

	@Override
	public void updateCompte(Compte a) {
		em.merge(a);
	}

	@Override
	public List<Compte> getallCompte() {
		Query query = em.createQuery("select m from Compte m");
		return query.getResultList();
	}

	@Override
    public boolean verifyLogin(String username, String password) {
        Query query = em.createQuery("SELECT c FROM Compte c WHERE c.login = :username AND c.motDePasse = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        
        List<Compte> resultList = query.getResultList();
        return !resultList.isEmpty(); // Si la liste n'est pas vide, les informations de connexion sont valides
    }
	public String getAccountType(String username) {
        Query query = em.createQuery("SELECT c.typeCompte FROM Compte c WHERE c.login = :username");
        query.setParameter("username", username);

        List<String> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0); // Retourne le premier élément de la liste (le type de compte)
        } else {
            return null; // Si aucun compte correspondant n'est trouvé
        }
    }
	@Override
	public String getCadreNomByCompteId(String compteId) {
	    Query query = em.createQuery("SELECT c.cadre.nom FROM Compte c WHERE c.login = :compteId");
	    query.setParameter("compteId", compteId);

	    List<String> resultList = query.getResultList();
	    if (!resultList.isEmpty()) {
	        return resultList.get(0); // Retourne le nom du cadre associé au compte
	    } else {
	        return null; // Si aucun nom de cadre correspondant n'est trouvé
	    }
	}

	@Override
	public int getIdCadreByNom(String login) {
	    Query query = em.createQuery("SELECT c.cadre.id FROM Compte c WHERE c.login = :login\r\n"
	    		+ "");
	    query.setParameter("login", login);

	    List<Integer> resultList = query.getResultList();
	    if (!resultList.isEmpty()) {
	        return resultList.get(0); // Retourne l'ID du cadre correspondant au nom
	    } else {
	        return -1; // Si aucun ID de cadre correspondant n'est trouvé pour ce nom
	    }
	}
	@Override
	public Compte getCompteById(int id) {
		
		Compte compte=em.find(Compte.class, id);
		return compte;
	}

	@Override
	public void assignCompteToCadre(int compteId, int cadreId) {
		Compte compte = em.find(Compte.class, compteId);
        Cadre cadre = em.find(Cadre.class, cadreId);

        // Check if the Compte is not already associated with a Cadre
        if (compte.getCadre() == null) {
            // Assign the Compte to the Cadre
            compte.setCadre(cadre);
            cadre.setCompte(compte);
        }
		
	}

}
