document.addEventListener("DOMContentLoaded", function() {
    // Obtener la referencia a la tabla y a los divs donde se mostrará la información
    var tabla = document.getElementById("tabla-sesiones");
    var divSesiones = document.getElementById("div-sesiones");

    // Obtener las filas de la tabla (excepto la primera fila de encabezados)
    var filas = tabla.getElementsByTagName("tr");
    
    // Crear divs para cada sesión y ocultar la tabla
    for (var i = 1; i < filas.length; i++) {
      var fila = filas[i];
      var datos = fila.getElementsByTagName("td");
      
      var numSesion = datos[0].textContent;
      var nombre = datos[1].textContent;
      var consultor = datos[2].textContent;
      var horario = datos[3].textContent;
      
      var sesionDiv = document.createElement("div");
      sesionDiv.className = "sesion-div";
      sesionDiv.innerHTML = `
        <strong>Sesión ${numSesion}</strong><br>
        Fecha: ${nombre}<br>
        Consultor: ${consultor}<br>
        Horario: ${horario}
      `;
      
      divSesiones.appendChild(sesionDiv);

      // Insertar un salto de línea después de cada 3 divs
      if (i % 3 === 0) {
        var breakLine = document.createElement("br");
        divSesiones.appendChild(breakLine);
      }
    }
    
    tabla.style.display = "none";
  });