package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.repositories.IUsuarioRepositorio;
import com.example.NutreAPP.models.Usuario;

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

    //metodo para buscar por ID

    //metodo para buscar todos

    //metodo para modificar
    
    //metodo para eliminar

    //metodo para buscar por depto y rol

    //metodo para buscar correo

    //metodo para buscar rol

    //metodo para verificar correo

}
