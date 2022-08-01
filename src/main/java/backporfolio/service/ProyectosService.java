
package backporfolio.service;

import backporfolio.models.Proyectos;
import backporfolio.repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    
    @Autowired
    ProyectosRepository proyectosRepository;
    
    public List<Proyectos> verProyectos(){
        return proyectosRepository.findAll();
    }
    
    public void addProy(Proyectos proy){
        proyectosRepository.save(proy);
    }
    
    public void deleteProy(int id){
        proyectosRepository.deleteById(id);
        
    }
   
    
     public Optional<Proyectos> getByProynombre(String proynombre){
        return proyectosRepository.findByProynombre(proynombre);
    }
     
    public boolean existsByProynombre(String proynombre){
        return proyectosRepository.existsByProynombre(proynombre);
    } 
    
    public Optional<Proyectos> getOne(int id){
        return proyectosRepository.findById(id);
    }
    
    public boolean existsById (int id){
        return proyectosRepository.existsById(id);
    }
    
    
}
