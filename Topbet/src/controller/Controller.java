package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DAOUsuario;
import model.Usuario;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOUsuario daou = new DAOUsuario();

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
				System.out.println(ciudad);
				String pais = request.getParameter("country");
				String f_nacimiento = request.getParameter("birthday");
//			int anno = Integer.parseInt(f_nacimiento.substring(0, 4));
//			int mes = Integer.parseInt(f_nacimiento.substring(5,7));
//			int dia = Integer.parseInt(f_nacimiento.substring(8,10));
				Date birth;
				birth = new SimpleDateFormat("yyyy-MM-dd").parse(f_nacimiento);
				String c_postal = request.getParameter("zip");
				Usuario user = new Usuario(0, 0, nombre, nick, phone, nif, apellidos, password, mail, birth, direccion1, direccion2, ciudad, c_postal, pais);
				daou.insertaUsuario(user, false, password);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dispatcher = request.getRequestDispatcher("home.jsp");
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
