<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../../layouts/bootStrap.jsp"/>

    <jsp:include page="../../../../layouts/head.jsp"/>
    <jsp:include page="../../../../layouts/panelInicio.jsp"/>
    <jsp:include page="../../../../layouts/admin/list.jsp"/>
    <jsp:include page="../../../../layouts/appointment/styleAppointments.jsp"/>


    <title>Agendar Cita</title>
</head>
<body>
<jsp:include page="../../../../layouts/appointment/bodyUp.jsp"/>
<div class="fondo-complete" id="fondo-complete">
            <div class="up">
                <div class="tutor txt-4-green">
                    <h6><c:out value="${consultor.name}"/> <c:out value="${consultor.first_last_name}"/> <c:out value="${consultor.second_last_name}"/></h6>
                </div>
                <input type="week" id="weekInput" style="font-size: .5rem;" class="dateSupr">
            </div>
            <div class="calendar" id="calendarContainer"></div>
            <table style="display: none;">
                <tr>
                    <th>Fecha</th>
                    <th>Hora</th>
                </tr>
                <c:forEach var="sessions" items="${sessions}" varStatus="s">
                    <tr class="ancho-columna">
                        <td><c:out value="${sessions.data}"/></td>
                        <td><c:out value="${sessions.hour}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
<form action="${pageContext.request.contextPath}/admin/appointment-view-sessions" method="get">
    <input type="hidden" required id="selectedDateTime" name="selectedDateTime">
    <div class="boton">
        <a href="${pageContext.request.contextPath}/admin/appointment-select-consultor" class="btn-blue" >anterior</a>
        <button type="submit" class="btn-blue">siguiente</button>
</form>
</div>
            <jsp:include page="../../../../layouts/appointment/bodyDown.jsp"/>


</body>
<jsp:include page="../../../../layouts/appointment/toolsCalendario.jsp"/>

</html>
