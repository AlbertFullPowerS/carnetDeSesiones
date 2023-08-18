<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../layouts/head.jsp"/>
    <jsp:include page="../../../layouts/panelInicio.jsp"/>
    <jsp:include page="../../../layouts/profile.jsp"/>

    <title>Perfil Estudiante</title>
</head>
<body>
<jsp:include page="../../../layouts/student/bodyUp.jsp"/>

        <div class="fondo">
            <div class="nombre-alumno  d-flex justify-content-around">
                <h4 class="txt-4-green"><c:out value="${studentU.name}"/> <c:out value="${studentU.first_last_name}"/> <c:out value="${studentU.second_last_name}"/></h4>
                <h4 class="txt-3-blue"> <c:out value="${studentU.group.academic_program.programName}"/> -Estudiante</h4>
            </div>
            <div class="info txt-2-gray">
                <div>
                    <p>Cuatrimestre</p>
                    <p class="txt-2-gray-v2"><c:out value="${studentU.group.grade}"/></p>
                </div>
                <div>
                    <p>Grupo</p>
                    <p class="txt-2-gray-v2"><c:out value="${studentU.group.group}"/></p>
                </div>
                <div>
                    <p>Teléfono</p>
                    <p class="txt-2-gray-v2"><c:out value="${studentU.phone}"/></p>
                </div>
                <div>
                    <p>Matrícula</p>
                    <p class="txt-2-gray-v2"><c:out value="${studentU.enrollment}"/></p>
                </div>
                <div>
                    <p>Matrícula</p>
                    <p class="txt-2-gray-v2"><c:out value="${studentU.status}"/></p>
                </div>
                <div>
                    <p>Correo</p>
                    <p class="txt-2-gray-v2"><c:out value="${studentU.email}"/></p>
                </div>
            </div>
            <form action="${pageContext.request.contextPath}/student/password-changes" id="forms" method="post" >
            <div class="cambio-passwd txt-2-gray d-flex flex-lg-wrap">
                <div class="mb-3">
                    <label for="ol_passowrd" class="form-label">Contraseña actual</label>
                    <input type="password" class="form-control " required id="ol_passowrd" name="ol_passowrd" placeholder="Contraseña">
                </div>
                <div class="mb-3">
                    <label for="new_passowrd" class="form-label">Nueva contraseña</label>
                    <input type="password" class="form-control " required id="new_passowrd" name="new_passowrd" placeholder="Contraseña">
                </div>
                <div class="mb-3">
                    <label for="rev_passowrd" id="errV" class="form-label">Confirmar contraseña</label>
                    <input type="password" class="form-control " required id="rev_passowrd" name="rev_passowrd" placeholder="Contraseña">
                </div>
            </div>
                <div class="d-flex justify-content-between">
                    <span id="err" class="txt-4-red"></span>
                    <button  id="vP"  type="button" class="btn-green" style="font-size: .6rem">Modificar</button>
                </div>

            </form>


        </div>

<script>

    let err =  document.getElementById("err");
    let vP= document.getElementById("vP");
    let errV = document.getElementById("errV");


    vP.addEventListener("click",()=>{
        let newP =  document.getElementById("new_passowrd");
        let oldP =  document.getElementById("rev_passowrd");

        if (newP.value===oldP.value)document.getElementById("forms").submit();
        else{
            err.innerText="Las contraseñas no conciden";
            errV.style.color="var(--color-rojo-claro)";
        }

    })
</script>
</body>

</html>
