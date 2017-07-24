package com.tarena.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;

public class CheckEmailServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String email=request.getParameter("email");
		UserDAO userDAO= DAOFactory.getUserDAO();
		User user=userDAO.getUserByEmail(email);
		if(user==null){
			out.write("0");
		}else{
			out.write("1");
		}
	}

}
