
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Image;

/**
 *
 * @author Kim Martesuo
 */
public interface ImageRepository extends JpaRepository<Image, String>{
    public Image findById(String Id);
}