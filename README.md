 **CRUD SpringBoot Angular Hoteles**
====================================

**APLICACIÓN REST CON MÉTODOS CRUD Y BBDD EN MEMORIA**

**FRONT**
- Framework: **Angular 7+**
- URL base : http://localhost:4200

**BACK**
- Framework: **Spring**
- BBDD: **H2 database**
- URL base : http://localhost:8080


### <i class="icon-folder"></i> Proyecto FRONT

**Prerequisitos**

1. Node.js
https://nodejs.org/es/
Descargamos la Recomendada para la mayoría.

2. TypeScript
Instalar de forma global, usando el comando en consola: 
<strong>npm install -g typescript</strong>

3. Angular CLI
https://angular.io/guide/setup-local

**Ejecución de la aplicación en local**

1. Ir a la carpeta Workspace de la aplicación.
**cd CRUD-angular7-hoteles-front**

2. Comando para instalar las dependecias de la aplicación.
**npm install**

3. Comando para ejecutar el servidor
**npm run start**

Mediante el comando "***npm run start***" estamos ejecutando el siguiente script definido en el package.json.

**ng serve --proxy-config proxy.conf.json**


### <i class="icon-folder"></i> Proyecto BACK

**Endpoints**

GET /hoteles/           - **Listar todos los hoteles**
GET /hoteles/{id}     - **Listar hotel por ID**

POST /hoteles          - **Insertar hotel**

```json
{
    "nombre": "hotel 4",
    "tipo": "Hotel 5 estrellas",
    "cadena": "Grupotel",
    "zona": "Playa de Palma",
    "codigoficina": "HIP",
    "activo": "S"
}
```

PUT /hoteles /{id}         - **Actualizar hotel**

```json
{
    "nombre": "hotel 5",
    "tipo": "Hotel 5 estrellas",
    "cadena": "Grupotel",
    "zona": "Alcudia",
    "codigoficina": "HAC",
    "activo": "N"
}
```

DELETE /hotels/{id} - **Eliminar hotel**

**Importar colecciones al Postman** 

En el archivo **CRUD-springboot-hoteles.postman_collection.json** estan definidas las colecciones de todas las peticiones CRUD de hoteles.
