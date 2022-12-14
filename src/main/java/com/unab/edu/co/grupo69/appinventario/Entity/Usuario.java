package com.unab.edu.co.grupo69.appinventario.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable=false, unique=false)
    private String idUsuario;

    @Column(length=45, nullable=false)
    private String nombre;

    @Column(length=45, nullable=false)
    private String apellido;

    @Column(length=20, nullable=false)
    private String tipoUsuario;

    
    @Column(length=45, nullable=false)
    private String email;

    @Column(length=20, nullable=false)
    private String telefono;

    @Column(length=20, nullable=false)
    private String tipoDocumento;

    @Column(length=25, nullable=false)
    private String documento;

    @Column(length=15, nullable=false)
    private String nickname;

    @Column(nullable=false)
    private String password;

   /*  @ManyToOne
    @JoinColumn(name = "idEntidad")
    private Entidad entidad;*/

    @ManyToOne
    @JoinColumn(name = "idEntidad")
    private Entidad entidad;

    
    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoUsuario="
                + tipoUsuario + "]";
    }


}
