
# Challange Eldar Octavio Bill Zito

La aplicacion tiene como objetivo realizar un CRUD (crear, leer, actualizar y eliminar) informacion desde una base de datos MySQL y de archivos locales especificamente en formato excel.

La documentacion va a contar con el siguiente indice.

    1. Herramientas utilizadas.
    2. Pasos para ejecutar la aplicacion.
    3. Documentacion API.
    4. Explicacion del codigo.


## Herramientas utilizadas.

 - El software de desarrollo utilizado es [Visual Studio Code](https://code.visualstudio.com/).
 - El lenguaje de programacion utilizado es Java 17 con Maven. [Extension Pack Java para Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
 - Para facilitar la creacion de end-points se utilizo el framework Spring Boot. [Documentacion de Spring Boot](https://spring.io/projects/spring-boot)
 - Se utilizo Spring JPA para la comunicacion a la base de datos MySQL. [Documentacion JPA](https://spring.io/projects/spring-data-jpa)
 - Para el manejo de archivos excel se utilizo Apache POI. [Documentacion de Apache POI](https://poi.apache.org/)
 - XAMPP para crear el serivicio MySQL [Descarga Xampp](https://www.apachefriends.org/)
 - Tablas de provincias y localidades. [Github de la tablas](https://github.com/piposeimandi/Localidades-Argentinas---Provincia-y-Localidad/blob/master/Localidades%20argentinas%20-%20Mysql.sql)
 - Postman para consumir los end-point. [Descargar Postman](https://www.postman.com/)


## Pasos para ejecutar la aplicacion.

A continuacion se detalla el proceso para lograr la ejecucion de la aplicacion. Antes de realizar dicho proceso tener en cuenta de tener descargadas las herramientas descriptas en el paso anterior.

    1. Clonar el repositorio de github y utilizar la rama main.
    
    2. Abrir el proyecto en Visual Studio Code con las extensiones descargadas.
    
    3. Abrir el archivo application.properties y configurar las siguientes variables:
        
        . spring.datasource.url=jdbc:mysql://"TU IP":"TU PUERTO"/"TU DB"
        . spring.datasource.username="TU NOMBRE DE USUARIO"
        . spring.datasource.password="TU CONTRASEÑA"

        En el proyecto ya se encuentra una configuracion incial que te puede servir de guia.

    4. Inciar el servicio de MySQL antes de ejecutar la aplicacion.
    
    5. Abrir el archivo ChallengeApplication.java para poder observar arriba a la derecha el boton de 
    play, al cual tenemos que hacer click para que la aplicacion se ejecute.

    6. Podemos probar el funcionamiento desde Postman, crearemos una peticion get con la siguientes URL:  
    
        . http://localhost:8080/db/provincias               Para obtener las provincias de la DB
    
        . http://localhost:8080/excel/provincias/crear      Para crear el excel de las provincias
    
        . http://localhost:8080/excel/localidades/crear     Para crear el excel de las localidades


## Documentacion API 

#### A continuacion se detallan todas las peticiones hacia la base de datos MySQL

#### Provincias

#### Obtener todas las provincias

```http
  GET /db/provincias
```
No requiere de parametros.

Retorna un JSON, Ejemplo

    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"} ]
    El tiempo transcurrido fue de 195ms

#### Obtener provincia por id

```http
  GET /db/provincias/id
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Requerido**. ID de la provincia a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"} ]
    El tiempo transcurrido fue de 195ms

#### Obtener provincia por codigo31662

```http
  GET /db/provincias/codigo31662
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `codigo31662`      | `string` | **Requerido**. Codigo31662 de la provincia a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"} ]
    El tiempo transcurrido fue de 195ms

#### Agregar provincia

```http
  POST /db/provincias/add
```
Ejemplo, se envia por body en formato JSON

    {
        "nombre" : "Mi provincia 2",
        "codigo31662" : "AR-MMM"
    }

Retorna un JSON, Ejemplo

    Creado con exito
    El tiempo transcurrido fue de 195ms

#### Actualizar provincia

```http
  POST /db/provincias/update
```
Ejemplo, se envia por body en formato JSON

    {
        "id": 35,
        "nombre": "Mi provincia update",
        "codigo31662": "AR-BP"
    }

Retorna un JSON, Ejemplo

    Modificado con exito
    El tiempo transcurrido fue de 195ms

#### Eliminar provincia

```http
  POST /db/provincias/delete
```
Ejemplo, se envia por body en formato JSON

    23

Retorna un JSON, Ejemplo

    Borrado con exito
    El tiempo transcurrido fue de 195ms

## Localidades

#### Obtener todas las localidades

```http
  GET /db/localidades
```
No requiere de parametros.

Retorna un JSON, Ejemplo

    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}
    El tiempo transcurrido fue de 195ms

#### Obtener localidades por id

```http
  GET /db/localidades/id
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Requerido**. ID de la localidad a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}
    El tiempo transcurrido fue de 195ms

#### Obtener localidad por codigo postal

```http
  GET /db/localidades/codigo
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `codigo`      | `string` | **Requerido**. Codigo postal de la localidad a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}
    El tiempo transcurrido fue de 195ms


#### Agregar localidad

```http
  POST /db/localidades/add
```

Ejemplo, se envia por body en formato JSON

    {
        "provincia_id": 10,
        "nombre": "Mi provincia",
        "codigopostal": "2270"
    }

Retorna un JSON, Ejemplo

    Creado con exito
    El tiempo transcurrido fue de 195ms

#### Actualizar localidad

```http
  POST /db/localidades/update
```

Ejemplo, se envia por body en formato JSON

    {
        "id": 22966,
        "provincia_id": 1,
        "nombre": "Mi provincia Update",
        "codigopostal": "2270"
    }

Retorna un JSON, Ejemplo

    Modificado con exito
    El tiempo transcurrido fue de 195ms

#### Eliminar provincia

```http
  POST /db/localidad/delete
```
Ejemplo, se envia por body en formato JSON

    22965

Retorna un JSON, Ejemplo

    Borrado con exito
    El tiempo transcurrido fue de 195ms

#### A continuacion se detallan todas las peticiones hacia los archivos locales en formato excel

#### Provincias

#### Crear excel de las provincias basado en la base de datos

```http
  GET /excel/provincias/crear
```
No requiere de parametros.

Retorna un JSON, Ejemplo

    Creado con exito
    El tiempo transcurrido fue de 195ms

#### Obtener todas las provincias

```http
  GET /excel/provincias
```
No requiere de parametros.

Retorna un JSON, Ejemplo

    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"} ]
    El tiempo transcurrido fue de 195ms


#### Obtener provincia por id

```http
  GET /excel/provincias/id
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Requerido**. ID de la provincia a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"} ]
    El tiempo transcurrido fue de 195ms

#### Obtener provincia por codigo31662

```http
  GET /excel/provincias/codigo31662
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `codigo31662`      | `string` | **Requerido**. Codigo31662 de la provincia a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"} ]
    El tiempo transcurrido fue de 195ms

#### Agregar provincia

```http
  POST /excel/provincias/add
```
Ejemplo, se envia por body en formato JSON

    {
        "nombre" : "Mi provincia 2",
        "codigo31662" : "AR-MMM"
    }

Retorna un JSON, Ejemplo

    Agregado con exito
    El tiempo transcurrido fue de 195ms

#### Actualizar provincia

```http
  POST /excel/provincias/update
```
Ejemplo, se envia por body en formato JSON

    {
        "id": 35,
        "nombre": "Mi provincia update",
        "codigo31662": "AR-BP"
    }

Retorna un JSON, Ejemplo

    Modificado con exito
    El tiempo transcurrido fue de 195ms

#### Eliminar provincia

```http
  POST /excel/provincias/delete
```
Ejemplo, se envia por body en formato JSON

    23

Retorna un JSON, Ejemplo

    Borrado con exito
    El tiempo transcurrido fue de 195ms

## Localidades

#### Crear excel de las localidades basado en la base de datos

```http
  GET /excel/localidades/crear
```
No requiere de parametros.

Retorna un JSON, Ejemplo

    Creado con exito
    El tiempo transcurrido fue de 195ms

#### Obtener todas las localidades

```http
  GET /excel/localidades
```
No requiere de parametros.

Retorna un JSON, Ejemplo

    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}
    El tiempo transcurrido fue de 195ms


#### Obtener localidades por id

```http
  GET /excel/localidades/id
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Requerido**. ID de la localidad a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}
    El tiempo transcurrido fue de 195ms

#### Obtener localidad por codigo postal

```http
  GET /excel/localidades/codigo
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `codigo`      | `string` | **Requerido**. Codigo postal de la localidad a obtener |

Retorna un JSON, Ejemplo

    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}
    El tiempo transcurrido fue de 195ms

#### Agregar localidad

```http
  POST /excel/localidades/add
```

Ejemplo, se envia por body en formato JSON

    {
        "provincia_id": 10,
        "nombre": "Mi provincia",
        "codigopostal": "2270"
    }

Retorna un JSON, Ejemplo

    Agregado con exito
    El tiempo transcurrido fue de 195ms

#### Actualizar localidad

```http
  POST /excel/localidades/update
```

Ejemplo, se envia por body en formato JSON

    {
        "id": 22966,
        "provincia_id": 1,
        "nombre": "Mi provincia Update",
        "codigopostal": "2270"
    }

Retorna un JSON, Ejemplo

    Modificado con exito
    El tiempo transcurrido fue de 195ms

#### Eliminar provincia

```http
  POST /excel/localidad/delete
```
Ejemplo, se envia por body en formato JSON

    22965

Retorna un JSON, Ejemplo

    Borrado con exito
    El tiempo transcurrido fue de 195ms

#### A continuacion se detallan todas las peticiones hacia ambos formatos MySQL y Excel

#### Provincias

#### Obtener todas las provincias

```http
  GET /mix/provincias
```
No requiere de parametros.

Retorna un JSON, Ejemplo

    Respuesta de la base de datos 
    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"}]
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"}]
    El tiempo transcurrido fue de 352ms

#### Obtener provincia por id

```http
  GET /mix/provincias/id
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Requerido**. ID de la provincia a obtener |

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"}]
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"}]
    El tiempo transcurrido fue de 352ms

#### Obtener provincia por codigo31662

```http
  GET /mix/provincias/codigo31662
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `codigo31662`      | `string` | **Requerido**. Codigo31662 de la provincia a obtener |

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"}]
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    [{"id":1,"nombre":"Ciudad Autónoma de Buenos Aires (CABA)","codigo31662":"AR-C"}]
    El tiempo transcurrido fue de 352ms

#### Agregar provincia

```http
  POST /mix/provincias/add
```
Ejemplo, se envia por body en formato JSON

    {
        "nombre" : "Mi provincia 2",
        "codigo31662" : "AR-MMM"
    }

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    Agregado con exito
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    Agregado con exito
    El tiempo transcurrido fue de 352ms

#### Actualizar provincia

```http
  POST /mix/provincias/update
```
Ejemplo, se envia por body en formato JSON

    {
        "id": 35,
        "nombre": "Mi provincia update",
        "codigo31662": "AR-BP"
    }

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    Modficado con exito
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    Modficado con exito
    El tiempo transcurrido fue de 352ms

#### Eliminar provincia

```http
  POST /mix/provincias/delete
```
Ejemplo, se envia por body en formato JSON

    23

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    Borrado con exito
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    Borrado con exito
    El tiempo transcurrido fue de 352ms

## Localidades

#### Obtener todas las localidades

```http
  GET /mix/localidades
```
No requiere de parametros.

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}]
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}]
    El tiempo transcurrido fue de 352ms


