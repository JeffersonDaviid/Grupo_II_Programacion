# INVENTARIO - GRUPO 2 - PROYECTO FINAL

Developers:
- Jefferson Chileno 

Roles:
- Jefferson: code
- Simone: Diseño y archivos
- Luis: Diseño y archivos
- Angel: code
- Sebastian: code
 
 > Unicamente son referencias 

 ### WARNING
Todos los integrantes deben tener la siguiente configuración en .gitignore para subir sus archivos

bin         
.gitignore          
*.class         
.vscode         
*.jar               
out               
.idea           
*.iml 

O cualquier archivo que no sea parte necesaria/indispensable en el proyecto

#  CONVENSION DE TRABAJO

## Asignacion de variables

### Entradas por teclado
- i_nombre
  > ejemplo:
  > - Entrada de usuario: _i_usuario_ 
  > - Entrada de contraseña: _i_contrasena_
  > - Entrada de codigo de barras: _i_codigo_

### Botones
- btn_nombre
    > ejemplo:
    > - Boton ingresar: _btn_ingresar_

### ComboBox
- combo_nombre
  > ejemplo:
  > - Escoger rol del usuario: _combo_rol_

### Paneles
- panel_nombre
  > ejemplo:
  > - panel de navegacion que contiene botones de opciones: panel_navegacionUsuario

### Imagenes
- img_nombre
  > Ejemplo:
  > - fondo del login: _img_fondoLogin_
  > - imagen del producto: img_mouseGamerAzul

> __NOTA 1__: Tanto el nombre de la variable y el nombre del archivo deben tener el mismo nombre y debe estar dentro de la __carpeta images__    
> __NOTA 2__: Si se usan iconos, los archivos deben estar en la carpeta iconos y la variable debe nombrarse: _icon_nombre_
    > ejemplo: 
    > - icono de inicio/home: icon_inicio   


### Fuciones
- todo con camelCase

> En general hay que ser bastante descriptivo tanto en la asignacion de las variables como de las funciones


> NO OLVIDARSE QUE PUEDEN PREGUNTAR Y SOBRE TODO EMITIR SUGERENCIAS :D




<br>

## BASE DE DATOS USUARIOS  
<br>

### TABLA - ESTADO DEL USUARIO

| ID_ESTADO | ESTADO        |
| --------- | ------------- |
| 0         | NO DISPONIBLE |
| 1         | DISPONIBLE    |

<br>

### TABLA - CATEGORIA ROL DEL USUARIO

| ID_CATEGORIA_ROL | FK_ID_ESTADO | ROL           |
| ---------------- | ------------ | ------------- |
| 1                | 1            | ADMINISTRADOR |
| 2                | 2            | TRABAJADOR    |


<br>

### TABLA - USUARIOS
| ID_USUARIO | FK_ID_ESTADO | FK_CATEGORIA_ROL | USUARIO          | CONTRASENA | EMAIL                   | PRIMER_NOMBRE | SEGUNDO_NOMBRE | APELLIDO_PATERNO | APELLIDO_MATERNO | CEDULA     | TELEFONO   | FOTO |
| ---------- | ------------ | ---------------- | ---------------- | ---------- | ----------------------- | ------------- | -------------- | ---------------- | ---------------- | ---------- | ---------- | ---- |
| 1          | 1            | 1                | Developer        | 12345      |                         |               |                |                  |                  |            | 09XXXXXXXX | url  |
| 2          | 1            | 2                | thomas.germain17 | 271001     | thomasgermain@gmail.com | Thomas        | Daniel         | Germain          | Lennox           | 1748968418 | 09927XXXXX | url  |
<br>

<br>
<br>

## BASE DE DATOS INVENTARIO  
<br>

### TABLA - ESTADO DEL PRUDUCTO

| ID_ESTADO | ESTADO        |
| --------- | ------------- |
| 0         | NO DISPONIBLE |
| 1         | DISPONIBLE    |

<br>

### TABLA - CATEGORIA DE PRODUCTO

| ID_CATEGORIA_PRODUCTO | ID_ESTADO | NOMBRE            |
| --------------------- | --------- | ----------------- |
| 1                     | 1         | Granos            |
| 2                     | 2         | electrodomesticos |


<br>

### TABLA - IVA

| ID_IVA | NOMBRE |
| ------ | ------ |
| 0      | No     |
| 1      | Si     |


<br>

### TABLA - PRODUCTO0
| ID_PRODUCTO | CODIGO_PRODUCTO | FK_ID_ESTADO | FK_ID_CATEGORIA_PRODUCTO | PK_IVA | PRODUCTO         | STOCK | PRECIO_COMPRA | PRECIO_VENTA | DESCRIPCION | IMAGEN | FECHA      |
| ----------- | --------------- | ------------ | ------------------------ | ------ | ---------------- | ----- | ------------- | ------------ | ----------- | ------ | ---------- |
| S2X3        | 1112021100029   | 1            | 1                        | 1      | Arroz Rico 25 lb | 700   | 17.85         | 25.00        | rico        | url    | 25/01/2022 |
| X2S5        | 9200011202111   | 1            | 2                        | 1      | Television 4k    | 100   | 870.00        | 960.00       | Samsung     | url    | 16/01/2023 |
| WS55        | 9200159881881   | 2            | 1                        | 1      | Aceite 1 litro   | 2500  | 1.00          | 1.25         | Samsung     | url    | 16/01/2023 |


> NOTA: Si se el producto se acaba debe cambiar la disponibilidad del producto

CAMEL CASE
