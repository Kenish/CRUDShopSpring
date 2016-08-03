package com.projectmaking.Config;

import com.projectmaking.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailService userDetailService;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    private DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Autowired
    public void ConfigAuthentication (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailService);
        authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/h2/*").permitAll()
                .antMatchers("/api/user").authenticated()
                .antMatchers("/api/cart").permitAll()
                .antMatchers(HttpMethod.POST,"/api/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/products").permitAll()
                .antMatchers("api/test").hasRole("USER")
                .and().formLogin().and().httpBasic()
                .and().csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