#### Obtener localidades por id

```http
  GET /mix/localidades/id
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Requerido**. ID de la localidad a obtener |

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}]
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}]
    El tiempo transcurrido fue de 352ms

#### Obtener localidad por codigo postal

```http
  GET /mix/localidades/codigo
```

| Parametro | Tipo     | Descripcion                       |
| :-------- | :------- | :-------------------------------- |
| `codigo`      | `string` | **Requerido**. Codigo postal de la localidad a obtener |

Responde un JSON, Ejemplo

    Respuesta de la base de datos 
    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}]
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    [{"id":1,"provincia_id":13,"nombre":"CABEZA DE CHANCHO","codigopostal":"3061"}]
    El tiempo transcurrido fue de 352ms

#### Agregar localidad

```http
  POST /mix/localidades/add
```

Ejemplo, se envia por body en formato JSON

    {
        "provincia_id": 10,
        "nombre": "Mi provincia",
        "codigopostal": "2270"
    }

Responde un JSON, Ejemplo
    Respuesta de la base de datos 
    Agregado con exito
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    Agregado con exito
    El tiempo transcurrido fue de 352ms

#### Actualizar localidad

```http
  POST /mix/localidades/update
```

Ejemplo, se envia por body en formato JSON

    {
        "id": 22966,
        "provincia_id": 1,
        "nombre": "Mi provincia Update",
        "codigopostal": "2270"
    }

Responde un JSON, Ejemplo
    Respuesta de la base de datos 
    Modificado con exito
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    Modificado con exito
    El tiempo transcurrido fue de 352ms

#### Eliminar provincia

```http
  POST /mix/localidad/delete
