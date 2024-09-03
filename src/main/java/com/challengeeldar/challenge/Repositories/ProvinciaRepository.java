package com.challengeeldar.challenge.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengeeldar.challenge.Entitys.Provincia;
import java.util.List;


@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

    @SuppressWarnings("null")
    List<Provincia> findAll();
    Provincia findById(int id);
    Provincia findByCodigo31662(String codigo31662);
    
}
