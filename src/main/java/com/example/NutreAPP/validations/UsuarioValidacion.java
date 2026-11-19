package com.example.NutreAPP.validations;
import com.example.NutreAPP.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


import com.example.NutreAPP.repositories.IUsuarioRepositorio;



@Component 
public class UsuarioValidacion {
 // Validaciones de formarto(tipos de datos que no son, campos obligatorios que no llegan,)


@Autowired 
    private IUsuarioRepositorio repositorio;



 //1. Validar que un campo sea obligatorio

 public void validarTextoObligatorio(String valor, String campo){
    if(valor==null || valor.isBlank()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo"+"es obligatorio");

    }

 }

 // 2. Validar la logitud de un nombre

 public void validarNombre(String nombre){
    if(nombre.trim().length()<3 || nombre.trim().length()>100){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe tener entre 3 y 100 caracteres");
    }
 }


 //3. Expresiones regulares para validar que un correo si sea un correo
 //algo@algo.algo

 public void validarCorreo(String correo){
    if(!correo.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo no cumple el formato esperado");

    }
 }

 // 4.Validar que la contraseña tengo mínimo 8 caractres
public void validarContraseña(String contraseña){
    if (contraseña.length()<8) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La contraseña debe tener mínimo 8 caractéres");
        
    }

}



 //Validaciones del negocio(asociadas a la lógico, ejemplo: usuario con correo que ya existe)

 //1. Validar que el correo de un usuario que se quiere registrar no existe en la BD
 public void validarUsuarioNuevo(Usuario datos){

    String correoEntregado=datos.getCorreo();
    if(this.repositorio.existsByCorreo(correoEntregado)){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo entregado ya existe en BD");

    }
 }




}
