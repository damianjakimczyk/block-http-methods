package com.dj.bhm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3717469540872593642L;

	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doOptions servlet " + request.getMethod());
		resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}
	
	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("doTrace servlet " + request.getMethod());

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet servlet " + request.getMethod());
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(403);
	}
}
