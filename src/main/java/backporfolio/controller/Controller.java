
package backporfolio.controller;

import backporfolio.dto.AcercaDeDto;
import backporfolio.dto.EducationDto;
import backporfolio.dto.ExperienciaDto;
import backporfolio.dto.HabilidadesDto;
import backporfolio.dto.Mensajes;
import backporfolio.dto.PerfilDto;
import backporfolio.dto.ProyectosDto;
import backporfolio.models.AcercaDe;
import backporfolio.models.Education;
import backporfolio.models.Experiencia;
import backporfolio.models.Habilidades;
import backporfolio.models.Perfil;
import backporfolio.models.Proyectos;
import backporfolio.service.AcercaService;
import backporfolio.service.EducationService;
import backporfolio.service.ExperienciaService;
import backporfolio.service.HabilidadesService;
import backporfolio.service.PerfilService;
import backporfolio.service.ProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    
    //perfil----------------
    
    @Autowired
    PerfilService perfilService;
    
    
    @PostMapping ("/perfil/new")
    public void addPerfil (@RequestBody Perfil perf){
        perfilService.addPerfil(perf);  
    }
    
    
    @GetMapping ("/perfil")
    @ResponseBody
    public ResponseEntity<List<Perfil>> List(){
        List<Perfil> list = perfilService.verPerfil();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!perfilService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el perfil"), HttpStatus.NOT_FOUND);
        perfilService.deletePerfil(id);
        return new ResponseEntity(new Mensajes("Perfil eliminado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int  id, @RequestBody PerfilDto perfilDto) {
        if(!perfilService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el perfil"), HttpStatus.NOT_FOUND);
        if(StringUtils.isEmpty(perfilDto.getNombre())   )
         return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
       
        Perfil perf = perfilService.getOne(id).get();
        perf.setNombre(perfilDto.getNombre());
        perfilService.addPerfil(perf);
        
        
        
        return new ResponseEntity(new Mensajes("Producto actualizado"), HttpStatus.OK);
    }
    
    //ACERCADE-----
    
    @Autowired
    AcercaService acercaService;
    

    @PostMapping ("/acerca/new")
    public void addAcerca (@RequestBody AcercaDe acerca){
        acercaService.addAcerca(acerca);  
    }
    
    
    @GetMapping ("/acerca")
    @ResponseBody
    public ResponseEntity<List<AcercaDe>> ListAcerca(){
        List<AcercaDe> list = acercaService.verAcercaDe();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @DeleteMapping("/acerca/delete/{id}")
    public ResponseEntity<?> deleteAcerca(@PathVariable("id") int id){
        acercaService.deleteAcerca(id);
        return new ResponseEntity(new Mensajes("Registro eliminado"), HttpStatus.OK);
    }
    
    @PutMapping("/acerca/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int  id, @RequestBody AcercaDeDto acercaDeDto) {
        
        AcercaDe acerca = acercaService.getOne(id).get();
        acerca.setDescripcion(acercaDeDto.getDescripcion());
        acercaService.addAcerca(acerca);
        
        return new ResponseEntity(new Mensajes("Registro actualizado"), HttpStatus.OK);
    }
    
    
    
    // EDUCATION----------
    
    @Autowired
    EducationService educationService;
    
    
    @GetMapping("/education")
    @ResponseBody
    public ResponseEntity<List<Education>> ListEdu(){
        List<Education> list = educationService.verEducation();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }

   
    @PostMapping("/education/new")
    public ResponseEntity<?> addEducation(@RequestBody EducationDto educationDto) {
        
       if(StringUtils.isEmpty(educationDto.getTitulo())   )
               return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(educationService.existsByTitulo(educationDto.getTitulo()))   
            return new ResponseEntity(new Mensajes("El nombre ya existe"), HttpStatus.BAD_REQUEST);
       
        //revisar
        Education education = new Education(educationDto.getTitulo(), educationDto.getInstitucion(), educationDto.getUrl_imgedu());
        educationService.addEducation(education);
        return new ResponseEntity(new Mensajes("Registro creado"), HttpStatus.OK);
    }
    
  
    
    
    @PutMapping("education/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,   @RequestBody EducationDto educationDto) {
        if(!educationService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        if(StringUtils.isEmpty(educationDto.getTitulo())   )
           return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
       //comprueba que no duplique el nombre, pero que si se pueda actualizar otros campos(aunque el nombre E)(obteng prod obtengo nombre obt id del nombre si es != al ppal es otro)
        if(educationService.existsByTitulo(educationDto.getTitulo()) && educationService.getByTitulo(educationDto.getTitulo()).get().getEduc_id() != id)   
            return new ResponseEntity(new Mensajes("El nombre ya existe,elija otro"), HttpStatus.BAD_REQUEST);
       
        Education education = educationService.getOne(id).get();
        education.setTitulo(educationDto.getTitulo());
        education.setInstitucion(educationDto.getInstitucion());
        education.setUrl_imgedu(educationDto.getUrl_imgedu());
        educationService.addEducation(education);
         
        return new ResponseEntity(new Mensajes("Registro actualizado"), HttpStatus.OK);
    }
   
    
    @DeleteMapping("education/delete/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") int id){
        if(!educationService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        educationService.deleteEducation(id);
        return new ResponseEntity(new Mensajes("Registro eliminado"), HttpStatus.OK);
    }
    
    
    //Experiencia------
    
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/experiencia")
    @ResponseBody
    public ResponseEntity<List<Experiencia>> ListExp(){
        List<Experiencia> list = experienciaService.verExperiencia();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }

    
    @PostMapping("/experiencia/new")
    public ResponseEntity<?> addExperiencia(@RequestBody ExperienciaDto experienciaDto) {
        
       if(StringUtils.isEmpty(experienciaDto.getPosition())   )
               return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      
        Experiencia experiencia = new Experiencia(experienciaDto.getPosition(), experienciaDto.getOrganization(), experienciaDto.getStartDate(),experienciaDto.getEndDate(),
                     experienciaDto.getDescription(),experienciaDto.getActual(), experienciaDto.getUrl_image());
        experienciaService.addExperiencia(experiencia);
        return new ResponseEntity(new Mensajes("Registro creado"), HttpStatus.OK);
    }
    
  
    

    @PutMapping("experiencia/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,   @RequestBody ExperienciaDto experienciaDto) {
        if(!experienciaService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        if(StringUtils.isEmpty(experienciaDto.getPosition())   )
           return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
       //comprueba que no duplique el nombre, pero que si se pueda actualizar otros campos(aunque el nombre E)(obteng prod obtengo nombre obt id del nombre si es != al ppal es otro)
        if(experienciaService.existsByPosition(experienciaDto.getPosition()) && experienciaService.getByPosition(experienciaDto.getPosition()).get().getExperiencia_id() != id)   
            return new ResponseEntity(new Mensajes("El nombre ya existe,elija otro"), HttpStatus.BAD_REQUEST);
       
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setPosition(experienciaDto.getPosition());
        experiencia.setOrganization(experienciaDto.getOrganization());
        experiencia.setStartDate(experienciaDto.getStartDate());
        experiencia.setEndDate(experienciaDto.getEndDate());
        experiencia.setActual(experienciaDto.getActual());
        experiencia.setUrl_image(experienciaDto.getUrl_image());
        experienciaService.addExperiencia(experiencia);
        
        return new ResponseEntity(new Mensajes("Registro actualizado"), HttpStatus.OK);
    }
   
    
    @DeleteMapping("experiencia/delete/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity(new Mensajes("Registro eliminado"), HttpStatus.OK);
    }
     
    //Habilidades----------
    
    @Autowired
    HabilidadesService habilidadesService;
    
    @GetMapping("/habilidades")
    @ResponseBody
    public ResponseEntity<List<Habilidades>> ListHabil(){
        List<Habilidades> list = habilidadesService.verHabilidades();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }

    
    @PostMapping("/habilidades/new")
    public ResponseEntity<?> addHabilidades(@RequestBody HabilidadesDto habilidadesDto) {
        
       if(StringUtils.isEmpty(habilidadesDto.getNombrehab())   )
               return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      
        Habilidades habilidades = new Habilidades(habilidadesDto.getNombrehab(), habilidadesDto.getNivel(), habilidadesDto.getUrl_imaghab(), habilidadesDto.getPersona_id());
        habilidadesService.addHabili(habilidades);
        return new ResponseEntity(new Mensajes("Registro creado"), HttpStatus.OK);
    }
    
  
    

    @PutMapping("habilidades/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,   @RequestBody HabilidadesDto habilidadesDto) {
        if(!habilidadesService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        if(StringUtils.isEmpty(habilidadesDto.getNombrehab())   )
           return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
       //comprueba que no duplique el nombre, pero que si se pueda actualizar otros campos(aunque el nombre E)(obteng prod obtengo nombre obt id del nombre si es != al ppal es otro)
        if(habilidadesService.existsByNombrehab(habilidadesDto.getNombrehab()) && habilidadesService.getByNombrehab(habilidadesDto.getNombrehab()).get().getHabilidades_id() != id)   
            return new ResponseEntity(new Mensajes("El nombre ya existe,elija otro"), HttpStatus.BAD_REQUEST);
       
        Habilidades habilidades = habilidadesService.getOne(id).get();
        habilidades.setNombrehab(habilidadesDto.getNombrehab());
        habilidades.setNivel(habilidadesDto.getNivel());
        habilidades.setUrl_imaghab(habilidadesDto.getUrl_imaghab());
        
        habilidadesService.addHabili(habilidades);
        
        return new ResponseEntity(new Mensajes("Registro actualizado"), HttpStatus.OK);
    }
   
    
    @DeleteMapping("habilidades/delete/{id}")
    public ResponseEntity<?> deleteHabili(@PathVariable("id") int id){
        if(!habilidadesService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        habilidadesService.deleteHabili (id);
        return new ResponseEntity(new Mensajes("Registro eliminado"), HttpStatus.OK);
    }
    
    // Proyectos--------------------
    
    @Autowired
    ProyectosService proyectosService;
    
    @GetMapping("/proyectos")
    @ResponseBody
    public ResponseEntity<List<Proyectos>> ListProy(){
        List<Proyectos> list = proyectosService.verProyectos();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }

    
    @PostMapping("/proyectos/new")
    public ResponseEntity<?> addProy(@RequestBody ProyectosDto proyectosDto) {
        
       if(StringUtils.isEmpty(proyectosDto.getProynombre())   )
               return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      
        Proyectos proyectos = new Proyectos(proyectosDto.getProynombre(),proyectosDto.getProy_descripcion(),proyectosDto.getUrl_imagproy(),
                proyectosDto.getUrl_proy(), proyectosDto.getPersona_id());
        proyectosService.addProy(proyectos);
        return new ResponseEntity(new Mensajes("Registro creado"), HttpStatus.OK);
    }
    
  
    

    @PutMapping("proyectos/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,   @RequestBody ProyectosDto proyectosDto) {
        if(!proyectosService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        if(StringUtils.isEmpty(proyectosDto.getProynombre())   )
           return new ResponseEntity(new Mensajes("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
       //comprueba que no duplique el nombre, pero que si se pueda actualizar otros campos(aunque el nombre E)(obteng prod obtengo nombre obt id del nombre si es != al ppal es otro)
        if(proyectosService.existsByProynombre(proyectosDto.getProynombre()) && proyectosService.getByProynombre(proyectosDto.getProynombre()).get().getProyectos_id() != id)   
            return new ResponseEntity(new Mensajes("El nombre ya existe,elija otro"), HttpStatus.BAD_REQUEST);
       
        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setProynombre(proyectosDto.getProynombre());
        proyectos.setProy_descripcion(proyectosDto.getProy_descripcion());
        proyectos.setUrl_imagproy(proyectosDto.getUrl_imagproy());
        proyectos.setUrl_proy(proyectosDto.getUrl_proy());
        
        proyectosService.addProy(proyectos);
        
        return new ResponseEntity(new Mensajes("Registro actualizado"), HttpStatus.OK);
    }
   
    
    @DeleteMapping("proyectos/delete/{id}")
    public ResponseEntity<?> deleteProy(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
             return new ResponseEntity(new Mensajes("No existe el registro"), HttpStatus.NOT_FOUND);
        proyectosService.deleteProy(id);
        return new ResponseEntity(new Mensajes("Registro eliminado"), HttpStatus.OK);
    }
    
    
    
    
    
    
    
}
