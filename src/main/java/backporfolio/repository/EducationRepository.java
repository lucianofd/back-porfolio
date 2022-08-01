
package backporfolio.repository;

import backporfolio.models.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducationRepository extends JpaRepository<Education, Integer>{
    
    Optional <Education> findByTitulo(String titulo);
    boolean existsByTitulo (String titulo);
    
}
