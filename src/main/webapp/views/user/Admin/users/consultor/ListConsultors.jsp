
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../../../layouts/appointment/styleAppointments.jsp"/>
    <jsp:include page="../../../../../layouts/head.jsp"/>
    <jsp:include page="../../../../../layouts/panelInicio.jsp"/>
    <jsp:include page="../../../../../layouts/admin/list.jsp"/>


    <title>Consultores</title>
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">
</head>
<body>
<jsp:include page="../../../../../layouts/admin/bodyUp.jsp"/>
            <div class="scroll">
                <div class="sm-t flex">
                    <div class="flex">
                        <h2 class="txt-4-green">Consultores</h2>

                        <a href="${pageContext.request.contextPath}/admin/consultor/create" class="btn-green">Agregar</a>

                    </div>


                    <div class="form-floating" style="font-size: .6rem">
                        <input type="text"  class="form-control search-input" style="font-size: .6rem " id="inputFiltro" placeholder="Email">

                        <label for="inputFiltro" class="search-span">Email</label>
                    </div>


                </div>
                <table class="table table-borderless miTablaPersonalizada" id="miTabla" style="display: none;">

                    <tr class="hv">
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Email</th>
                        <th scope="col">Id</th>
                    </tr>

                    <c:forEach var="consultor" items="${Consultors}" varStatus="s">
                        <tr class="ancho-columna">
                            <td><c:out value="${consultor.name}"/></td>
                            <td><c:out value="${consultor.first_last_name}"/> <c:out value="${consultor.second_last_name}"/></td>
                            <td><c:out value="${consultor.email}"/> </td>
                            <td><c:out value="${consultor.id_consultor}"/></td>
                        </tr>
                    </c:forEach>
                </table>




                <table id="tablaHTML" class="table table-borderless miTablaPersonalizada">
                    <thead>
                    <tr class="">
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Email</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">

                    </tbody>
                    <br>
                </table>


                <div id="paginado" class="d-flex justify-content-center"></div>
            </div>


<jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>
</body>
<jsp:include page="../../../../../layouts/admin/listsJSCon.jsp"/>
</html>