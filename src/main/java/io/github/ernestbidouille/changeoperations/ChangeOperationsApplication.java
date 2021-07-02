package io.github.ernestbidouille.changeoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChangeOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangeOperationsApplication.class, args);
	}

	@GetMapping("/ping")
	public String ping() {
		return "Service successfully pinged !";
	}

}
