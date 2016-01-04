
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.FileObject;

/**
 *
 * @author Kim Martesuo
 */
public interface FileObjectRepository extends JpaRepository<FileObject, Long> {
    
}
