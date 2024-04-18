package com.example.securityspring.configsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails userDetails = User.withUsername("t1").password(passwordEncoder.encode("123456")).build();
        UserDetails userDetails2 = User.withUsername("t2").password(passwordEncoder.encode("123456")).build();
        return new InMemoryUserDetailsManager(userDetails,userDetails2);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        cross size request fore: Chống giả mạo request
        httpSecurity.csrf().disable();
        //không yêu cầu request để vào
        httpSecurity.authorizeHttpRequests().requestMatchers("/register").permitAll();
        // bất kỳ request nào cũng phải đăng nhập
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();

        httpSecurity.httpBasic();
        return httpSecurity.build();
    }
}
