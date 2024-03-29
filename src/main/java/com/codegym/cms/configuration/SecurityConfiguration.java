package com.codegym.cms.configuration;

import com.codegym.cms.model.repository.UserRepository;
import com.codegym.cms.model.service.impl.UserDetailsServiceImpl;
import com.codegym.cms.security.JwtAuthEntryPoint;
import com.codegym.cms.security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.Filter;

@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {
        UserDetailsServiceImpl.class,
        JwtAuthEntryPoint.class,
        UserRepository.class
})
public class SecurityConfiguration {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Filter jwtAuthenticationFilter() {
        return new JwtAuthFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("**");
        corsConfig.addAllowedHeader("**");
        corsConfig.addAllowedMethod("**");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf()
                .disable();

        http.exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                // configure not use session to save client info
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests() // links start with /api/
                .antMatchers("/api/**", "/api/auth/login","api/car/list","api/car/detail/**") // perform segregate authorize
                .permitAll();

        // Pages require login with role: ROLE_ADMIN.
        // If not login at admin role yet, redirect to /login
        http.authorizeHttpRequests()
                .antMatchers("/api/role/**", "/api/user/**","api/car/**")
                .hasRole("ADMIN");
        /*
        any user have ROLE_EMPLOYEE
         */
        http.authorizeHttpRequests()
                .antMatchers("/api/car/create","/api/car/delete/**")
                .hasRole("EMPLOYEE");

        // Pages require login with role: ROLE_USER
        // If not login at user role yet, redirect to /login
        http.authorizeHttpRequests()
                .antMatchers("/api/user/**")
                .hasRole("CUSTOMER");


        // When user login with ROLE_USER, but try to
        // access pages require ROLE_ADMIN, redirect to /error-403
        http.authorizeHttpRequests().and().exceptionHandling()
                .accessDeniedPage("/access-denied");

        // Configure remember me (save token in database)
        http.authorizeHttpRequests()
                .and().rememberMe()
                .tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(24 * 60 * 60);//24 hours

        // Use JwtAuthorizationFilter to check token -> get user info
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    public PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }
}
