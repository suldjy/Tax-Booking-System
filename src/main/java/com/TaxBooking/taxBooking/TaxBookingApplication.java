package com.TaxBooking.taxBooking;


import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ComponentScan("com.TaxBooking.taxBooking")
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
public class TaxBookingApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TaxBookingApplication.class, args);
	}
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TaxBookingApplication.class);
	}

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory h){
		return h.getSessionFactory();
		
	}
}
