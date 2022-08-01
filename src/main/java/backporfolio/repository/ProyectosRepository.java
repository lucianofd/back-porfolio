
package backporfolio.repository;

import backporfolio.models.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository <Proyectos, Integer> {
    
     Optional <Proyectos> findByProynombre(String proynombre);
    boolean existsByProynombre (String proynombre);
     
}
