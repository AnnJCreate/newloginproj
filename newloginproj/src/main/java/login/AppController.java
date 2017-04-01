package login;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class AppController {

	public static void main(String[] args) {
		 SpringApplication.run(AppController.class, args);
	}

}
