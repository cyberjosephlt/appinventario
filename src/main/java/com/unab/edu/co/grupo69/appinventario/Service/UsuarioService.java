package com.unab.edu.co.grupo69.appinventario.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.grupo69.appinventario.Entity.Message;
import com.unab.edu.co.grupo69.appinventario.Entity.Usuario;
import com.unab.edu.co.grupo69.appinventario.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuariorepository;
    public Usuario save(Usuario usuario){

        return usuariorepository.save(usuario);

    }
public List<Usuario> findAll(){

    return (List<Usuario>) usuariorepository.findAll();
    
}

public Message deleteById(String idUsuario){

    

    try {
        usuariorepository.deleteById(idUsuario);
        return new Message(201,"Registro con id: "+idUsuario+"eliminado");
        
    } catch (Exception e) {
        // TODO: handle exception
        return new Message(400,"No existe usuario con id:  "+idUsuario);
    }
   

    }

public Message update(Usuario usuario){

        usuario=usuariorepository.findById(usuario.getIdUsuario()).get();
    
        if(usuario==null){
            return new Message(200,"ok");
    
        } else{
            return new Message(404,"usuario no encontrado");
        }
    }
}
