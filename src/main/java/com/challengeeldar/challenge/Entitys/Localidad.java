package com.challengeeldar.challenge.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "localidad")
@Getter @Setter
public class Localidad {


    public Localidad() { }

    public Localidad(int _id, int _provincia_id, String _nombre, String _codigopostal)
    {
        id = _id;
        provincia_id = _provincia_id;
        nombre = _nombre;
        codigopostal = _codigopostal;
    }

    public Localidad(int _provincia_id, String _nombre, String _codigopostal)
    {
        provincia_id = _provincia_id;
        nombre = _nombre;
        codigopostal = _codigopostal;
    }

    @Id
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "provincia_id")
    int provincia_id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "codigopostal")
    String codigopostal;
}
