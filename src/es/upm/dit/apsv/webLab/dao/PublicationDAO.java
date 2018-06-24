package es.upm.dit.apsv.webLab.dao;

import java.util.List;

import es.upm.dit.apsv.webLab.dao.model.Publication;

public interface PublicationDAO {
	public Publication create(Publication p);
	public Publication read(Publication p);
	public Publication update(Publication p);
	public Publication delete(Publication p);
	
	public List<Publication> search(String searchQuery);
	public List<Publication> readAll();

	public Publication read(String pId);
	
}
