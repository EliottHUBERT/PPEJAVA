package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rendezvous database table.
 * 
 */
@Entity
@Table(name="rendezvous")
@NamedQuery(name="Rendezvous.findAll", query="SELECT r FROM Rendezvous r")
public class Rendezvous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String nom;
	
	private int visited;

	//bi-directional many-to-one association to CompteRendu
	@OneToMany(mappedBy="rendezvous")
	private List<CompteRendu> compteRendus;

	//bi-directional many-to-one association to Medecin
	@ManyToOne
	@JoinColumn(name="idMedecin")
	private Medecin medecin;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Rendezvous() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getVisited() {
		return this.visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}

	public List<CompteRendu> getCompteRendus() {
		return this.compteRendus;
	}

	public void setCompteRendus(List<CompteRendu> compteRendus) {
		this.compteRendus = compteRendus;
	}

	public CompteRendu addCompteRendus(CompteRendu compteRendus) {
		getCompteRendus().add(compteRendus);
		compteRendus.setRendezvous(this);

		return compteRendus;
	}

	public CompteRendu removeCompteRendus(CompteRendu compteRendus) {
		getCompteRendus().remove(compteRendus);
		compteRendus.setRendezvous(null);

		return compteRendus;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}