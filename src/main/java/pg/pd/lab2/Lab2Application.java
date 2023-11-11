package pg.pd.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Lab 2 application.
 */
@SpringBootApplication(excludeName = {"de.flapdoodle.embed.mongo.spring.autoconfigure.EmbeddedMongoAutoConfiguration"})
public class Lab2Application {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
        SpringApplication.run(Lab2Application.class, args);
    }

}
