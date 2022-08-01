
package backporfolio.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer educ_id;
    @Basic
    private String Institucion;
    private String titulo;
    private String url_imgedu;
    private Integer persona_id;

    public Education() {
    }

    public Education(Integer educ_id, String Institucion, String titulo, String url_imgedu, Integer persona_id) {
        this.educ_id = educ_id;
        this.Institucion = Institucion;
        this.titulo = titulo;
        this.url_imgedu = url_imgedu;
        this.persona_id = persona_id;
    }
   
    public Education(String Institucion, String titulo, String url_imgedu) {
        this.Institucion = Institucion;
        this.titulo = titulo;
        this.url_imgedu = url_imgedu;
    }
    
    
          
    
    
}
