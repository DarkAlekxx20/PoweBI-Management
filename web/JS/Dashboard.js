

function cargarModuloAlumnos(){
var contenedor = document.getElementById('content');

// Realizar petición Fetch
fetch('../Modules/ModuloAlumnos/Alumnos.html')
  .then(function(response) {
    return response.text();
  })
  .then(function(html) {
    // Insertar el contenido HTML en el contenedor
    contenedor.innerHTML = html;
  })
  .catch(function(error) {
    console.log('Error:', error);
  });

}

function cargarModuloMaestros(){
  var contenedor = document.getElementById('content');
  
  // Realizar petición Fetch
  fetch('../Modules/ModuloMaestros/Maestros.html')
    .then(function(response) {
      return response.text();
    })
    .then(function(html) {
      // Insertar el contenido HTML en el contenedor
      contenedor.innerHTML = html;
    })
    .catch(function(error) {
      console.log('Error:', error);
    });
  
  }