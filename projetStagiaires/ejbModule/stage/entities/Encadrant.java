package stage.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Encadrant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int identifiant;
	private String nom ;
	private String prenom;
	private String departement;
	private String statut;
	private String Cin;
	private String Email;
	
	
	@ManyToOne
	@JoinColumn(name="id")
	Cadre cadre;
	
	@OneToMany(mappedBy = "encadrant")
	List<Stagiaire> stagiaire;
	
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public Encadrant() {
		super();
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Encadrant(int identifiant, String nom, String prenom, String departement, String statut, Cadre cadre,
			List<Stagiaire> stagiaire) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.statut = statut;
		this.cadre = cadre;
		this.stagiaire = stagiaire;
	}
	public String getCin() {
		return Cin;
	}
	public void setCin(String cin) {
		Cin = cin;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

}
