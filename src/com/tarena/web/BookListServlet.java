package com.tarena.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.dao.BookDAO;
import com.tarena.dao.DAOFactory;

public class BookListServlet extends HttpServlet{
	private static final long serialVersionUID = 1555657103833491636L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		BookDAO bookDAO= DAOFactory.getBookDAO();
		ArrayList books= bookDAO.getBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
	}

}
