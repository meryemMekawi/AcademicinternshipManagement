package stage.session;

import java.util.List;

import javax.ejb.Local;

import stage.entities.Compte;

@Local
public interface CompteSessionLocal {
	public void addCompte(Compte a);
	public void deleteCompte(int Id);
	public void updateCompte(Compte a);
	public List<Compte> getallCompte();
	public boolean verifyLogin(String username, String password);
	public String getAccountType(String username);
	int getIdCadreByNom(String nomCadre);
	public String getCadreNomByCompteId(String compteId) ;
	void assignCompteToCadre(int compteId, int cadreId);
	Compte getCompteById(int id);}
