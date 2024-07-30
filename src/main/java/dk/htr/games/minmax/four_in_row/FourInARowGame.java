package dk.htr.games.minmax.four_in_row;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FourInARowGame implements ApplicationRunner {
	static Logger logger = LoggerFactory.getLogger(FourInARowGame.class);
	private NInARowGame nInARowGame;

	public FourInARowGame() throws Exception {
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(FourInARowGame.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
