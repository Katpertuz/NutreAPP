package com.example.NutreAPP.validations;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.repositories.IUsuarioRepositorio;
import com.example.NutreAPP.repositories.IVideoRepositorio;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Component 
public class Visualizacionvalidacion {

    @Autowired 
 private IVisualizacionRepositorio repositorio;

 @Autowired 
    private IUsuarioRepositorio usuarioRepositorio;

@Autowired 
    private IVideoRepositorio videoRepositorio;

 // 1. La fecha de visualizacion es obligatoria.   

 public void validarFechaVisualizacion(LocalDate fechaVisualizacion){
    if (fechaVisualizacion==null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de visualización es obligatoria");

    }
 }


 // 2. La fecha NO puede ser futura (nadie ve un video mañana).  
//     Pista: fecha.isAfter(LocalDate.now())

 public void validarFechaFutura(LocalDate fechaVisualizacion){
    if(fechaVisualizacion!=null && fechaVisualizacion.isAfter(LocalDate.now())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de visualización no puede ser superior a la fecha actual");

    }

 }
 // 3. El campo completado es obligatorio (true o false, no null).
    public void validarCompletado(Boolean completado){
        if (completado==null) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo obligatorio(true o false)");
            
        }

    } 

    // 4. El usuario y el video deben EXISTIR en la BD.                 
//     Pista: inyectar IUsuarioRepositorio e IVideoRepositorio y
//     usar existsById(id)

//4.1 validar que usuario existe en BD
    public void validarUsuarioExiste(UUID usuarioId){
        if(usuarioId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El Id de usuario es obligatorio");
            
        }
        if (!this.usuarioRepositorio.existsById(usuarioId)){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario especificado no existe"); 
         }
    }

//4.2 validar que video existe en la BD
    public void validarVideoExiste(UUID videoId) { 
        if (videoId == null) { 
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de video es obligatorio"); }
        if (!this.videoRepositorio.existsById(videoId)) { 
       throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El video especificado no existe"); }
}





}


    
  