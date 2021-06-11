package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DAOCompeticion;
import daos.DAOCuenta;
import daos.DAOEquipo;

import daos.DAOEvento;
import daos.DAOTarjeta;
import daos.DAOUsuario;
import model.CuentaBancaria;
import model.Deporte;
import model.Equipo;
import model.Evento;
import model.EventoEquipos;
import model.Tarjeta;
import model.Usuario;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOUsuario daou = DAOUsuario.getDAOU();
	DAOCompeticion daoc = DAOCompeticion.getDAOC();
	DAOEquipo daoe = DAOEquipo.getDAOE();
	DAOEvento daoev = DAOEvento.getDAOEvento();
	DAOTarjeta daot = DAOTarjeta.getDAOT();
	DAOCuenta daocu = DAOCuenta.getDAOC();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		RequestDispatcher dispatcher;
		if (op.equals("inicio")) {
			session.setAttribute("page", "home");
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);

		} else if (op.equals("signin")) {
			dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("damefutbol")) {
			session.setAttribute("page", "apuestas");
			session.setAttribute("watching", "partidos");
			int idCompeticion;
			String compet = request.getParameter("compet");
			if (compet.equals("liga"))
				idCompeticion = 1;
			else
				idCompeticion = 0;
			List<Equipo> equipos = daoe.listadoEquipos(idCompeticion);
			List<Evento> eventos = daoev.listado(38, idCompeticion);
			List<EventoEquipos> partidos = new ArrayList<>();
			for (Evento evento : eventos) {
				partidos.add(daoev.getResuladoPartido(evento.getcEvento()));
//				System.out.println(evento.getcEvento());
			}
			session.setAttribute("partidos", partidos);
			session.setAttribute("equipos", equipos);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("registrarme")) {
			try {
				String nombre = request.getParameter("name");
				String apellidos = request.getParameter("surname");
				String nick = request.getParameter("nickname");
				String mail = request.getParameter("mail");
				String nif = request.getParameter("nif");
				String phone = request.getParameter("phone");
				String password = request.getParameter("password");
				String direccion1 = request.getParameter("address");
				String direccion2 = request.getParameter("address2");
				String ciudad = request.getParameter("city");
				String pais = request.getParameter("country");
				String f_nacimiento = request.getParameter("birthday");
//			int anno = Integer.parseInt(f_nacimiento.substring(0, 4));
//			int mes = Integer.parseInt(f_nacimiento.substring(5,7));
//			int dia = Integer.parseInt(f_nacimiento.substring(8,10));
				Date birth;
				birth = new SimpleDateFormat("yyyy-MM-dd").parse(f_nacimiento);
				String c_postal = request.getParameter("zip");
				Usuario user = new Usuario(0, 0, nombre, nick, phone, nif, apellidos, password, mail, birth, direccion1, direccion2, ciudad, c_postal, pais, false);
				daou.insertaUsuario(user, false, password);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);

		} else if (op.equals("login")) {
			String mail = request.getParameter("mail");
			String pass = request.getParameter("pass");
			Usuario user = daou.getUsuario(mail);
			System.out.println(user.toString());
			if (user != null && user.checkPassword(pass) && !user.isBanned())
				session.setAttribute("user", user);
			else 
				request.setAttribute("error", "Contrase&ntilde;a incorrecta");
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("logout")) {
			session.setAttribute("user", null);
			System.out.println("Sesion cerrada con exito");
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("damef1")) {
			session.setAttribute("watching", "f1");
			session.setAttribute("page", "apuestas");
			List<Equipo> clasificacion = (List<Equipo>) daoe.listadoEquipos(11);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("perfil")) {
			dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("updateProfile")) {
			try {
				String nombre = request.getParameter("name");
				String apellidos = request.getParameter("surname");
				String nick = request.getParameter("nickname");
				String mail = request.getParameter("mail");
				String nif = request.getParameter("nif");
				String phone = request.getParameter("phone");
				String password = request.getParameter("password"), current = request.getParameter("currentPassword");
				boolean passwordChanged = true;
				if (password.equals(""))
					passwordChanged = false;
				String direccion1 = request.getParameter("address");
				String direccion2 = request.getParameter("address2");
				String ciudad = request.getParameter("city");
				System.out.println(ciudad);
				String pais = request.getParameter("country");
				String f_nacimiento = request.getParameter("birthday");
				Date birth;
				birth = new SimpleDateFormat("yyyy-MM-dd").parse(f_nacimiento);
				String c_postal = request.getParameter("zip");
				Usuario user = (Usuario) session.getAttribute("user");
				user.setNombre(nombre);
				user.setApellidos(apellidos);
				user.setNickname(nick);
				user.setMail(mail);
				user.setNif(nif);
				user.setPhone(phone);
				user.setDir1(direccion1);
				user.setDir2(direccion2);
				user.setPais(pais);
				user.setfNacimiento(birth);
				user.setPass(current, password);
				if (user.checkPassword(current))
					if (passwordChanged) {
						daou.actualizaUsuarioWithPass(user, false, password);
					} else {
						daou.actualizaUsuarioNoPass(user, false);
					}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("cards")) {
			Usuario usuario = (Usuario) session.getAttribute("user");
			List<Tarjeta> tarjetas = daot.listado(usuario);
			List<CuentaBancaria> cuentas = daocu.listado(usuario);
			session.setAttribute("tarjetas", tarjetas);
			session.setAttribute("cuentas", cuentas);
			
			dispatcher = request.getRequestDispatcher("payments.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
