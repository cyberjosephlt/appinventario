package com.unab.edu.co.grupo69.appinventario.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable=false, unique=false)
    private String idTransaccion;

    @Column(length=20, nullable=false)
    private String tipoTransaccion;

    @Column(length=20, nullable=false)
    private int cantidad;

    @Column(length=300, nullable=false)
    private String documentoSoporte;

    /*@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;*/

    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    private Producto usuario;

    private String idUsuario;

    /*@ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;*/

    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Producto.class, fetch = FetchType.EAGER)
    private Producto producto;

    private String idProducto;


    @Override
    public String toString() {
        return "Transaccion [idTransaccion=" + idTransaccion + ", tipoTransaccion=" + tipoTransaccion + ", cantidad="
                + cantidad + ", documentoSoporte=" + documentoSoporte + ", usuario=" + usuario + ", producto="
                + producto + "]";
    }
    
    
}
