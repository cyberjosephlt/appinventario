package com.unab.edu.co.grupo69.appinventario.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.grupo69.appinventario.Entity.Message;
import com.unab.edu.co.grupo69.appinventario.Entity.Entidad;
import com.unab.edu.co.grupo69.appinventario.Repository.EntidadRepository;

@Service
public class EntidadService {
    @Autowired
    EntidadRepository entidadrepository;
    public Entidad save(Entidad entidad){

        return entidadrepository.save(entidad);

    }
public List<Entidad> findAll(){

    return (List<Entidad>) entidadrepository.findAll();
    
}

public Message deleteById(String idEntidad){

    

    try {
        entidadrepository.deleteById(idEntidad);
        return new Message(201,"Registro con id: "+idEntidad+"eliminado");
        
    } catch (Exception e) {
        // TODO: handle exception
        return new Message(400,"No existe entidad con id:  "+idEntidad);
    }
   

    }
    
    public Message update(Entidad entidad){

        entidad=entidadrepository.findById(entidad.getIdEntidad()).get();
    
        if(entidad==null){
            return new Message(200,"ok");
    
        } else{
            return new Message(404,"Entidad no encontrada");
        }
    }
}
