package uz.jl.trello.trello.config.encoders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:25 (Tuesday)
 * trello/IntelliJ IDEA
 */

@Configuration
public class Encoders {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
