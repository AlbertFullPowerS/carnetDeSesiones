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
    <jsp:include page="../../../../layouts/admin/list.jsp"/>
    <jsp:include page="../../../../layouts/tutor/tutorhead.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/student/change.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/consultor/modalRegister.css">




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
<jsp:include page="../../../../layouts/consultor/bodyUp.jsp"/>
<div style="
    display: flex;
    align-content: center;
    justify-content: space-around;
">
    <h2 style="margin: 1rem;">Sesiones
    </h2>
    <button class="btn-green " data-bs-toggle="modal" data-bs-target="#transf">Transferencia de estudiante</button>
</div>
<div class="d-flex flex-wrap  justify-content-center" style="padding-bottom: 1rem">
    <c:forEach var="session" items="${sessions}" varStatus="s">
    <div class="profile profile-default ">
        <div class="profile__info">
            <h3>Sesión <c:out value="${s.count}"/></h3>
            <p class="profile__info__extra"><c:out value="${session.appointment.student.name}"/> <c:out value="${session.appointment.student.first_last_name}"/> <c:out value="${session.appointment.student.second_last_name}"/></p>
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
        <div class="bt" data-session="<c:out value="${session.id_session}"/>" data-st="<c:out value="${session.appointment.student.id_student}"/>"></div>
    </div>
    </c:forEach>

    <div class="modal fade" id="myModal"   tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="wrap animate pop">
                    <div class="overlay">
                        <div class="overlay-content animate slide-left delay-2">
                            <h1 class="animate slide-left pop delay-4">Registrar</h1>
                            <div class="attendance">
                                <form action="${pageContext.request.contextPath}/consultor/save-register-session" method="post" id="formAs">
                                    <input type="hidden" id="session" name="session">
                                    <input type="hidden" name="option" id="option">
                                    <button type="button" id="asist" class="botAtt btn-blue">Asistencia</button>
                                    <button type="button" id="falt" class="botAtt btn-blue">Falta</button>
                                </form>
                            </div>
                        </div>
                        <div class="image-content animate slide delay-5"></div>
                        <button type="button" class="boton btn-white" id="button">Justificar</button>
                    </div>
                    <div class="text">
                        <form action="${pageContext.request.contextPath}/consultor/save-justification" method="post" id="formsJus">
                            <input type="hidden" id="sessionJ" name="sessionJ">
                            <input type="hidden" id="app" name="app" value="<c:out value="${id}"/>">
                            <h6>Justificar</h6>
                            <div class="form-floating">
                                <textarea class="form-control textA" name="text" id="text" placeholder="Leave a comment here" id="floatingTextarea" style="font-size: .5rem;"></textarea>
                                <label for="floatingTextarea"></label>
                            </div>
                            <button type="button" id="just" class="btn-green btn-enviar">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="transf"   tabindex="-1" aria-labelledby="transf" aria-hidden="true" >
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content" style="background-color: var(--color-claro-blanco)">
                <form action="${pageContext.request.contextPath}/consultor/trasnfer-student" method="post" id="formsTr" >
                    <div class="modal-header">
                        <h1 class="modal-title fs-5 txt-4-green" style="font-size: .5rem"> Transferencia</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p>Motivo o causa</p>
                        <textarea id="appointment_text" name="text" class="form-control" style="font-size: .4rem" required aria-label="With textarea"></textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-gray" data-bs-dismiss="modal" style="font-size: .4rem">Cerrar</button>

                        <input type="hidden" name="id_appointment" id="id_appointment" value="<c:out value="${id}"/>">
                        <input type="hidden" name="id_student" id="id_student" >

                        <button type="button" id="buttonTr" class="btn btn-green" style="font-size: .4rem">Enviar</button>


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
        const idSession = document.getElementById("session");
        const idSessionJ = document.getElementById("sessionJ");
        const id_student = document.getElementById("id_student");


        asist.forEach((elemento,indice)=>{
            console.log(elemento.innerText);
            if (elemento.innerText === '-'){
                bt[indice].innerHTML=`
  <button type="button" class="btn-green myInput" data-bs-toggle="modal" data-bs-target="#myModal" style="font-size: .4rem;margin-bottom: .2rem" >
Registrar
    </button>
`;
                bt[indice].addEventListener('click', () => {

                    idSession.value =  bt[indice].dataset.session;
                    idSessionJ.value =  bt[indice].dataset.session;


                });
                id_student.value =  bt[indice].dataset.st;
            }
            else   {
                bt[indice].style.height="0.407rem";
                if (elemento.innerText === 'Asistio')bt[indice].style.backgroundColor="#3d3c3c";
                    if (elemento.innerText === 'Pendiente')bt[indice].style.backgroundColor="#ff9900";
                if (elemento.innerText === 'Justificada')bt[indice].style.backgroundColor="var(--color-utez-azul)";

                if (elemento.innerText === 'Falta')bt[indice].style.backgroundColor="var(--color-rojo-claro)";

            }




        })




        let overLay = document.querySelector(".overlay");
        let overlayContent = document.querySelector(".overlay-content");
        let attendance = document.querySelector(".attendance");
        let imageContent = document.querySelector(".image-content");
        let dots = document.querySelectorAll(".dots");
        let myButton = document.querySelectorAll(".myInput");
        let text = document.querySelector(".textA");
        let option = document.getElementById("option");
        let count = 0;
        myButton.forEach((elemento,indice)=>{
            elemento.addEventListener("click",()=>{
                count=0;
                overLay.style.transform = 'translateX(0vmin)';
                imageContent.style.width = '58vmin';
                overlayContent.style.transform = 'translateX(0vmin)';
                attendance.style.display = 'block';
                text.value="";

            });
        });


        document.getElementById("button").addEventListener("click",()=>{
            if (count == 0) {
                overLay.style.transform = 'translateX(-60vmin)';
                imageContent.style.width = '30vmin';
                overlayContent.style.transform = 'translateX(60vmin)';
                attendance.style.display = 'none';

                count = 1;
            } else {
                overLay.style.transform = 'translateX(0vmin)';
                imageContent.style.width = '58vmin';
                overlayContent.style.transform = 'translateX(0vmin)';
                attendance.style.display = 'block';
                count = 0;
            }
        });




        document.getElementById('asist').addEventListener('click', function(e) {
            option.value=1;
            e.preventDefault();
            pregunta()
        });
        document.getElementById('falt').addEventListener('click', function(e) {
            option.value=0;
            e.preventDefault();
            pregunta()
        });
        document.getElementById('just').addEventListener('click', function(e) {
            e.preventDefault();
            pregunta1()
        });
        document.getElementById('buttonTr').addEventListener('click', function(e) {
            e.preventDefault();
            pregunta2()
        });
        function pregunta() {
            if (confirm('Confirma tu opción')) {
                document.getElementById('formAs').submit();
            }
        }
        function pregunta1() {
            if (confirm('Confirma tu opción')) {
                document.getElementById('formsJus').submit();
            }
        }
        function pregunta2() {
            if (confirm('¿Seguro que quieres solicitar la transferencia?')) {
                document.getElementById('formsTr').submit();
            }
        }
    })

</script>
</body>

</html>