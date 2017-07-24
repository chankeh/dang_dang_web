package com.tarena.test;

import java.util.ArrayList;

import com.tarena.dao.BookDAO;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.impl.BookDAOImpl;

public class BookDAOTest {
	public static void main(String[] args) {
		BookDAO bookDAO= DAOFactory.getBookDAO();
		ArrayList books= bookDAO.getBooks();
		System.out.println(books.toString());
	}

}
