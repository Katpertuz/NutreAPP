package com.example.NutreAPP.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.models.helpers.Departamento;
import com.example.NutreAPP.models.helpers.Rol;

@Repository 
public interface IUsuarioRepositorios extends JpaRepository <Usuario, UUID> {

    //Consultas prefabricadas(Buscar)

    //1. Buscar un usuario, asociado a un departamento y a un rol específico
   List <Usuario>findByDepartamentoAndRol(String departamento, String rol);

   Optional<Usuario>findByCorreo(String correo);

   List<Usuario>findByRolOrderByNombreAsc(String rol);

   Boolean existsByCorreo(String correo);

}
