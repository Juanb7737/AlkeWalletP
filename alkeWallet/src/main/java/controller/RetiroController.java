package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import conexion.ConexionBD;
import dao.DaoCuenta;
import model.Cuenta;

@WebServlet("/RetiroController")
public class RetiroController extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        ConexionBD conexionBD = new ConexionBD();
    	Connection conexion = conexionBD.establecerConexion();

    	Cuenta cuenta = new Cuenta();
    	
    	
    	cuenta.setSaldo((Double.parseDouble(request.getParameter("montoretiro"))));
    	System.out.println("monto: "+cuenta.getSaldo());
    	
    	//public void actualizarSaldo(int id, double saldo)
		DaoCuenta dao = new DaoCuenta(conexion);
		double saldoActual = dao.consultarCuentaPorId(1);
		saldoActual = saldoActual - cuenta.getSaldo();
		
		dao.actualizarSaldo(1, saldoActual);
		
        request.setAttribute("cuenta",dao.obtenerTodos());  
		
		
		RequestDispatcher rd=request.getRequestDispatcher("vista/home.jsp");  
        rd.forward(request, response); 		

        
	}


    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
	
}
