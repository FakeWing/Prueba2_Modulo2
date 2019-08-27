/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.p2m2.controladores;

import cl.duoc.p2m2.modelos.conexion.Conectar;
import cl.duoc.p2m2.modelos.vo.SolicitudVo;
import cl.duoc.p2m2.modelos.vo.ValidadorVo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hells
 */
public class borraSolicitudControlador {

    private JdbcTemplate jdbcT;

    public borraSolicitudControlador() {
        Conectar conn = new Conectar();
        this.jdbcT = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView solicitudBorrar(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();
        int idsolicitud = Integer.parseInt(request.getParameter("idsolicitud"));
        mav.setViewName("borrasolicitud");

        SolicitudVo solicitud = traeSolicitud(idsolicitud);
        mav.addObject("solicitud", solicitud);

        ValidadorVo validador = traeValidador(solicitud.getIdValidador());
        mav.addObject("validador", validador);

        String sql1 = "select * from estados";
        List estados = this.jdbcT.queryForList(sql1);
        mav.addObject("estados", estados);

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView solicitudBorrar(SolicitudVo s, ValidadorVo v, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int idsolicitud = Integer.parseInt(request.getParameter("idsolicitud"));

        SolicitudVo solicitud = traeSolicitud(idsolicitud);
        System.out.println(solicitud.getIdEstado());
        if (validarUsuario(request) && solicitud.getIdEstado() == 1) {

            this.jdbcT.update("DELETE FROM solicitud WHERE idsolicitud=" + idsolicitud);

            return new ModelAndView("redirect:/listasolicitud.htm");

        } else {

            mav.setViewName("borrasolicitud");
            s = traeSolicitud(idsolicitud);
            mav.addObject("solicitud", s);
            mav.addObject("validador", v);
            String sql1 = "select * from estados";
            List estados = this.jdbcT.queryForList(sql1);
            mav.addObject("estados", estados);
            request.setAttribute("errorMessage", "Contraseña Invalida");

            return mav;

        }
    }

    public boolean validarUsuario(HttpServletRequest request) {
        List clave = jdbcT.queryForList("select * from validador where usuario = ? and clave= ?", request.getParameter("usuario"), request.getParameter("clave"));
        if (clave.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public SolicitudVo traeSolicitud(int idsolicitud) {
        SolicitudVo s = new SolicitudVo();

        String sql = "SELECT * FROM solicitud WHERE idsolicitud= " + idsolicitud;
        return (SolicitudVo) jdbcT.query(sql, (ResultSet rs) -> {
            if (rs.next()) {
                s.setFecha(rs.getDate("fecha").toString());
                s.setGlosa(rs.getString("glosa"));
                s.setIdEstado(rs.getInt("idestado"));
                s.setIdValidador(rs.getInt("idvalidador"));

            }
            return s;
        });
    }

    public ValidadorVo traeValidador(int idvalidador) {
        ValidadorVo v = new ValidadorVo();
        String sql = "SELECT * FROM validador WHERE idvalidador=" + idvalidador;
        return (ValidadorVo) jdbcT.query(sql, (ResultSet rs) -> {
            if (rs.next()) {
                v.setIdValidador(rs.getInt("idvalidador"));
                v.setUsuario(rs.getString("usuario"));

            }

            return v;
        });

    }
}
