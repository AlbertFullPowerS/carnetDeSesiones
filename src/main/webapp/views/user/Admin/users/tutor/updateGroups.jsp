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
    <input type="hidden" value="${pageContext.request.contextPath}" id="url">
</head>
<body>
<jsp:include page="../../../../../layouts/admin/bodyUp.jsp"/>
<div class="row">
    <div class="col">
        <div class="scroll">
            <div class="sm-t flex">
                <div class="flex">
                    <h2 class="txt-4-green">Grupos</h2>
                </div>




            </div>
            <table class="table table-borderless miTablaPersonalizada" id="miTabla" style="display: none;">

                <tr class="">
                    <th scope="col">GrupoyGrado</th>
                    <th scope="col">ProgramaAcademico</th>
                    <th scope="col">Id</th>
                </tr>




                <c:forEach var="Tgroup" items="${tutorGroups}" varStatus="s">
                    <tr class="ancho-columna">
                        <td><c:out value="${Tgroup.grade}"/> - <c:out value="${Tgroup.group}"/></td>
                        <td><c:out value="${Tgroup.academic_program.programName}"/></td>
                        <td><c:out value="${Tgroup.id_group}"/></td>

                    </tr>
                </c:forEach>

            </table>




            <table id="tablaHTML" class="table table-borderless miTablaPersonalizada">
                <thead>
                <tr class="" style="font-size: .5rem">
                    <th scope="col">Grado - Grupo </th>
                    <th scope="col">Programa Académico</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody class="table-group-divider">

                </tbody>
            </table>


            <div id="paginado" class="d-flex justify-content-center"></div>
        </div>
    </div>
    <div class="col">
        <div class="card card-uu card-padding flex-md-fill" >
            <div class="card-body">
                <h5 class="card-title " style="text-align: start;">Grupos</h5>
                <form action="${pageContext.request.contextPath}/admin/tutor/group-save" method="post"  style="text-align: center">

                <div class="input-group input-group-sm mb-3">

                    <input class="form-control" required  list="suggestionList" id="answerInput">
                    <datalist id="suggestionList">
                        <c:forEach var="groups" items="${groups}" varStatus="s">
                            <option  data-value="<c:out value="${groups.id_group}"/>"><c:out value="${groups.grade}"/><c:out value="${groups.group}"/> <c:out value="${groups.academic_program.programName}"/> </option>
                        </c:forEach>


                    </datalist>
                    <input type="hidden"  name="answerInput-hidden" id="answerInput-hidden" >

                </div>

                    <a href="${pageContext.request.contextPath}/admin/user-view-update-tutor" class="btn btn-gray">Volver</a>
                    <button class="btn btn-green" type="submit" style="font-size: .4rem ; ">Agregar</button>
                    <input type="hidden" value="<c:out value="${tutor.id_tutor}"/>"  id="id" name="id">
                </form>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
    document.getElementById("fondo").className="fondo d-flex justify-content-evenly";



</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/ToolsListsGrpTutor.js"></script>


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