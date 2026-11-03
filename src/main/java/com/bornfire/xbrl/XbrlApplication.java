package com.bornfire.xbrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bornfire.xbrl.repositories")
@Configuration
@EnableScheduling
@EnableAsync
public class XbrlApplication  extends SpringBootServletInitializer{
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(XbrlApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(XbrlApplication.class, args);
	}

}
