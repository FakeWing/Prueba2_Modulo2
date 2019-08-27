/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.p2m2.modelos.vo;

import java.util.Date;
import java.util.List;

public class SolicitudVo {
   
    private int idSolicitud;
    private String glosa;
    private String fecha;
    private int idEstado;
    private int idPersonal;
    private int idValidador;
    private Date fechaEstado;
    private List<ValidadorVo> validadores;

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdValidador() {
        return idValidador;
    }

    public void setIdValidador(int idValidador) {
        this.idValidador = idValidador;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public SolicitudVo() {
    }

    public SolicitudVo(String glosa, String fecha, int idEstado, int idPersonal, int idValidador, Date fechaEstado) {
        this.glosa = glosa;
        this.fecha = fecha;
        this.idEstado = idEstado;
        this.idPersonal = idPersonal;
        this.idValidador = idValidador;
        this.fechaEstado = fechaEstado;
    }
    
  
    
    
}
