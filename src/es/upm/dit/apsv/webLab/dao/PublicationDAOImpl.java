package es.upm.dit.apsv.webLab.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.webLab.dao.model.Publication;

public class PublicationDAOImpl implements PublicationDAO{

	private static PublicationDAOImpl instance;
	private PublicationDAOImpl() { }
	public static PublicationDAOImpl getInstance() {
		if( null == instance ) instance = new PublicationDAOImpl();
		return instance;
	}
	@Override
	public Publication create(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return p;
	}
	@Override
	public Publication read(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		Publication res = null;
		try {
			res = (Publication) session
			.createQuery("select p from Publication p where p.id=:id")
			.setParameter("id", p.getId())
			.getSingleResult();
		} finally {
			session.close();
		}
		return res;
	}
	@Override
	public Publication update(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(p);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return p;
	}
	@Override
	public Publication delete(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return p;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Publication> search(String searchQuery){
		Session session = SessionFactoryService.get().openSession();
		List<Publication> res = new ArrayList<Publication>();
		try {
			res.addAll(session
					.createQuery("select p from Publication p where p.title like :search")
					.setParameter("search", "%"+searchQuery+"%")
					.getResultList());
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return res;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Publication> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Publication> res = new ArrayList<Publication>();
		try {
			res.addAll(session
					.createQuery("select p from Publication p")
					.getResultList());
		} finally {
			session.close();
		}
		return res;
	}
	@Override
	public Publication read(String pId) {
		Session session = SessionFactoryService.get().openSession();
		Publication res = null;
		try {
			res = (Publication) session
			.createQuery("select p from Publication p where p.id=:id")
			.setParameter("id", pId)
			.getSingleResult();
		} finally {
			session.close();
		}
		return res;
	}

}
