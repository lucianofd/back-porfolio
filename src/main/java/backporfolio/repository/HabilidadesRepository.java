
package backporfolio.repository;

import backporfolio.models.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository <Habilidades, Integer> {
    
    Optional <Habilidades> findByNombrehab(String nombrehab);
    boolean existsByNombrehab (String nombrehab);
    
    
}
