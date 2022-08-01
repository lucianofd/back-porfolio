
package backporfolio.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectosDto {
    
    @NotBlank
    private String proynombre;
    @NotBlank
    private String proy_descripcion;
    private String url_imagproy;
    @NotBlank
    private String url_proy;
    private Integer persona_id;

    public ProyectosDto() {
    }

    public ProyectosDto(String proynombre, String proy_descripcion, String url_imagproy, String url_proy, Integer persona_id) {
        this.proynombre = proynombre;
        this.proy_descripcion = proy_descripcion;
        this.url_imagproy = url_imagproy;
        this.url_proy = url_proy;
        this.persona_id = persona_id;
    }
    
    
    
}
