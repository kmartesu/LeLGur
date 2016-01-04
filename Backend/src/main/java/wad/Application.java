
package wad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import wad.profiles.DevProfile;
import wad.profiles.ProdProfile;


/**
 *
 * @author Kim Martesuo
 */
@EnableAsync
@EnableCaching
@SpringBootApplication
@Import({DevProfile.class, ProdProfile.class})
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}