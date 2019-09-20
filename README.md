 **CRUD SpringBoot Angular Hoteles**
====================================

###**Aplicación REST con métodos CRUD y BBDD en memoria.**

**FRONT**
- Framework: **Angular 7+**
- URL base : http://localhost:4200

**BACK**
- Framework: **Spring**
- BBDD: **H2 database**
- URL base : http://localhost:8080


### <i class="icon-folder"></i> Proyecto FRONT

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
