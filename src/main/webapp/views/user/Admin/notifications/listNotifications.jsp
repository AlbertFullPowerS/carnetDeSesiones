<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../../../../layouts/bootStrap.jsp"/>
    <jsp:include page="../../../../layouts/appointment/styleAppointments.jsp"/>
    <jsp:include page="../../../../layouts/head.jsp"/>
    <jsp:include page="../../../../layouts/panelInicio.jsp"/>
    <jsp:include page="../../../../layouts/admin/list.jsp"/>


    <title>Notificaciones</title>
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">


</head>
<body>
<jsp:include page="../../../../layouts/appointment/bodyUp.jsp"/>
<div class="content_list" id="content_list" >
    <div class="d-flex justify-content-evenly" style="font-size: .6rem ; padding: 1rem">
        <button class="btn-green" id="d-trans">Transferencias</button>
        <button class="btn-green" id="d-just">Justificantes</button>
        <button class="btn-green" id="d-report" data-bs-toggle="modal" data-bs-target="#report">Reporte</button>

    </div>
    <div class="scroll" id="blockTransf" style="display: none">
        <div class="sm-t flex" style="padding: 1rem">
            <div class="flex">
                <h4 class="txt-4-green" style="font-size: .6rem">Transferencia</h4>

            </div>


            <div class="form-floating" style="font-size: .6rem">
                <input type="text"  class="form-control search-input" style="font-size: .6rem " id="inputFiltro" placeholder="Matrìcula">

                <label for="inputFiltro" class="search-span">Apellido</label>
            </div>


        </div>
        <table class="table table-borderless miTablaPersonalizada" id="miTabla" style="display: none;">

            <tr class="hv">
                <th scope="col">Nombre</th>
                <th scope="col">Apellidos</th>
                <th scope="col">Tipo</th>
                <th scope="col">Razon</th>
                <th scope="col">Id</th>
            </tr>

            <c:forEach var="requestStudent" items="${requestStudents}" varStatus="s">
                <tr class="ancho-columna">
                    <td><c:out value="${requestStudent.user.name}"/></td>
                    <td><c:out value="${requestStudent.user.first_last_name}"/> <c:out value="${requestStudent.user.second_last_name}"/></td>
                    <td><c:out value="${requestStudent.typeUser}"/> </td>
                    <td><c:out value="${requestStudent.reason}"/></td>
                    <td><c:out value="${requestStudent.appointment.id_appointment}"/></td>
                </tr>
            </c:forEach>

        </table>




        <table id="tablaHTML" class="table table-borderless miTablaPersonalizada">
            <thead>
            <tr class="hv">
                <th scope="col">Nombre</th>
                <th scope="col">Apellidos</th>
                <th scope="col">Tipo</th>
                <th scope="col">Razón</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody class="table-group-divider tbT">

            </tbody>
        </table>


        <div id="paginado" class="d-flex justify-content-center"></div>
    </div>

    <div class="scroll" id="blockJust" style="display: none">
        <div class="sm-t flex" style="padding: 1rem">
            <div class="flex">
                <h4 class="txt-4-green" style="font-size: .6rem">Justificaciones</h4>

            </div>


            <div class="form-floating" style="font-size: .6rem">
                <input type="text"  class="form-control search-input" style="font-size: .6rem " id="inputFiltroj" placeholder="Matrìcula">

                <label for="inputFiltroj" class="search-span">Apellido</label>
            </div>


        </div>
        <table class="table table-borderless miTablaPersonalizada" id="miTablaj" style="display: none;">

            <tr class="hv">
                <th scope="col">Nombre</th>
                <th scope="col">Apellidos</th>
                <th scope="col">Tipo</th>
                <th scope="col">Razon</th>
                <th scope="col">Id</th>
            </tr>

            <c:forEach var="justification" items="${justifications}" varStatus="s">
                <tr class="ancho-columna">
                    <td><c:out value="${justification.user.name}"/></td>
                    <td><c:out value="${justification.user.first_last_name}"/> <c:out value="${justification.user.second_last_name}"/></td>
                    <td><c:out value="${justification.date}"/> </td>
                    <td><c:out value="${justification.reason}"/></td>
                    <td><c:out value="${justification.id_justification}"/></td>
                </tr>
            </c:forEach>

        </table>




        <table id="tablaHTMLj" class="table table-borderless miTablaPersonalizada">
            <thead>
            <tr class="hv">
                <th scope="col">Nombre</th>
                <th scope="col">Apellidos</th>
                <th scope="col">Fecha</th>
                <th scope="col">Razón</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody class="table-group-divider tbd">

            </tbody>
        </table>


        <div id="paginadoj" class="d-flex justify-content-center"></div>
    </div>



    <div class="modal fade" id="transf"   tabindex="-1" aria-labelledby="transf" aria-hidden="true" >
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content" style="background-color: var(--color-claro-blanco)">

                    <div class="modal-header">
                        <h1 class="modal-title fs-5 txt-4-green" style="font-size: .5rem"> Transferencia</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-footer">
                        <form action="${pageContext.request.contextPath}/admin/deny-transfer" method="post" id="formsDen" >
                            <input type="hidden" name="id_appointmentD" id="id_appointmentD" >
                            <button type="button" id="DENY" class="btn btn-gray" data-bs-dismiss="modal" style="font-size: .4rem">Denegar</button>

                        </form>
                        <form action="${pageContext.request.contextPath}/admin/transferens-select-consultor" method="get" id="formsTr" >
                        <input type="hidden" name="id_appointment" id="id_appointment" >
                        <button type="submit" id="buttonTr" class="btn btn-green" style="font-size: .4rem">Transferir</button>

                        </form>
                    </div>

            </div>
        </div>
    </div>
    <div class="modal fade" id="justM"   tabindex="-1" aria-labelledby="justM" aria-hidden="true" >
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content" style="background-color: var(--color-claro-blanco)">

                <div class="modal-header">
                    <h1 class="modal-title fs-5 txt-4-green" style="font-size: .5rem"> Justificar</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-footer">
                    <form action="${pageContext.request.contextPath}/admin/notifications/justification" method="post" id="formsJust" >
                        <button type="button" id="JustFal" class="btn btn-gray" data-bs-dismiss="modal" style="font-size: .4rem">No Aceptar</button>

                        <input type="hidden" name="option" id="option" >

                        <input type="hidden" name="id_just" id="id_just" >
                        <button type="submit" id="JustAccep" class="btn btn-green" style="font-size: .4rem">Aceptar</button>

                    </form>
                </div>

            </div>
        </div>
    </div>
    <div class="modal fade" id="report"   tabindex="-1" aria-labelledby="report" aria-hidden="true" >
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content" style="background-color: var(--color-claro-blanco)">

                <div class="modal-header">
                    <h1 class="modal-title fs-5 txt-4-green" style="font-size: .5rem"> Reporte</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-footer">
                    <form action="${pageContext.request.contextPath}/admin/view-report" method="get" id="formsReport" >

                        <div class="input-group input-group-sm mb-3">
                            <h5 class="card-title " style="text-align: start; font-size: .4rem">Selecione un periodo</h5>

                            <input class="form-control" required   list="periodsList" id="periodsInput">
                            <datalist id="periodsList">
                                <c:forEach var="period" items="${periods}" varStatus="s">
                                    <option  data-value="<c:out value="${period.id_Periods}"/>"><c:out value="${period.name}"/> <c:out value="${period.dateBegin}"/> <c:out value="${period.dateEnd}"/></option>
                                </c:forEach>


                            </datalist>
                            <input type="hidden" name="periodsInput-hidden" id="periodsInput-hidden" >

                        </div>
                        <button type="submit" id="buttonReport" class="btn btn-green" style="font-size: .4rem">Crear reporte</button>

                    </form>
                </div>

            </div>
        </div>
    </div>
