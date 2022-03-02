package data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDataJPAApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootDataJPAApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJPAApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CelebrityService service) {
		return (args) -> {
			log.info("saving customers");
			service.save(new Celebrity("John Wick"));
			service.save(new Celebrity("Bob Dylan"));

			log.info("Customers found with findAll():");
			for (Celebrity customer : service.findAll()) {
				log.info(customer.toString());
			}

			// fetch an individual by ID
			Celebrity customer = service.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info(customer.toString());

			service.findByName("John Wick").forEach(john -> {
				log.info(john.toString());
			});
		};
	}
}