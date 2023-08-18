<%--
  Created by IntelliJ IDEA.
  User: cheto
  Date: 24/07/2023
  Time: 12:13 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <jsp:include page="../../../../../layouts/admin/list.jsp"/>
    <title>Información Personal</title>
    <input type="hidden" value="<c:out value="${op.card}"/>" id="id_card">
    <input type="hidden" value="<c:out value="${op.camp}"/>" id="id_if">

</head>
<body>
<jsp:include page="../../../../../layouts/admin/bodyUp.jsp"/>
            <div class="col-sm-6 mb-3 mb-sm-0 align-self-center ">
                <div class="card card-uu" id="idCard">






                </div>
            </div>
        </div>


<jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
    document.getElementById("fondo").className="fondo d-flex justify-content-evenly";


    $(function(){
        contentCard = document.getElementById("idCard");
        valueCard = document.getElementById("id_card").value;
        idIf = document.getElementById("id_if").value;
        console.log(idIf);

        switch(valueCard){
            case'1':
                switch (idIf) {

                    case "Email" :
                        contentCard.innerHTML = `<div class="card-body">
                      <h5 class="card-title " style="text-align: start;"><c:out value="${op.camp}"/></h5>
                      <form action="${pageContext.request.contextPath}/admin/tutor/update" method="post">
                        <div class="input-group input-group-sm mb-3">

                          <input type="email"  class="form-control card-input" id="inputGroup-sizing-sm" name="valor" placeholder="<c:out value="${op.valueView}"/>">
                          <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                          <input type="hidden" value="<c:out value="${z.id_user}"/>" id="id" name="id">
                          <span class="input-group-text" id="inputGroup-sizing-sm"><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                        </div>
                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-tutor" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                      </form>
                   </div>`;
                        break;

                    default:
                        contentCard.innerHTML = `<div class="card-body">
                      <h5 class="card-title " style="text-align: start;"><c:out value="${op.camp}"/></h5>
                      <form action="${pageContext.request.contextPath}/admin/tutor/update" method="post">
                        <div class="input-group input-group-sm mb-3">

                          <input type="text" class="form-control card-input" id="inputGroup-sizing-sm" name="valor" placeholder="<c:out value="${op.valueView}"/>">
                          <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                          <input type="hidden" value="<c:out value="${consultor.id_user}"/>" id="id" name="id">
                          <span class="input-group-text" id="inputGroup-sizing-sm"><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                        </div>
                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-tutor" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                      </form>
                   </div>`;
                            break;
                }




                break;
            case'2':

                contentCard.innerHTML = `<div class="card-body">
                      <h5 class="card-title " style="text-align: start;">Contraseña</h5>
                      <form action="${pageContext.request.contextPath}/admin/tutor/update" method="post">
                        <div class="input-group input-group-sm mb-3">

                          <input type="password" class="form-control card-input" id="inputGroup-sizing-sm" name="valor" placeholder="********">
                          <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                          <input type="hidden" value="<c:out value="${consultor.id_consultor}"/>" id="id" name="id">
                           <span class="input-group-text" id="inputGroup-sizing-sm"><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                        </div>
                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-tutor" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                      </form>
                   </div>`;
                break;


        }




    })



</script>


<script>
    $(document).ready(function() {

        document.querySelector('input[list]').addEventListener('input', function(e) {
            var input = e.target,
                list = input.getAttribute('list'),
                options = document.querySelectorAll('#' + list + ' option'),
                hiddenInput = document.getElementById(input.getAttribute('id') + '-hidden'),
                inputValue = input.value;


            hiddenInput.value = inputValue;



            for(var i = 0; i < options.length; i++) {
                var option = options[i];

                console.log(inputValue.trim()  == option.innerText.trim())
                if(inputValue.trim()  == option.innerText.trim()) {
                    hiddenInput.value = option.dataset.value;

                    break;
                }
            }

        });
    });



</script>

</body>

</html>