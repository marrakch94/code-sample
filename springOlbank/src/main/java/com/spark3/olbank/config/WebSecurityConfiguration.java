package com.spark3.olbank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final JWTUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.route.authentication.path}")
    private String authenticationPath;

    @Autowired
    public WebSecurityConfiguration(JWTUtil jwtUtil, JwtUserDetailsService jwtUserDetailsService) {
        this.jwtTokenUtil = jwtUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(jwtUserDetailsService)
            .passwordEncoder(passwordEncoderBean());
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        JWTTokenFilter authenticationTokenFilter = new JWTTokenFilter(userDetailsService(), jwtTokenUtil, tokenHeader);

        //httpSecurity.authorizeRequests().antMatchers("/").permitAll(). antMatchers(HttpMethod.POST, "/").permitAll();
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()

                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()

                // Un-secure H2 Database
                .antMatchers("/commentChat/**").permitAll() //StompEndpoint
                .antMatchers("/h2-console/**/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/register/**")
                .permitAll()
                .antMatchers("/auth/**")
                .permitAll()
                .antMatchers("/image/**")
                .permitAll()
                .antMatchers("/signup/**")
                .permitAll()
                .antMatchers("Access-Control-Allow-Origin", "*")
                .permitAll()
                .antMatchers("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS")
                .permitAll()
                .antMatchers("Access-Control-Max-Age", "3600")
                .permitAll()
                .antMatchers("Access-Control-Allow-Headers",
                        "Authorization" + "xsrf-token", "Origin", "Accept",
                        "X-Requested-With", "Content-Type",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers").permitAll()
                .antMatchers("Access-Control-Expose-Headers", "xsrf-token")
                .permitAll()
        ;

        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()  // required to set for H2 else H2 Console will be blank.
                .cacheControl();




    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers(
                    HttpMethod.POST,
                    authenticationPath
            )

            // allow anonymous resource requests
            .and()
            .ignoring()
            .antMatchers(
                    HttpMethod.GET,
                    "/",
                    "/*.html",
                    "/favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js"
            );

    }
}