```
Ejemplo, se envia por body en formato JSON

    22965

Responde un JSON, Ejemplo
    Respuesta de la base de datos 
    Borrado con exito
    El tiempo transcurrido fue de 125ms
    Respuesta del archivo excel
    Borrado con exito
    El tiempo transcurrido fue de 352ms
## Explicacion del codigo

Esta seccion esta dedicada exclusivamente a la explicacion tecnica del codigo y porque su resolucion de esta manera.

El codigo consta con tres controladores que son la capa de relacion entre el front-end y el sistema de procesamientos de datos del back-end estos son:
    
    . DBController: Aca se crean todos los metodos que estan relacionados a un end-point,
    esta clase tiene instanciado el servicio de LocalidadesServicesImp y ProvinciasServicesImp
    A su ves cada metodo al ser llamado por el front-end guarda el tiempo de incio y luego de
    ejecutar la sentencia a la base de datos guarda el tiempo final para lograr saber el tiempo
    total de procesamiento.

El controllador ExcelController realiza la misma funcionalidades con el cambio que no llama a los metodos que utlizan la base de datos si no a los que utilizan el formato Excel.

Por ultimo el MixController llama a ambos metodos en cada end-point para realizar asi un comportamiento mixto que permita agregar, leer, actualizar y eliminar datos al mismo tiempo.


Pasamos a hablar de los servicios, poseemos dos de estos llamados LocalidadesServicesImp y el otro
ProvinciasServicesImp ambas son la implementacion de metodos que poseen las interfaces con su mismo nombre ProvinciasServices y LocalidadesServices que contienen las siguientes declaraciones:

LocalidadesServices
    
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

ProvinciasServices
    
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

En el codigo tambien podemos encontrar dos entidades que se relacionan de manera identica a cada tabla y que nos va a permitir almacenar la provincia o la localidad para poder trabajar con ella y luego guardarla en el formato que nosotros queramos.

Poseemos dos repositorios cada uno hace referencia a una tabla y son los que se van a encargar de las sentencias hacia la base de datos.

Por ultimo contamos con una clase llamada ExcelUtils que se va a encargar de realizar toda la logica de abrir, guardar y eliminar archivos en formato Excel, esta clase es muy generica para lograr utilizar cualquier tipo de objeto con el unico requerimiento de pasar una lista de ese objeto y el nombre que queramos guardar del archivo.





## Autor

- Octavio Bill Zito [Github](https://www.github.com/obzk123)

Esta aplicacion tiene como unico proposito cumplir los requerimientos del Challange Eldar como promocion para el nivel dos.

