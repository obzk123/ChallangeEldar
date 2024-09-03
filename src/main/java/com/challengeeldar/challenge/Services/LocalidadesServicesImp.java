package com.challengeeldar.challenge.Services;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.challengeeldar.challenge.Contracts.LocalidadesServices;
import com.challengeeldar.challenge.Entitys.Localidad;
import com.challengeeldar.challenge.Repositories.LocalidadesRepository;
import com.challengeeldar.challenge.Utils.ExcelUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalidadesServicesImp implements LocalidadesServices{

    private final String fileName = "localidades.xlsx";
    private final LocalidadesRepository repository;
    
    private ExcelUtils excel = new ExcelUtils();

    @Override
    public List<Localidad> GetAllLocalidades_DB()
    {
        List<Localidad> localidades = repository.findAll();
        return localidades != null ? localidades : Collections.emptyList();
    }

    @Override
    public Localidad GetLocalidadID_DB(int id)
    {
        return repository.findById(id);
    }

    @Override
    public List<Localidad> GetLocalidadCodigoPostal_DB(String codigoPostal)
    {
        List<Localidad> localidad = repository.findByCodigopostal(codigoPostal) ;
        return localidad != null ? localidad : null;
    }

    @Override
    public String AddLocalidad_DB(Localidad l)
    {
        try
        {   
            repository.save(l);
        }catch(Exception e){
            return e.getMessage();
        }
        return "Creado con exito";
    }

    @Override
    public String DeleteLocalidad_DB(int id)
    {
        try
        {   
            Localidad l = GetLocalidadID_DB(id);
            if(l != null)
            {
                repository.delete(l);
            }else{
                return "No existe la localidad";
            }
        }catch(Exception e){
            return e.getMessage();
        }

        return "Borrado con exito";
    }

    @Override
    public String CreateLocalidad_Excel(List<Localidad> localidades)
    {
        try{
            excel.saveListToExcel(localidades, "localidades.xlsx");
        }catch(Exception e)
        {
            return e.getMessage();
        }
        return "Creado con exito";
    }

    @Override
    public List<Localidad> GetAllLocalidades_Excel()
    {
        try{
            return excel.readExcelFileToList("localidades.xlsx", Localidad.class);
        }catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public Localidad GetLocalidadID_Excel(int id)
    {
        List<Localidad> localidades = GetAllLocalidades_Excel();
        for (Localidad localidad : localidades) {
            if(localidad.getId() == id)
            {
                return localidad;
            }
        }
        return null;
    }

    @Override
    public List<Localidad> GetLocalidadCodigoPostal_Excel(String codigoPostal){
        List<Localidad> localidades = GetAllLocalidades_Excel();
        List<Localidad> localidadARetornar = new ArrayList<Localidad>();
        for (Localidad localidad : localidades) {
            if(localidad.getCodigopostal().equals(codigoPostal))
            {
                localidadARetornar.add(localidad);
            }
        }
        return localidadARetornar;
    }

    @Override
    public String AddLocalidad_Excel(Localidad localidad){
        List<Localidad> localidades = GetAllLocalidades_Excel();
        if(!localidades.isEmpty())
        {
            localidad.setId(localidades.get(localidades.size() - 1).getId() + 1); 
            localidades.add(localidad);
            if(CreateLocalidad_Excel(localidades).equals("Creado con exito")){
                return "Agregado con exito";
            }
            return "No se pudo agregar";
        }
        return "No hay localidades";
    }

    @Override
    public String UpdateLocalidad_Excel(Localidad localidad)
    {
        List<Localidad> localidades = GetAllLocalidades_Excel();
        for (int i = 0; i < localidades.size(); i++) {
            if(localidades.get(i).getId() == localidad.getId())
            {
                localidades.set(i, localidad);
                if(CreateLocalidad_Excel(localidades).equals("Creado con exito")){
                    return "Provincia actualizada con exito";
                }
            }
        }
        return "No se encontro la localidad";
    }

    @Override
    public String DeleteLocalidad_Excel(int id)
    {
        try{
            List<Localidad> localidades = GetAllLocalidades_Excel();
            if(excel.deleteById(localidades, id, fileName))
            {
                excel.saveListToExcel(localidades, fileName);
                return "Borrado con exito";
            }
        }catch(Exception e){
            return e.getMessage();
        }
        return "No se pudo borrar";
    }
}
