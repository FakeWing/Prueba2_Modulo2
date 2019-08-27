/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.p2m2.controladores;

import cl.duoc.p2m2.modelos.conexion.Conectar;
import cl.duoc.p2m2.modelos.vo.SolicitudVo;
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
public class listaEstadosControlador {

    private JdbcTemplate jdbcT;

    public listaEstadosControlador() {
        Conectar conn = new Conectar();
        this.jdbcT = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView solicitudes(HttpServletRequest request) {
        int idestado = Integer.parseInt(request.getParameter("id"));
        String sql = "SELECT \n"
                + "s.idsolicitud,s.idestado, p.nombre, p.apellido,p.email,p.fono,s.fecha, s.glosa , v.usuario AS asignado\n"
                + "FROM solicitud AS s \n"
                + "JOIN estados AS e ON e.idestado = s.idestado \n"
                + "JOIN validador AS v ON v.idvalidador = s.idvalidador \n"
                + "JOIN personal AS p ON p.idpersonal = s.idpersonal where e.idestado= " + idestado;
        List datos = this.jdbcT.queryForList(sql);

        ModelAndView mav = new ModelAndView();

        mav.addObject("datos", datos);
        mav.setViewName("listaestados");

        return mav;

    }
}
