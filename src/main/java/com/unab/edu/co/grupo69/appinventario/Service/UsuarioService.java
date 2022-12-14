package com.unab.edu.co.grupo69.appinventario.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.grupo69.appinventario.Entity.Message;
import com.unab.edu.co.grupo69.appinventario.Entity.Usuario;
import com.unab.edu.co.grupo69.appinventario.Repository.UsuarioRepository;
import com.unab.edu.co.grupo69.appinventario.Security.Encriptar;

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
    
        if(!usuario.getIdUsuario().equals("")){
            usuario.setPassword(Encriptar.sha1(usuario.getPassword()));
            usuariorepository.save(usuario);
            return new Message(200,"Usuario actualizado");
    
        } else{
            return new Message(404,"Usuario no actualizado");
        }
        /* clienterepository.findById(cliente.getIdCliente()).orElseThrow(()->new Message(404,"El id "+cliente.getIdCliente()+" no existe"));
        return new Message(200,"Cliente actualizado" ); */
    
    }
}
