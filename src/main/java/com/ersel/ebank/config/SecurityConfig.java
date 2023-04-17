package com.ersel.ebank.config;

import com.ersel.ebank.business.abstracts.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin= User.withUsername("Ersel")
                .password(encoder.encode("123321"))
                .roles("ADMIN")
                .build();
        UserDetails user= User.withUsername("Tansel")
                .password(encoder.encode("123321"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/api/pages/admin").hasRole("ADMIN")
                        .antMatchers("/api/pages/user").hasRole("USER")
                        .anyRequest().authenticated()
                );
        http
                .formLogin()
                .and()
                .httpBasic();
        return http.build();

    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
