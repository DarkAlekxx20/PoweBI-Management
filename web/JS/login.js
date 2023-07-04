function login(){
  let user = document.getElementById("txtUser").value;
  let password = document.getElementById("txtPassword").value;
  let userData = JSON.stringify({user:user,password:password});
  params = new URLSearchParams({ userData: userData });
  fetch("api/user/login",{
    method: "POST",
    headers: {"Content-Type":"application/x-www-form-urlencoded;charset=UTF-8"},
    body: params
  }).then((response) => {
      return response.json();
    }).then((data) => {
      if (data.error) {
        alert("Error al iniciar sesion");
      }else{
        alert("Bienvenido " + user.toString());
        localStorage.setItem(currentUser,JSON.stringify(data));
        window.location.href = "";
      }
    });
}