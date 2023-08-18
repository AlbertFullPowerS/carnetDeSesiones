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
                Grupo
            </div>
            <div class="col txt-2-gray-v2">
                <c:out value="${group.group}"/>
            </div>
        </div>
        <div class="row fila txt-2-gray" id="item2">
            <div class="col ">
                Grado
            </div>
            <div class="col txt-2-gray-v2">
                <c:out value="${group.grade}"/>
            </div>
        </div>
        <div class="row fila txt-2-gray" id="item3">
            <div class="col ">
                Programa Académico
            </div>
            <div class="col txt-2-gray-v2">
                <c:out value="${group.academic_program.programName}"/>
            </div>
        </div>
        <div class="row fila txt-2-gray" id="item4">
            <div class="col ">
                Periodo
            </div>
            <div class="col txt-2-gray-v2">
                <c:out value="${group.periodo.name}"/>
            </div>
        </div>
        <div class="row fila txt-2-gray" id="item6">
            <div class="col ">
                Plazo
            </div>
            <div class="col txt-2-gray-v2">
                <c:out value="${group.periodo.dateBegin}"/> <c:out value="${group.periodo.dateEnd}"/>
            </div>
        </div>
        <div class="row fila txt-2-gray" id="item5">
            <div class="col ">
                Tutor
            </div>
            <div class="col txt-2-gray-v2">
                <c:out value="${group.tutor.name}"/> <c:out value="${group.tutor.first_last_name}"/>
            </div>
        </div>





        <form action="${pageContext.request.contextPath}/admin/user-view-one-update-group" method="get" style="display: none;" id="form">
            <input type="hidden" value="" id="Camp" name="Camp">
            <input type="hidden" value="" id="Card" name="Card">
            <input type="hidden" value="<c:out value="${group.id_group}"/>" id="id" name="id">
        </form>
    </div>

</div>
<form action="${pageContext.request.contextPath}/admin/group/delete" method="post"  style="text-align: center">
    <button class="btn btn-dark btn-sm" type="submit" style="font-size: .4rem ; ">Eliminar</button>
    <input type="hidden" value="<c:out value="${group.id_group}"/>"  id="id_delate" name="id_delate">
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
        form = document.getElementById("form");
        Camp =  document.getElementById("Camp");
        Card =  document.getElementById("Card");


        item1.addEventListener("click", ()=>{

            Camp.value="Grupo";
            Card.value = '1';
            form.submit();

        }, false);
        item2.addEventListener("click", ()=>{
            Camp.value="Grado";
            Card.value = '1';
            form.submit();

        }, false);
        item3.addEventListener("click", ()=>{

            Camp.value="Programa Academico";
            Card.value = '4';
            form.submit();

        }, false);
        item4.addEventListener("click", ()=>{
            Camp.value="Periodo";
            Card.value = '3';
            form.submit();

        }, false);
        item6.addEventListener("click", ()=>{
            Camp.value="Periodo";
            Card.value = '3';
            form.submit();

        }, false);
        item5.addEventListener("click", ()=>{
            Camp.value="Tutor";
            Card.value = '5';
            form.submit();

        }, false);



    })
</script>
</body>
</html>