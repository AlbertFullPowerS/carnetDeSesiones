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
  <jsp:include page="../../../layouts/head.jsp"/>
  <jsp:include page="../../../layouts/student/panel.jsp"/>

  <title>Panel Principal</title>
</head>
<body>
<div class="content-body">
  <div class="header flex-end">

    <img src="https://upload.wikimedia.org/wikipedia/commons/5/54/Logo-utez.png" alt="" class="img-u">
    <a  href="${pageContext.request.contextPath}/user/logout" class="btn-blue">Salir</a>
  </div>
  <div class="content">
    <div class="img-utez">
      <div class="text-header tl-1-white">
        <span>Carnet Sesiones</span>
        <p>Puedes observar tus diversas citas</p>
      </div>
    </div>
    <div class="content-option">
      <div class="item">
        <a href="${pageContext.request.contextPath}/student/history">

        <p>
          <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-book" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none" stroke-linecap="round" stroke-linejoin="round">
             <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
             <path d="M3 19a9 9 0 0 1 9 0a9 9 0 0 1 9 0" />
             <path d="M3 6a9 9 0 0 1 9 0a9 9 0 0 1 9 0" />
             <path d="M3 6l0 13" />
             <path d="M12 6l0 13" />
             <path d="M21 6l0 13" />
          </svg>
        </p>

        <p class="txt-4-green subt">Historial</p>
        <p class="txt-2-gray sl">Visualiza todas las citas que has tenido.</p>

        </a>
      </div>
      <div class="item">
        <a href="${pageContext.request.contextPath}/student/view-change-consulter">
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-zoom-replace" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" fill="none" stroke-linecap="round" stroke-linejoin="round">
            <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
            <path d="M21 21l-6 -6" />
            <path d="M3.291 8a7 7 0 0 1 5.077 -4.806a7.021 7.021 0 0 1 8.242 4.403" />
            <path d="M17 4v4h-4" />
            <path d="M16.705 12a7 7 0 0 1 -5.074 4.798a7.021 7.021 0 0 1 -8.241 -4.403" />
            <path d="M3 16v-4h4" />
          </svg>
        </p>


        <p class="txt-4-green subt">Cambio de consultor</p>
        <p class="txt-2-gray sl">Solicita un cambio de consultor.</p>

        </a>
      </div>
      <div class="item">
        <a href="${pageContext.request.contextPath}/student/sessions">
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" class="icon nav" width="48" height="48" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" fill="none" stroke-linecap="round" stroke-linejoin="round">
            <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
            <path d="M4 5m0 2a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2z" />
            <path d="M16 3l0 4" />
            <path d="M8 3l0 4" />
            <path d="M4 11l16 0" />
            <path d="M8 15h2v2h-2z" />
          </svg>
        </p>
        <p class="txt-4-green subt">Sesiones</p>
        <p class="txt-2-gray sl">Visualiza toda la información que necesites.</p>

        </a>
      </div>
    </div>

  </div>
<a href="${pageContext.request.contextPath}/student/profile" class="txt-5-blue btn btn-white " style="text-decoration: none">Perfil</a>
</div>

<div class="masc-blue"></div>
</body>
</html>