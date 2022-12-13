package com.unab.edu.co.grupo69.appinventario.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.edu.co.grupo69.appinventario.Entity.Message;
import com.unab.edu.co.grupo69.appinventario.Entity.Usuario;
import com.unab.edu.co.grupo69.appinventario.Security.Encriptar;
import com.unab.edu.co.grupo69.appinventario.Service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioservice;
    @PostMapping("/create")
    public ResponseEntity<Message> save(@RequestBody Usuario usuario){

        try {

            if(usuario.getNombre()==null){
                return new ResponseEntity<Message>(new Message(400,"El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            } else{
                usuario.setPassword(Encriptar.sha1(usuario.getPassword()));
                usuarioservice.save(usuario);
                return new ResponseEntity<Message>(new Message(200,"Registro creado"), HttpStatus.CREATED);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Message>(new Message(400,"El registro no se creó: "+e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteByidEntity(@PathVariable String idUsuario){
        
        Message message=usuarioservice.deleteById(idUsuario);
        return new ResponseEntity<Message>(message,HttpStatus.resolve(message.getStatus()));

    }

    @GetMapping("/listar")

    public List<Usuario> findAll(){

            return (List<Usuario>) usuarioservice.findAll();
        
    }
    @GetMapping("/encriptar/{dato}")
    public String encriptar(@PathVariable String dato){
        return Encriptar.sha1(dato);

    }

    @PutMapping("/update")
    public ResponseEntity<Message> update(@RequestBody Usuario usuario){
        

        try {

            if(usuario.getNombre()==null){
                return new ResponseEntity<Message>(new Message(400,"El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            } else{
                usuario.setPassword(Encriptar.sha1(usuario.getPassword()));
                Message message=usuarioservice.update(usuario);
                return new ResponseEntity<Message>(new Message(message.getStatus(),message.getMessage()), HttpStatus.valueOf(message.getStatus()));
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Message>(new Message(400,"El registro no se creó"),HttpStatus.BAD_REQUEST);
        }
    }
    
    
}
