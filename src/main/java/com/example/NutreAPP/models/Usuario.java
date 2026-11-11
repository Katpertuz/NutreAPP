package com.example.NutreAPP.models;

import java.util.UUID;

import com.example.NutreAPP.models.helpers.Departamento;
import com.example.NutreAPP.models.helpers.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name="Usuarios")

public class Usuario {


    @Id 
    @GeneratedValue (strategy=GenerationType.UUID)
    private UUID id;

    @Column (name="nombre", nullable = false, unique = false, length = 100)
    private String nombre;

    @Column (name="correo", nullable = false, unique = true, length = 80)
    private String correo;


    @Enumerated (EnumType.STRING)
    @Column (name="rol", nullable = false, unique = false)
    private Rol rol;


    @Enumerated (EnumType.STRING)
    @Column (name="departamento", nullable = false, unique = false)
    private Departamento departamento;

    @Column (name="contraseña", nullable = false, unique = false)
    private String constrasenia_hash;


    public Usuario() {
    }


    public Usuario(UUID id, String nombre, String correo, Rol rol, Departamento departamento,
            String constrasenia_hash) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.departamento = departamento;
        this.constrasenia_hash = constrasenia_hash;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public Rol getRol() {
        return rol;
    }


    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public Departamento getDepartamento() {
        return departamento;
    }


    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    public String getConstrasenia_hash() {
        return constrasenia_hash;
    }


    public void setConstrasenia_hash(String constrasenia_hash) {
        this.constrasenia_hash = constrasenia_hash;
    }

    
    


   



}
