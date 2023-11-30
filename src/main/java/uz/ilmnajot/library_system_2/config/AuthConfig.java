package uz.ilmnajot.library_system_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {

    private final PasswordEncoder passwordEncoder;

    public AuthConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public AuthenticationManagerBuilder authenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder passwordEncoder = passwordEncoder();

        UserDetails user = User.builder()
                .username("bilal")
                .password(passwordEncoder.encode("test123"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("merve")
                .password(passwordEncoder.encode("test123"))
                .roles("USER", "ADMIN")
                .build();

        auth.inMemoryAuthentication()
                .withUser(user)
                .withUser(admin);

        return auth;
    }
}
