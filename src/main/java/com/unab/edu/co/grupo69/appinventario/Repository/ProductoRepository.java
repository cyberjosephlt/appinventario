package com.unab.edu.co.grupo69.appinventario.Repository;

import org.springframework.data.repository.CrudRepository;

import com.unab.edu.co.grupo69.appinventario.Entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto,String> {
    
}
