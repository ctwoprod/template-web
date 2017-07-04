package org.rf.template.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rf.template.constants.Keyword;
import org.rf.template.model.UserInfo;
import org.rf.template.util.SessionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	private static final String LOGOUT = "logout";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		/*if (!uri.endsWith(LOGIN) && !uri.endsWith(LOGOUT)) {
			UserInfo userData = (UserInfo) request.getSession().getAttribute(
					SessionUtil.USER_LOGIN);
			if (userData == null) {
				if (isAjax(request)) {
					response.setStatus(HttpStatus.UNAUTHORIZED.value());
					return false;
				}
				request.setAttribute(Keyword.PESAN, Keyword.SESSION_HABIS);
				request.getRequestDispatcher("/login").forward(request,
						response);
				return false;
			}
		}*/
		return true;
	}

	private boolean isAjax(HttpServletRequest request) {
		String requestedWithHeader = request.getHeader("X-Requested-With");
		return "XMLHttpRequest".equals(requestedWithHeader);
	}
}
