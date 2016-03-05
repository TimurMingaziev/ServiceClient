package home;

/**
 * Created by Switch on 05.03.2016.
 */

import home.wsdl.GetCountryResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        CountryClass country = ctx.getBean(CountryClass.class);

        String countryName = "Poland";
        if (args.length > 0) {
            countryName = args[0];
        }
        GetCountryResponse resp = country.getCountryResponse(countryName);
        if (resp != null) {
            System.out.println("Capital of Poland is: " + '\n');

            country.printResponce(resp);
        }
    }
}