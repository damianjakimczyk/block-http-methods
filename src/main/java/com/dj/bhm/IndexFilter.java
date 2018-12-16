package com.dj.bhm;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class IndexFilter extends OncePerRequestFilter {

	private String indexPageParam;
	
	public IndexFilter() {
		addRequiredProperty("indexPageParam");
	}
	
	public void setIndexPageParam(String indexPageParam) {
		this.indexPageParam = indexPageParam;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("Index Filter");
		 if ((request.getRequestURI().equals(request.getContextPath()) || request.getRequestURI().equals(request.getContextPath() + "/") ) 
				&& request.getMethod().equals("GET")) {
			System.out.println("send redirect ");
			response.sendRedirect(request.getContextPath() + "/" + indexPageParam);
		} else {
			System.out.println("servlet path nie puste");
			filterChain.doFilter(request, response);	
		}
	}

	

}
