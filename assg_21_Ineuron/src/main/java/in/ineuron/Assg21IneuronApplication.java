package in.ineuron;

import in.ineuron.entity.Tourist;
import in.ineuron.service.ITouristMgmtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assg21IneuronApplication {

	public static void main(String[] args) {

		ApplicationContext factory = SpringApplication.run(Assg21IneuronApplication.class, args);
		ITouristMgmtService service = factory.getBean(ITouristMgmtService.class);

		Tourist tourist = new Tourist(1,"Singapore","Yogesh","4days 5Nights",23345.6);

		System.out.println(service.registerTourist(tourist));
	}
}

/**
 * Hibernate:
 *     insert
 *     into
 *         tourist1
 *         (budget, city, name, package_type, ticket_id)
 *     values
 *         (?, ?, ?, ?, ?)
 * Tourist is registered having the ticket id :: 1
 */
