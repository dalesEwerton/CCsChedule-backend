package br.edu.ufcg.embedded.ccschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"br.edu.ufcg.embedded.ccschedule"})
public class CCsCheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CCsCheduleApplication.class, args);
	}
}
