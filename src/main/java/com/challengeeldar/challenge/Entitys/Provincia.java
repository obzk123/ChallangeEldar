package com.challengeeldar.challenge.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "provincia")
@Getter @Setter
public class Provincia {
    
    public Provincia() { }

    public Provincia(int _id, String _nombre, String _codigo31662)
    {
        id = _id;
        nombre = _nombre;
        codigo31662 = _codigo31662;
    }

    public Provincia(String _nombre, String _codigo31662)
    {
        nombre = _nombre;
        codigo31662 = _codigo31662;
    }

    @Id
    @Column(name = "id", nullable = false)
    int id;
    
    @Column(name = "nombre")
    String nombre;
    
    @Column(name = "codigo31662")
    String codigo31662;
}
