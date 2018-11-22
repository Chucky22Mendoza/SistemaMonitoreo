<%-- 
    Document   : tabla_usuario_evento
    Created on : 22/11/2018, 03:26:34 PM
    Author     : Jesús Mendoza Verduzco
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tbody id="rows2">

  <c:forEach items="${evento}" var="dato">
      <tr>
          <c:set var="count" value="0"></c:set>
          <td class="text-center">${dato.id}</td>
          <td class="text-center">${dato.nombre}</td>
          <c:forEach items="${evento_usuario}" var="dato2">
            <c:if test="${dato2 == dato.id}">
                <c:set var="count" value="${count+1}"></c:set>
            </c:if>
          </c:forEach>
            <c:if test="${count >= 1}">
                <td class="text-center"><input id="${dato.id}" value="" type="checkbox" class="mt-1 cbAlertaSec2" name="" checked></td>
            </c:if>
            <c:if test="${count == 0}">
                <td class="text-center"><input id="${dato.id}" value="" type="checkbox" class="mt-1 cbAlertaSec2" name=""></td>
            </c:if>
      </tr>
  </c:forEach>

</tbody>