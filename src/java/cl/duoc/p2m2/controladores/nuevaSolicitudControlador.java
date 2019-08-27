/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.p2m2.controladores;

import cl.duoc.p2m2.modelos.conexion.Conectar;
import cl.duoc.p2m2.modelos.vo.SolicitudVo;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hells
 */
public class nuevaSolicitudControlador {

    private JdbcTemplate jdbcT;

    public nuevaSolicitudControlador() {
        Conectar conn = new Conectar();
        this.jdbcT = new JdbcTemplate(conn.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView nuevaSolicitud() {
        ModelAndView mav = new ModelAndView();
        String sql = "select idpersonal as id, nombre as nom, apellido as ape from personal";
        List pers = this.jdbcT.queryForList(sql);
        mav.addObject("pers", pers);
        String sql1 = "select * from validador";
        List valid = this.jdbcT.queryForList(sql1);

        mav.addObject("valid", valid);
        mav.addObject("solicitud", new SolicitudVo());
        mav.setViewName("nuevasolicitud");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView nuevaSolicitud(SolicitudVo s) {
        this.jdbcT.update("insert into solicitud "
                + "(glosa, fecha, idestado, idpersonal, idvalidador, fecha_estado) "
                + "values(?, ?, ?, ?, ?, NOW())",
                s.getGlosa(), s.getFecha(), 1, s.getIdPersonal(), s.getIdValidador());
        return new ModelAndView("redirect:/listasolicitud.htm");
    }
}
