package stage.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import stage.entities.Cadre;
import stage.entities.Stage;

@Stateless
@LocalBean
public class StageSession implements StageSessionLocal {
	@PersistenceContext(unitName = "dbstagiaire") 
    EntityManager em;
    public StageSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addStage(Stage a) {
		em.persist(a);
	}

	@Override
	public void deleteStage(int Id) {
		Stage stage = em.find(Stage.class, Id);
		em.remove(stage);
	}

	@Override
	public void updateStage(Stage a) {
		em.merge(a);
	}

	@Override
	public List<Stage> getallStage() {
		Query query = em.createQuery("select m from Stage m");
		return query.getResultList();
	}
	@Override
	public Stage getStageById(int stageId) {

	    Stage stage =em.find(Stage.class, stageId);
	    return stage;

	}
	public String getIdCadre(int stageId) {
		Query query =em.createQuery("SELECT c.cadre.nom FROM Stage c WHERE c.identifiant = :stageId");
		query.setParameter("stageId", stageId);

	    List<String> resultList = query.getResultList();
	    if (!resultList.isEmpty()) {
	        return resultList.get(0); // Retourne le nom du cadre associé au compte
	    } else {
	        return null; // Si aucun nom de cadre correspondant n'est trouvé
	    }
	}

	@Override
	
	public List<Stage> getallStageNonAffecter() {
	    TypedQuery<Stage> query = em.createQuery("SELECT s FROM Stage s WHERE s.statut = :statut", Stage.class);
	    query.setParameter("statut", "Non Affecte");
	    return query.getResultList();
	}

}
