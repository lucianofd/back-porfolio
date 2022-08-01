
package backporfolio.models;

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
public class AcercaDe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer acerca_id;
    @Basic
    private String descripcion;
    private String email;
    private String url_red;
    private String url_link;
    private Integer persona_id;
    
    public AcercaDe(){
    }

    public AcercaDe(String descripcion, String email, String url_red, String url_link, Integer persona_id) {
        this.descripcion = descripcion;
        this.email = email;
        this.url_red = url_red;
        this.url_link = url_link;
        this.persona_id = persona_id;
    }
    
   
}
