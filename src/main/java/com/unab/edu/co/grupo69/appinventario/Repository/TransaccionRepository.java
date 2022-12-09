package com.unab.edu.co.grupo69.appinventario.Repository;

import org.springframework.data.repository.CrudRepository;

import com.unab.edu.co.grupo69.appinventario.Entity.Transaccion;

public interface TransaccionRepository extends CrudRepository<Transaccion,String> {
    
}
