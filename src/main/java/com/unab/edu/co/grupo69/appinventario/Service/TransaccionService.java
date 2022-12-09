package com.unab.edu.co.grupo69.appinventario.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.grupo69.appinventario.Entity.Message;
import com.unab.edu.co.grupo69.appinventario.Entity.Transaccion;
import com.unab.edu.co.grupo69.appinventario.Repository.TransaccionRepository;

@Service
public class TransaccionService {
    @Autowired
    TransaccionRepository transaccionrepository;
    public Transaccion save(Transaccion transaccion){

        return transaccionrepository.save(transaccion);

    }
public List<Transaccion> findAll(){

    return (List<Transaccion>) transaccionrepository.findAll();
    
}


public Message deleteById(String idTransaccion){

    

    try {
        transaccionrepository.deleteById(idTransaccion);
        return new Message(201,"Registro con id: "+idTransaccion+"eliminado");
        
    } catch (Exception e) {
        // TODO: handle exception
        return new Message(400,"No existe Transaccion  con id:  "+idTransaccion);
    }
   

    }
    
    public Message update(Transaccion transaccion){

        transaccion=transaccionrepository.findById(transaccion.getIdTransaccion()).get();
    
        if(transaccionrepository==null){
            return new Message(200,"ok");
    
        } else{
            return new Message(404,"Transaccion no encontrada");
        }
    }
}
