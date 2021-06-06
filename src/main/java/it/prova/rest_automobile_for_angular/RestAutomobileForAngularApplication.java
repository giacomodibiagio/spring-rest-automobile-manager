package it.prova.rest_automobile_for_angular;

import it.prova.rest_automobile_for_angular.model.Automobile;
import it.prova.rest_automobile_for_angular.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class RestAutomobileForAngularApplication implements CommandLineRunner {
    @Autowired
    private AutomobileService automobileService;

    public static void main(String[] args) {
        SpringApplication.run(RestAutomobileForAngularApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // inizializzo il Db
        automobileService.save(new Automobile("Fiat", "Tipo", "AB987UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("28/12/2018"), true));
        automobileService.save(new Automobile("Fiat", "500", "HG987UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("28/09/2018"), true));
        automobileService.save(new Automobile("VW", "Golf", "YU547UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("28/12/2018"), true));
        automobileService.save(new Automobile("Opel", "Tigra", "XX127UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("28/12/1998"), false));

        automobileService.save(new Automobile("Fiat", "500", "RR123UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("28/03/2015"), true));
        automobileService.save(new Automobile("Toyota", "Yaris", "ZZ987UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2018"), true));
        automobileService.save(new Automobile("Peugeot", "208", "JJ789UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("08/12/2017"), true));
        automobileService.save(new Automobile("Opel", "Corsa", "LK987HB",
                new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2018"), false));

        automobileService.save(new Automobile("Fiat", "Punto", "XZ987UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("19/12/2016"), true));
        automobileService.save(new Automobile("Fiat", "500", "BN343MM",
                new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2018"), true));
        automobileService.save(new Automobile("Audi", "A3", "KK547UI",
                new SimpleDateFormat("dd/MM/yyyy").parse("06/06/2019"), true));
        automobileService.save(new Automobile("Renault", "Clio", "BV878HJ",
                new SimpleDateFormat("dd/MM/yyyy").parse("02/04/2020"), false));
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200/"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
