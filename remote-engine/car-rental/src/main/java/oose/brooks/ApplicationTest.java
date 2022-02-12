package oose.brooks;

import oose.brooks.config.KeycloakIdentityProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;

@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = KeycloakIdentityProvider.class)
})
@Profile({ "test" })
public class ApplicationTest {
    public static void main(String... args) {
        SpringApplication.run(ApplicationTest.class, args);
    }
}