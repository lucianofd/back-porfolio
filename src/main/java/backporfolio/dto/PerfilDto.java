
package backporfolio.dto;


import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PerfilDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;

    public PerfilDto() {
    }

    public PerfilDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
}
