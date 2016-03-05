package home;

/**
 * Created by Switch on 05.03.2016.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class AppConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("home.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClass country(Jaxb2Marshaller marshaller) {
        CountryClass country = new CountryClass();
        country.setDefaultUri("http://localhost:8080/ws");
        country.setMarshaller(marshaller);
        country.setUnmarshaller(marshaller);
        return  country;

    }
}
