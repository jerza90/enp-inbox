package com.enp_inbox.enp_inbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = "com.enp_inbox.enp_inbox")
@EnableJpaAuditing
public class EnpInboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnpInboxApplication.class, args);
	}

}
