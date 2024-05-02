package stage.session;

import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import stage.entities.Cadre;
import stage.entities.Encadrant;
import stage.entities.Stage;
import stage.entities.Stagiaire;

/**
 * Session Bean implementation class StagiaireSession
 */
@Stateless
@LocalBean
public class StagiaireSession implements StagiaireSessionLocal {
	@PersistenceContext(unitName = "dbstagiaire") 
    EntityManager em;
	 @EJB
	    EncadrantSessionLocal encadrantsession;

	    @EJB
	    StageSessionLocal stagesession;
    public StagiaireSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addStagiaire(Stagiaire a) {
		em.persist(a);
	}

	@Override
	public void deleteStagiaire(int Id) {
		// TODO Auto-generated method stub
		Stagiaire satgiaire= em.find(Stagiaire.class, Id);
		em.remove(satgiaire);
		
	}

	@Override
	public void updateStagiaire(Stagiaire a) {
		em.merge(a);
		
	}

	@Override
	public List<Stagiaire> getallStagiaire() {
		Query query = em.createQuery("select m from Stagiaire m");
		return query.getResultList();
	}
	// Méthode pour rechercher des stagiaires par leur nom
    public List<Stagiaire> rechercherStagiairesParNom(String nom) {
        String queryString = "SELECT s FROM Stagiaire s WHERE s.nom LIKE :nom";
        TypedQuery<Stagiaire> query = em.createQuery(queryString, Stagiaire.class);
        query.setParameter("nom", "%" + nom + "%");
        return query.getResultList();
    }
  
	@Override
	public Stagiaire getStagiaireById(int stagiaireId) {
		Stagiaire stagiaire =em.find(Stagiaire.class, stagiaireId);
		return stagiaire;
	}

	
		    @Override
		    public void addStageStagiaire(Stagiaire stagiaire, Encadrant encadrant, Stage stage, Cadre cadre) {
		        stagiaire.setEncadrant(encadrant);
		        stagiaire.setStage(stage);
		        stagiaire.setCadre(cadre);
		        stagiaire.setStatut("Affecte"); // Mettre à jour le statut du stagiaire

		        // Mettre à jour le stagiaire dans la base de données
		        updateStagiaire(stagiaire);

		        // Vérifier et mettre à jour le statut de l'encadrant s'il est "Non affecté"
		        if (encadrant.getStatut().equals("Non affecte")) {
		            encadrant.setStatut("Affecte");
		            encadrantsession.updateEncadrant(encadrant); // Mettre à jour l'encadrant dans la base de données
		        }

		        // Vérifier et mettre à jour le statut du stage s'il est "Non affecté"
		        if (stage.getStatut().equals("Non affecte")) {
		            stage.setStatut("Affecte");
		            stagesession.updateStage(stage); // Mettre à jour le stage dans la base de données
		        }
		    }

			@Override
			public List<Stagiaire> getAllNouveauStagiaire() {
				    TypedQuery<Stagiaire> query = em.createQuery("SELECT s FROM Stagiaire s WHERE s.statut = :statut", Stagiaire.class);
				    query.setParameter("statut", "Nouveau");
				    return query.getResultList();
				}

			@Override
			public List<Stagiaire> getAllArchiveStagiaire() {
				TypedQuery<Stagiaire> query = em.createQuery("SELECT s FROM Stagiaire s WHERE s.statut = :statut", Stagiaire.class);
			    query.setParameter("statut", "Archive");
			    return query.getResultList();
			}
	
			
			}
	

	