
package wad.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kim Martesuo
 */
@Entity
public class Image extends AbstractUUIDPersistable {
    
    private String name;
     
    @Basic(fetch = FetchType.LAZY)     
    @OneToOne                          //Every image has exactly one original file
    private FileObject file;
    @Basic(fetch = FetchType.LAZY)    
    @OneToOne                          //Every image has exactly one thumbnail
    private FileObject thumbnail;
    @OneToMany
    private List<Comment> comments;    //One picture has many comments
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePosted;

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileObject getFile() {
        return file;
    }

    public void setFile(FileObject file) {
        this.file = file;
    }

    public FileObject getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(FileObject thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    public Collection<Comment> getComments() {
        return comments;
    }
    
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}