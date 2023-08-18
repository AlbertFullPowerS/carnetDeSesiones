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


    <title>Estudiantes</title>
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">
</head>
<body>
<style>
    .content{
        height: 70vh;
    }
</style>
<jsp:include page="../../../layouts/tutor/bodyUp.jsp"/>
<div class="scroll">
    <div class="sm-t flex">
        <div class="flex">
            <h2 class="txt-4-green">Estudiantes</h2>


        </div>


        <div class="form-floating" style="font-size: .6rem">
            <input type="text"  class="form-control search-input" style="font-size: .6rem " id="inputFiltro" placeholder="Matricula">

            <label for="inputFiltro" class="search-span">Matrícula</label>
        </div>


    </div>
    <table class="table table-borderless miTablaPersonalizada" id="miTabla" style="display: none;">

        <tr class="">
            <th scope="col">Nombre</th>
            <th scope="col">Apellidos</th>
            <th scope="col">GradoyGrupo</th>
            <th scope="col">Carrera</th>
            <th scope="col">Matricula</th>
            <th scope="col">Id</th>
            <th scope="col">IdU</th>
        </tr>




        <c:forEach var="student" items="${students}" varStatus="s">
            <tr class="ancho-columna">
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.first_last_name}"/> <c:out value="${student.second_last_name}"/></td>
                <td><c:out value="${student.group.grade}"/> - <c:out value="${student.group.group}"/></td>
                <td><c:out value="${student.group.academic_program.programName}"/> </td>
                <td><c:out value="${student.enrollment}"/></td>
                <td><c:out value="${student.id_student}"/></td>
                <td><c:out value="${student.id_user}"/></td>

            </tr>
        </c:forEach>

    </table>




    <table id="tablaHTML" class="table table-borderless miTablaPersonalizada">
        <thead>
        <tr >
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Grado y Grupo</th>
            <th scope="col">Carrera</th>
            <th scope="col">Matricula</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody class="table-group-divider">

        </tbody>
    </table>


    <div id="paginado" class="d-flex justify-content-center"></div>
</div>



</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/tutor/ToolsListsSt.js"></script>
</html>