package com.seamoon.demo.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Charactor implements Filter {
	private String charactor ;

	public void init(FilterConfig config) throws ServletException {
		String str = config.getInitParameter("encoding");
		if (str != null) {
			charactor = str;
		}

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charactor);
		response.setCharacterEncoding(charactor);
		response.setContentType("text/html;charset=" + charactor);
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
