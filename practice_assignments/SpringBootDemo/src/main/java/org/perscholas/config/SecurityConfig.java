package org.perscholas.config;

import org.perscholas.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    //these parts of the web page do not require authentication
                    //***will need to add/edit urls to match what i have in project***
                    .antMatchers("/pub/**", "/error/**", "/login/**", "/search").permitAll()
                    //these parts of the web page do require authentication
                    //***will need to edit these urls to match which urls require user authentication***
                    .antMatchers("/admin/**", "/user/**").authenticated()
                    .and()
                .formLogin()
                    //URL for login to display jsp page below
                    //this need to be implemented in the controller
                    .loginPage("/login/login")
                    //URL below is where the login page submits to be processed by Spring Security
                    //this should match the action url on login jsp form
                    .loginProcessingUrl("/login/loginSecurityPost")
                    .and()
                .logout()
                    //removes cookie from the browser and removes user session from tomcat and spring security
                    .invalidateHttpSession(true)
                    //this url logs out the user
                    //this is implemented by spring security and does not need a controller
                    .logoutUrl("/login/logout")
                    //this is where user will be redirected on sucessful logout
                    .logoutSuccessUrl("/login/logoutSuccess")
                    .and()
                .rememberMe()
                    //this configuration is not required for the class or the case study, but is nice to have
                    .key("SR_KEY")
                    .tokenValiditySeconds(60*60*24*2)//seconds equivalent of 2 days
                    .rememberMeParameter("remember-me")
                    .and()
                .exceptionHandling()
                    //url for the access denied page, can customize if desired
                    .accessDeniedPage("/error/404");
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }




















}
