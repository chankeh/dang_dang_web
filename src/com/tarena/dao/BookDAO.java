package com.tarena.dao;

import java.util.ArrayList;

import com.tarena.entity.Book;

public interface BookDAO {
	public ArrayList getBooks();
	public Book getBookById(int id);
}
