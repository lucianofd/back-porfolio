
package backporfolio.security.entity;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//implementa privilegios de usuario

public class UsuarioAdmin implements UserDetails  {
    
    private String nombre; 
    private String nombreUsuario; 
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;  

    public UsuarioAdmin(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    //asigna privilegios, 
    //devuelvo usuario principal, 
    // obtengo roles-los mapeo- accedo desde nombre del rol-lo paso a listado
    //paso clase rol a grantedauthority
    //devulevo usuario principal.
    
    public static UsuarioAdmin build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioAdmin (usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; 
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

  
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
      public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
    
}
