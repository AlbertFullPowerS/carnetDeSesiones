
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


    <title>Tutores</title>
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">
</head>
<body>
<jsp:include page="../../../../../layouts/admin/bodyUp.jsp"/>
            <div class="scroll">
                <div class="sm-t flex">
                    <div class="flex">
                        <h2 class="txt-4-green">Tutores</h2>

                        <a href="${pageContext.request.contextPath}/admin/tutor/create" class="btn-green">Agregar</a>

                    </div>


                    <div class="form-floating" style="font-size: .6rem">
                        <input type="text"  class="form-control search-input" style="font-size: .6rem " id="inputFiltro" placeholder="Email">

                        <label for="inputFiltro" class="search-span">Email</label>
                    </div>


                </div>
                <table class="table table-borderless miTablaPersonalizada" id="miTabla" style="display: none;">

                    <tr class="">
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Email</th>
                        <th scope="col">Id</th>
                    </tr>

                    <c:forEach var="tutor" items="${tutors}" varStatus="s">
                        <tr class="ancho-columna">
                            <td><c:out value="${tutor.name}"/></td>
                            <td><c:out value="${tutor.first_last_name}"/> <c:out value="${tutor.second_last_name}"/></td>
                            <td><c:out value="${tutor.email}"/> </td>
                            <td><c:out value="${tutor.id_user}"/></td>
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
                </table>


                <div id="paginado" class="d-flex justify-content-center"></div>
            </div>


<jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/ToolsListsTut.js"></script>
</html>