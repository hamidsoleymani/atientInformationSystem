package com.boostmedia.patientinformationsystem.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
public class CustomUserDetailsService {

    /**
     * @Bean public UserDetailsService userDetailsService(PasswordEncoder encoder) {
     * List<UserDetails> usersList = new ArrayList<>();
     * usersList.add(new User("buzz", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
     * usersList.add(new User("woody", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
     * return new InMemoryUserDetailsManager(usersList);
     * }
     */
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User byUsername = userRepo.findByUsername(username);
            if (byUsername != null) return byUsername;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }
}
