 
package backporfolio.service;

import backporfolio.models.Education;
import backporfolio.repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService {
    
    @Autowired
    EducationRepository educationRepository;
    
    public List<Education> verEducation(){
        return educationRepository.findAll();
    }
    
    public void addEducation(Education educ){
        educationRepository.save(educ);
    }
    
    public void deleteEducation(int id){
        educationRepository.deleteById(id);
        
    }
   
    
     public Optional<Education> getByTitulo(String titulo){
        return educationRepository.findByTitulo(titulo);
    }
     
    public boolean existsByTitulo(String titulo){
        return educationRepository.existsByTitulo(titulo);
    } 
    
    public Optional<Education> getOne(int id){
        return educationRepository.findById(id);
    }
    
    public boolean existsById (int id){
        return educationRepository.existsById(id);
    }
    
  
    
}
