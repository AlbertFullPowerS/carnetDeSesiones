// Obtener los datos de la tabla
var url = document.getElementById("url").value;
var tabla = document.getElementById("miTabla");
var tablaBr = document.getElementById("tablaHTML");
var arregloTabla = [];
for (var i = 1; i < tabla.rows.length; i++) {
  var fila = tabla.rows[i];
  var objetoFila = {};
  for (var j = 0; j < fila.cells.length; j++) {
    var celda = fila.cells[j];
    var nombreColumna = tabla.rows[0].cells[j].textContent;
    objetoFila[nombreColumna] = celda.textContent;
  }

  arregloTabla.push(objetoFila);
}


  //-----------------------------------------------------------------------
  const resultadosPorPagina = 10;
  let paginaActual = 1;
  
  function imprimirDatosEnTabla(datos, pagina) {
    const tablaHTML = document.getElementById('tablaHTML');
    const tbody = tablaHTML.querySelector('tbody');
    console.log(tablaHTML);

    const inicio = (pagina - 1) * resultadosPorPagina;
    const fin = inicio + resultadosPorPagina;
  
    tbody.innerHTML = '';
  
    for (let i = inicio; i < fin && i < datos.length; i++) {
      const fila = datos[i];
      const filaHTML = document.createElement('tr');
      filaHTML.innerHTML = `
        <tr class="ancho-columna">
                                  <td>${fila.Nombre}</td>
                                  <td>${fila.Apellidos}</td>
                                  <td>${fila.Tipo}</td>
                                  <td>${fila.Razon}</td>
                               
                                  <td>
                                      <form action="${url}/admin/user-view-update-consultor" method="get">
                                          <button type="button" class="btn-green butJs" value="${fila.Id}" data-bs-toggle="modal" data-bs-target="#transf">Selecionar</button>
                                      </form>
                                  </td>
        </tr>
      `;
      tbody.appendChild(filaHTML);
    }
  }

  //-----------------------------------------------------------------------------
  function actualizarPaginado(totalPaginas) {
    const paginadoDiv = document.getElementById('paginado');
  
    paginadoDiv.innerHTML = '';
  
    for (let i = 1; i <= totalPaginas; i++) {
      const boton = document.createElement('button');
      boton.innerText = i;
      boton.className="btn btn-sm btn-edi";
      boton.addEventListener('click', () => {
        paginaActual = i;
        imprimirDatosEnTabla(arregloTabla, paginaActual);
      });
      paginadoDiv.appendChild(boton);
    }
  }
  
  const totalPaginas = Math.ceil(arregloTabla.length / resultadosPorPagina);
  actualizarPaginado(totalPaginas);
  
  imprimirDatosEnTabla(arregloTabla, paginaActual);
  //------------------------------------------------------------------------------
  function filtrarPorNombre() {
    const inputFiltro = document.getElementById('inputFiltro').value.toLowerCase();
    const datosFiltrados = arregloTabla.filter((fila) =>
      fila.Apellidos.toLowerCase().includes(inputFiltro)
    );
  
    const totalPaginas = Math.ceil(datosFiltrados.length / resultadosPorPagina);
    actualizarPaginado(totalPaginas);
    imprimirDatosEnTabla(datosFiltrados, paginaActual);
  }
  
  document.getElementById('inputFiltro').addEventListener('input', filtrarPorNombre);
tablaBr.appendChild(document.createElement('br'));

let butJs = document.querySelectorAll(".butJs")

butJs.forEach((element, index) => {
 element.addEventListener("click",()=>{
   document.getElementById("id_appointment").value =element.value;
   document.getElementById("id_appointmentD").value = element.value;
 })
});