<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="layouts/head.jsp"/>
  <jsp:include page="layouts/sessions.jsp"/>


  <title>Carnet Sessiones</title>
</head>
<body>
<div class="masc-green"></div>
  <div class="content-total-center">
    <div class="content-flex">
      <div class="item white">
        <div class="">
          <span class="txt-3-blue">Inicio Sesión</span>
        </div>
        <form action="${pageContext.request.contextPath}/user/login"  id="user-form" class="needs-validation" novalidate method="post" >
          <div class="">
            <div class="inpt">
              <p for="email" class="txt-2-gray">Usuario</p>
              <input type="email" name="email" id="email" placeholder="ejemplo@utez.edu.mx">
            </div>
            <div class="inpt">
              <p for="password" class="txt-2-gray">Contraseña</p>
              <input type="password" name="password" id="password" placeholder="********">
            </div>

          </div>
          <div class="flex-column-center">
            <input type="submit" name="" id="" class="txt-1-white btn-blue" value="Iniciar">
          </div>
        </form>
      </div>
      <div class="item blue">
        <div class="flex-column-left">
          <img class="img-utez" src="${pageContext.request.contextPath}/assets/img/Utez.png" alt="">
        </div>
        <div class="flex-column-center">
          <span class="tl-1-white">Bienvenidos al carnet de Citas</span>
          <span class="txt-1-white t-1">¿Necesitas Ayuda?</span>
        </div>
        <div class="flex-column-center">
          <a href="http://www.utez.edu.mx/index.php/servpestu" class=" txt-1-white btn-white">Registrar</a>
        </div>

      </div>
    </div>
  </div>



</body>
</html>