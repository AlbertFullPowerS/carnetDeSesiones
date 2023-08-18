<%--
  Created by IntelliJ IDEA.
  User: cheto
  Date: 19/07/2023
  Time: 01:33 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <jsp:include page="../../../layouts/student/panel.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/student/change.css">

  <title>Panel Principal</title>
</head>
<body>
<jsp:include page="../../../layouts/student/bodyUp.jsp"/>
<h2 class="txt-3-blue" style="font-size: 1.4rem;">Cambio de consultor</h2>
<form style="margin: 0 auto;" action="${pageContext.request.contextPath}/student/change-consulter" method="post">
  <div class="d-flex  align-items-center justify-content-center" style="height: 100%;display: flex;flex-direction: column;">
    <div class="input-group" style="
    margin: 1rem;
">
  <span class="input-group-text" style="
    font-size: .5rem;
">Escribe el motivo</span>
      <textarea class="form-control" id="text" name="text" style="font-size: .4rem" required aria-label="With textarea"></textarea>
    </div>
    <div style="
    margin: 1rem;
    justify-content: end;
    display: flex;
">
      <button type="submit" class="btn-green" style="font-size: .4rem">Enviar</button>
    </div>
  </div>
</form>
</div>
</div>
<div class="masc-blue"></div>
</body>
</html>