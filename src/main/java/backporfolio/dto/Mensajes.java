
package backporfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensajes {
    
    private String mensaje;
    
    public Mensajes(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
