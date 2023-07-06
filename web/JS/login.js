function login(){
  let username = document.getElementById("txtUsername").value;
  let password = document.getElementById("txtPassword").value;
  let userData = JSON.stringify({username:username,password:password});
  params = new URLSearchParams({userData:userData});
  console.log(userData);
  fetch("api/user/login",{
    method:"POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"},
    body:params
  }).then((response) => {
    return response.json();
  }).then((data)=>{
    if(data.error){
      Swal.fire({icon: 'error',title:'Oops...',text: 'Hubo un error al iniciar sesion :(!'});
    }else{
      Swal.fire('Bienvenido '+username+'!','success');
      localStorage.setItem("currentUser",JSON.stringify(data));
      window.location.href="http://localhost:8080/PowerBi/Modules/Dashboard.html";
    }
  });
}