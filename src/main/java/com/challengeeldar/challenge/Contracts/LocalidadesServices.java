package com.challengeeldar.challenge.Contracts;

import java.util.List;

import com.challengeeldar.challenge.Entitys.Localidad;

public interface LocalidadesServices {

    List<Localidad> GetAllLocalidades_DB();
    Localidad GetLocalidadID_DB(int id);
    List<Localidad> GetLocalidadCodigoPostal_DB(String codigoPostal);
    String AddLocalidad_DB(Localidad localidad);
    String DeleteLocalidad_DB(int localidad);
    
    
    String CreateLocalidad_Excel(List<Localidad> localidades);
    List<Localidad> GetAllLocalidades_Excel();
    Localidad GetLocalidadID_Excel(int id);
    List<Localidad> GetLocalidadCodigoPostal_Excel(String codigoPostal);
    String AddLocalidad_Excel(Localidad localidad);
    String UpdateLocalidad_Excel(Localidad localidad);
    String DeleteLocalidad_Excel(int id);

}

