<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../../layouts/head.jsp"/>
    <jsp:include page="../../../../layouts/student/panel.jsp"/>
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
                <p>Puedes administrar el sistema mediante distintas opciones.</p>
            </div>
        </div>
        <div class="content-option">
            <div class="item">
                <a href="${pageContext.request.contextPath}/admin/student" style="text-decoration: none">

                    <p>
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="48" height="48" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" fill="none" stroke-linecap="round" stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                            <path d="M10 13a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                            <path d="M8 21v-1a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v1" />
                            <path d="M15 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                            <path d="M17 10h2a2 2 0 0 1 2 2v1" />
                            <path d="M5 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                            <path d="M3 13v-1a2 2 0 0 1 2 -2h2" />
                        </svg>
                    </p>
                    <p class="txt-4-green subt">Usuarios</p>
                    <p class="txt-2-gray sl">Crea y edita usuarios como Consultores , Tutores y Estudiantes.</p>
                </a>

            </div>
            <div class="item">
                <a href="${pageContext.request.contextPath}/admin/appointment-select-consultor"  style="text-decoration: none">
                <p>
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="48" height="48" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" fill="none" stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                        <path d="M4 5m0 2a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2z" />
                        <path d="M16 3l0 4" />
                        <path d="M8 3l0 4" />
                        <path d="M4 11l16 0" />
                        <path d="M8 15h2v2h-2z" />
                    </svg>
                </p>
                <p class="txt-4-green subt">Calendario</p>
                <p class="txt-2-gray sl">Agendar citas , transferir consultores y reagendar.</p>
                </a>
            </div>
            <div class="item">
                <a href="${pageContext.request.contextPath}/admin/notifications">
                <p>
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-brand-telegram" width="48" height="48" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" fill="none" stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                        <path d="M15 10l-4 4l6 6l4 -16l-18 7l4 2l2 6l3 -4" />
                    </svg>
                </p>
                <p class="txt-4-green subt">Notificaciones</p>
                <p class="txt-2-gray sl">Recibe las solicitudes de los usuarios.</p>
                </a>
            </div>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/admin/profile" class="btn-white" style="text-decoration: none">Perfil</a>
</div>
<div class="masc-blue"></div>
</body>
</html>