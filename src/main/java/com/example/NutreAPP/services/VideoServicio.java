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
    
    //metodo para eliminar

    //metodo para buscar categoria

    //metodo para buscar titulo

    //metodo para buscar descripcion

    //metodo para buscar url

     //metodo para buscar por titulo y categoria 







}
