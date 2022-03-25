package my.example.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.example.model.Person;
import my.example.service.NameServiceable;

/**
 * Servlet implementation class TextResultServlet
 */

@WebServlet("/text-result-servlet")
public class TextResultServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NameServiceable service;
	
//	public TextResultServlet() {
//		ServiceFactory factory =  new ServiceFactory();
//		service = factory.getService("concat");
//	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Person p = new Person();
		p.setFirstName(request.getParameter("fname"));
		p.setLastName(request.getParameter("lname"));
		
		response.getWriter().append(service.display(p));
		response.getWriter().close();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// do nothing
	}


}
