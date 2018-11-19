<%-- 
    Document   : tablaHistorialAlerta
    Created on : 17/11/2018, 11:12:31 AM
    Author     : Jesús Mendoza Verduzco
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tbody id="rows">
  <c:set var="contador" value="${0}"></c:set>
  <c:forEach items="${historial}" var="dato">
      <c:set var="contador" value="${contador+1}"></c:set>
      <c:set var="status" value="${dato.status}"></c:set>
      <!--<c:out value="${dato.status}"></c:out>-->
    <c:if test = "${contador <=  15}">
    <tr>
      <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
      <td class="text-center">${dato.id}</td>
      <td class="text-center">${dato.fechaHora}</td>
      <td class="text-center">${dato.tipoAlerta}</td>
      <td class="text-center">${dato.mensaje}</td>
      <td class="text-center">${dato.kiosco}</td>
      <c:if test = "${status == true}">
        <td class="text-center text-success h3">
          <a id="${dato.id}" name="${status}" value="${dato.kiosco}" class="ico-status" title="success" style="cursor: pointer">
            <i class="fas fa-check-circle"></i>
          </a>
        </td>
      </c:if>
      <c:if test = "${status == false}">
        <td class="text-center text-danger h3">
          <a id="${dato.id}" name="${status}" value="${dato.kiosco}" class="ico-status" title="error" style="cursor: pointer">
            <i class="fas fa-exclamation-circle"></i>
          </a>
        </td>
      </c:if>
      <td class="text-center h3">
        <a id="${dato.id}" name="${dato.mensaje}" value="${dato.fechaHora}/${dato.tipoAlerta}/${dato.mensaje}/${dato.kiosco}" class="ico-detalles" title="Detalles">
          <i class="far fa-eye icono"></i>
        </a>
      </td>
    </tr>
    </c:if>
  </c:forEach>
</tbody>
