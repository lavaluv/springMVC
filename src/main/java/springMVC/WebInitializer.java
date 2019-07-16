package springMVC;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringMVCConfig.class);
		context.setServletContext(servletContext);
		
		Dynamic servletDynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servletDynamic.addMapping("/");
		servletDynamic.setLoadOnStartup(1);
	}
}
