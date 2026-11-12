package com.example.NutreAPP.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.helpers.Categoria;

@Repository 
public interface IVideoRepositorio extends JpaRepository{


   List<Video> findByCategoria(Categoria categoria);

   List<Video> findByTituloContainingIgnoreCase(String titulo);

   List<Video> findByDescripcionContainingIgnoreCase(String descripcion);

   Optional<Video> findByUrl(String url);

   List<Video> findByTituloAndCategoria(String titulo, Categoria categoria);


}
