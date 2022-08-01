
package backporfolio.repository;

import backporfolio.models.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcercaDeRepository extends JpaRepository <AcercaDe, Integer> {
    
}
