
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content-body">
    <div class="header flex-end">
        <a href="${pageContext.request.contextPath}/admin/panel">
            <img src="https://upload.wikimedia.org/wikipedia/commons/5/54/Logo-utez.png" alt="" class="img-u">

        </a>
        <div class="navegation">
            <a href="${pageContext.request.contextPath}/admin/student">
                <p>
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon nav" width="48" height="48" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" fill="none" stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                        <path d="M10 13a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                        <path d="M8 21v-1a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v1" />
                        <path d="M15 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                        <path d="M17 10h2a2 2 0 0 1 2 2v1" />
                        <path d="M5 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0" />
                        <path d="M3 13v-1a2 2 0 0 1 2 -2h2" />
                    </svg>
                </p>
            </a>
            <a href="${pageContext.request.contextPath}/admin/appointment-select-consultor">
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
            </a>
            <a href="${pageContext.request.contextPath}/admin/notifications">
            <p>
                <svg xmlns="http://www.w3.org/2000/svg" class="icon nav" width="48" height="48" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" fill="none" stroke-linecap="round" stroke-linejoin="round">
                    <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                    <path d="M15 10l-4 4l6 6l4 -16l-18 7l4 2l2 6l3 -4" />
                </svg>
            </p>
            </a>
        </div>

        <a href="${pageContext.request.contextPath}/user/logout" class="btn-blue">Salir</a>


    </div>
    <div class="content">
        <div class="usuarios">

                    <div class="user">
                        <a href="${pageContext.request.contextPath}/admin/student" class="users txt-1-white">
                            Estudiantes
                        </a>
                    </div>
                    <div class="user">
                        <a href="${pageContext.request.contextPath}/admin/consultor" class=" users txt-1-white">
                            Consultores
                        </a>
                    </div>
                    <div class="user">
                        <a href="${pageContext.request.contextPath}/admin/tutor" class="users txt-1-white">
                            Tutores
                        </a>
                    </div>
                    <div class="user">
                        <a href="${pageContext.request.contextPath}/admin/group" class="users txt-1-white">
                            Grupos
                        </a>
                    </div>
                    <div class="user">
                        <a href="${pageContext.request.contextPath}/admin/period" class="users txt-1-white">
                            Periodos
                        </a>
                    </div>


        </div>

        <div class="fondo " id="fondo" style="padding: 1rem;">