
package backporfolio.service;

import backporfolio.models.AcercaDe;
import backporfolio.repository.AcercaDeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AcercaService {
    
    @Autowired
    AcercaDeRepository acercaDeRepository;
    
    public List<AcercaDe> verAcercaDe() {
       return acercaDeRepository.findAll();
    }


    public void addAcerca(AcercaDe acerca) {
        acercaDeRepository.save(acerca);
    }

    
    public void deleteAcerca(Integer id) {
        acercaDeRepository.deleteById(id);
    }
    
    public AcercaDe findAcerca(Integer id) {
        return acercaDeRepository.findById(id).orElse(null);
        
    }
     public Optional<AcercaDe> getOne(int id){
        return acercaDeRepository.findById(id);
    }
    
}
