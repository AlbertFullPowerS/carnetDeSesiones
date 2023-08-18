
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
                <h2 class="txt-4-green" style="text-align: start; font-size: 1.2rem;">Periodo</h2>

            </div>
            <form action="${pageContext.request.contextPath}/admin/period/save" method="post">
                <div class="d-flex align-content-center justify-content-center">
                    <div class="row">
                        <div class="col">
                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Nombre</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="text" required  class="form-control card-input" id="name" name="name" placeholder="Alberto">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>



                        </div>
                        <div class="col">

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Fecha de inicio</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="date" required  class="form-control card-input" id="date_begin" name="date_begin" placeholder="">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">

                            <div class="card card-uu card-padding flex-md-fill" >
                                <div class="card-body">
                                    <h5 class="card-title " style="text-align: start;">Fecha de final</h5>

                                    <div class="input-group input-group-sm mb-3">

                                        <input type="date" required  class="form-control card-input" id="date_end" name="date_end" placeholder="">
                                        <span class="input-group-text" ><img src="${pageContext.request.contextPath}/assets/img/Pencil.png" alt="" class="icon"></span>

                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>







                </div>
                <div class="d-flex justify-content-evenly sm-t">
                    <a href="${pageContext.request.contextPath}/admin/period" class="btn  btn-dark btn-sm">Cancelar</a>
                    <button class="btn  btn-green"  type="submit" style="font-size: .4rem ; ">Guardar</button>
                </div>

            </form>


<jsp:include page="../../../../../layouts/admin/bodyDown.jsp"/>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<script>


</script>
</body>

</html>