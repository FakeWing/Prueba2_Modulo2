/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.p2m2.modelos.conexion;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author hells
 */
public class Conectar {
    
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/db_prueba2mvc?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("qwerty");
        
        return dataSource;
        
    }
    
    
    
}
