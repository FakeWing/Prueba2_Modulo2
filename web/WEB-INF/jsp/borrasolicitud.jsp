<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar Solicitud</title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header bg-dark text-white">
                      <h1>Borrar Solicitud</h1>
                </div>
                <div class="card-body">
                    
                    <%
                        if (null != request.getAttribute("errorMessage")) {
                            out.println("<div class='alert alert-danger'>"+request.getAttribute("errorMessage")+"</div>");
                        }
                        %> 
                     <f:form method="post" commandName="solicitud">
                         
                     
                         
                         
                        <p>
                         <f:label path="fecha">Fecha:</f:label>
                        <f:input disabled="true" path="fecha" class="form-control" required="true" type="date"/>   
                        </p>
                        <p>
                         <f:label path="glosa">glosa:</f:label>
                        <f:input disabled="true" path="glosa" class="form-control" required="true"/> 
                        </p>
                        <p>
                     
                            <p>
                                <f:label path="idEstado">Seleccione Estado</f:label>
                                <f:select selected="true" disabled="true" path="idEstado" class="form-control">
                                    <c:forEach items="${estados}" var="estados">
                                        <f:option value="${estados.idestado}">${estados.detalle}</f:option>
                                    </c:forEach>
                                </f:select>
                   
                        </p>
                        
                           
                        <p>
                        <label >Usuario</label>
                        <input  value="${validador.usuario}" name="usuario" class="form-control editable-false" type="text" readonly/>
                        </p>
                          <p>
                        <label >Clave</label>
                        <input value="${validador.clave}" name="clave"  class="form-control" type="password"  required />
                        </p>

                        
                        
                        
                   <div class="row">
                            <div class="col"> <f:button class=" btn btn-danger form-control">BORRAR SOLICITUD</f:button></div>

                                <div class="col"><a class=" btn btn-success form-control" href="listasolicitud.htm">VOLVER A LA LISTA</a></div>
                            </div>
                    </f:form>
                   
                    
                </div>
            </div>
        </div>
      
    </body>
</html>