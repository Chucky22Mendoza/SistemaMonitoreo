<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tbody id="rows2">
    <c:forEach items="${lista}" var="dato">
      <tr>
        <td class="text-center"><input type="checkbox" class="mt-1 cbAr2" name="cbAr" value="${dato.id}" style="cursor:pointer;"></td>
        <td class="text-center">${dato.nombre}</td>
        <td class="text-center">${dato.tipo}</td>
        <td class="text-center">${dato.duracion}</td>
      </tr>
    </c:forEach>
</tbody>
