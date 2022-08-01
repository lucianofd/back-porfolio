
package backporfolio.service;

import backporfolio.models.Habilidades;
import backporfolio.repository.HabilidadesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadesService {
    
    @Autowired
    HabilidadesRepository habilidadesRepository;
    
       public List<Habilidades> verHabilidades(){
        return habilidadesRepository.findAll();
    }
    
    public void addHabili(Habilidades habil){
        habilidadesRepository.save(habil);
    }
    
    public void deleteHabili(int id){
        habilidadesRepository.deleteById(id);
        
    }
   
    
     public Optional<Habilidades> getByNombrehab(String nombrehab){
        return habilidadesRepository.findByNombrehab(nombrehab);
    }
     
    public boolean existsByNombrehab(String nombrehab){
        return habilidadesRepository.existsByNombrehab(nombrehab);
    } 
    
    public Optional<Habilidades> getOne(int id){
        return habilidadesRepository.findById(id);
    }
    
    public boolean existsById (int id){
        return habilidadesRepository.existsById(id);
    }
    
    
}
