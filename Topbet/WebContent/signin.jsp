<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="es-ES">
<% Usuario user = (Usuario) session.getAttribute("user"); %>
<head>
    <title>TopBet - Las mejores apuestas del mercado</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/f132adb9c2.js" crossorigin="anonymous"></script>
</head>

<body class="bg-dark">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="Controller?op=inicio">Navbar</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
            aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="Controller?op=inicio">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">F&uacute;tbol</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <a class="dropdown-item" href="Controller?op=damefutbol&compet=ucl">Champions League</a>
                        <a class="dropdown-item" href="Controller?op=damefutbol&compet=uel">Europa League</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="Controller?op=damefutbol&op=liga">LaLiga Santander</a>
                        <a class="dropdown-item" href="Controller?op=damefutbol&op=liga2">LaLiga SmartBank</a>
                        <a class="dropdown-item" href="Controller?op=damefutbol&op=epl">Premier League</a>
                        <a class="dropdown-item" href="Controller?op=damefutbol&op=bundesliga">Bundesliga</a>

                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tenis</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">Baloncesto</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <a class="dropdown-item" href="#">Turkish Euroleague</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Liga Endesa</a>
                        <a class="dropdown-item" href="#">NBA</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">Motor</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <a class="dropdown-item" href="#">F1</a>
                        <a class="dropdown-item" href="#">MotoGP</a>
                    </div>
                </li>
            </ul>
            <a href="pagar.html" class="btn btn-primary mx-1"><i class="fas fa-credit-card"></i> Mis fondos</a>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalLogin"><i
                class="fas fa-sign-out-alt"></i> Cerrar sesi&oacute;n</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalLogin"><i
                    class="fas fa-user-circle"></i></button>
        </div>
    </nav>
    <!-- Pagina principal -->
    <div class="container my-5 text-white">
        <h4>Alta de usuario</h4>
        <form action="<%if (user == null) {%>Controller?op=registrarme <%} else { %> Controller?op=updateProfile<% } %>" method="POST">
            <div class="form-row">
                <div class="col">
                    <label for="inputName">Nombre</label>
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="Severus" <%if (user != null){ %> value="<%=user.getNombre()%>"<%} %>>
                </div>
                <div class="col">
                    <label for="inputSurname">Apellidos</label>
                    <input type="text" name="surname" class="form-control" id="inputSurname"<%if (user != null){ %> value="<%=user.getApellidos()%>"<%} %> placeholder="Snape">
                </div>
                <div class="col">
                    <label for="nickname">Nombre de usuario</label>
                    <input type="text" name="nickname" class="form-control" id="nickname" <%if (user != null){ %> value="<%=user.getNickname()%>"<%} %> placeholder="Snivelis">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail">Email</label>
                    <input type="email" class="form-control" name="mail" id="inputEmail" <%if (user != null){ %> value="<%=user.getMail()%>"<%} %> placeholder="severus.snape@hogwarts.com">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputNif">NIF</label>
                            <input type="text" class="form-control" name="nif" <%if (user != null){ %> value="<%=user.getNif()%>"<%} %> id="inputNif">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPhone">Tel&eacute;fono</label>
                            <input type="tel" class="form-control" name="phone" <%if (user != null){ %> value="<%=user.getPhone()%>"<%} %> id="inputPhone">
                        </div>
                    </div>

                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword">Contrase&ntilde;a</label>
                    <input type="password" name="password" class="form-control" id="inputPassword">
                    <label for="inputCheckPass">Confirmar contrase&ntilde;a</label>
                    <input type="password" name="checkPass" class="form-control" id="inputCheckPass" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Direcci&oacute;n</label>
                <input type="text" class="form-control" name="address" <%if (user != null){ %> value="<%=user.getDir1()%>"<%} %> id="inputAddress" placeholder="Pº de la Castellana, 81">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Direcci&oacute;n 2</label>
                <input type="text" class="form-control" name="address2" <%if (user != null){ %> value="<%=user.getDir2()%>"<%} %> id="inputAddress2" placeholder="Apartmento, estudio o planta">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">Ciudad</label>
                    <input type="text" class="form-control" name="city" <%if (user != null){ %> value="<%=user.getCiudad()%>"<%} %> id="inputCity" placeholder="Madrid">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputCountry">Pa&iacute;s</label>
                    <input type="text" class="form-control" id="inputCountry"<%if (user != null){ %> value="<%=user.getPais()%>"<%} %> name="country" placeholder="Espa&ntilde;a">
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">Zip</label>
                    <input type="text" class="form-control" id="inputZip" <%if (user != null){ %> value="<%=user.getC_postal()%>"<%} %> name="zip">
                </div>
                <div class="form-group col-12">
                    <label for="inputBirthday">Fecha de nacimiento</label>
                    <input type="date" class="form-control" id="inputBirthday" <%if (user != null){ %> value="<%=new SimpleDateFormat("dd-MM-yyyy").format(user.getfNacimiento())%>"<%} %> name="birthday">
                </div>
            </div>
            <% if (user != null){ %>
            <div class="form-row">
            	<div class="col-md-9">
            		<input type="password" class="form-control" id="inputCurrentPass" placeholder="Contrase&ntilde;a actual" name="currentPass">
            	</div>
            	<div class="col-md-3">
            		<button type="submit" class="btn btn-primary">Actualizar mi perfil</button>
            	</div>
            </div>
            <%} else { %>
            <button type="submit" class="btn btn-primary">Registrarme</button>
            <%} %>
        </form>
    </div>
    
    <footer class="p-2">
        <div class="container">
            <div class="row">
                <ul class="nav col-8 bottom-nav">
                    <li class="m-2">
                        T&eacute;rminos y condiciones de uso
                    </li>
                    <li class="m-2">
                        Pol&iacute;tica de cookies y privacidad</li>
                    <li class="m-2">
                        ¿Qui&eacute;nes somos?</li>
                    <li class="m-2">
                        Contacto</li>
                </ul>
                <div class="col-1 offset-3">
                    <img src="img/escudosFutbol/realMadrid.png" style="height: 80px;" />
                </div>
            </div>
            <span>&copy; 2021 - Softop</span>
            <img src="img/legal/jugarsegurokk.png" class="mx-1" style="width: 170px;">
            <img src="img/legal/pegi18.jpg" class="mx-1" style="height: 40px;">
            <img src="img/legal/pegicompras.jpg" class="mx-1" style="height: 40px;">
            <img src="img/legal/juegopegi.jpg" class="mx-1" style="height: 40px;">
        </div>
    </footer>
    <!-- Modal Login-->
    <div class="modal fade" id="modalLogin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Iniciar sesi&oacute;n</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="GET" action="Controller?op=login">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                                else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1">
                        </div>
                        <small>¿A&uacute;n no tienes cuenta?<a href="#">Reg&iacute;strate</a></small>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Iniciar sesi&oacute;n</button>
                </div>
                </form>
            </div>

        </div>
    </div>
    </div>
    <!-- Modal Apuesta-->
    <div class="modal fade" id="modalApuesta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Apostar Real Madrid - FC Barcelona</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form style="text-align: center;" method="GET" action="Controller?op=apuesta">
                        <div class="form-row">
                            <div class="form-group col-6">
                                <img src="img/escudosFutbol/realMadrid.png" class="escudoModal img-fluid">
                                <input type="number" min="0" class="form-control form-control-xl bg-dark score-bet"
                                    id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">

                            </div>
                            <div class="form-group col-6">
                                <img src="img/escudosFutbol/farsa.png" class="escudoModal img-fluid">
                                <input type="number" min="0" class="form-control bg-dark score-bet"
                                    id="exampleInputPassword1">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Apostar a este partido</button>
                        </div>
                </div>
            </div>

        </div>
    </div>
    </div>
    <!-- Modal Partido-->
    <div class="modal fade" id="modalPartido" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Real Madrid - FC Barcelona en directo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Apostar a este partido</button>
                </div>
            </div>

        </div>
    </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>