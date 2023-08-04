let moduloAlumnos;
let moduloMaestros;
let moduloReportes;

function cargarModuloAlumnos(){
  fetch("../Modules/ModuloAlumnos/Alumnos.html").then(function(response){
    return response.text();
  }).then(function (html){
    document.getElementById("content").innerHTML = html;
    import("../Modules/ModuloAlumnos/AlumnoController.js").then(function (controller){
      moduloAlumnos = controller;
    });
  });
}

function cargarModuloMaestros(){
  fetch("../Modules/ModuloMaestros/Maestros.html").then(function(response){
    return response.text();
  }).then(function (html){
    document.getElementById("content").innerHTML = html;
    import("../Modules/ModuloMaestros/MaestrosController.js").then(function (controller){
      moduloMaestros = controller;
     moduloMaestros.inicializar();
    });
  });
}

function cargarModuloReportes(){
  fetch("../Modules/ModuloReportes/Reportes.html").then(function(response){
    return response.text();
  }).then(function(html){
    document.getElementById("content").innerHTML = html;
    import("../Modules/ModuloReportes/ReportesController.js").then(function(controller){
      moduloReportes = controller;
    });
  });
}