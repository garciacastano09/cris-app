package es.upm.dit.apsv.webLab.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Researcher implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	private String affiliation;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="authors", cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	private Collection<Publication> publications;
	
	public Researcher() {
		this.publications = new ArrayList<Publication> ();		
	}

	public Researcher(String id, String name, String email, String affiliation){
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.affiliation = affiliation;
		this.publications = new ArrayList<Publication> ();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Collection<Publication> publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "Researcher [id=" + id + ", name=" + name + ", email=" + email + ", affiliation=" + affiliation
				+ ", password=" + password + ", publications=" + publications + "]";
	}

}
