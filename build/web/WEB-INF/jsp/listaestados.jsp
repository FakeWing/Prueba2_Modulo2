<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" /> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/octicons/3.5.0/octicons.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitudes</title>
    </head>
    <body>
        
        <div class="container">
            <div class="card">
                <div class="card-header bg-info text-white">
                    <h1>Solicitudes</h1>
                    
                </div>
                
                <div class="card-body">
                    <div class="row text-center">
                        <div class="col"><a href="listasolicitud.htm" class="btn btn-info form-control">Todas</a></div>
                        <div class="col"><a href="listaestados.htm?id=1" class="btn btn-dark form-control">Pendientes</a></div>
                        <div class="col"><a href="listaestados.htm?id=2" class="btn btn-dark form-control">Aceptadas</a></div>
                        <div class="col"><a href="listaestados.htm?id=3" class="btn btn-dark form-control">Rechazadas</a></div>
                                     
                        
                        </div>
                    <br>
                    
                    <table class="table table-bordered text-center ">
                        <thead>
                            <tr class="bg-success text-white">
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Email</th>
                                <th>Fono</th>
                                <th>Fecha</th>
                                <th>Glosa</th>
                                <th>Asignado</th>
                                <th>Acciones</th>
                             
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${datos}" var="item">
                                <tr>
                            <td>${item.nombre}</td>
                            <td>${item.apellido}</td>
                            <td>${item.email}</td>
                            <td>${item.fono}</td>
                            <td>${item.fecha}</td>
                            <td>${item.glosa}</td>
                            <td>${item.asignado}</td>
                             <td>
                                  <div class="btn-group text-center">
                                <!--acciones-->
                                <c:if test="${item.idestado==1}">
                                 <a class="btn btn-info btn-lg" href="validasolicitud.htm?idsolicitud=${item.idsolicitud}"><span class="octicon octicon-checklist"></span></a>
                                 </c:if>
                                <c:if test="${item.idestado!=1}">
                                 <button disabled class="btn btn-info btn-lg" ><span class="octicon octicon-checklist"></span></button>
                                 </c:if>
                                
                                <c:if test="${item.idestado==1}">
                                <a class="btn btn-danger btn-lg" href="borrasolicitud.htm?idsolicitud=${item.idsolicitud}"><span class="octicon octicon-trashcan"></span></a>
                                </c:if>
                                <c:if test="${item.idestado!=1}">
                                <button disabled class="btn btn-danger btn-lg"><span class="octicon octicon-trashcan"></span></button>
                                </c:if>
                                
                              
                                
                                </div>
                            </td>
                            
                                </tr>
                            </c:forEach>
                           
                        </tbody>
                    </table>
                        <div class="row ">
                            <div class="col"></div>
                            <div class="col"><a href="nuevasolicitud.htm" class="btn btn-lg btn-success form-control">NUEVA SOLICITUD</a></div>
                            <div class="col"></div>
                        
                </div>
                </div> 
               
                
            </div>
        </div>
    </body>
</html>
