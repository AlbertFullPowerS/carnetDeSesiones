<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../../layouts/head.jsp"/>
    <jsp:include page="../../../../layouts/panelInicio.jsp"/>
    <jsp:include page="../../../../layouts/profile.jsp"/>

    <title>Perfil Consultor</title>
</head>
<body>
<jsp:include page="../../../../layouts/appointment/bodyUp.jsp"/>

        <div class="fondo">
            <div class="nombre-alumno  d-flex justify-content-around">
                <h4 class="txt-4-green"><c:out value="${admin.name}"/> <c:out value="${admin.first_last_name}"/> <c:out value="${admin.second_last_name}"/></h4>
                <h4 class="txt-3-blue">Admin</h4>
            </div>
            <div class="info txt-2-gray">
                <div>
                    <p>Correo</p>
                    <p class="txt-2-gray-v2"><c:out value="${admin.email}"/></p>
                </div>
            </div>
            <form action="${pageContext.request.contextPath}/admin/password-changes" id="forms" method="post" >
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
