package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service 
public class VisualizacionServicio {

//INYECCION DE  DEPENDENCIAS

@Autowired 
 private IVisualizacionRepositorio repositorio;


  //metodo para guardar una visualización
 public Visualizacion guardar(Visualizacion datos){
    return this.repositorio.save(datos);

 }


    //metodo para guardar

    //metodo para buscar por ID

    //metodo para buscar todos

    //metodo para modificar
    
    //metodo para eliminar

     //metodo para buscar por fecha de visualizacion

     //metodo para buscar por incompletos
     
     //metodo para buscar por completados



}
