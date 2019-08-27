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
public class ValidadorVo {
   private int idValidador;
   private String usuario;
   private String clave;
   private int idPersonal;
   

    public int getIdValidador() {
        return idValidador;
    }

    public void setIdValidador(int idValidador) {
        this.idValidador = idValidador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public ValidadorVo() {
    }

    public ValidadorVo(String usuario, String clave, int idPersonal) {
        this.usuario = usuario;
        this.clave = clave;
        this.idPersonal = idPersonal;
    }
   
    
   
}
