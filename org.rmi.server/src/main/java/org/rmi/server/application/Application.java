package org.rmi.server.application;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.NamingException;

import org.rmi.server.service.BookService;
import org.rmi.server.service.BookTypeService;

public class Application {

	public static void main(String[] args) throws RemoteException, NamingException {
		String RMI_SERVER_URL = null;
		final int RMI_SERVER_PORT = 8080;
		try {
			RMI_SERVER_URL = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		try {
			LocateRegistry.createRegistry(RMI_SERVER_PORT);

			Naming.bind("rmi://" + RMI_SERVER_URL + ":" + RMI_SERVER_PORT + "/bookService", new BookService());
			Naming.bind("rmi://" + RMI_SERVER_URL + ":" + RMI_SERVER_PORT + "/bookTypeService", new BookTypeService());

			System.err.println("\nRMI Server is running in address: " + RMI_SERVER_URL + ":" + RMI_SERVER_PORT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
