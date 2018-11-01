<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
              <tbody  id="rows">
                 <c:forEach items="${programadas}" var="dato">
                    <c:set var="dom" value="${dato.d}"></c:set>
                    <c:set var="lun" value="${dato.l}"></c:set>
                    <c:set var="mar" value="${dato.ma}"></c:set>
                    <c:set var="mier" value="${dato.mi}"></c:set>
                    <c:set var="jue" value="${dato.j}"></c:set>
                    <c:set var="vie" value="${dato.v}"></c:set>
                    <c:set var="sab" value="${dato.s}"></c:set>
                  <tr>
                    <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                    <td id="nombreLista" class="text-center">${dato.nombreLista}</td>
                    <td id="horaInicio" class="text-center">${dato.hora_inicio}</td>

                    <c:if test="${dom == true}">
                        <td class="text-center"><input id="D" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${dom == false}">
                        <td class="text-center"><input id="D" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>

                    <c:if test="${lun == true}">
                        <td class="text-center"><input id="L" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${lun == false}">
                        <td class="text-center"><input id="L" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>

                    <c:if test="${mar == true}">
                        <td class="text-center"><input id="Ma" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${mar == false}">
                        <td class="text-center"><input id="Ma" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>

                    <c:if test="${mier == true}">
                        <td class="text-center"><input id="Mi" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${mier == false}">
                        <td class="text-center"><input id="Mi" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>

                    <c:if test="${jue == true}">
                        <td class="text-center"><input id="J" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${jue == false}">
                        <td class="text-center"><input id="J" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>

                    <c:if test="${vie == true}">
                        <td class="text-center"><input id="V" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${vie == false}">
                        <td class="text-center"><input id="V" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>

                    <c:if test="${sab == true}">
                        <td class="text-center"><input id="S" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${sab == false}">
                        <td class="text-center"><input id="S" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>

                    <td class="text-center">
                      <a id="${dato.id_lista_reproduccion}" name="${dato.nombreLista}" value="${dato.nombreLista}-${dato.hora_inicio}-${dato.d}-${dato.l}-${dato.ma}-${dato.mi}-${dato.j}-${dato.v}-${dato.s}"
                        class="ico-edit" >
                        <i class="fas fa-edit icono"></i>
                      </a>
                    </td>
                  </tr>
                 </c:forEach>
              </tbody>

              <script>
              $('.ico-edit').on('click', function(){
                $('#selectList').attr('disabled','disabled');
                $('#modalProgramarLista').modal('show');
              });
              </script>
