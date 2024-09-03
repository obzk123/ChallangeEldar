package com.challengeeldar.challenge.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challengeeldar.challenge.Services.LocalidadesServicesImp;
import com.challengeeldar.challenge.Services.ProvinciasServicesImp;
import com.google.gson.Gson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.challengeeldar.challenge.Entitys.Localidad;
import com.challengeeldar.challenge.Entitys.Provincia;


@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ProvinciasServicesImp provinciasServices;

    @Autowired
    private LocalidadesServicesImp localidadesServices;

    private Gson gson = new Gson();
    private long startTime = 0;
    private long endTime = 0;
    private long totalTime = 0;

    @GetMapping("/localidades/crear")
    public String getCreateLocalidades() {
        startTime = System.currentTimeMillis();
        List<Localidad> listLocalidades = localidadesServices.GetAllLocalidades_DB();
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return localidadesServices.CreateLocalidad_Excel(listLocalidades) + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/localidades")
    public String getLocalidades() {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(localidadesServices.GetAllLocalidades_Excel()); 
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/localidades/id")
    public String getLocalidadesID(@RequestParam int id) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(localidadesServices.GetLocalidadID_Excel(id));
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/localidades/codigo")
    public String getLocalidadesCodigo(@RequestParam String codigo) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(localidadesServices.GetLocalidadCodigoPostal_Excel(codigo));
        if(json.toString().equals("[]")) json = "No se encontraron localidades con ese codigo";
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/localidades/add")
    public String postAddLocalidad(@RequestBody Localidad localidad) {
        startTime = System.currentTimeMillis();
        String response = localidadesServices.AddLocalidad_Excel(localidad);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }
    
    @PostMapping("/localidades/update")
    public String postUpdateLocalidad(@RequestBody Localidad localidad) {
        startTime = System.currentTimeMillis();
        String response = localidadesServices.UpdateLocalidad_Excel(localidad);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/localidades/delete")
    public String postDeleteLocalidad(@RequestBody int id) {
        startTime = System.currentTimeMillis();
        String response = localidadesServices.DeleteLocalidad_Excel(id);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/provincias/crear")
    public String getCreateProvincias() {
        startTime = System.currentTimeMillis();
        List<Provincia> listProvincias = provinciasServices.GetAllProvincias_DB();
        String response = provinciasServices.CreateProvincia_Excel(listProvincias);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/provincias")
    public String getProvincias() {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(provinciasServices.GetAllProvincias_Excel());
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/provincias/id")
    public String getProvinciaID(@RequestParam int id) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(provinciasServices.GetProvinciaID_Excel(id));
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/provincias/codigo")
    public String getProvinciaCodigo(@RequestParam String codigo31662) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(provinciasServices.GetProvinciaCodigo31662_Excel(codigo31662));
        if(json.toString().equals("null")) json = "No se encontro la provincia";
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/provincias/add")
    public String postAddProvincia(@RequestBody Provincia provincia) {
        startTime = System.currentTimeMillis();
        String response = provinciasServices.AddProvincia_Excel(provincia);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }
    
    @PostMapping("/provincias/update")
    public String postUpdateProvincia(@RequestBody Provincia provincia) {
        startTime = System.currentTimeMillis();
        String response = provinciasServices.UpdateProvincia_Excel(provincia);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";

    }

    @PostMapping("/provincias/delete")
    public String postDeleteProvincia(@RequestBody int id) {
        startTime = System.currentTimeMillis();
        String response = provinciasServices.DeleteProvincia_Excel(id);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }
  
}
