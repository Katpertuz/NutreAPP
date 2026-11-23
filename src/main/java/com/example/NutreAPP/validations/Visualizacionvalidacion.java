package com.example.NutreAPP.validations;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Component 
public class Visualizacionvalidacion {

    @Autowired 
 private IVisualizacionRepositorio repositorio;

 // 1. La fecha de visualizacion es obligatoria.   

 public void validarFechaVisualizacion(LocalDate fechaVisualizacion){
    if (fechaVisualizacion==null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de visualización es obligatoria");

    }
 }


 // V2. La fecha NO puede ser futura (nadie ve un video mañana).  
//     Pista: fecha.isAfter(LocalDate.now())

 public void validarFechaFutura(LocalDate fechaVisualizacion){
    if(fechaVisualizacion!=null && fechaVisualizacion.isAfter(LocalDate.now())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de visualización no puede ser superior a la fecha actual");

    }

 }
 // V3. El campo completado es obligatorio (true o false, no null).
    public void validarCompletado(Boolean completado){
        if (completado==null) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo obligatorio(true o false)");
            
        }

    } 
    
}
