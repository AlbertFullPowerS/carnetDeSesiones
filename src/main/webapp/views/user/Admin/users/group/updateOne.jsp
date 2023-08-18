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
                    case "Grupo" :
                        contentCard.innerHTML = `<div class="card-body">
                      <h5 class="card-title " style="text-align: start;"><c:out value="${op.camp}"/></h5>
                      <form action="${pageContext.request.contextPath}/admin/group/update" method="post">
                        <div class="input-group input-group-sm mb-3">

                          <input type="text" maxlength="10" class="form-control card-input" id="inputGroup-sizing-sm" name="valor" placeholder="<c:out value="${op.valueView}"/>">
                          <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                          <input type="hidden" value="<c:out value="${group.id_group}"/>" id="id" name="id">
                          <span class="input-group-text" id="inputGroup-sizing-sm"><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                        </div>
                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-group" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                      </form>
                   </div>`;
                        break;

                    case "Grado" :
                        contentCard.innerHTML = `<div class="card-body">
                      <h5 class="card-title " style="text-align: start;"><c:out value="${op.camp}"/></h5>
                      <form action="${pageContext.request.contextPath}/admin/group/update" method="post">
                        <div class="input-group input-group-sm mb-3">

                          <input type="number" class="form-control card-input" id="valor" name="valor" placeholder="">
                          <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                          <input type="hidden" value="<c:out value="${group.id_group}"/>" id="id" name="id3">
                          <span class="input-group-text" id="inputGroup-sizing-sm"><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                        </div>
                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-group" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                      </form>
                   </div>`;
                        break;
                }




                break;
            case'3':
                contentCard.innerHTML = `



                                <div class="card-body">
                     <h5 class="card-title " style="text-align: start;">Periodos</h5>
                      <form action="${pageContext.request.contextPath}/admin/group/update" method="post">

                        <div class="input-group input-group-sm mb-3">


                                        <input class="form-control"  list="suggestionList" id="answerInput">
                                        <datalist id="suggestionList">
                                            <c:forEach var="period" items="${periods}" varStatus="s">
                                                <option  data-value="<c:out value="${period.id_Periods}"/>"><c:out value="${period.name}"/> <c:out value="${period.dateBegin}"/> <c:out value="${period.dateEnd}"/></option>
                                            </c:forEach>


                                        </datalist>
                                        <input type="hidden" name="valor" id="answerInput-hidden" >

                                    </div>

                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-group" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                       <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                                        <input type="hidden" value="<c:out value="${group.id_group}"/>" id="id" name="id">
                      </form>
                   </div>
                   `;
                break;
            case'4':
                contentCard.innerHTML = `



                                <div class="card-body">
                     <h5 class="card-title " style="text-align: start;">Programas Academicos</h5>
                      <form action="${pageContext.request.contextPath}/admin/group/update" method="post">

                        <div class="input-group input-group-sm mb-3">


                                        <input class="form-control"  list="suggestionList" id="answerInput">
                                        <datalist id="suggestionList">
                                            <c:forEach var="academi" items="${academic}" varStatus="s">
                                                <option  data-value="<c:out value="${academi.id_AcademicProgram}"/>"><c:out value="${academi.programName}"/> <c:out value="${academi.academicDivisions.name}"/></option>
                                            </c:forEach>


                                        </datalist>
                                        <input type="hidden" name="valor" id="answerInput-hidden" >

                                    </div>

                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-group" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                       <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                                        <input type="hidden" value="<c:out value="${group.id_group}"/>" id="id" name="id">
                      </form>
                   </div>
                   `;
                break;
            case'5':
                contentCard.innerHTML = `



                                <div class="card-body">
                     <h5 class="card-title " style="text-align: start;">Tutores</h5>
                      <form action="${pageContext.request.contextPath}/admin/group/update" method="post">

                        <div class="input-group input-group-sm mb-3">


                                        <input class="form-control"  list="suggestionList" id="answerInput">
                                        <datalist id="suggestionList">
                                            <c:forEach var="tutor" items="${tutors}" varStatus="s">
                                                <option  data-value="<c:out value="${tutor.id_tutor}"/>"><c:out value="${tutor.name}"/> <c:out value="${tutor.first_last_name}"/> <c:out value="${tutor.second_last_name}"/></option>
                                            </c:forEach>


                                        </datalist>
                                        <input type="hidden" name="valor" id="answerInput-hidden" >

                                    </div>

                      <div class="d-flex justify-content-evenly">
                        <a href="${pageContext.request.contextPath}/admin/user-view-update-group" class="btn btn-secondary card-sm-btn">Cancelar</a>
                        <button type="submit" class="btn btn-green card-sm-btn">Guardar</button>
                      </div>
                       <input type="hidden" value="<c:out value="${op.campv2}"/>" id="object" name="object">
                                        <input type="hidden" value="<c:out value="${group.id_group}"/>" id="id" name="id">
                      </form>
                   </div>
                   `;
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
                console.log(inputValue.trim())
                console.log(option.innerText.trim())

                console.log(inputValue.trim()  == option.innerText.trim())
                if(inputValue.trim()  == option.innerText.trim()) {
                    console.log(option.dataset.value);
                    hiddenInput.value = option.dataset.value;

                    break;
                }
            }

        });
    });
</script>
</body>

</html>