package com.Serv;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/aaa")
public class MyServlet extends HttpServlet {


	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println("name" + name);
		System.out.println("email" + email);
		PrintWriter out= response.getWriter();
		out.println("name is "+name);
		out.println("email is"+email);
	}

	
}
