package stage.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Stage implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int identifiant;
	private String sujet;
	private Date date_debut;
	private Date date_fin;
	private String departement;
	private String typestage;
	private String statut;
	@ManyToOne
	@JoinColumn(name="id" )//Nom de la colonne représentant la clé étrangère
	Cadre cadre;
	
	@OneToMany(mappedBy = "stage")
	List<Stagiaire>stagiaire;
	
	
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getTypestage() {
		return typestage;
	}
	public void setTypestage(String typestage) {
		this.typestage = typestage;
	}
	public Stage(int identifiant) {
		super();
		this.identifiant = identifiant;
	}

	public Stage() {
		super();
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Stage(int identifiant, String sujet, Date date_debut, Date date_fin, String departement, String typestage,
			String statut) {
		super();
		this.identifiant = identifiant;
		this.sujet = sujet;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.departement = departement;
		this.typestage = typestage;
		this.statut = statut;
		this.cadre = null;
		this.stagiaire = null;
	}
	public Cadre getCadre() {
		return cadre;
	}
	public void setCadre(Cadre cadre) {
		this.cadre = cadre;
	}
	
	

}
