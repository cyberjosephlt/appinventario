package com.unab.edu.co.grupo69.appinventario.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable=false, unique=false)
    private String idProducto;

    @Column(length=45, nullable=false)
    private String nombreProducto;

    @Column( nullable=false)
    private int cantidadProducto;

    @Column(length=100, nullable=false)
    private String detalleProducto;

    @ManyToOne
    @JoinColumn(name = "idEntidad")
    private Entidad entidad;
}
