package FWK;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * AppConfiguration
 * Definici�n de variables globales, constantes y configuraciones
 * para toda la aplicacion
 * patmic
 */
public enum APP {
    GLOBAL;
    public final  String  KEY_DB_FULLPATH   = "DB_FULLPATH";
    public final  String  API_GET_USER      = "https://jsonplaceholder.typicode.com/users/";
    public final  String  API_LOCAL_GET_USER= "http://127.0.0.1:5500/src/API/get_user.json";
    public final  int  METHOD_OK            = 200;
    public final  int  METHOD_ERROR         = 400;
    //Constantes por definir en el contructor
    private final String  CONFIG_PATH           ;
    private final String  EXCEPTION_UNDEFINED       ;
    private final String  EXCEPTION_UNDEFINED_CLASS ;
    private final Boolean LOG_ON_OFF                ;
    private final Double  PI;
    private Properties config=null;
    APP() {
        //Definir constantes
        LOG_ON_OFF                  = true;
        CONFIG_PATH                 = "src/appConfig.properties";
        EXCEPTION_UNDEFINED         = "Error no identificado";
        EXCEPTION_UNDEFINED_CLASS   = "Error en clase no especificada ";
        PI                          = 1.14;

        //Load : appConfig.properties
        try{
            config = new Properties();
            InputStream configInput = new FileInputStream(CONFIG_PATH);
            config.load(configInput);
        }  
        catch (Exception e) {  // IOException - FileNotFoundException
            System.out.println("<<ERROR>> : appConfig.properties, No encontrado \nAPP.APP()");
        }
    }

    /**
     * getProperty  : retorna el valor de Key configurado en el archivo appConfig.properties
     * @throws : AppException excepcion personalizada
     * @Key    : Palabra clave definida en el achivo appConfig.properties caso contrario null
     * */ 
    public static String getProperty(String Key) { 
        String value = APP.GLOBAL.config.getProperty(Key);  
        if (value == null)
            System.out.println("<<ISSUE>> : "+Key+"  no definida en appConfig.properties \nAPP.getProperty()");
        return value;
    }

    // metodos de acceso a las constastes
    public static double  getPI()           {   return  APP.GLOBAL.PI; }
    public static String  getConfigPath()   {   return  APP.GLOBAL.CONFIG_PATH; }
    public static Boolean getLogOnOff()     {   return  APP.GLOBAL.LOG_ON_OFF; }
    // metodos de acceso restringido
    protected String  getExceptionUndefined()      {   return  EXCEPTION_UNDEFINED; }
    protected String  getExceptionUndefinedClass() {   return  EXCEPTION_UNDEFINED_CLASS; }
}
