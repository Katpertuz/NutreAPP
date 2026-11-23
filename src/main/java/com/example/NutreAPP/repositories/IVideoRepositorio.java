package com.example.NutreAPP.repositories;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.helpers.Categoria;

@Repository 
public interface IVideoRepositorio extends JpaRepository<Video, UUID>{


   List<Video> findByCategoria(Categoria categoria);

   List<Video> findByTituloContainingIgnoreCase(String titulo);

   List<Video> findByDescripcionContainingIgnoreCase(String descripcion);

   Optional<Video> findByUrl(String url);

   List<Video> findByTituloAndCategoria(String titulo, Categoria categoria);

   Boolean existsByUrl(String url);

   @Query(value = "SELECT COUNT(*) FROM Videos WHERE url = :url AND id != :id", nativeQuery = true)
    Long contarUrlEnOtroVideo(@Param("url") String url, @Param("id") UUID id);



}
