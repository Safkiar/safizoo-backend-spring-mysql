package com.safizoo.safiizoo_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Adjust mapping as needed.  `/**` will match all endpoints
                        .allowedOrigins("http://localhost:4200", "https://safizoo.netlify.app") // Or use your specific origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Adjust as needed
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }
}