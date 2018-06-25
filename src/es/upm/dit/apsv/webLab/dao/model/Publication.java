package es.upm.dit.apsv.webLab.dao.model;

import java.io.Serializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Publication implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private int citeCount;
	
	public Publication() {
	}
	
	public Publication(String id, String title, int citeCount) {
		super();
		this.id = id;
		this.title = title;
		this.citeCount = citeCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCiteCount() {
		return citeCount;
	}

	public void setCiteCount(int citeCount) {
		this.citeCount = citeCount;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", citeCount=" + citeCount+"]";
	}

}
