/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.p2m2.modelos.vo;

/**
 *
 * @author hells
 */
public class PersonalVo {
    
    private int idPersonal;
    private String nombre;
    private String apellido;
    private String email;
    private String fono;

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public PersonalVo() {
    }

    public PersonalVo(String nombre, String apellido, String email, String fono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fono = fono;
    }
    
    
    
    
}
