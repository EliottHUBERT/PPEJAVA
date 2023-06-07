package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compteRendu database table.
 * 
 */
@Entity
@Table(name="compteRendu")
@NamedQuery(name="CompteRendu.findAll", query="SELECT c FROM CompteRendu c")
public class CompteRendu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String confiance;

	private String lisibilite;

	private String probleme;

	//bi-directional many-to-one association to Medecin
	@ManyToOne
	@JoinColumn(name="idMedecin")
	private Medecin medecin;

	//bi-directional many-to-one association to Rendezvous
	@ManyToOne
	@JoinColumn(name="idRDV")
	private Rendezvous rendezvous;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public CompteRendu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfiance() {
		return this.confiance;
	}

	public void setConfiance(String confiance) {
		this.confiance = confiance;
	}

	public String getLisibilite() {
		return this.lisibilite;
	}

	public void setLisibilite(String lisibilite) {
		this.lisibilite = lisibilite;
	}

	public String getProbleme() {
		return this.probleme;
	}

	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Rendezvous getRendezvous() {
		return this.rendezvous;
	}

	public void setRendezvous(Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}