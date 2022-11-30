package org.rmi.server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.rmi.server.entity.BookType;
import org.rmi.server.repository.BookTypeRepository;

public class BookTypeService extends UnicastRemoteObject implements BookTypeRepository {

	private static final long serialVersionUID = 1L;

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	public BookTypeService() throws RemoteException {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookType> findAll() throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			String queryCommand = "db.type.find({})";
			List<BookType> bookTypes = entityManager.createNativeQuery(queryCommand, BookType.class).getResultList();
			entityManager.getTransaction().commit();
			return bookTypes;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public BookType findByID(Long id) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			BookType bookType = entityManager.find(BookType.class, id);
			entityManager.getTransaction().commit();
			return bookType;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public boolean save(BookType bookType) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(bookType);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean update(BookType bookType) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(bookType);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean delete(BookType bookType) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(bookType);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

}
