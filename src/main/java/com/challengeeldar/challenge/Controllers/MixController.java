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

@RestController
@RequestMapping("/mix")
public class MixController {

    @Autowired
    private DBController dbController;

    @Autowired
    private ExcelController excelController;

    @GetMapping("/localidades")
    public String getLocalidades() {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.getLocalidades();
        response += "\nRespuesta del archivo excel \n" + excelController.getLocalidades();
        return response;
    }

    @GetMapping("/localidades/id")
    public String getLocalidadesID(@RequestParam int id) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.getLocalidadesID(id);
        response += "\nRespuesta del archivo excel \n" + excelController.getLocalidadesID(id);
        return response;
    }

    @GetMapping("/localidades/codigo")
    public String getLocalidadesCodigo(@RequestParam String codigo) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.getLocalidadesCodigo(codigo);
        response += "\nRespuesta del archivo excel \n" + excelController.getLocalidadesCodigo(codigo);
        return response;
    }

    @PostMapping("/localidades/add")
    public String postAddLocalidad(@RequestBody Localidad localidad) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.postAddLocalidad(localidad);
        response += "\nRespuesta del archivo excel \n" + excelController.postAddLocalidad(localidad);
        return response;
    }
    
    @PostMapping("/localidades/update")
    public String postUpdateLocalidad(@RequestBody Localidad localidad) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.postUpdateLocalidad(localidad);
        response += "\nRespuesta del archivo excel \n" + excelController.postUpdateLocalidad(localidad);
        return response;
    }

    @PostMapping("/localidades/delete")
    public String postDeleteLocalidad(@RequestBody int id) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.postDeleteLocalidad(id);
        response += "\nRespuesta del archivo excel \n" + excelController.postDeleteLocalidad(id);
        return response;
    }

    @GetMapping("/provincias")
    public String getProvincias() {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.getProvincias();
        response += "\nRespuesta del archivo excel \n" + excelController.getProvincias();
        return response;
    }

    @GetMapping("/provincias/id")
    public String getProvinciaID(@RequestParam int id) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.getProvinciaID(id);
        response += "\nRespuesta del archivo excel \n" + excelController.getProvinciaID(id);
        return response;
    }

    @GetMapping("/provincias/codigo")
    public String getProvinciaCodigo(@RequestParam String codigo31662) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.getProvinciaCodigo(codigo31662);
        response += "\nRespuesta del archivo excel \n" + excelController.getProvinciaCodigo(codigo31662);
        return response;
    }

    @PostMapping("/provincias/add")
    public String postAddProvincia(@RequestBody Provincia provincia) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.postAddProvincia(provincia);
        response += "\nRespuesta del archivo excel \n" + excelController.postAddProvincia(provincia);
        return response;
    }

    @PostMapping("/provincias/update")
    public String postUpdateProvincia(@RequestBody Provincia provincia) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.postUpdateProvincia(provincia);
        response += "\nRespuesta del archivo excel \n" + excelController.postUpdateProvincia(provincia);
        return response;
    }

    @PostMapping("/provincias/delete")
    public String postDeleteProvincia(@RequestBody int id) {
        String response;
        response = "Respuesta de la base de datos \n" + dbController.postDeleteProvincia(id);
        response += "\nRespuesta del archivo excel \n" + excelController.postDeleteProvincia(id);
        return response;
    }
}
