
package backporfolio.service;

import backporfolio.models.Perfil;
import backporfolio.repository.PerfilRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PerfilService {
    
    @Autowired
    PerfilRepository perfilRepository;
    
    public List<Perfil> verPerfil() {
       return perfilRepository.findAll();
    }


    public void addPerfil(Perfil perf) {
        perfilRepository.save(perf);
    }

    
    public void deletePerfil(int id) {
        perfilRepository.deleteById(id);
    }
    
    public Perfil findPerfil(int id) {
        return perfilRepository.findById(id).orElse(null);
        
    }
    
    public boolean existsById (int id){
        return perfilRepository.existsById(id);
    }
    
    public Optional<Perfil> getOne(int id){
        return perfilRepository.findById(id);
    }
    
    
    //revisar metodo ,necesario?
    public void editPerfil (Perfil perf){
        perfilRepository.save(perf);
    }
    //faltan findby?
}
