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

    public final String FK_ID_ESTADO = "FK_ID_ESTADO";
    public final String NOMBRE = "NOMBRE";
    public final String ESTADO = "ESTADO";
    public final String ID_ROL = "ID_ROL";
    public final String ID_ESTADO = "ID_ESTADO";

    // BASE DE DATOS ---- PRODUCTO
    public final String ID_PRODUCTO = "ID_PRODUCTO";
    public final String CODIGO_PRODUCTO = "CODIGO_PRODUCTO";
    public final String FK_ID_CATEGORIA_PRODUCTO = "FK_ID_CATEGORIA_PRODUCTO";
    public final String PK_ID_IVA = "PK_ID_IVA";
    public final String PRODUCTO = "PRODUCTO";
    public final String STOCK = "STOCK";
    public final String PRECIO_COMPRA = "PRECIO_COMPRA";
    public final String PRECIO_VENTA = "PRECIO_VENTA";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String IMAGEN = "IMAGEN";
    public final String FECHA_CREACION = "FECHA_CREACION";
    public final String FECHA_MODIFICACION = "FECHA_MODIFICA";

    // BASE DE DATOS ---- USARIO
    public final String ID_USUARIO = "ID_USUARIO";
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

}
