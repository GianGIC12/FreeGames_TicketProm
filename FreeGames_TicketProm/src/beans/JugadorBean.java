/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author user
 */
public class JugadorBean {
    
    int idApuesta,idUser;
    float monto_jugada;
    int type;
    String fecha_jugada,nombre,apellido,correo;
    String telefono;

    public JugadorBean() {
    }

    public int getIdApuesta() {
        return idApuesta;
    }

    public void setIdApuesta(int idApuesta) {
        this.idApuesta = idApuesta;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getMonto_jugada() {
        return monto_jugada;
    }

    public void setMonto_jugada(float monto_jugada) {
        this.monto_jugada = monto_jugada;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFecha_jugada() {
        return fecha_jugada;
    }

    public void setFecha_jugada(String fecha_jugada) {
        this.fecha_jugada = fecha_jugada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   
    
    
}
