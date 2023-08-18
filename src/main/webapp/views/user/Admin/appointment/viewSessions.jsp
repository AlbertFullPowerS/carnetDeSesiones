<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../../layouts/appointment/styleAppointments.jsp"/>
    <jsp:include page="../../../../layouts/head.jsp"/>
    <jsp:include page="../../../../layouts/panelInicio.jsp"/>
    <jsp:include page="../../../../layouts/admin/list.jsp"/>
    <title>Agendar Cita</title>
</head>
<body>
<jsp:include page="../../../../layouts/appointment/bodyUp.jsp"/>
<div class="fondo-complete" id="fondo-complete">
            <table id="tabla-sesiones">
                <tr>
                    <th>Número de Sesión</th>
                    <th>Fecha</th>
                    <th>Consultor</th>
                    <th>Horario</th>
                </tr>
                <c:forEach var="listDate" items="${listDate}" varStatus="s">
                    <tr class="ancho-columna">
                        <td><c:out value="${s.count}"/></td>
                        <td><c:out value="${listDate.prueba}"/> </td>
                        <td><c:out value="${consultor.name}"/> <c:out value="${consultor.first_last_name}"/> <c:out value="${consultor.second_last_name}"/></td>
                        <td><c:out value="${listDate.prueba1}"/></td>
                    </tr>
                </c:forEach>
                <!-- Agrega más filas de datos aquí -->
            </table>


            <div id="div-sesiones"></div>

        </div>

<form action="${pageContext.request.contextPath}/admin/appointment-select-student" method="get">
    <input type="hidden" id="selectedDateTime" name="selectedDateTime">
    <div class="boton">
        <a href="${pageContext.request.contextPath}/admin/appointment-consultor" class="btn-blue" >anterior</a>
        <button type="submit" class="btn-blue">siguiente</button>
</form>
</div>
    </div>
</div>
<jsp:include page="../../../../layouts/appointment/bodyDown.jsp"/>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/appointment/sessions.js"></script>
</html>