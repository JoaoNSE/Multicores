package br.mult.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession s = ((HttpServletRequest)request).getSession(false);
		String path = ((HttpServletRequest) request).getRequestURI();
		
		
		if(path.endsWith("login")) {
//			chain.doFilter(request, response);
			if(s != null && s.getAttribute("usuarioLogado") != null) {
				((HttpServletResponse)response).sendRedirect("/");
				return false;
			}
			return true;
			
		} else if(s != null && s.getAttribute("usuarioLogado") != null) {
//			chain.doFilter(request, response);
			return true;
			
		} else if(s != null && s.getAttribute("usuarioLogado") == null){
			//as exceções de páginas que não podem ser acessadas com usuário não autenticado são
			//adicionas aqui nesse if com OU Ex: path.endsWith("logout") || path.endsWith("sobre")
			if(path.endsWith("logout") || path.endsWith("update")) {
				((HttpServletResponse)response).sendRedirect("/");
				return false;
			}
			return true;
				
		} else {
			return true;
		}
		
	}
}
