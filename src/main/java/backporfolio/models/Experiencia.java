
package backporfolio.models;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer experiencia_id;
    @Basic
    private String position;
    private String organization;
    private Date startDate;
    private Date endDate;
    private String description;
    private Boolean actual;
    private String url_image;
    private Integer persona_id;

    public Experiencia() {
    }

    public Experiencia(String position, String organizacion, Date startDate, Date endDate, String description, Boolean actual, String url_image) {
       
        this.position = position;
        this.organization = organizacion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.actual = actual;
        this.url_image = url_image;
        
    }
    
    
    
    
}
