<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="es-ES">

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
               <li class="nav-item"><a class="nav-link"
					href="Controller?op=damefutbol&compet=tenis">Tenis</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownId"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Baloncesto</a>
					<div class="dropdown-menu" aria-labelledby="dropdownId">
						<a class="dropdown-item"
							href="Controller?op=damefutbol&compet=euroleagueBasket">Turkish
							Euroleague</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="Controller?op=damefutbol&compet=ligaendesa">Liga Endesa</a>
						<a class="dropdown-item"
							href="Controller?op=damefutbol&compet=nba">NBA</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownId"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Motor</a>
					<div class="dropdown-menu" aria-labelledby="dropdownId">
						<a class="dropdown-item" href="Controller?op=damef1">F1</a> <a
							class="dropdown-item" href="Controller?op=megustanlasmotos">MotoGP</a>
					</div></li>
			</ul>
            <a href="Controller?op=cards" class="btn btn-primary mx-1"><i class="fas fa-credit-card"></i> Mis fondos</a>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalLogin"><i
                    class="fas fa-sign-out-alt"></i> Cerrar sesi&oacute;n</button>
        </div>
    </nav>
    <!-- Pagina principal -->
    <div class="container my-5 text-white">
        <span>Mis fondos: 1000000000 &euro;</span>
        <div class="row my-2">
            <h5 class="col-6">Mis tarjetas</h5>
            <button type="button" class="btn btn-primary col-1 offset-5" data-toggle="modal" data-target="#modalcard"><i
                    class="fas fa-plus"></i></button>
        </div>
        <table class="table table-striped table-dark">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Alias</th>
                    <th scope="col">N&uacute;mero</th>
                    <th scope="col">F. Caducidad</th>
                    <th scope="col">Titular</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Santander</td>
                    <td>XXXX-XXXX-XXXX-1012</td>
                    <td>15/10/2021</td>
                    <td>Severus Snape</td>
                    <td><i class="fab fa-cc-mastercard"></i> Mastercard</td>
                    <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalpay"><i
                                class="fas fa-plus"></i> Ingresar dinero</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalremovecard"><i
                                class="fas fa-trash"></i></button>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="row mt-5 mb-2">
            <h5 class="col-6">Mis cuentas bancarias</h5>
            <button type="button" class="btn btn-primary col-1 offset-5" data-toggle="modal" data-target="#modalBank"><i
                    class="fas fa-plus"></i></button>
        </div>
        <table class="table table-striped table-dark">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Alias</th>
                    <th scope="col">IBAN</th>
                    <th scope="col">Titular</th>
                    <th scope="col">Entidad</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Santander</td>
                    <td>ES14-XXXX-XXXX-XX-XXXXXX1425</td>
                    <td>Severus Snape</td>
                    <td>Banco Santander</td>
                    <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalwithdraw"><i
                                class="fas fa-money-bill-wave"></i> Retirar fondos</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalremoveaccount"><i
                                class="fas fa-trash"></i></button>
                    </td>
                </tr>
            </tbody>
        </table>
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

    <!-- Modal add tarjeta -->
    <div class="modal fade" id="modalcard" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">A&ntilde;adir tarjeta</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="GET" action="Controller?op=newCard">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Numero de Tarjeta</label>
                            <input type="number" class="form-control" id="exampleInputEmail1"
                                aria-describedby="cardHelp" placeholder="XXXX-XXXX-XXXX-XXXX">
                            <small id="cardHelp" class="form-text text-muted">Nunca compartiremos los datos de tu
                                tarjeta de cr&eacute;dito.</small>
                        </div>
                        <div class="form-row">
                            <div class="col-5">
                                <label for="inputName">Nombre del titular</label>
                                <input type="text" class="form-control" id="titularName" placeholder="Severus Snape">
                            </div>
                            <div class="col-4">
                                <label for="inputSurname">Fecha caducidad</label>
                                <input type="month" class="form-control" id="fechaCaducidad">
                            </div>
                            <div class="col-3">
                                <label for="inputSurname">CVV</label>
                                <input type="number" class="form-control" id="cvv">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">A&ntilde;adir tarjeta</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <!-- Modal add bank -->
    <div class="modal fade" id="modalBank" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">A&ntilde;adir cuenta bancaria</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="GET" action="Controller?op=newBank">
                        <div class="form-group">
                            <label for="exampleInputEmail1">IBAN</label>
                            <input type="text" class="form-control" id="iban" aria-describedby="emailHelp"
                                placeholder="ESXX-XXXX-XXXX-XX-XXXXXXXXXX">
                            <small id="emailHelp" class="form-text text-muted">Nunca compartiremos los datos de tu
                                cuenta.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Alias</label>
                            <input type="text" class="form-control" id="alias" aria-describedby="emailHelp"
                                placeholder="TopbetBank">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Nombre completo del titular</label>
                            <input type="text" class="form-control" id="titularName" aria-describedby="emailHelp"
                                placeholder="Albus Severus Potter">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">A&ntilde;adir tarjeta</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </div>
    <!-- Modal remove cuenta -->
    <div class="modal fade" id="modalremoveaccount" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿Est&aacute;s segurx de que deseas eliminar esta cuenta bancaria?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Esta acci&oacute;n no se puede deshacer.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-danger">Eliminar</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal remove card -->
    <div class="modal fade" id="modalremovecard" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿Est&aacute;s segurx de que deseas eliminar esta tarjeta?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Esta acci&oacute;n no se puede deshacer.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-danger">Eliminar</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal withdraw -->
    <div class="modal fade" id="modalwithdraw" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿Est&aacute;s segurx de que quieres sacar tu dinero?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="GET" action="Controller?op=withdraw">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Introduce la cantidad que deseas transferir a la cuenta</label>
                            <input type="number" class="form-control" id="importe"
                                aria-describedby="emailHelp" placeholder=" &euro;">
                            <small>La cantidad m&iacute;nima que puedes sacar es de 5&euro;</small>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Transferir a mi banco</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal pay -->
    <div class="modal fade" id="modalpay" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿Cu&aacute;nto deseas ingresar?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="GET" action="Controller?op=pay">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Introduce la cantidad que deseas ingresar desde esta tarjeta</label>
                            <input type="number" class="form-control" id="cantidad"
                                aria-describedby="emailHelp" placeholder=" &euro;">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Transferir a mi banco</button>
                        </div>
                    </form>
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