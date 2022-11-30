package org.rmi.clent.application;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.rmi.server.repository.BookRepository;
import org.rmi.server.repository.BookTypeRepository;

public class Application {
	public static void main(String[] args) throws RemoteException {
		String RMI_SERVER_URI = null;
		final int RMI_SERVER_PORT = 8080;
		try {
			RMI_SERVER_URI = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.err.println("Client connected to server in address: " + RMI_SERVER_URI + ":" + RMI_SERVER_PORT);

		BookRepository bookService = null;
		BookTypeRepository bookTypeService = null;

		try {
			bookService = (BookRepository) Naming
					.lookup("rmi://" + RMI_SERVER_URI + ":" + RMI_SERVER_PORT + "/bookService");
			bookTypeService = (BookTypeRepository) Naming
					.lookup("rmi://" + RMI_SERVER_URI + ":" + RMI_SERVER_PORT + "/bookTypeService");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
