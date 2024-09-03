package com.challengeeldar.challenge.Services;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.challengeeldar.challenge.Contracts.ProvinciasServices;
import com.challengeeldar.challenge.Entitys.Provincia;
import com.challengeeldar.challenge.Repositories.ProvinciaRepository;
import com.challengeeldar.challenge.Utils.ExcelUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProvinciasServicesImp implements ProvinciasServices {

    private final String fileName = "provincias.xlsx";
    
    private ExcelUtils excel = new ExcelUtils();
    private final ProvinciaRepository repository;

    @Override
    public List<Provincia> GetAllProvincias_DB() {
        List<Provincia> provincias = repository.findAll();
        return provincias != null ? provincias : Collections.emptyList();
    }

    @Override
    public Provincia GetProvinciaID_DB(int id) {
        return repository.findById(id);
    }

    @Override
    public Provincia GetProvinciaCodigo31662_DB(String codigo31662)
    {
        return repository.findByCodigo31662(codigo31662);
    }

    @Override
    public String AddProvincia_DB(Provincia p)
    {
        try{
            repository.save(p);
        }catch(DataIntegrityViolationException e){
            return "El codigo 31662 ya existe";
        }catch(Exception e){
            return e.getMessage();
        }
        return "Creado con exito";
    }

    @Override
    public String DeleteProvincia_DB(int id)
    {
        try{
            Provincia p = GetProvinciaID_DB(id);
            if(p != null){
                repository.delete(p);
            }else{
                return "No existe la provincia";
            }
        }catch(Exception e){
            return e.getMessage();
        }
        return "Borrado con exito";
    }

    @Override
    public String CreateProvincia_Excel(List<Provincia> provincias)
    {
        try{
            excel.saveListToExcel(provincias, fileName);
        }catch(Exception e){
            return e.getMessage();
        }
        return "Creado con exito";
    }

    @Override
    public List<Provincia> GetAllProvincias_Excel(){
        try{
            return excel.readExcelFileToList(fileName, Provincia.class);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public Provincia GetProvinciaID_Excel(int id){
        List<Provincia> provincias = GetAllProvincias_Excel();
        for (Provincia provincia : provincias) {
            if(provincia.getId() == id)
            {
                return provincia;
            }
        }
        return null;
    }

    @Override
    public Provincia GetProvinciaCodigo31662_Excel(String codigo31662){
        List<Provincia> provincias = GetAllProvincias_Excel();
        for (Provincia provincia : provincias) {
            if(provincia.getCodigo31662().equals(codigo31662))
            {
                return provincia;
            }
        }
        return null;
    }

    @Override
    public String AddProvincia_Excel(Provincia provincia){
        List<Provincia> provincias = GetAllProvincias_Excel();
        if(!provincias.isEmpty())
        {
            provincia.setId(provincias.get(provincias.size() - 1).getId() + 1); 
            for (Provincia p : provincias) {
                if(p.getCodigo31662().equals(provincia.getCodigo31662())){
                    return "El codigo 31662 ya existe";
                }
            }
            provincias.add(provincia);

            if(CreateProvincia_Excel(provincias).equals("Creado con exito")){
                return "Creado con exito";
            }
            return "No se pudo agregar";
        }
        return "No hay provincias";
    }

    @Override
    public String UpdateProvincia_Excel(Provincia provincia)
    {
        List<Provincia> provincias = GetAllProvincias_Excel();
        for (int i = 0; i < provincias.size(); i++) {
            if(provincias.get(i).getId() == provincia.getId())
            {
                for(int j = 0; j < provincias.size(); j++)
                {
                    if(provincias.get(j).getCodigo31662().equals(provincia.getCodigo31662()) && provincias.get(j).getId() != provincia.getId())
                    {
                        System.out.println(provincias.get(j).getNombre());
                        return "El codigo que estas intentando actualizar ya existe";
                    }
                }
                provincias.set(i, provincia);
                if(CreateProvincia_Excel(provincias).equals("Creado con exito")){
                    return "Provincia actualizada con exito";
                }
            }
        }
        return "No se encontro la provincia";
    }

    @Override
    public String DeleteProvincia_Excel(int id)
    {
        try{
            List<Provincia> provincias = GetAllProvincias_Excel();
            if(provincias != null)
            {
                if(excel.deleteById(provincias, id, fileName))
                {
                    excel.saveListToExcel(provincias, fileName);
                    return "Borrado con exito";
                }
            }
        }catch(Exception e){
            return e.getMessage();
        }
        return "No se pudo borrar";
    }

}
