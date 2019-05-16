package my.example.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/dynamic-web-project/myservlet/a/b;c=123?a=1&b=2
 * 
 * Servlet implementation class MyServlet
 */
@WebServlet(urlPatterns="/myservlet/*")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * https://examples.javacodegeeks.com/enterprise-java/servlet/java-servlet-http-request-headers-example/
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /***** Set Response Content Type *****/
        response.setContentType("text/html");
//        response.setContentType("text/plain");
        
        /***** Print The Response *****/
        PrintWriter out = response.getWriter();
        String title = "HTTP Request Example";
        String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body>\n" );
        
        printURL(request, out);
        printMethod(request, out);
        printHeader(request, out);
        printBody(request, out);
        
        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void printURL(HttpServletRequest request,PrintWriter out){
        out.println("<h1 align = \"center\">URL</h1>\n" +
                "<table border = \"1\" align = \"center\">\n" +
                "<tr>\n" +
                "<th>Name</th><th>Value</th>\n"+
                "</tr>\n");
 
        out.println("<tr><td>Scheme</td>\n<td> " + request.getScheme() + "</td></tr>\n");
        out.println("<tr><td>Server Name</td>\n<td> " + request.getServerName() + "</td></tr>\n");
        out.println("<tr><td>Server Port</td>\n<td> " + request.getServerPort() + "</td></tr>\n");
        out.println("<tr><td>Context Path</td>\n<td> " + request.getContextPath()+ "</td></tr>\n");
        out.println("<tr><td>Servlet Path</td>\n<td> " + request.getServletPath() + "</td></tr>\n");
        out.println("<tr><td>Path Info</td>\n<td> " + request.getPathInfo() + "</td></tr>\n");
        out.println("<tr><td>Query String</td>\n<td> " + request.getQueryString() + "</td></tr>\n");
        
        out.println("</table>\n");
	}

	private void printMethod(HttpServletRequest request,PrintWriter out){
        out.println("<h1 align = \"center\">Method</h1>\n" +
                "<table border = \"1\" align = \"center\">\n");
        
        out.println("<tr><td>"+request.getMethod()+"</td></tr>\n");
        
        out.println("</table>\n");
	}
	
	private void printHeader(HttpServletRequest request,PrintWriter out){
        out.println("<h1 align = \"center\">Header</h1>\n" +
                "<table border = \"1\" align = \"center\">\n" +
                "<tr>\n" +
                "<th>Header Name</th><th>Header Value(s)</th>\n"+
                "</tr>\n");
 
        Enumeration<String> headerNames = request.getHeaderNames();
        
        List<String> list = Collections.list(headerNames);
        Collections.sort(list);
        
        for (String key : list) {
            out.print("<tr><td>" + key + "</td>\n");
            String paramValue = request.getHeader(key);
            out.println("<td> " + paramValue + "</td></tr>\n");
        }
        
        
        out.println("</table>\n");
	}
	
	private void printBody(HttpServletRequest request,PrintWriter out) throws IOException{
        out.println("<h1 align = \"center\">Body</h1>\n" +
                "<table border = \"1\" align = \"center\">\n");
        
        out.println("<tr><td>");
        
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
        	 out.println(line);
        }
        
        out.println("</td></tr>\n");
        
        out.println("</table>\n");
	}
	

}
