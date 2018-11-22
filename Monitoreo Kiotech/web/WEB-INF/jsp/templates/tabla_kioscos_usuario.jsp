<%--
    Document   : tabla_kioscos_usuario
    Created on : 20-nov-2018, 16:52:54
    Author     : mario
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tbody id="rows">

  <c:forEach items="${kiosco}" var="dato">
      <tr>
          <c:set var="count" value="0"></c:set>
          <td class="text-center">${dato.id_kiosco}</td>
          <td class="text-center">${dato.nombre}</td>
          <c:forEach items="${permiso}" var="dato2">
            <c:if test="${dato2 == dato.id_kiosco}">
                <c:set var="count" value="${count+1}"></c:set>
            </c:if>
          </c:forEach>
            <c:if test="${count >= 1}">
                <td class="text-center"><input id="${dato.id_kiosco}" value="" type="checkbox" class="mt-1 cbAlertaSec" name="${dato.id_usuario}" checked></td>
            </c:if>
            <c:if test="${count == 0}">
                <td class="text-center"><input id="${dato.id_kiosco}" value="" type="checkbox" class="mt-1 cbAlertaSec" name="${dato.id_usuario}"></td>
            </c:if>
      </tr>
  </c:forEach>

</tbody>
