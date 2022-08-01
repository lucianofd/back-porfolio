
package backporfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AcercaDeDto {
    
    private String descripcion;
    private Integer persona_id;
    private String email;
    private String url_red;
    private String url_link;

    public AcercaDeDto() {
    }

    public AcercaDeDto(String descripcion, Integer persona_id, String email, String url_red, String url_link) {
        this.descripcion = descripcion;
        this.persona_id = persona_id;
        this.email = email;
        this.url_red = url_red;
        this.url_link = url_link;
    }

   
    
    
    
}
