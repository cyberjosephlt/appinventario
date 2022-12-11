package com.unab.edu.co.grupo69.appinventario.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "llave")
public class Llave {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable=false, unique=false)
    private String idLlave;

    @Column(length=200, nullable=false)
    private String token;

    @Column( nullable=false)
    private Date fechac;

    @Column( nullable=false)
    private Date fechav;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Override
    public String toString() {
        return "Llave [idLlave=" + idLlave + ", token=" + token + ", fechac=" + fechac + ", fechav=" + fechav
                + ", usuario=" + usuario + "]";
    }



    
}
