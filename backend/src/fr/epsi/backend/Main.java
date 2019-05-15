package fr.epsi.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@SpringBootApplication
public class Main {

    @Configuration
    static class GlobalSecurityConfig extends GlobalAuthenticationConfigurerAdapter {
        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("laplaud")
                    .password("{noop}ronan")
                    .roles("USER")
                    .and()
                    .withUser("admin")
                    .password("{noop}admin")
                    .roles("USER, HERO");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
