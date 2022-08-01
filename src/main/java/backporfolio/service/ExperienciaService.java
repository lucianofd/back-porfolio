
package backporfolio.service;

import backporfolio.models.Experiencia;
import backporfolio.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
     @Autowired
    ExperienciaRepository experienciaRepository;
    
       public List<Experiencia> verExperiencia(){
        return experienciaRepository.findAll();
    }
    
    public void addExperiencia(Experiencia expe){
        experienciaRepository.save(expe);
    }
    
    public void deleteExperiencia(int id){
        experienciaRepository.deleteById(id);
        
    }
   
    
     public Optional<Experiencia> getByPosition(String position){
        return experienciaRepository.findByPosition(position);
    }
     
    public boolean existsByPosition(String position){
        return experienciaRepository.existsByPosition(position);
    } 
    
    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }
    
    public boolean existsById (int id){
        return experienciaRepository.existsById(id);
    }
    
}
