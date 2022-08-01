
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
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer proyectos_id;
    @Basic
    private String proynombre;
    private String proy_descripcion;
    private String url_imagproy;
    private String url_proy;
    private Integer persona_id;

    public Proyectos() {
    }

    public Proyectos(String proynombre, String proy_descripcion, String url_imagproy, String url_proy, Integer persona_id) {
       
        this.proynombre = proynombre;
        this.proy_descripcion = proy_descripcion;
        this.url_imagproy = url_imagproy;
        this.url_proy = url_proy;
        this.persona_id = persona_id;
    }
    
    
    
}
