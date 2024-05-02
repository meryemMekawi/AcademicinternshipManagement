package stage.session;

import java.util.List;

import javax.ejb.Local;

import stage.entities.Cadre;
import stage.entities.Encadrant;
import stage.entities.Stage;
import stage.entities.Stagiaire;

@Local
public interface StagiaireSessionLocal {
	public void addStagiaire(Stagiaire a);
	public void deleteStagiaire(int Id);
	public void updateStagiaire(Stagiaire a);
	public List<Stagiaire> getallStagiaire();
	public Stagiaire getStagiaireById(int stagiaireId);
	public void addStageStagiaire(Stagiaire stagiaire, Encadrant encadrant, Stage stage, Cadre cadre);
	public List<Stagiaire> getAllNouveauStagiaire();
	public List<Stagiaire> getAllArchiveStagiaire();

}
