package com.challengeeldar.challenge.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challengeeldar.challenge.Entitys.Localidad;
import com.challengeeldar.challenge.Entitys.Provincia;
import com.challengeeldar.challenge.Services.LocalidadesServicesImp;
import com.challengeeldar.challenge.Services.ProvinciasServicesImp;
import com.google.gson.Gson;

@RestController
@RequestMapping("/db")
public class DBController {

    @Autowired
    private ProvinciasServicesImp provinciasServices;

    @Autowired
    private LocalidadesServicesImp localidadesServices;

    private Gson gson = new Gson();
    private long startTime = 0;
    private long endTime = 0;
    private long totalTime = 0;

    @GetMapping("/localidades")
    public String getLocalidades() {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(localidadesServices.GetAllLocalidades_DB());
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/localidades/id")
    public String getLocalidadesID(@RequestParam int id) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(localidadesServices.GetLocalidadID_DB(id));
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/localidades/codigo")
    public String getLocalidadesCodigo(@RequestParam String codigo) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(localidadesServices.GetLocalidadCodigoPostal_DB(codigo));
        if(json.toString().equals("[]")) json = "No se encontraron localidades con ese codigo";
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/localidades/add")
    public String postAddLocalidad(@RequestBody Localidad localidad) {
        startTime = System.currentTimeMillis();
        String response = localidadesServices.AddLocalidad_DB(localidad);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }
    
    @PostMapping("/localidades/update")
    public String postUpdateLocalidad(@RequestBody Localidad localidad) {
        String response;
        startTime = System.currentTimeMillis();
        if(localidadesServices.AddLocalidad_DB(localidad).equals("Creado con exito"))
        {
            response = "Modificado con exito";
        }else{
            response = "No se encontro la localidad";
        }
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/localidades/delete")
    public String postDeleteLocalidad(@RequestBody int id) {
        String response;
        startTime = System.currentTimeMillis();
        response = localidadesServices.DeleteLocalidad_DB(id);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/provincias")
    public String getProvincias() {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(provinciasServices.GetAllProvincias_DB());
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/provincias/id")
    public String getProvinciaID(@RequestParam int id) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(provinciasServices.GetProvinciaID_DB(id));
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @GetMapping("/provincias/codigo")
    public String getProvinciaCodigo(@RequestParam String codigo31662) {
        startTime = System.currentTimeMillis();
        String json = gson.toJson(provinciasServices.GetProvinciaCodigo31662_DB(codigo31662));
        if(json.toString().equals("null")) json = "No se encontro la provincia";
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/provincias/add")
    public String postAddProvincia(@RequestBody Provincia provincia) {
        startTime = System.currentTimeMillis();
        String json = provinciasServices.AddProvincia_DB(provincia);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return json + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/provincias/update")
    public String postUpdateProvincia(@RequestBody Provincia provincia) {
        startTime = System.currentTimeMillis();
        String response;
        if(provinciasServices.AddProvincia_DB(provincia).equals("Creado con exito")){
            response = "Modifcado con exito";
        }else{
            response = "No se pudo modificar";
        }
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

    @PostMapping("/provincias/delete")
    public String postDeleteProvincia(@RequestBody int id) {
        startTime = System.currentTimeMillis();
        String response = provinciasServices.DeleteProvincia_DB(id);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        return response + "\nEl tiempo transcurrido fue de " + totalTime + "ms";
    }

}
