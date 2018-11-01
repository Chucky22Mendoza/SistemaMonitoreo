<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tbody id="rows">

  <c:forEach items="${lista}" var="dato">

    <tr style="cursor: pointer" class="takeRow" id="${dato.idArchivo}">
        <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
        <td class="text-center orden" name="${dato.orden}">${dato.orden}</td>
        <td class="text-center">${dato.nombre}</td>
        <td class="text-center">${dato.tipo}</td>
        <td class="text-center">${dato.duracion}</td>
        <td class="text-center">
          <a value="${dato.idArchivo}-${dato.nombre}"  class="ico-delList">
            <i class="fas fa-trash-alt icono"></i>
          </a>
        </td>
    </tr>
  </c:forEach>
  
</tbody>
