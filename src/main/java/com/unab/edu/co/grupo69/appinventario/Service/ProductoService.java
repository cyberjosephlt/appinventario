package com.unab.edu.co.grupo69.appinventario.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.grupo69.appinventario.Entity.Message;
import com.unab.edu.co.grupo69.appinventario.Entity.Producto;
import com.unab.edu.co.grupo69.appinventario.Repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productorepository;
    public Producto save(Producto producto){

        return productorepository.save(producto);

    }
public List<Producto> findAll(){

    return (List<Producto>) productorepository.findAll();
    
}


public Message deleteById(String idProducto){

    

    try {
        productorepository.deleteById(idProducto);
        return new Message(201,"Registro con id: "+idProducto+"eliminado");
        
    } catch (Exception e) {
        // TODO: handle exception
        return new Message(400,"No existe Producto  con id:  "+idProducto);
    }
   

    }
    
    public Message update(Producto producto){

        producto=productorepository.findById(producto.getIdProducto()).get();
    
        if(productorepository==null){
            return new Message(200,"ok");
    
        } else{
            return new Message(404,"Producto no encontrado");
        }
    }
    
}
