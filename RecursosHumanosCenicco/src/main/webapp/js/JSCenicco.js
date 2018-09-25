function handlelShowRecibos(args) {
    if (args.isValidate) {
        location.href = args.ruta;
    } else {
//        jhandleLoginRequestQuery('#formLogin').effect("shake", {times: 3}, 100);
    }
}
function handleLShow(args) {
    location.href = args.ruta;
}
function handleLoginRequest(args) {
    if (args.loggedIn) {
        location.href = args.ruta;
    }
}
function handleLogoutRequest(args) {
    if (args.loggetOut) {
        location.href = args.ruta;
    }
}
function handleLShow(args) {
    location.href = args.ruta;
}
function handleLoginRequest(args) {
    location.href = args.ruta;
}
function handleLogoutRequest(args) {
    if (args.loggetOut) {
        location.href = args.ruta;
    }
}
function validaformato() {
    var m = document.getElementById("nombreEmpleado").value;
    var expreg = /^[A-Z]$/;

    if (expreg.test(m))
        alert("La matrícula es correcta");
    else
        alert("La matrícula NO es correcta");
}

function objeto() {
    var m = document.getElementById("matricula").value;
    var expreg = new RegExp("^[A-Z]{1,2}\\s\\d{4}\\s([B-D]|[F-H]|[J-N]|[P-T]|[V-Z]){3}$");

    if (expreg.test(m))
        alert("La matrícula es correcta");
    else
        alert("La matrícula NO es correcta");
}