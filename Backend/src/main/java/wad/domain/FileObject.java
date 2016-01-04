package wad.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.OneToOne;

@Entity
public class FileObject extends AbstractPersistable<Long> {
    
    private String name;
    private String contentType;
    private Long contentLength;
    @OneToOne
    private Image image;
    
    @Lob
    @Basic(fetch = FetchType.EAGER)  
    private byte[] content;             

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
    
    
}