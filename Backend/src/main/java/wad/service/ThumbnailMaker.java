
package wad.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;
import wad.domain.FileObject;

/**
 *
 * @author Kim Martesuo
 */
@Component
public class ThumbnailMaker {
    
    public FileObject makeThumbnail(byte[] data, String filename) {
        BufferedImage thumbnail;
        try {
            thumbnail = Scalr.resize(ImageIO.read(new ByteArrayInputStream(data)),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.FIT_TO_WIDTH,
                    256, 256, Scalr.OP_ANTIALIAS);
        } catch (IOException ex) {
            Logger.getLogger(ThumbnailMaker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(thumbnail, "png", baos);
        } catch (IOException ex) {
            Logger.getLogger(ThumbnailMaker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        byte[] bytes = baos.toByteArray();
 
        //Create a fileobject from the thumbnail
        FileObject fo = new FileObject();
        fo.setContent(bytes);
        fo.setContentLength(new Long(bytes.length));
        fo.setContentType("image/png");
        fo.setName(filename + "-thumb.png");
 
        return fo;
    }
}