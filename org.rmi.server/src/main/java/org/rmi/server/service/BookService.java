package org.rmi.server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.rmi.server.entity.Book;
import org.rmi.server.repository.BookRepository;

public class BookService extends UnicastRemoteObject implements BookRepository {

	private static final long serialVersionUID = -4925383572557858924L;

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	public BookService() throws RemoteException {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public boolean save(Book book) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(book);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findAll() throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			String queryCommand = "db.book.find({})";
			List<Book> books = entityManager.createNativeQuery(queryCommand, Book.class).getResultList();
			entityManager.getTransaction().commit();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public Book findByID(Long id) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			Book book = entityManager.find(Book.class, id);
			entityManager.getTransaction().commit();
			return book;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public boolean update(Book book) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(book);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean delete(Book book) throws RemoteException {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(book);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}
}
