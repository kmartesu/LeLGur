package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Comment;

/**
 *
 * @author Kim Martesuo
 */
public interface CommentRepository extends JpaRepository<Comment, String> {
    
}
