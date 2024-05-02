package stage.session;

import java.util.List;

import javax.ejb.Local;

import stage.entities.Cadre;
import stage.entities.Stagiaire;

@Local
public interface CadreSessionLocal {
	public void addCadre(Cadre a);
	public void deleteCadre(int Id);
	public void updateCadre(Cadre a);
	public List<Cadre> getAllCadre();
	String getNomById(int cadreId);
	Cadre getCadreByNom(String nomCadre);
	Cadre getCadreById(int cadreID);
	
}


