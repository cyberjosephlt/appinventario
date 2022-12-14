package com.unab.edu.co.grupo69.Dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String tipoUsuario;
    private String email;
    //private String telefono;
    private String tipoDocumento;
    private String documento;
    private String nickname;
    private String password;
}
