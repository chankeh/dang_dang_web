package com.tarena.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet{
	private static final long serialVersionUID = -8724335192163228378L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String numberCode=request.getParameter("numberCode");
		HttpSession session =request.getSession();
		String number=(String)session.getAttribute("number");
		if(numberCode.equals(number)){
			out.write("1");
		}else{
			out.write("0");
		}
	}

}
