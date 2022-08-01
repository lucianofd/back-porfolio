
package backporfolio.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

 @Getter @Setter
public class ExperienciaDto {
    
    @NotBlank    
    private String position;
    private String organization;
    private Date startDate;
    private Date endDate;
    @NotBlank
    private String description;
    private Boolean actual;
    private String url_image;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String position, String organization, Date startDate, Date endDate,
            String description, Boolean actual, String url_image) {
        this.position = position;
        this.organization = organization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.actual = actual;
        this.url_image = url_image;
    }
    
    
    
}
