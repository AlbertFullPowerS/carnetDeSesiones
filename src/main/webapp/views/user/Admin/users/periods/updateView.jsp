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
                            <c:out value="${period.name}"/>
                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item2">
                        <div class="col ">
                            Fecha de Inicio
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${period.dateBegin}"/>
                        </div>
                    </div>
                    <div class="row fila txt-2-gray" id="item3">
                        <div class="col ">
                            Fecha de fin
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${period.dateEnd}"/>
                        </div>
                    </div>

                    <form action="${pageContext.request.contextPath}/admin/user-view-one-update-period" method="get" style="display: none;" id="form">
                        <input type="hidden" value="" id="Camp" name="Camp">
                        <input type="hidden" value="" id="Card" name="Card">
                        <input type="hidden" value="<c:out value="${period.id_Periods}"/>" id="id" name="id">
                    </form>
                </div>

            </div>
            <div class="border rounded-3  box">
                <div class="container">
                    <h4 class="txt-5-blue title">Información Periodo</h4>
                    <div class="row fila txt-2-gray" id="item1C">
                        <div class="col">
                            Grupos
                        </div>
                        <div class="col txt-2-gray-v2">
                            <c:out value="${period.count}"/>
                        </div>
                    </div>



                </div>

            </div>
            <form action="${pageContext.request.contextPath}/admin/period/delete" method="post"  style="text-align: center">
                <button class="btn btn-dark btn-sm" type="submit" style="font-size: .4rem ; ">Eliminar</button>
                <input type="hidden" value="<c:out value="${consultor.id_user}"/>"  id="id_delate" name="id_delate">
            </form>
<jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script>


    $(document).ready(function(){
        item1 = document.getElementById("item1");
        item2 = document.getElementById("item2");
        item3 = document.getElementById("item3");
        form = document.getElementById("form");
        Camp =  document.getElementById("Camp");
        Card =  document.getElementById("Card");


        item1.addEventListener("click", ()=>{

            Camp.value="Nombre";
            Card.value = '2';
            form.submit();

        }, false);
        item2.addEventListener("click", ()=>{
            Camp.value="Fecha de inicio";
            Card.value = '1';
            form.submit();

        }, false);
        item3.addEventListener("click", ()=>{

            Camp.value="Fecha de fin";
            Card.value = '1';
            form.submit();

        }, false);




    })
</script>
</body>
</html>