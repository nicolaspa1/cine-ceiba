package com.ceiba.infraestructura.filtro;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = { "/*" })
public class FiltroHeaderSeguridad implements Filter {

	private static final String X_FRAME_OPTIONS = "X-Frame-Options";
	private static final String PRAGMA = "Pragma";
	private static final String X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options";
	private static final String X_XSS_PROTECTION = "X-XSS-Protection";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader(X_XSS_PROTECTION, "1; mode=block");
		httpServletResponse.setHeader(X_CONTENT_TYPE_OPTIONS, "nosniff");
		httpServletResponse.setHeader(PRAGMA, "no-cache");
		httpServletResponse.setHeader(X_FRAME_OPTIONS, "SAMEORIGIN");
		chain.doFilter(request, response);
	}
}