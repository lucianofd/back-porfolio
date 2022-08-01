
package backporfolio.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationDto {
    
    @NotBlank
    private String Institucion;
    @NotBlank
    private String titulo;
    private String url_imgedu;

    public EducationDto() {
    }

    public EducationDto(String Institucion, String titulo, String url_imgedu) {
        this.Institucion = Institucion;
        this.titulo = titulo;
        this.url_imgedu = url_imgedu;
    }
    
    
    
}
