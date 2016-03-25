package Task007.classes;

import Task007.classes.*;
import Task007.interfaces.Cinema;
import Task007.interfaces.Genre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * Created by ruslanzigansin on 24.03.16.
 */
@Configuration
@ComponentScan(value = {"Task007.classes"})
public class Config {
    @Bean
    Film film(){return new Film("Inception", karo(), fantasy());}
    @Bean
    Film film1(){return  new Film("Judgment",imax(),comedy());}
    @Bean
    Film film2(){return new Film("Sinister", dream(),horror());}


    @Bean
    StuntmanActor sactor() {
        return new StuntmanActor("Tom Hardy");
    }

    @Bean
    UnderstudyActor uactor() {
        return new UnderstudyActor("Robert Downey");
    }

    @Bean
    Genre comedy() {
        return new Comedy("Comedy");
    }

    @Bean
    Genre fantasy(){
        return new Fantasy("Fantasy");
    }

    @Bean
    Genre horror() {
        return new Horror("Horror");
    }

    @Bean
    Cinema imax() {
        return new Imax("imax", "Kazan");
    }

    @Bean
    Cinema dream() {
        return new DreamCinema("dreamCinema","Kazan");
    }

    @Bean
    Cinema karo(){
        return new KaroFilm("KaroFilm", "Kazan");
    }
}
