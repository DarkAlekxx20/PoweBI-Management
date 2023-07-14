function login(){
  let username = document.getElementById("txtUsername").value;
  let password = document.getElementById("txtPassword").value;
  let userData = JSON.stringify({nombreUsuario:username,contrasenia:password});
  params = new URLSearchParams({userData:userData});
  console.log(userData);
  fetch("api/user/login",{
    method:"POST",
    headers:{ "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"},
    body:params
  }).then((response)=>{
    return response.json();
  }).then((data)=>{
    if(data.error){
      Swal.fire({icon:'error',title:'Error al iniciar sesion!'});
    }else{
      localStorage.setItem("currentUser",JSON.stringify(data));
      Swal.fire('Bienvenido '+username+'!','success');
      window.location.href = "http://localhost:8080/PowerBi/Modules/Dashboard.html";
    }
  });
}