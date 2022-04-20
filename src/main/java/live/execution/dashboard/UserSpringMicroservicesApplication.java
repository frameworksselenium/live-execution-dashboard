package live.execution.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserSpringMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSpringMicroservicesApplication.class, args);
		System.out.println("Hello World Spring World");
	}

	public static void notification(){
		System.out.println("notification Message");
	}

	public static void notification2(){
		System.out.println("notification Message2");
	}
}
