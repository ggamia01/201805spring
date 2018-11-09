package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PerfomanceCheckInterceptor extends HandlerInterceptorAdapter{
	
	private Logger logger = LoggerFactory.getLogger(PerfomanceCheckInterceptor.class);
	
	//전처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		//다음 인터셉터로 연결
		return true;
	}
	//후처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//controller 메소드의 로직이 종료되고 실행
		long endTime = System.currentTimeMillis();
		long startTime = (long) request.getAttribute("startTime");
		
		logger.debug("duration {} : {}",request.getRequestURI(),(endTime-startTime));
		
	}
}
