package poc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableRetry
public class Application {


    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    static {
        System.setProperty("spring.profiles.active", "dev");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplicationBuilder(Application.class).build();
        app.run(args);

    }

}