package com.example.NutreAPP.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;


@Service 
public class VideoServicio {

//INYECCIÓN DE DEPENDENCIAS
    @Autowired 
    private IVideoRepositorio repositorio;


//Método para guardar un video

    public Video guardar (Video datos){
        return this.repositorio.save(datos);
    }

//Método para buscar por ID

     public Video buscarPorId(UUID id){
        Optional<Video> videoBuscado=this.repositorio.findById(id);
        if (!videoBuscado.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
            return videoBuscado.get();
        }

    }

//Método para buscar todos

       public List<Video>buscarTodos(){
        return this.repositorio.findAll();
    }

//metodo para modificar

    public Video modificar(UUID id, Video datos){
        Optional<Video> videoBuscado=this.repositorio.findById(id);
       if (!videoBuscado.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
//1. PRECARGAR LA INFO QUE ESXISTE ACTUALMENTE EN LA BASE DE DATOS
            Video videoEncontrado=videoBuscado.get();

// 2. ESPACIO PARA MODIFICAR SOLO LAS PROPIEDADES PERMITIDAS 
            videoEncontrado.setTitulo(datos.getTitulo());
            videoEncontrado.setDescripcion(datos.getDescripcion());

//3. ESPACIO PARA VOLVER A GUARDAR EL USUARIO QUE SE ACABA DE MODIFICAR

            return this.repositorio.save(videoEncontrado);
            
        }

    }
    
//metodo para eliminar

     public boolean eliminar(UUID id){
         Optional<Video> videoBuscado=this.repositorio.findById(id);
        if (!videoBuscado.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
            this.repositorio.deleteById(id);
            return true;
        }

    }

//Método para buscar categoria

//Método para buscar titulo

//Método para buscar descripcion

//Método para buscar url

//Método para buscar por titulo y categoria 







}
