package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

@Service 
public class VideoServicio {

    //INYECCIÓN DE DEPENDENCIAS
    @Autowired 
    private IVideoRepositorio repositorio;


     //metodo para guardar un video

    public Video guardar (Video datos){
        return this.repositorio.save(datos);
    }

    //metodo para guardar

    //metodo para buscar por ID

    //metodo para buscar todos

    //metodo para modificar
    
    //metodo para eliminar

    //metodo para buscar categoria

    //metodo para buscar titulo

    //metodo para buscar descripcion

    //metodo para buscar url

     //metodo para buscar por titulo y categoria 







}
