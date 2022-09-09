package uz.jl.trello.trello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TrelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrelloApplication.class, args);
    }

}
