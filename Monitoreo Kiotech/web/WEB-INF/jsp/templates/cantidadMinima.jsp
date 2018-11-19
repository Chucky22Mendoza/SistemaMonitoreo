<%--
    Document   : cantidadMinima
    Created on : 17/11/2018, 12:56:10 PM
    Author     : Jesús Mendoza Verduzco
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="modal-body row d-flex justify-content-center">
  <label for="mon1" class="form-control-label col-sm-5">Monedas de $1: </label>
  <input id="mon1" type="number" class="form-control col-sm-3 ml-2" name="" value="10" min="5">
</div>
