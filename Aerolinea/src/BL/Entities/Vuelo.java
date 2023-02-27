package BL.Entities;

public class Vuelo {
    private int id;
    private String estado; // S: disponible, N: no disponible
    private int tipoVuelo; // 1: IDA. 2: IDA Y VUELTA
    private String lugarPartida;
    private String lugarDestino;
    private float precioPorPersona;
    private String recomendacion; // 'S': Si, 'N': No
    private String claseVuelo; // directo, transbordo
    private String latamPass; // 'S' Si, 'N' NO, lo usaremos como un booleano
    private int clasePrecio; // 1: ECONOMICO, 2: NEGOCIOS, 3: PIMERA CLASE

    private String fechaSalida;
    private String fechaVuelta;
    private String tiempoSalida;
    private String tiempoLlegada;

    public Vuelo(){
        
    }

    public Vuelo(int id, String estado, int tipoVuelo, String lugarPartida, String lugarDestino, float precioPorPersona,
            String recomendacion, String claseVuelo, String latamPass, int clasePrecio, String fechaSalida,
            String fechaVuelta, String tiempoSalida, String tiempoLlegada) {
        this.id = id;
        this.estado = estado;
        this.tipoVuelo = tipoVuelo;
        this.lugarPartida = lugarPartida;
        this.lugarDestino = lugarDestino;
        this.precioPorPersona = precioPorPersona;
        this.recomendacion = recomendacion;
        this.claseVuelo = claseVuelo;
        this.latamPass = latamPass;
        this.clasePrecio = clasePrecio;
        this.fechaSalida = fechaSalida;
        this.fechaVuelta = fechaVuelta;
        this.tiempoSalida = tiempoSalida;
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(int tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getLugarPartida() {
        return lugarPartida;
    }

    public void setLugarPartida(String lugarPartida) {
        this.lugarPartida = lugarPartida;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public float getPrecioPorPersona() {
        return precioPorPersona;
    }

    public void setPrecioPorPersona(float precioPorPersona) {
        this.precioPorPersona = precioPorPersona;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public String getLatamPass() {
        return latamPass;
    }

    public void setLatamPass(String latamPass) {
        this.latamPass = latamPass;
    }

    public int getClasePrecio() {
        return clasePrecio;
    }

    public void setClasePrecio(int clasePrecio) {
        this.clasePrecio = clasePrecio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaVuelta() {
        return fechaVuelta;
    }

    public void setFechaVuelta(String fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public String getTiempoSalida() {
        return tiempoSalida;
    }

    public void setTiempoSalida(String tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public String getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(String tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

}