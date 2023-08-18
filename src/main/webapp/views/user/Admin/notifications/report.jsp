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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/Admin/reporte.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>


    <title>Notificaciones</title>
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">


</head>
<body>
<jsp:include page="../../../../layouts/appointment/bodyUp.jsp"/>
<div class="fondo-complete">
    <button onclick="generarPDF()" class="btn-green bot">Generar PDF</button>
    <div id="miTabla">
        <div class="txt-3-blue">Reporte Cuatrimestral</div>
        <table>
            <thead>
            <tr>
                <th>Acción</th>
                <th>Número</th>
                <th>Tabla</th>
                <th>Fecha</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="report" items="${reports}" varStatus="s">
                <tr>
                <td><c:out value="${report.action}"/></td>
                <td><c:out value="${report.numero}"/></td>
                <td><c:out value="${report.tabla}"/> </td>
                <td><c:out value="${report.data}"/></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<script>
    function generarPDF() {
        const element = document.getElementById("miTabla");
        html2pdf().from(element).save("Reporte-Cuatrimestral.pdf");
    }
</script>
</body>
</html>