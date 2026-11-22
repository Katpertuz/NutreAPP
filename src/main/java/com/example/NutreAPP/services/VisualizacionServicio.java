package com.example.NutreAPP.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service 
public class VisualizacionServicio {

//INYECCION DE  DEPENDENCIAS

@Autowired 
 private IVisualizacionRepositorio repositorio;


//Método para guardar una visualización
 public Visualizacion guardar(Visualizacion datos){
    return this.repositorio.save(datos);

 }


//Método para buscar por ID

     public Visualizacion buscarPorId(UUID id){
        Optional<Visualizacion> visualizacionBuscada=this.repositorio.findById(id);
        if (!visualizacionBuscada.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
            return visualizacionBuscada.get();
        }

    }

//Método para buscar todos


        public List<Visualizacion>buscarTodos(){
        return this.repositorio.findAll();
    }

//Método para modificar/ actualizar(SIN METODO DE MODIFICAR)

    
    
//Método para eliminar

     public boolean eliminar(UUID id){
         Optional<Visualizacion> visualizacionBuscado=this.repositorio.findById(id);
        if (!visualizacionBuscado.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
            this.repositorio.deleteById(id);
            return true;
        }

    }

//Método para buscar por fecha de visualizacion

//Método para buscar por incompletos
     
//Método para buscar por completados



}
