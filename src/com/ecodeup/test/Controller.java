package com.ecodeup.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TestDAO test;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	 @Override
	public void init() throws ServletException {
		String jdbcURL=getServletContext().getInitParameter("jdbcURL");
		String jdbcUserName=getServletContext().getInitParameter("jdbcUserName");
		String jdbcPassword=getServletContext().getInitParameter("jdbcPassword");
		
		System.out.print(jdbcURL+"\n");
		
		try {
			test = new TestDAO(jdbcURL,jdbcUserName,jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Articulo articulo = new Articulo(0,"Televisor","Televisor 60 pulgadas",560);
		if(test.registrar(articulo)) {
			System.out.println("Articulo ingresado");
		}else {
			System.out.println("Articulo no ingresado");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
