package stage.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Stagiaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int identifiant;
	private String nom;
	private String prenom;
	private String cin;
	private String Etablissement;
	private String filiere;
	private String adresse;
	private String email;
	private Date dateNaissance;
	private long numTelephone;
	private String statut;
	private String departement;
	private  int absence;
	@OneToOne(mappedBy ="stagiaire")
	
	@ManyToOne
	@JoinColumn(name="id_cadre")
	Cadre cadre;
	
	@ManyToOne
	@JoinColumn(name="idStage" )
	Stage stage;
	
	@ManyToOne
	@JoinColumn(name="id_encadrant" )
	Encadrant encadrant;
	
	public int getAbsence() {
		return absence;
	}
	public void setAbsence(int absence) {
		this.absence = absence;
	}
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getEtablissement() {
		return Etablissement;
	}
	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public long getNumTelephone() {
		return numTelephone;
	}
	public void setNumTelephone(long numTelephone) {
		this.numTelephone = numTelephone;
	}

	public Stagiaire() {
		super();
	}

	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public Stagiaire(int identifiant, String nom, String prenom, String cin, String etablissement, String filiere,
			String adresse, String email, Date dateNaissance, long numTelephone, String statut, String departement) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		Etablissement = etablissement;
		this.filiere = filiere;
		this.adresse = adresse;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.numTelephone = numTelephone;
		this.statut = statut;
		this.departement = departement;
		this.cadre = null;
		this.stage = null;
		this.encadrant = null;
		this.setAbsence(0);
	}

	public Cadre getCadre() {
		return cadre;
	}
	public void setCadre(Cadre cadre) {
		this.cadre = cadre;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Encadrant getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(Encadrant encadrant) {
		this.encadrant = encadrant;
	}
	
	
	
	

}
