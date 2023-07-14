let moduloAlumnos;
let moduloMaestros;

function cargarModuloAlumnos() {
  fetch("../Modules/ModuloAlumnos/Alumnos.html").then(function(response){
    return response.text();
  }).then(function (html){
    document.getElementById("content").innerHTML = html;
    import("../Modules/ModuloAlumnos/AlumnosController.js").then(function (controller){
      moduloAlumnos = controller;
    });
  });
}

function cargarModuloMaestros() {
  fetch("../Modules/ModuloMaestros/Maestros.html").then(function(response){
    return response.text();
  }).then(function (html){
    document.getElementById("content").innerHTML = html;
    import("../Modules/ModuloMaestros/MaestrosController.js").then(function (controller){
      moduloAlumnos = controller;
    });
  });
}