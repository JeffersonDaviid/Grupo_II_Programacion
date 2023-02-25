package Framework;

public enum APP {
    GLOBAL, LOGIN, BASE_DATOS_MYSQL;

    public final int ADMINISTRADOR = 1;
    public final int TRABAJADOR = 2;

    // TABLA ACTUALIZAR
    public final int NINGUN_FILTRO = 0;

    // BASE DE DATOS
    public final String DB_NAME = "jdbc:mysql://localhost/DB_INVENTARIO";
    public final String DB_USER = "root";
    public final String DB_PASSWORD = "";

    // TABLAS
    public final String TABLA_ESTADO = "Estado";
    public final String TABLA_CATEGORIA_PRODUCTO = "CategoriaProducto";
    public final String TABLA_IVA = "Iva";
    public final String TABLA_PRODUCTO = "producto";
    public final String TABLA_ROL = "Rol";
    public final String TABLA_USUARIO = "Usuario";

    // BASE DE DATOS ---- VARIABLES SECUNDARIAS
    public final String PK_ID_ROL = "PK_ID_ROL";
    public final String PK_ID_ESTADO = "PK_ID_ESTADO";
    public final String PK_ID_IVA = "PK_ID_IVA";
    public final String PK_ID_CATEGORIA_PRODUCTO = "PK_ID_CATEGORIA_PRODUCTO";
    public final String FK_ID_ESTADO = "FK_ID_ESTADO";
    public final String NOMBRE = "NOMBRE";
    public final String ESTADO = "ESTADO";

    // BASE DE DATOS ---- PRODUCTO
    public final String PK_ID_PRODUCTO = "PK_ID_PRODUCTO";
    public final String CODIGO_PRODUCTO = "CODIGO_PRODUCTO";
    public final String FK_ID_CATEGORIA_PRODUCTO = "FK_ID_CATEGORIA_PRODUCTO";
    public final String FK_ID_IVA = "FK_ID_IVA";
    public final String PRODUCTO = "PRODUCTO";
    public final String STOCK = "STOCK";
    public final String PRECIO_COMPRA = "PRECIO_COMPRA";
    public final String PRECIO_VENTA = "PRECIO_VENTA";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String IMAGEN = "IMAGEN";
    public final String FECHA_CREACION = "FECHA_CREACION";
    public final String FECHA_MODIFICACION = "FECHA_MODIFICA";

    // BASE DE DATOS ---- USARIO
    public final String PK_ID_USUARIO = "PK_ID_USUARIO";
    public final String FK_ID_ROL = "FK_ID_ROL";
    public final String USUARIO = "USUARIO";
    public final String CONTRASENA = "CONTRASENA";
    public final String EMAIL = "EMAIL";
    public final String PRIMER_NOMBRE = "PRIMER_NOMBRE";
    public final String SEGUNDO_NOMBRE = "SEGUNDO_NOMBRE";
    public final String APELLIDO_PATERNO = "APELLIDO_PATERNO";
    public final String APELLIDO_MATERNO = "APELLIDO_MATERNO";
    public final String CEDULA = "CEDULA";
    public final String TELEFONO = "TELEFONO";
    public final String FOTO = "FOTO";
}
