package com.example.NutreAPP.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.repositories.IUsuarioRepositorio;
import com.example.NutreAPP.models.Usuario;
import java.util.UUID;
import java.util.List;

@Service 
public class UsuarioServicio {


    //para cocinar necesito la receta
    //Para programar los servicios, necesito los repositorios

    //INYECCIÓN DE DEPENDENCIAS
    @Autowired 
    private IUsuarioRepositorio repositorio;

    //metodo para guardar un usuario

    public Usuario guardar(Usuario datos){
         return this.repositorio.save(datos);
    }

    //Método para buscar por ID

    public Usuario buscarPorId(UUID id){
        Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
        if (!usuarioBuscado.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
            return usuarioBuscado.get();
        }

    }

    //Método para buscar todos

    public List<Usuario>buscarTodos(){
        return this.repositorio.findAll();
    }

    //Método para modificar/ actualizar

    public Usuario modificar(UUID id, Usuario datos){
        Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
       if (!usuarioBuscado.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
            //1. PRECARGAR LA INFO QUE ESXISTE ACTUALMENTE EN LA BASE DE DATOS
            Usuario usuarioEncontrado=usuarioBuscado.get();

            // 2. ESPACIO PARA MODIFICAR SOLO LAS PROPIEDADES PERMITIDAS 
            usuarioEncontrado.setNombre(datos.getNombre());
            usuarioEncontrado.setRol(datos.getRol());

            //3. ESPACIO PARA VOLVER A GUARDAR EL USUARIO QUE SE ACABA DE MODIFICAR

            return this.repositorio.save(usuarioEncontrado);
            
        }

    }

    
    //Método para eliminar

    public boolean eliminar(UUID id){
         Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
        if (!usuarioBuscado.isPresent()) {
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"Id no encontrado");
        }else {
            this.repositorio.deleteById(id);
            return true;
        }

    }

    //metodo para buscar por depto y rol

    //metodo para buscar correo

    //metodo para buscar rol

    //metodo para verificar correo

}
