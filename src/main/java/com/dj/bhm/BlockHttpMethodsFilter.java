package com.dj.bhm;

import static java.util.Arrays.asList;
import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class BlockHttpMethodsFilter extends OncePerRequestFilter {

	private String blockedHttpMethodsParam;
	
	public BlockHttpMethodsFilter() {
		addRequiredProperty("blockedHttpMethodsParam");
	}
	
	public void setBlockedHttpMethodsParam(String blockedHttpMethodsParam) {
		this.blockedHttpMethodsParam = blockedHttpMethodsParam;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (asList(blockedHttpMethodsParam.split(",")).contains(request.getMethod().toUpperCase())) {
			response.sendError(SC_FORBIDDEN);
		}  else {
			filterChain.doFilter(request, response);	
		}
	}

	

}
