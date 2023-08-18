// Obtener los datos de la tabla
var url = document.getElementById("url").value;
var tabla = document.getElementById("miTabla");
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
  
    const inicio = (pagina - 1) * resultadosPorPagina;
    const fin = inicio + resultadosPorPagina;
  
    tbody.innerHTML = '';
  
    for (let i = inicio; i < fin && i < datos.length; i++) {
      const fila = datos[i];
      const filaHTML = document.createElement('tr');
      filaHTML.innerHTML = `
        <tr class="ancho-columna">
                                  <td>${fila.GrupoyGrado}</td>
                                  <td>${fila.ProgramaAcademico}</td>                         
                                 
                                  <td>
                                      <form action="${url}/admin/tutor/group-delete" method="post">
                                          <input hidden value="${fila.Id}" name="id"/>
                                          <button type="submit" class="btn btn-red" style="font-size: .4rem ; ">Eliminar</button>
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
    }
  }

  const totalPaginas = Math.ceil(arregloTabla.length / resultadosPorPagina);
  actualizarPaginado(totalPaginas);

  imprimirDatosEnTabla(arregloTabla, paginaActual);
  //------------------------------------------------------------------------------
  function filtrarPorNombre() {
    const inputFiltro = document.getElementById('inputFiltro').value.toLowerCase();
    const datosFiltrados = arregloTabla.filter((fila) =>
      fila.GradoyGrupo.toLowerCase().includes(inputFiltro)
    );

    const totalPaginas = Math.ceil(datosFiltrados.length / resultadosPorPagina);
    actualizarPaginado(totalPaginas);
    imprimirDatosEnTabla(datosFiltrados, paginaActual);
  }

  document.getElementById('inputFiltro').addEventListener('input', filtrarPorNombre);