<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../layouts/head.jsp"/>
    <jsp:include page="../../../layouts/panelInicio.jsp"/>
    <jsp:include page="../../../layouts/admin/list.jsp"/>
    <jsp:include page="../../../layouts/tutor/tutorhead.jsp"/>


    <title>Sesiones</title>
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">
</head>
<body>
<style>
    .content{
        height: 70vh;
    }
</style>
<jsp:include page="../../../layouts/consultor/bodyUp.jsp"/>
<div class="scroll">
    <div class="sm-t flex" style="padding: 1rem">
        <div class="flex">
            <h4 class="txt-4-green" style="font-size: .6rem"><c:out value="${student.name}"/> <c:out value="${student.first_last_name}"/> <c:out value="${student.second_last_name}"/></h4>

        </div>


        <div class="form-floating" style="font-size: .6rem">
            <input type="text"  class="form-control search-input" style="font-size: .6rem " id="inputFiltro" placeholder="Matrìcula">

            <label for="inputFiltro" class="search-span">Fecha</label>
        </div>


    </div>
    <table class="table table-borderless miTablaPersonalizada" id="miTabla" style="display: none;">

        <tr class="">
            <th scope="col">FechaInicio</th>
            <th scope="col">Estudiante</th>
            <th scope="col">Status</th>
            <th scope="col">Place</th>
            <th scope="col">Id</th>
        </tr>




        <c:forEach var="sessions" items="${sessions}" varStatus="s">
            <tr class="ancho-columna">
                <td><c:out value="${sessions.date_begin}"/></td>
                <td><c:out value="${sessions.appointment.student.name}"/> <c:out value="${sessions.appointment.student.first_last_name}"/> <c:out value="${sessions.appointment.student.second_last_name}"/></td>
                <td><c:out value="${sessions.attendance}"/></td>
                <td><c:out value="${sessions.appointment.place}"/></td>
                <td><c:out value="${sessions.appointment.id_appointment}"/></td>

            </tr>
        </c:forEach>

    </table>




    <table id="tablaHTML" class="table table-borderless miTablaPersonalizada">
        <thead>
        <tr >
            <th scope="col">Fecha Cita</th>
            <th scope="col">Estudiante</th>
            <th scope="col">Asistencia</th>
            <th scope="col">Lugar</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody class="table-group-divider">

        </tbody>
    </table>


    <div id="paginado" class="d-flex justify-content-center"></div>
</div>



</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/consultor/ToolsListsSs.js"></script>
</html>