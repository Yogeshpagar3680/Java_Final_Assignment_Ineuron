package in.ineuron;

import in.ineuron.service.IUserOrdersMgmtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assignment22Application {

	public static void main(String[] args) {

		SpringApplication.run(Assignment22Application.class, args);
//		ApplicationContext factory = SpringApplication.run(Assignment22Application.class, args);
//		IUserOrdersMgmtService service = factory.getBean(IUserOrdersMgmtService.class);
//
//		service.fetchOrdersByUserId(2).forEach(System.out::println);
	}

}
