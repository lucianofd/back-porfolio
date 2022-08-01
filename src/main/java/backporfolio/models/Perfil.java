
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
public class Perfil {
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer persona_id;
    @Basic
    private String nombre;
    private String apellido;
    
    public Perfil(){
        
    }

    public Perfil(Integer persona_id, String nombre, String apellido) {
        this.persona_id = persona_id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
