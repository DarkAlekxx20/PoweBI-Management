// Datos de ejemplo (sustituir con datos reales)
const data = {
    alumnos: [{ nombre: "Juan", calificacion: 80 },{nombre:"María",calificacion: 90 }],
    materias: ["Matemáticas", "Historia", "Ciencias", "Arte", "Deportes"]
  };
  
  document.addEventListener("DOMContentLoaded", function () {
    // Obtener el contexto del canvas para el gráfico
    const ctx = document.getElementById("chart").getContext("2d");
  
    // Crear el gráfico de barras
    const chart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: data.materias,
        datasets: [
          {
            label: "Calificaciones",
            data: data.alumnos.map((alumno) => alumno.calificacion),
            backgroundColor: "rgba(54, 162, 235, 0.6)", // Color de las barras
            borderWidth: 1,
          },
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
            max: 100, // Puedes ajustar este valor según el rango de calificaciones
          },
        },
      },
    });
  });  