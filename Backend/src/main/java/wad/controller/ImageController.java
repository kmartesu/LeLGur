
package wad.controller;

import java.io.IOException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Comment;
import wad.domain.Image;
import wad.repository.CommentRepository;
import wad.repository.ImageRepository;
import wad.service.CommentService;
import wad.service.ImageService;

/**
 *
 * @author Kim Martesuo
 */
@CrossOrigin(origins = "https://stark-falls-2484.herokuapp.com")
@RestController
@RequestMapping("images")
public class ImageController {
    
    @Autowired
    ImageRepository imageRepository;
    
    @Autowired
    ImageService imageService;
    
    @Autowired
    CommentService commentService;
    
    @Autowired
    CommentRepository commentRepository;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Image> getImages() {
        return imageRepository.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Image getImage(@PathVariable String id) {
        return imageRepository.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Image postImage(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) throws IOException {
        
        Image image = new Image();
        image.setName(name);
        Image img = imageService.add(image, file.getContentType(), file.getOriginalFilename(), file.getBytes());
        return img;
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/{id}")
    public Comment postComment(@PathVariable String id,
                                @RequestParam("poster") String poster, @RequestParam("content") String content) {
        Comment c = new Comment();
        c.setPoster(poster);
        c.setContent(content);
        return commentService.postCommentToImage(c, id);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/comments")
    public Collection<Comment> getComments() {
        return commentRepository.findAll();
    }
}