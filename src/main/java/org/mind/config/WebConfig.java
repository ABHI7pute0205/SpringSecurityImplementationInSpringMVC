package org.mind.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.mind")
public class WebConfig implements WebMvcConfigurer {

	 @Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver vr = new InternalResourceViewResolver();
	        vr.setPrefix("/WEB-INF/views/");
	        vr.setSuffix(".jsp");
	        return vr;
	    }
	 
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:5173")
	                .allowedMethods("*")
	                .allowedHeaders("*");
	    }
}