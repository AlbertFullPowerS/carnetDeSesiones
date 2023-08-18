
var tablaj = document.getElementById("miTablaj");
var tablaBrj = document.getElementById("tablaHTMLj");
var arregloTablaj = [];
for (var i = 1; i < tablaj.rows.length; i++) {
  var fila = tablaj.rows[i];
  var objetoFila = {};
  for (var j = 0; j < fila.cells.length; j++) {
    var celda = fila.cells[j];
    var nombreColumna = tablaj.rows[0].cells[j].textContent;
    objetoFila[nombreColumna] = celda.textContent;
  }

  arregloTablaj.push(objetoFila);
}


  //-----------------------------------------------------------------------
  const resultadosPorPaginaj = 10;
  let paginaActualj = 1;
  
  function imprimirDatosEnTabla(datos, pagina) {
    const tablaHTML = document.getElementById('tablaHTMLj');
    console.log(tablaHTML);
    const tbody = tablaHTML.querySelector('tbody');
  
    const inicio = (pagina - 1) * resultadosPorPaginaj;
    const fin = inicio + resultadosPorPaginaj;
  
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
                                      
                                          <button type="button" class="btn-green butJsJust" value="${fila.Id}" data-bs-toggle="modal" data-bs-target="#justM">Selecionar</button>
                                     
                                  </td>
        </tr>
      `;
      tbody.appendChild(filaHTML);
    }
  }

  //-----------------------------------------------------------------------------
  function actualizarPaginado(totalPaginas) {
    const paginadoDiv = document.getElementById('paginadoj');
  
    paginadoDiv.innerHTML = '';
  
    for (let i = 1; i <= totalPaginasj; i++) {
      const boton = document.createElement('button');
      boton.innerText = i;
      boton.className="btn btn-sm btn-edi";
      boton.addEventListener('click', () => {
        paginaActualj = i;
        imprimirDatosEnTabla(arregloTablaj, paginaActualj);
      });
      paginadoDiv.appendChild(boton);
    }
  }
  
  const totalPaginasj = Math.ceil(arregloTablaj.length / resultadosPorPaginaj);
  actualizarPaginado(totalPaginasj);
  
  imprimirDatosEnTabla(arregloTablaj, paginaActualj);
  //------------------------------------------------------------------------------
  function filtrarPorNombre() {
    const inputFiltro = document.getElementById('inputFiltroj').value.toLowerCase();
    const datosFiltrados = arregloTablaj.filter((fila) =>
      fila.Apellidos.toLowerCase().includes(inputFiltro)
    );
  
    const totalPaginasj = Math.ceil(datosFiltrados.length / resultadosPorPaginaj);
    actualizarPaginado(totalPaginasj);
    imprimirDatosEnTabla(datosFiltrados, paginaActualj);
  }
  
  document.getElementById('inputFiltroj').addEventListener('input', filtrarPorNombre);
tablaBr.appendChild(document.createElement('br'));

let butJsJust = document.querySelectorAll(".butJsJust")

butJsJust.forEach((element, index) => {
 element.addEventListener("click",()=>{
   document.getElementById("id_just").value =element.value;
 })
});