
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
                <h2 class="txt-4-green" style="text-align: start; font-size: 1.2rem;">Estudiante</h2>

            </div>
            <form action="${pageContext.request.contextPath}/admin/student/save" method="post">
                <div class="d-flex align-content-center justify-content-center">
                    <div class="row">
                        <div class="col">
                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Nombre</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="text" required onchange="change()" class="form-control card-input" id="name" name="name" placeholder="Alberto">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Apellido Paterno</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="text" required  onchange="change()"  class="form-control card-input" id="first_last_name" name="first_last_name" placeholder="Bernat">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Apellido Materno</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="text" required onchange="change()"  class="form-control card-input" id="second_last_name" name="second_last_name" placeholder="Uribe">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>




                        </div>
                        <div class="col">

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Contraseña</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="text" required class="form-control card-input" id="password" name="password" placeholder="***********" readonly>
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Teléfono</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="number" required maxlength="10" onchange="change()"  class="form-control card-input" id="phone" name="phone" placeholder="7771456456">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>


                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Grupos</h5>

                                    <div class="input-group input-group-sm mb-3">


                                        <input class="form-control" required onchange="change()"  list="suggestionList" id="answerInput">
                                        <datalist id="suggestionList">
                                            <c:forEach var="groups" items="${groups}" varStatus="s">
                                                <option  data-value="<c:out value="${groups.id_group}"/>"><c:out value="${groups.grade}"/><c:out value="${groups.group}"/> <c:out value="${groups.academic_program.programName}"/> </option>
                                            </c:forEach>


                                        </datalist>
                                        <input type="hidden" name="answerInput-hidden" id="answerInput-hidden" >

                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="col">

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Email</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="email" required onchange="change()" class="form-control card-input" id="email" name="email" placeholder="ejemplo@utez.edu.mx">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>


                            <div class="card card-uu card-padding flex-md-fill" id="idCard">
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Matrícula</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="text" required maxlength="10" onchange="change()"  class="form-control card-input" id="enrollment" name="enrollment" placeholder="AAAAAA213AS">
                                        <span class="input-group-text" id="inputGroup-sizing-sm"><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>






                        </div>
                    </div>







                </div>
                <div class="d-flex justify-content-evenly sm-t">
                    <a href="${pageContext.request.contextPath}/admin/student" class="btn  btn-dark btn-sm">Cancelar</a>
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
    nom = document.getElementById("name");
    email = document.getElementById("email");
    phone = document.getElementById("phone");
    matrcula = document.getElementById("enrollment");
    ap1 =document.getElementById("first_last_name");
    ap2 = document.getElementById("second_last_name");
   function change(e)  {

        nom = document.getElementById("name");
        email = document.getElementById("email");
        phone = document.getElementById("phone");
        matrcula = document.getElementById("enrollment");
        ap1 =document.getElementById("first_last_name");
        ap2 = document.getElementById("second_last_name");



        document.getElementById('password').value = nom.value.substring(1,3) + "U" +matrcula.value.substring(1,3)+ email.value.substring(1,3)
            + Math.floor(Math.random() * 100) + ap1.value.substring(1,3)+ ap2.value.substring(1,3)+ Math.floor(Math.random() * 100)+phone.value.substring(1,3);


    };
</script>
</body>

</html>