package live.execution.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("live.execution.dashboard")
public class UserSpringMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSpringMicroservicesApplication.class, args);
		System.out.println("Hello Spring World");
	}

}
