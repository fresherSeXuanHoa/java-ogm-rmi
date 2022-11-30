package org.rmi.server.repository;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.rmi.server.entity.BookType;

public interface BookTypeRepository extends Remote {
	public List<BookType> findAll() throws RemoteException;

	public BookType findByID(Long id) throws RemoteException;

	public boolean save(BookType bookType) throws RemoteException;

	public boolean update(BookType bookType) throws RemoteException;

	public boolean delete(BookType bookType) throws RemoteException;
}
