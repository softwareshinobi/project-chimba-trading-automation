package digital.softwareshinobi.projectchimba.usherrule;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectChimba {

    public static void main(final String[] commandLineArguments) throws IOException {

        System.out.println("launch > ProjectPajaUsherRule");

        SpringApplication.run(ProjectChimba.class, commandLineArguments);

    }

}
