package config;

import aspects.LoggingAspect;
import aspects.SecurityAspect;
import beans.Parrot;
import beans.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import services.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(
        basePackages = {"proxies", "services", "repositories"}
)
public class ProjectConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public SecurityAspect securityAspect() { return new SecurityAspect(); }
}