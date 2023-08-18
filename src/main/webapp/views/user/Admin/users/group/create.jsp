
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <jsp:include page="../../../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../../../layouts/student/create.jsp"/>

    <title>Información Personal</title>

</head>
<body>
<jsp:include page="../../../../../layouts/admin/bodyUp.jsp"/>

            <div class="sm-t flex">
                <h2 class="txt-4-green" style="text-align: start; font-size: 1.2rem;">Grupo</h2>

            </div>
            <form action="${pageContext.request.contextPath}/admin/group/save" method="post">
                <div class="d-flex align-content-center justify-content-center">
                    <div class="row">
                        <div class="col">
                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Grupo</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="text" required  class="form-control card-input" id="group" name="group" placeholder="">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Grado</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="number" required  class="form-control card-input" id="grade" name="grade" placeholder="">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>








                        </div>
                        <div class="col">

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Periodo</h5>

                                    <div class="input-group input-group-sm mb-3">


                                        <input class="form-control" required   list="periodsList" id="periodsInput">
                                        <datalist id="periodsList">
                                            <c:forEach var="period" items="${periods}" varStatus="s">
                                                <option  data-value="<c:out value="${period.id_Periods}"/>"><c:out value="${period.name}"/> <c:out value="${period.dateBegin}"/> <c:out value="${period.dateEnd}"/></option>
                                            </c:forEach>


                                        </datalist>
                                        <input type="hidden" name="periodsInput-hidden" id="periodsInput-hidden" >

                                    </div>

                                </div>
                            </div>

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Programa Académico</h5>

                                    <div class="input-group input-group-sm mb-3">


                                        <input class="form-control" required   list="academicList" id="academicInput">
                                        <datalist id="academicList">
                                            <c:forEach var="academi" items="${academic}" varStatus="s">
                                                <option  data-value="<c:out value="${academi.id_AcademicProgram}"/>"><c:out value="${academi.programName}"/> <c:out value="${academi.academicDivisions.name}"/></option>
                                            </c:forEach>


                                        </datalist>
                                        <input type="hidden" name="academicInput-hidden" id="academicInput-hidden" >

                                    </div>

                                </div>
                            </div>





                        </div>
                        <div class="col">
                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Tutores</h5>

                                    <div class="input-group input-group-sm mb-3">


                                        <input class="form-control" required  list="tutorsList" id="tutorsInput">
                                        <datalist id="tutorsList">
                                            <c:forEach var="tutor" items="${tutors}" varStatus="s">
                                                <option  data-value="<c:out value="${tutor.id_tutor}"/>"><c:out value="${tutor.name}"/> <c:out value="${tutor.first_last_name}"/> <c:out value="${tutor.second_last_name}"/></option>
                                            </c:forEach>


                                        </datalist>
                                        <input type="hidden" name="tutorsInput-hidden" id="tutorsInput-hidden" >

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>







                </div>
                <div class="d-flex justify-content-evenly sm-t">
                    <a href="${pageContext.request.contextPath}/admin/group" class="btn  btn-dark btn-sm">Cancelar</a>
                    <button class="btn  btn-green"  type="submit" style="font-size: .4rem ; ">Guardar</button>
                </div>

            </form>




            <jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<script>
    function isEqual(str1, str2)
    {
        return str1.toUpperCase() === str2.toUpperCase()
    }
    let inputList =   document.querySelectorAll('input[list]');
    inputList[0].addEventListener('input', function(e) {
        var input = e.target,
            list = input.getAttribute('list'),
            options = document.querySelectorAll('#' + list + ' option'),
            hiddenInput = document.getElementById(input.getAttribute('id') + '-hidden'),
            inputValue = input.value;
        hiddenInput.value = inputValue;
        for(var i = 0; i < options.length; i++) {
            var option = options[i];
            if(inputValue.trim()  == option.innerText.trim()) {
                hiddenInput.value = option.dataset.value;
                break;
            }
        }

    });
    inputList[1].addEventListener('input', function(e) {
        var input = e.target,
            list = input.getAttribute('list'),
            options = document.querySelectorAll('#' + list + ' option'),
            hiddenInput = document.getElementById(input.getAttribute('id') + '-hidden'),
            inputValue = input.value;
        hiddenInput.value = inputValue;
        for(var i = 0; i < options.length; i++) {
            var option = options[i];
            if(inputValue.trim()  == option.innerText.trim()) {
                hiddenInput.value = option.dataset.value;
                break;
            }
        }

    });
    inputList[2].addEventListener('input', function(e) {
        var input = e.target,
            list = input.getAttribute('list'),
            options = document.querySelectorAll('#' + list + ' option'),
            hiddenInput = document.getElementById(input.getAttribute('id') + '-hidden'),
            inputValue = input.value;
        hiddenInput.value = inputValue;
        for(var i = 0; i < options.length; i++) {
            var option = options[i];
            if(inputValue.trim()  == option.innerText.trim()) {
                hiddenInput.value = option.dataset.value;
                break;
            }
        }

    });


</script>
</body>

</html>