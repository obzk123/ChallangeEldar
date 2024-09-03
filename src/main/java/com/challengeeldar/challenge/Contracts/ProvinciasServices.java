package com.challengeeldar.challenge.Contracts;

import java.util.List;

import com.challengeeldar.challenge.Entitys.Provincia;

public interface ProvinciasServices {

    List<Provincia> GetAllProvincias_DB();
    Provincia GetProvinciaID_DB(int id);
    Provincia GetProvinciaCodigo31662_DB(String codigo31662);
    String AddProvincia_DB(Provincia provincia);
    String DeleteProvincia_DB(int id);
    
    
    String CreateProvincia_Excel(List<Provincia> provincias);
    List<Provincia> GetAllProvincias_Excel();
    Provincia GetProvinciaID_Excel(int id);
    Provincia GetProvinciaCodigo31662_Excel(String codigo31662);
    String AddProvincia_Excel(Provincia provincia);
    String UpdateProvincia_Excel(Provincia provincia);
    String DeleteProvincia_Excel(int id);

}
