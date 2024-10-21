package ru.netology.springbootconditionalapplication.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootconditionalapplication.profile.DevProfile;
import ru.netology.springbootconditionalapplication.profile.ProductionProfile;
import ru.netology.springbootconditionalapplication.profile.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(name = "ru.netology.profile", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "ru.netology.profile", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
