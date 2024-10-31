package vn.iotstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import vn.iotstar.configs.SitemeshFilter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<SitemeshFilter> sitemeshFilter () {
		
		FilterRegistrationBean<SitemeshFilter> resgisterBean = new FilterRegistrationBean<SitemeshFilter>();
		resgisterBean.setFilter(new SitemeshFilter());
		resgisterBean.addUrlPatterns("/*");
		
		return resgisterBean;
	}
}
