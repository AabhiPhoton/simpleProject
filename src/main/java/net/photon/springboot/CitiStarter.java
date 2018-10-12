package net.photon.springboot;

import net.photon.springboot.model.Person;
import net.photon.springboot.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SuppressWarnings({"SpellCheckingInspection", "unused"})
@SpringBootApplication
public class CitiStarter {

    public static void main(String[] args) {
        SpringApplication.run(CitiStarter.class, args);
    }

    @Bean
    public CommandLineRunner dataAdd(PersonRepository repository) {
        return (args) -> {
            repository.save(new Person("Jack", "Bauer"));
            repository.save(new Person("Jane", "Bauer"));
            repository.save(new Person("Mike", "Jackson"));
        };
    }
}