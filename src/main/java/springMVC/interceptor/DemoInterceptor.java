package springMVC.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {
	//请求发生前
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception{
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	@Override
	//请求发生后
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,ModelAndView modelAndView)throws Exception{
		long startTime = (long)request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("Handling time is: "+new Long(endTime-startTime)+" ms");
		request.setAttribute("handleTime", endTime - startTime);
	}
}
