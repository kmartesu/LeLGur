
package wad.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Kim Martesuo
 */
@Configuration
@Profile(value = {"dev", "default"})
public class DevProfile {
   
}