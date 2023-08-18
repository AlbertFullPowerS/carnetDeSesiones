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
    <jsp:include page="../../../layouts/admin/list.jsp"/>
    <jsp:include page="../../../layouts/tutor/tutorhead.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/student/change.css">




    <title>Sesiones</title>
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">
</head>
<body>
<style>
    body{
        background: var(--color-utez-azul);
    }
    .content{
        height: auto;
        margin-bottom: 1rem;
    }
    .sp {
        font-size: .6rem;
        text-align: end;
        padding-top: .5rem;
        padding-right: .5rem;
    }


</style>
<jsp:include page="../../../layouts/student/bodyUp.jsp"/>
<span class="txt-4-green sp"><c:out value="${studentU.name}"/> <c:out value="${studentU.first_last_name}"/> <c:out value="${studentU.second_last_name}"/></span>
<h2 style="margin: 1rem">Sesiones
</h2>
<div class="d-flex flex-wrap  justify-content-center" style="padding-bottom: 1rem">
    <c:forEach var="session" items="${sessions}" varStatus="s">
    <div class="profile profile-default ">
        <div class="profile__info">
            <h3>Sesión <c:out value="${s.count}"/></h3>
            <p class="profile__info__extra"><c:out value="${session.consultor.name}"/> <c:out value="${session.consultor.first_last_name}"/> <c:out value="${session.consultor.second_last_name}"/></p>
        </div>
        <div class="profile__stats">
            <p class="profile__stats__title">Asistencia</p>
            <h5 class="profile__stats__info asist" style="color: #3d3c3c"><c:out value="${session.attendance}"/></h5>
        </div>
        <div class="profile__stats">
            <p class="profile__stats__title">Hora</p>
            <h5 style="color: #3d3c3c"><c:out value="${session.hour}"/></h5>
        </div>
        <div class="profile__stats">
            <p class="profile__stats__title">Fecha</p>
            <h5 class="profile__stats__info" style="color: #3d3c3c"><c:out value="${session.data}"/></h5>
        </div>
        <div class="bt" data-session="<c:out value="${session.id_session}"/>"></div>
    </div>
    </c:forEach>

    <div class="modal fade" id="myModal"   tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <form action="${pageContext.request.contextPath}/student/save-justification" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Justificación</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <textarea id="text" name="text"class="form-control" style="font-size: .4rem" required aria-label="With textarea"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-gray" data-bs-dismiss="modal" style="font-size: .4rem">Cerrar</button>

                        <input type="hidden" name="idSession" id="idSession">
                        <button type="submit" class="btn btn-green" style="font-size: .4rem">Enviar</button>


                </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
<script>
    $(document).ready(function(){
        const asist = document.querySelectorAll('.asist');
        const bt = document.querySelectorAll('.bt');
        const idSession = document.getElementById("idSession");

        asist.forEach((elemento,indice)=>{
            console.log(elemento.innerText);
            if (elemento.innerText === '-'){
                bt[indice].innerHTML=`
  <button type="button" class="btn-green myInput" data-bs-toggle="modal" data-bs-target="#myModal" style="font-size: .4rem;margin-bottom: .2rem" >
Justificar
    </button>
`;
                bt[indice].addEventListener('click', () => {

                    idSession.value =  bt[indice].dataset.session;

                });
            }
            else   {
                bt[indice].style.height="0.407rem";
                if (elemento.innerText === 'Asistio')bt[indice].style.backgroundColor="#3d3c3c";
                    if (elemento.innerText === 'Pendiente')bt[indice].style.backgroundColor="#ff9900";
                if (elemento.innerText === 'Justificada')bt[indice].style.backgroundColor="var(--color-utez-azul)";

                if (elemento.innerText === 'Falta')bt[indice].style.backgroundColor="var(--color-rojo-claro)";

            }




        })
    })

</script>
</body>

</html>