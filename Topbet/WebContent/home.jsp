<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="es-ES">
<% String pageLoaded = (String) session.getAttribute("page");
   String watching = (String) session.getAttribute("watching");
   String competicion = (String) request.getParameter("compet");%>
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
        <a class="navbar-brand  <%if (pageLoaded.equals("home")){ %> active <%} %>" href="#">Navbar</a>
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
                        <a class="dropdown-item <%if (competicion != null && competicion.equals("ucl")){ %> active <%} %>>" href="Controller?op=damefutbol&compet=ucl">Champions League</a>
                        <a class="dropdown-item <%if (competicion != null && competicion.equals("uel")){ %> active <%} %>" href="Controller?op=damefutbol&compet=uel">Europa League</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item <%if (competicion != null && competicion.equals("liga")){ %> active <%} %>" href="Controller?op=damefutbol&compet=liga">LaLiga Santander</a>
                        <a class="dropdown-item <%if (competicion != null && competicion.equals("liga2")){ %> active <%} %>" href="Controller?op=damefutbol&compet=liga2">LaLiga SmartBank</a>
                        <a class="dropdown-item <%if (competicion != null && competicion.equals("epl")){ %> active <%} %>" href="Controller?op=damefutbol&compet=epl">Premier League</a>
                        <a class="dropdown-item <%if (competicion != null && competicion.equals("bundesliga")){ %> active <%} %>" href="Controller?op=damefutbol&compet=bundesliga">Bundesliga</a>

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
    <% if (pageLoaded.equals("home")){ %>
    <!-- Homepage -->
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="img/carousel/ata-juv.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Atalanta - Juventus de Turin</h5>
                    <p>Apuesta ya a este partido de la Serie A</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img/carousel/bos-was.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="img/carousel/mon-psg.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <div class="container-fluid">
        <div class="row my-1">
            <div class="col-md-4">
                <div class="card bg-dark text-white">
                    <img src="img/publi/movistar.webp" style="height: 200px;" class="card-img" alt="...">
                    <div class="card-img-overlay">
                        <h5 class="card-title">Todo el f&uacute;tbol en Movistar +</h5>
                        <p class="card-text">Liga, Copa, Champions y mucho m&aacute;s. Disfrutalo con Fusi&oacute;n
                            Total por 114 &euro;/mes</p>
                        <a class="btn btn-primary" href="https://movistar.es">M&aacute;s informaci&oacute;n</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card bg-dark text-white">
                    <img src="img/publi/dazn.jpg" style="height: 200px;" class="card-img" alt="...">
                    <div class="card-img-overlay daznf1">
                        <h5 class="card-title">La F1, en Dazn con Lobato</h5>
                        <p class="card-text">Liga, Copa, Champions y mucho m&aacute;s.</p>
                        <a class="btn btn-primary" href="https://dazn.com">Inicia tu mes de prueba gratis</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card bg-dark text-white">
                    <img src="img/publi/daznmgp.jpg" style="height: 200px;" class="card-img" alt="...">
                    <div class="card-img-overlay daznf1">
                        <h5 class="card-title">Disfruta la MotoGP en Dazn</h5>
                        <p class="card-text">Me gustan las motoos!!!</p>
                        <p class="card-text">Disfrutalo todo con Fusi&oacute;n Total por 114 &euro;/mes</p>
                        <a class="btn btn-primary" href="https://dazn.com">Inicia tu mes de prueba gratis</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%} else { %>
    <!-- Pagina principal -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-9 main">
            	<% if (watching.equals("partidos")) {%>
                <!-- Maestro apuestas partidos -->
                <div class="container my-3">
                    <h5 style="color: #fff;"><%=competicion %></h5>
                    <table class="table  table-responsive table-striped table-dark">
                        <thead>
                            <tr>
                                <th colspan="4" scope="col">Local</th>
                                <th scope="col">Visitante</th>
                                <th scope="col" colspan="3">Fecha y hora</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><img src="img/escudosFutbol/realMadrid.png" class="escudoTabla"></td>
                                <td>10</td>
                                <td>-</td>
                                <td>2</td>
                                <td><img src="img/escudosFutbol/farsa.png" class="escudoTabla"></td>
                                <td>22/10/2021 - 21:00</td>
                                <td style="text-align: right;"><button class="btn-primary btn btn-sm"
                                        data-toggle="modal" data-target="#modalApuesta"><i
                                            class="fas fa-credit-card"></i> Apuesta</button>
                                </td>
                                <td> <button class="btn-primary btn-sm btn" data-toggle="modal"
                                        data-target="#modalPartido">Seguir en
                                        directo</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
				<%} else { %>
                <!-- Maestro carreras -->
                <div class="container my-3">
                    <h5 style="color: #fff;">Formula 1</h5>
                    <table class="table table-responsive table-striped table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Ubicaci&oacute;n</th>
                                <th scope="col">Fecha carrera</th>
                                <th scope="col">Tiempo</th>
                                <th scope="col">Campe&oacute;n</th>
                                <th scope="col" colspan="3">Escuder&iacute;a</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>GP M&oacute;naco</td>
                                <td>Circuito Urbano de Montecarlo</td>
                                <td>23/05/2021 -- 15:00</td>
                                <td>Soleado - 25º C</td>
                                <td>Carlos Sainz (ESP)</td>
                                <td><img src="img/escudosF1/ferrari.png" class="escudoTabla"></td>
                                <td><button class="btn-primary btn btn-sm" data-toggle="modal"
                                        data-target="#modalApuestaRace">
                                        <i class="fas fa-credit-card"></i> Apuesta</button></td>
                                <td><button class="btn-primary btn btn-sm" data-toggle="modal"
                                        data-target="#modalRace"><i class="fas fa-eye"></i> Ver</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <%} %>
            </div>
            <div class="col-md-3">
            <% if (watching.equals("partidos")){ %>
                <span style="color: #fff;" class="mt-3">Clasificaci&oacute;n</span>
                <table class="table table-responsive p-0 m-0 table-sm table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Pos</th>
                            <th scope="col">Equipo</th>
                            <th scope="col">PG</th>
                            <th scope="col">PE</th>
                            <th scope="col">PP</th>
                            <th scope="col">Pts</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td><img src="img/escudosFutbol/realMadrid.png" height="20px"> Real Madrid</td>
                            <td>22</td>
                            <td>8</td>
                            <td>9</td>
                            <td>75</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td><img src="img/escudosFutbol/farsa.png" height="20px"> FC Barcelona</td>
                            <td>23</td>
                            <td>6</td>
                            <td>6</td>
                            <td>75</td>
                        </tr>
                    </tbody>
                </table>
                <%} else { %>
                <span style="color: #fff;">Mundial de pilotos</span>
                <table class="table table-responsive p-0 m-0 mb-3 table-sm table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Pos</th>
                            <th scope="col">Piloto</th>
                            <th scope="col">Escuder&iacute;a</th>
                            <th scope="col">Pa&iacute;s</th>
                            <th scope="col">Pts</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>SAI</td>
                            <td><img src="img/escudosF1/ferrari.png" height="20px"></td>
                            <td>Espa&ntilde;a</td>
                            <td>125</td>
                        </tr>
                    </tbody>
                </table>
                <span style="color: #fff;">Mundial de constructores</span>
                <table class="table table-responsive p-0 m-0 table-sm table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Pos</th>
                            <th colspan="2" scope="col">Equipo</th>
                            <th scope="col">Pa&iacute;s</th>
                            <th scope="col">Pts</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td><img src="img/escudosF1/ferrari.png" height="20px"></td>
                            <td>Scuderia Ferrari</td>
                            <td>Italia</td>
                            <td>225</td>
                        </tr>
                    </tbody>
                </table>
				<%} %>
            </div>
        </div>
    </div>
    <%} %>
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
                            <label for="inputEmail">Email address</label>
                            <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp">
                            <small id="emailHelp" class="form-text text-muted">Nunca compartiremos tus datos personales
                                con terceros.</small>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Password</label>
                            <input type="password" class="form-control" id="inputPassword">
                        </div>
                        <small>¿A&uacute;n no tienes cuenta?<a href="Controller?op=signin">Reg&iacute;strate</a></small>
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
                                    id="inputLocal" aria-describedby="emailHelp" placeholder="">

                            </div>
                            <div class="form-group col-6">
                                <img src="img/escudosFutbol/farsa.png" class="escudoModal img-fluid">
                                <input type="number" min="0" class="form-control bg-dark score-bet" id="inputVisitante">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="importe">¿Cu&aacute;nto quieres apostar?</label>
                            <input type="number" min="0" class="form-control bg-dark score-bet" id="inputVisitante">
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
    <!-- Modal Apuesta Carrera-->
    <div class="modal fade" id="modalApuestaRace" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Apostar GP M&oacute;naco</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form style="text-align: center;" method="GET" action="Controller?op=apuesta">
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">¿Qui&eacute;n va a ser el campe&oacute;n del GP de M&oacute;naco</label>
                            <select class="form-control" id="exampleFormControlSelect1">
                              <option>Carlos Sainz - Ferrari</option>
                              <option>Lando Norris - McLaren Mercedes</option>
                              <option>Max Verstappen - Red Bull Racing</option>
                              <option>Charles Leclerc - Ferrari</option>
                              <option>Lewis Hamilton - Mercedes</option>
                            </select>
                          </div>
                          <div class="form-group">
                            <label for="importe">¿Cu&aacute;nto quieres apostar?</label>
                            <input type="number" min="0" class="form-control bg-dark score-bet" id="inputVisitante">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Apostar a esta carrera</button>
                        </div>
                    </form>
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

    <!-- Modal Carrera -->
    <div class="modal fade" id="modalRace" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">GP M&oacute;naco en directo</h5>
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