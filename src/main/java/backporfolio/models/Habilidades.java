
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
public class Habilidades {   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer habilidades_id;
    @Basic
    private String nombrehab;
    private String nivel;
    private String url_imaghab;
    private Integer persona_id;

    public Habilidades() {
    }

    public Habilidades(String nombrehab, String nivel, String url_imaghab, Integer persona_id) {
      
        this.nombrehab = nombrehab;
        this.nivel = nivel;
        this.url_imaghab = url_imaghab;
        this.persona_id = persona_id;
    }
    
    
    
    
    
    
}
