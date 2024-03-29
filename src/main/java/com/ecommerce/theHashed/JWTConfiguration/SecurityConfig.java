package com.ecommerce.theHashed.JWTConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecommerce.theHashed.security.oauth2.CustomOAuth2UserService;
import com.ecommerce.theHashed.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.ecommerce.theHashed.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.ecommerce.theHashed.security.oauth2.OAuth2AuthenticationSuccessHandler;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 	@Autowired
	    CustomUserDetailsService customUserDetailsService;
//	 	@Autowired
//		BCryptPasswordEncoder eEncrypt;
	    @Autowired
	    private JwtAuthenticationEntryPoint unauthorizedHandler;
	    @Autowired
	    private CustomOAuth2UserService customOAuth2UserService;
	    

	    @Autowired
	    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

	    @Autowired
	    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

	    @Bean
	    public JwtAuthenticationFilter jwtAuthenticationFilter() {
	        return new JwtAuthenticationFilter();
	    }
	    
	    @Bean
	    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
	        return new HttpCookieOAuth2AuthorizationRequestRepository();
	    }

	    @Override
	    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	        authenticationManagerBuilder
	                .userDetailsService(customUserDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
	    @Bean(BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .cors()
	                    .and()
	                .csrf()
	                    .disable()
	                .exceptionHandling()
	                    .authenticationEntryPoint(unauthorizedHandler)
	                    .and()
	                .sessionManagement()
	                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                    .and()
	                .authorizeRequests()
	                    .antMatchers("/",
	                        "/favicon.ico",
	                        "/**/*.png",
	                        "/**/*.gif",
	                        "/**/*.svg",
	                        "/**/*.jpg",
	                        "/**/*.html",
	                        "/**/*.css",
	                        "/**/*.js")
	                        .permitAll()
	                    .antMatchers("/auth/**", "/oauth2/**", "/login/**", "/api/**", "/hashedApi/addProducts/**").permitAll()
	                        .antMatchers(HttpMethod.GET, "/api/status/**")
	                        .permitAll()
	                    .anyRequest()
	                        .authenticated()
	                        .and()
	                        .oauth2Login()
	                        .authorizationEndpoint()
	                            .baseUri("/oauth2/authorize")
	                            .authorizationRequestRepository(cookieAuthorizationRequestRepository())
	                            .and()
	                        .redirectionEndpoint()
	                            .baseUri("/oauth2/callback/*")
	                            .and()
	                        .userInfoEndpoint()
	                            .userService(customOAuth2UserService)
	                            .and()
	                        .successHandler(oAuth2AuthenticationSuccessHandler)
	                        .failureHandler(oAuth2AuthenticationFailureHandler);

	        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	    }
}
