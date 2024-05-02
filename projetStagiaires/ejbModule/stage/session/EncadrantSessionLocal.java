package stage.session;

import java.util.List;

import javax.ejb.Local;

import stage.entities.Encadrant;

@Local
public interface EncadrantSessionLocal {
	public void addEncadrant(Encadrant a);
	public void deleteEncadrant(int Id);
	public void updateEncadrant(Encadrant a);
	public List<Encadrant> getallEncadrant();
	public Encadrant getEncadrantById(int encadrantId);
	public List<Encadrant> chercherParNom(String nom);
	List<Encadrant> chercherParCIN(String cin);
	public List<Encadrant> getallEncadrantNonAffecter();
}
