package poc.config;

import com.fasterxml.jackson.databind.Module;
import javaslang.jackson.datatype.JavaslangModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 23/04/2017.
 */
@Configuration
public class SerializationConfig {

    @Bean
    public Module javaslangModule(){
        return new JavaslangModule();
    }

}
