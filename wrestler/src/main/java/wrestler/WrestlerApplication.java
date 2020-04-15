package wrestler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@ComponentScan("wrestler")
@SpringBootApplication
public class WrestlerApplication {
	public static void main(String[] args) {
		SpringApplication.run(new Class[]{WrestlerApplication.class, WebApplicationInitializer.class}, args);
	}
}
