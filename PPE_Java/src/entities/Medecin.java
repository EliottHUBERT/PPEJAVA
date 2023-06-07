package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medecin database table.
 * 
 */
@Entity
@Table(name="medecin")
@NamedQuery(name="Medecin.findAll", query="SELECT m FROM Medecin m")
public class Medecin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adresse;

	private String mail;

	private String nom;

	private int tel;

	//bi-directional many-to-one association to CompteRendu
	@OneToMany(mappedBy="medecin")
	private List<CompteRendu> compteRendus;

	//bi-directional many-to-one association to Rendezvous
	@OneToMany(mappedBy="medecin")
	private List<Rendezvous> rendezvouses;

	public Medecin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public List<CompteRendu> getCompteRendus() {
		return this.compteRendus;
	}

	public void setCompteRendus(List<CompteRendu> compteRendus) {
		this.compteRendus = compteRendus;
	}

	public CompteRendu addCompteRendus(CompteRendu compteRendus) {
		getCompteRendus().add(compteRendus);
		compteRendus.setMedecin(this);

		return compteRendus;
	}

	public CompteRendu removeCompteRendus(CompteRendu compteRendus) {
		getCompteRendus().remove(compteRendus);
		compteRendus.setMedecin(null);

		return compteRendus;
	}

	public List<Rendezvous> getRendezvouses() {
		return this.rendezvouses;
	}

	public void setRendezvouses(List<Rendezvous> rendezvouses) {
		this.rendezvouses = rendezvouses;
	}

	public Rendezvous addRendezvous(Rendezvous rendezvous) {
		getRendezvouses().add(rendezvous);
		rendezvous.setMedecin(this);

		return rendezvous;
	}

	public Rendezvous removeRendezvous(Rendezvous rendezvous) {
		getRendezvouses().remove(rendezvous);
		rendezvous.setMedecin(null);

		return rendezvous;
	}

}