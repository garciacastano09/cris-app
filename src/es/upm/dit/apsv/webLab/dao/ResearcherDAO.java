package es.upm.dit.apsv.webLab.dao;

import java.util.List;

import es.upm.dit.apsv.webLab.dao.model.Researcher;

public interface ResearcherDAO {
	public Researcher create(Researcher r);
	public Researcher read(Researcher r);
	public Researcher update(Researcher r);
	public Researcher delete(Researcher r);
	public List<Researcher> readAll();

	public Researcher read(String rId);
	public Researcher readEmail(String email);
	public Researcher readUser(String email, String pwd);
}