package es;

import es.powerbutton.PowerButton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ElecticalSystemApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
            SpringApplication.run(ElecticalSystemApplication.class, args);

        applicationContext.getBean(PowerButton.class).click();
    }
}
