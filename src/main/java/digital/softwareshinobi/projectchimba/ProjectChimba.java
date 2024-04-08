package digital.softwareshinobi.projectchimba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectChimba {

    public static void main(final String[] commandLineArguments) {

        System.out.println("##");
        System.out.println("## launch > Project Chimba Trading Automation");
        System.out.println("##");

        SpringApplication.run(ProjectChimba.class, commandLineArguments);

    }

}
