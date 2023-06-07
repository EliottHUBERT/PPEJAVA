package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String login;

	private String password;

	private String role;

	//bi-directional many-to-one association to CompteRendu
	@OneToMany(mappedBy="user")
	private List<CompteRendu> compteRendus;

	//bi-directional many-to-one association to Rendezvous
	@OneToMany(mappedBy="user")
	private List<Rendezvous> rendezvouses;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<CompteRendu> getCompteRendus() {
		return this.compteRendus;
	}

	public void setCompteRendus(List<CompteRendu> compteRendus) {
		this.compteRendus = compteRendus;
	}

	public CompteRendu addCompteRendus(CompteRendu compteRendus) {
		getCompteRendus().add(compteRendus);
		compteRendus.setUser(this);

		return compteRendus;
	}

	public CompteRendu removeCompteRendus(CompteRendu compteRendus) {
		getCompteRendus().remove(compteRendus);
		compteRendus.setUser(null);

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
		rendezvous.setUser(this);

		return rendezvous;
	}

	public Rendezvous removeRendezvous(Rendezvous rendezvous) {
		getRendezvouses().remove(rendezvous);
		rendezvous.setUser(null);

		return rendezvous;
	}

}