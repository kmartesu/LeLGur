package wad.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Comment;
import wad.repository.CommentRepository;
import wad.repository.ImageRepository;

/**
 *
 * @author Kim Martesuo
 */
@Service
public class CommentService {
    
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CommentRepository commentRepository;
    
    @Transactional
    public Comment postCommentToImage(Comment comment, String id) {
        
        Comment c = commentRepository.save(comment);
        imageRepository.findById(id).getComments().add(c);
        return c;
    }
}
