package stage.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cadre implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String tel;
	private Date dateNaissance;
	private String adresse;
	private String role;
	
	@OneToMany(mappedBy = "cadre")
	List<Encadrant>encadrant;
	
	@OneToMany(mappedBy="cadre")
	List<Stage>stage;
	
	@OneToOne(mappedBy="cadre")//Cela siginifie qu'on a une relation 1 a 1 entre cadre et Compte . et on a l'attribut cadre dans compte !
	Compte compte;
	
	@OneToMany(mappedBy="cadre")
	List<Stagiaire>stagiaire;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Cadre() {
		super();
	}
	public Cadre(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public String getRoleString() {
		return role;
	}
	public void setRoleString(String roleString) {
		this.role = roleString;
	}
	public Cadre(int id, String nom, String prenom, String tel, Date dateNaissance, String adresse, String role,
			List<Encadrant> encadrant, List<Stage> stage, Compte compte, List<Stagiaire> stagiaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.role = role;
		this.encadrant = encadrant;
		this.stage = stage;
		this.compte = compte;
		this.stagiaire = stagiaire;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	

}
