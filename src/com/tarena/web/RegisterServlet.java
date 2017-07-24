package com.tarena.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;

public class RegisterServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String email=request.getParameter("email");
		String nickname=request.getParameter("nickname");
		String password=request.getParameter("password");
		UserDAO userDAO= DAOFactory.getUserDAO();
		userDAO.saveUser(email, nickname, password);
		response.sendRedirect("login.jsp");
	}

}
