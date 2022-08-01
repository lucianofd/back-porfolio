
package backporfolio.repository;

import backporfolio.models.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Integer> {
    
    Optional <Experiencia> findByPosition(String position);
    boolean existsByPosition (String position);
    
}
