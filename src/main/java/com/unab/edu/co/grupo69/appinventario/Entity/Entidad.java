package com.unab.edu.co.grupo69.appinventario.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entidad")
public class Entidad {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable=false, unique=false)
    private String idEntidad;

    @Column(length=45, nullable=false)
    private String razonSocial;

    @Column(length=20, nullable=false)
    private String nit;

    @Column(length=20, nullable=false)
    private String telefono;

    @Column(length=45, nullable=false)
    private String email;

    @Column(length=45, nullable=false)
    private String direccion;

    @Column(length=20, nullable=false)
    private String departamento;

    @Column(length=20, nullable=false)
    private String ciudad;

}
