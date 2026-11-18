package com.example.NutreAPP.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.models.Visualizacion;

@Repository 
public interface IVisualizacionRepositorio extends JpaRepository<Visualizacion, UUID> {


    List<Visualizacion> findByFecha_visualizacion(LocalDate fecha_visualizacion);
    List<Visualizacion> findByCompletadoFalse();
    List<Visualizacion> findByCompletadoTrue();


}
