
package wad.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.FileObject;
import wad.domain.Image;
import wad.repository.FileObjectRepository;
import wad.repository.ImageRepository;

/**
 *
 * @author Kim Martesuo
 */
@Service
public class ImageService {
    
    @Autowired
    private FileObjectRepository fileObjectRepository;
    
    @Autowired
    private ImageRepository imageRepository;
    
    @Autowired
    private ThumbnailMaker thumbnailMaker;
    
    public Image add(Image image, String mediaType, String filename, byte[] data) throws IOException {
        
        //Creates a smaller picture
        BufferedImage smallerImage;
        try {
            smallerImage = Scalr.resize(ImageIO.read(new ByteArrayInputStream(data)),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.FIT_TO_WIDTH,
                    500, 500, Scalr.OP_ANTIALIAS);
        } catch (IOException ex) {
            Logger.getLogger(ThumbnailMaker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(smallerImage, "png", baos);
        } catch (IOException ex) {
            Logger.getLogger(ThumbnailMaker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        byte[] bytes = baos.toByteArray();
        
        //Prepare the file with the smaller picture
        FileObject originalFile = new FileObject();
        originalFile.setContentType(mediaType);
        originalFile.setContent(bytes);
        originalFile.setName(filename);
        originalFile.setContentLength(new Long(data.length));
        
        //Save the file to the DB
        originalFile = fileObjectRepository.save(originalFile);
        
        FileObject thumbnail = null;
        
        //This is where the thumbnail is being made.
        try {
            thumbnail = thumbnailMaker.makeThumbnail(data, filename);       //Make thumbnail
        } catch (Throwable t) {
        }
 
        image.setFile(originalFile);
        image.setThumbnail(fileObjectRepository.save(thumbnail));
 
        return imageRepository.save(image);
    }
}