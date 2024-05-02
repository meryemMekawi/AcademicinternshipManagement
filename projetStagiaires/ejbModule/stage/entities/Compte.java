package stage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifiant;
	private String login;
	private String motDePasse;
	private String typeCompte;
	
	@OneToOne
	@JoinColumn(name="cadre_id", unique=true)//Cela veut dire que dans la table Compte dans la base de donnee on va ajouter une cle etragere nommee cadre_id et qui fait reference a compte
	Cadre cadre;
	
	
	
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public Compte(int identifiant, String login, String motDePasse, String typeCompte) {
		super();
		this.identifiant = identifiant;
		this.login = login;
		this.motDePasse = motDePasse;
		this.typeCompte = typeCompte;
	}
	public Compte() {
		super();
	}
	public Cadre getCadre() {
		return cadre;
	}
	public void setCadre(Cadre cadre) {
		this.cadre = cadre;
	}
	
	

}
