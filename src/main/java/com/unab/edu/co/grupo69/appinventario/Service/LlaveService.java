package com.unab.edu.co.grupo69.appinventario.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.grupo69.appinventario.Entity.Message;
import com.unab.edu.co.grupo69.appinventario.Entity.Llave;
import com.unab.edu.co.grupo69.appinventario.Repository.LlaveRepository;

@Service
public class LlaveService {
    @Autowired
    LlaveRepository llaverepository;
    public Llave save(Llave llave){

        return llaverepository.save(llave);

    }
public List<Llave> findAll(){

    return (List<Llave>) llaverepository.findAll();
    
}


public Message deleteById(String idLlave){

    

    try {
        llaverepository.deleteById(idLlave);
        return new Message(201,"Registro con id: "+idLlave+"eliminado");
        
    } catch (Exception e) {
        // TODO: handle exception
        return new Message(400,"No existe Llave con id:  "+idLlave);
    }
   

    }
    
    public Message update(Llave llave){

        llave=llaverepository.findById(llave.getIdLlave()).get();
    
        if(llave==null){
            return new Message(200,"ok");
    
        } else{
            return new Message(404,"Llave no encontrada");
        }
    }
    
}
