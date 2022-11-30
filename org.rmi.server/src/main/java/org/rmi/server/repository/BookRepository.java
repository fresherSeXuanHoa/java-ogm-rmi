package org.rmi.server.repository;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.rmi.server.entity.Book;

public interface BookRepository extends Remote {
	public List<Book> findAll() throws RemoteException;

	public Book findByName(String name) throws RemoteException;

	public boolean save(Book book) throws RemoteException;

	public boolean update(Book book) throws RemoteException;

	public boolean delete(Book book) throws RemoteException;
}
