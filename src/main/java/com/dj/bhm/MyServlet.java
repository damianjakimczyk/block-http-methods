package com.dj.bhm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	private String message;

	public void init() throws ServletException {
	      message = "Hello World MyServlet aaa";
	   }

	/**
	 * 
	 */
	private static final long serialVersionUID = -3717469540872593642L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      resp.setContentType("text/html");

	      PrintWriter out = resp.getWriter();
	      out.println("<h1>" + message + "</h1>");	
	}
	
	 public void destroy() {
	 }
	
}