<jsp:include page="../../../../layouts/appointment/bodyDown.jsp"/>


</body>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="${pageContext.request.contextPath}/assets/js/notifications/ToolsListsTransf.js"></script>
ç<script src="${pageContext.request.contextPath}/assets/js/notifications/ToolsListsJust.js"></script>

<script>
    let buttonTransf = document.getElementById("d-trans");
    let contentTransf = document.getElementById("blockTransf")
    let buttonJust = document.getElementById("d-just");
    let contentJust = document.getElementById("blockJust")

    $(document).ready(function(){

        let inputList =   document.querySelector('input[list]');
        inputList.addEventListener('input', function(e) {
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


        let option = document.getElementById("option");
        buttonTransf.addEventListener("click",()=>{
            contentTransf.style.display="block";
            contentJust.style.display="none";

        })
        buttonJust.addEventListener("click",()=>{
            contentJust.style.display="block";
            contentTransf.style.display="none";
        })

        document.getElementById('DENY').addEventListener('click', function(e) {
            e.preventDefault();
            pregunta()
        });
        document.getElementById('JustFal').addEventListener('click', function(e) {
            option.value = 0 ;
            e.preventDefault();
            pregunta1()
        });
        document.getElementById('JustAccep').addEventListener('click', function(e) {
            option.value = 1 ;
            e.preventDefault();
            pregunta1()
        });
        function pregunta() {
            if (confirm('¿Seguro que quieres denegar la tranferencia?')) {
                document.getElementById('formsDen').submit();
            }
        }
        function pregunta1() {
            if (confirm('¿Seguro que continuar?')) {
                document.getElementById('formsJust').submit();
            }
        }
    })

</script>
</html>
