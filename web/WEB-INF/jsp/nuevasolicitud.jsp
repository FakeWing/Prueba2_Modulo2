<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Solicitud</title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header bg-dark text-white">
                      <h1>Crear Solicitud</h1>
                </div>
                <div class="card-body">
                     <f:form method="post" commandName="solicitud">
                         
                     
                         
                         
                        <p>
                         <f:label path="fecha">Fecha:</f:label>
                        <f:input  path="fecha" class="form-control" required="true" type="date"/>   
                        </p>
                        <p>
                         <f:label path="glosa">glosa:</f:label>
                        <f:input path="glosa" class="form-control" required="true"/> 
                        </p>
                        <p>
                     
                            <p>
                            <f:label path="idPersonal">Personal</f:label>                            
                            <f:select path="idPersonal" cssClass="form-control">
                                <f:option selected="true" disabled="true" value="0">Seleccione..</f:option>
                                <c:forEach items="${pers}" var="pers">
                                    <f:option value="${pers.id}">${pers.nom} ${pers.ape}</f:option>
                            </c:forEach>
                            </f:select>
                        </p>
                           <p>
                            <f:label path="idValidador">Validador</f:label>                            
                            <f:select path="idValidador" cssClass="form-control">
                                <f:option selected="true" disabled="true" value="0">Seleccione..</f:option>
                                <c:forEach items="${valid}" var="valid">
                                    <f:option value="${valid.idvalidador}">${valid.usuario}</f:option>
                            </c:forEach>
                            </f:select>
                        </p>
                        
                        <div class="row">
                            <div class="col"> <f:button class=" btn btn-warning form-control">Generar Solicitud</f:button></div>

                                <div class="col"><a class=" btn btn-success form-control" href="listasolicitud.htm">VOLVER A LA LISTA</a></div>
                            </div>
                    </f:form>
                   
                    
                </div>
            </div>
        </div>
      
    </body>
</html>