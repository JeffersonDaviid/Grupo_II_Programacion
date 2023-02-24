package BusinnessLogic.Entities;

import javax.swing.ImageIcon;

public class Usuario {
    int idUsuario;
    int FkIdEstado;
    int FkIdRol;
    String usuario;
    String contrasena;
    String email;
    String primerNombre;
    String segundoNombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String cedula;
    String telefono;
    ImageIcon foto;

    public Usuario(){
        
    }

    public Usuario(int idUsuario, int fkIdEstado, int fkIdRol, String usuario, String contrasena, String email,
            String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String cedula,
            String telefono, ImageIcon foto) {
        this.idUsuario = idUsuario;
        FkIdEstado = fkIdEstado;
        FkIdRol = fkIdRol;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cedula = cedula;
        this.telefono = telefono;
        this.foto = foto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getFkIdEstado() {
        return FkIdEstado;
    }

    public void setFkIdEstado(int fkIdEstado) {
        FkIdEstado = fkIdEstado;
    }

    public int getFkIdRol() {
        return FkIdRol;
    }

    public void setFkIdRol(int fkIdRol) {
        FkIdRol = fkIdRol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

}
