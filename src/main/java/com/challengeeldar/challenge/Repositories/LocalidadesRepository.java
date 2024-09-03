package com.challengeeldar.challenge.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengeeldar.challenge.Entitys.Localidad;

@Repository
public interface LocalidadesRepository extends JpaRepository<Localidad, Integer>{

    @SuppressWarnings("null")
    List<Localidad> findAll();
    Localidad findById(int id);
    List<Localidad> findByCodigopostal(String codigopostal);
    
}
