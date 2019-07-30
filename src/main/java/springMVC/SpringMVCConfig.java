package springMVC;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springMVC.interceptor.DemoInterceptor;
import springMVC.messageConverter.DemoConverter;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("springMVC")
public class SpringMVCConfig extends WebMvcConfigurerAdapter{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	//添加静态资源映射
	public void addResourceHandlers(ResourceHandlerRegistry registration) {
		registration.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	//添加拦截器
	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("true");
		registry.addInterceptor(demoInterceptor());
	}
	//重定向控制器
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//跳转index.jsp
		registry.addViewController("/").setViewName("/index");
		registry.addViewController("/converter").setViewName("/converter");
		registry.addViewController("/sse").setViewName("/sse");
		registry.addViewController("/aysnc").setViewName("/aysnc");
	}
	//添加消息处理
	@Bean
	public DemoConverter converter() {
		return new DemoConverter();
	}
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
	}
}
