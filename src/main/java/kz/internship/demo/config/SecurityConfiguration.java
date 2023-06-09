package kz.internship.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * General Security Configuration.
 *
 * @author shabdan
 * Date: 6/9/2022
 */
@Configuration
public class SecurityConfiguration {

    /**
     * Security Filter Chain Configuration.
     *
     * @return Configured SecurityFilterChain.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/v1/**")
                .permitAll()
                .and()
                .csrf().disable();

        return http.build();
    }

    /**
     * Password Encoder Bean.
     *
     * @return new BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
