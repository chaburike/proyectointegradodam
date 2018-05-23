package spring.pintura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ComicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicsApplication.class, args);
	}
}
