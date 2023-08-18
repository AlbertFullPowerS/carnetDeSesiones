<%--
  Created by IntelliJ IDEA.
  User: cheto
  Date: 17/07/2023
  Time: 11:44 p. m.
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../../../layouts/head.jsp"/>
    <jsp:include page="../../../../../layouts/panelInicio.jsp"/>

    <title>Información Personal</title>
</head>
<body>
<jsp:include page="../../../../../layouts/admin/bodyUp.jsp"/>

            <h4 class="txt-4-green">Información Personal</h4>
            <div class="border rounded-3 box">
                <div class="container">
                    <h4 class="txt-5-blue title">Información Básica</h4>
                    <div class="row fila txt-2-gray" id="item1">
                        <div class="col">
                            Nombre
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.name}"/>
                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item2">
                        <div class="col ">
                            Apellido Paterno
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.first_last_name}"/>
                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item3">
                        <div class="col ">
                            Apellido Materno
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.second_last_name}"/>
                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item4">
                        <div class="col ">
                            Email
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.email}"/>
                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item5">
                        <div class="col ">
                            Contraseña
                        </div>
                        <div class="col txt-2-gray-v2">
                            ********
                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item6">
                        <div class="col ">
                            Grado y Grupo
                        </div>
                        <div class="col txt-2-gray-v2">
                              <c:out value="${student.group.grade}"/> <c:out value="${student.group.group}"/>

                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item7">
                        <div class="col ">
                            Carrera
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.group.academic_program.programName}"/>

                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item11">
                        <div class="col ">
                            Teléfono
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.phone}"/>

                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item9">
                        <div class="col ">
                            Estado
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.status}"/>

                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item10">
                        <div class="col ">
                            Matrícula
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.enrollment}"/>

                        </div>
                    </div>
                    <form action="${pageContext.request.contextPath}/admin/user-view-one-update" method="get" style="display: none;" id="form">
                        <input type="hidden" value="" id="Camp" name="Camp">
                        <input type="hidden" value="" id="Card" name="Card">
                        <input type="hidden" value="<c:out value="${student.id_user}"/>" id="id_student" name="id_student">
                    </form>
                </div>

            </div>
            <div class="border rounded-3  box">
                <div class="container">
                    <h4 class="txt-5-blue title">Información Citas</h4>
                    <div class="row fila txt-2-gray">
                        <div class="col">
                            Citas
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.citas_view}"/>
                        </div>
                    </div>
                    <div class="row fila txt-2-gray">
                        <div class="col ">
                            Sesiones
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.sessiones_view}"/>

                        </div>
                    </div>
                    <div class="row fila txt-2-gray">
                        <div class="col ">
                            Consultor
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${student.group.tutor.name}"/>

                        </div>
                    </div>

                </div>

            </div>
            <form action="${pageContext.request.contextPath}/admin/student/delete" method="post"  style="text-align: center">
                <button class="btn btn-dark btn-sm" type="submit" style="font-size: .4rem ; ">Eliminar</button>
                <input type="hidden" value="<c:out value="${student.id_user}"/>"  id="id_delate" name="id_student_delate">
            </form>
<jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script>


    $(document).ready(function(){
        item1 = document.getElementById("item1");
        item2 = document.getElementById("item2");
        item3 = document.getElementById("item3");
        item4 = document.getElementById("item4");
        item5 = document.getElementById("item5");
        item6 = document.getElementById("item6");
        item7 = document.getElementById("item7");
        item9 = document.getElementById("item9");
        item10 = document.getElementById("item10");
        item11 = document.getElementById("item11");
        form = document.getElementById("form");
        Camp =  document.getElementById("Camp");
        Card =  document.getElementById("Card");

        item11.addEventListener("click", ()=>{

            Camp.value="Teléfono";
            Card.value = '1';
            form.submit();

        }, false);
        item1.addEventListener("click", ()=>{

            Camp.value="Nombre";
            Card.value = '1';
            form.submit();

        }, false);
        item2.addEventListener("click", ()=>{
            Camp.value="Apellido Paterno";
            Card.value = '1';
            form.submit();

        }, false);
        item3.addEventListener("click", ()=>{

            Camp.value="Apellido Materno";
            Card.value = '1';
            form.submit();

        }, false);
        item4.addEventListener("click", ()=>{
            Camp.value="Email";
            Card.value = '1';
            form.submit();

        }, false);
        item5.addEventListener("click", ()=>{
            Camp.value="Contrasela";
            Card.value = '2';
            form.submit();

        }, false);
        item6.addEventListener("click", ()=>{
            Camp.value="Grupo";
            Card.value = '3';
            form.submit();

        }, false);
        item7.addEventListener("click", ()=>{
            Camp.value="Grupo";
            Card.value = '3';
            form.submit();

        }, false);
        item9.addEventListener("click", ()=>{
            Camp.value="Estado";
            Card.value = '1';
            form.submit();

        }, false);
        item10.addEventListener("click", ()=>{
            Camp.value="Matrícula";
            Card.value = '1';
            form.submit();

        }, false);



    })
</script>
</body>
</html>