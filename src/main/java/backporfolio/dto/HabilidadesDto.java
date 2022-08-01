
package backporfolio.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadesDto {
    
    @NotBlank
    private String nombrehab;
    
    private String nivel;
    private String url_imaghab;
    private Integer persona_id;

    public HabilidadesDto() {
    }

    public HabilidadesDto(String nombrehab, String nivel, String url_imaghab) {
        this.nombrehab = nombrehab;
        this.nivel = nivel;
        this.url_imaghab = url_imaghab;
    }
    
    

    
}
