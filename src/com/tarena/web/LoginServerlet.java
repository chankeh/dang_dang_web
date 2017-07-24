package com.tarena.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;

public class LoginServerlet extends HttpServlet{
	private static final long serialVersionUID = -3123544202808450856L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDAO usedao = DAOFactory.getUserDAO();
	    User user = usedao.isRegisterUser(email,password);
	    if(user==null){
	    	response.sendRedirect("login.jsp");
	    }else{
	        request.getSession().setAttribute("user", user);
	        System.out.println(user.getNickname());
	    	response.sendRedirect("booklist");
	    }
	   
		
	}
     
}
