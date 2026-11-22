package com.example.NutreAPP.validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.helpers.Categoria;
import com.example.NutreAPP.repositories.IVideoRepositorio;

@Component 
public class VideoValidacion {

     @Autowired 
    private IVideoRepositorio repositorio;

     //1.  Validar titulo obligatorio y entre 5 y 120 caracteres. 
     public void validarTitulo(String titulo){

     if(titulo==null || titulo.trim().isEmpty()){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "titulo obligatorio");
    }

    if(titulo.trim().length()<5 || titulo.trim().length()>120){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El titulo debe tener entre 5 y 120 caracteres");
    }
 }


 // 2. La URL es obligatoria y debe empezar por "http://" o "https://".    
 // Pista: url.startsWith("https://")
 
    public void validarUrl(String url){
        if(url==null || url.trim().isEmpty()){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "URL obligatoria");
    }

    if(!((url.trim().startsWith("https://")||(url.trim().startsWith("http://"))))){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La URL debe empezar por http:// o https://");
    }

}

// 3. La categoria es obligatoria (no puede llegar null).  
    public void validarCategoria(Categoria categoria){
        if (categoria==null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La categoría es obligatoria");
            
        }

    }

}

