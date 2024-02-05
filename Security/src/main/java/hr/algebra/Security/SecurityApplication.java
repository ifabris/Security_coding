package hr.algebra.Security;

import hr.algebra.Security.serialization.SerializationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);

		SerializationImpl serialization = new SerializationImpl();
		serialization.serialize();
		serialization.deserialize();
	}

}
