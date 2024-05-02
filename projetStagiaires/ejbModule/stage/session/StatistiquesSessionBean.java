package stage.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class StatistiquesSessionBean
 */
@Stateless
@LocalBean
public class StatistiquesSessionBean implements StatistiquesSessionBeanLocal {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Long> getNombreStagiairesParStatut() {
		 List<Long> nombreStagiairesParStatut = new ArrayList<>();

		    //Nouveaux
		    Long nouveauxCount = (Long) em.createQuery("SELECT COUNT(s) FROM Stagiaire s WHERE s.statut = 'Nouveau'")
		                                           .getSingleResult();
		    nombreStagiairesParStatut.add(nouveauxCount);

		    // En cours
		    Long enCoursCount = (Long) em.createQuery("SELECT COUNT(s) FROM Stagiaire s WHERE s.statut = 'En cours'")
		                                          .getSingleResult();
		    nombreStagiairesParStatut.add(enCoursCount);

		    // En archive
		    Long enArchiveCount = (Long) em.createQuery("SELECT COUNT(s) FROM Stagiaire s WHERE s.statut = 'Archive'")
		                                             .getSingleResult();
		    nombreStagiairesParStatut.add(enArchiveCount);

		    return nombreStagiairesParStatut;
	}

	@Override
	public List<Long> getNombreStagesParStatut() {
	    List<Long> nombreStagesParStatut = new ArrayList<>();

		// Affectés
	    Long stagesAffectesCount = (Long) em.createQuery("SELECT COUNT(s) FROM Stage s WHERE s.statut = 'Affecte'")
	                                                   .getSingleResult();
	    nombreStagesParStatut.add(stagesAffectesCount);

	    // Non Affectés
	    Long stagesNonAffectesCount = (Long) em.createQuery("SELECT COUNT(s) FROM Stage s WHERE s.statut = 'Non Affecte'")
	                                                      .getSingleResult();
	    nombreStagesParStatut.add(stagesNonAffectesCount);

	    return nombreStagesParStatut;
	}

	@Override
	public List<Long> getNombreEncadrantsParStatut() {
		   List<Long> nombreEncadrantsParStatut = new ArrayList<>();

		    // Affectés
		    Long encadrantsAffectesCount = (Long) em.createQuery("SELECT COUNT(e) FROM Encadrant e WHERE e.statut = 'Affecte'")
		                                                        .getSingleResult();
		    nombreEncadrantsParStatut.add(encadrantsAffectesCount);

		    // Non Affectés
		    Long encadrantsNonAffectesCount = (Long) em.createQuery("SELECT COUNT(e) FROM Encadrant e WHERE e.statut = 'non Affecte'")
		                                                           .getSingleResult();
		    nombreEncadrantsParStatut.add(encadrantsNonAffectesCount);

		    return nombreEncadrantsParStatut;
	}

    /**
     * Default constructor. 
     */
   

}