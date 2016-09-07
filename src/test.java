import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Richard-DT on 07/09/2016.
 */
public class test extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        String message ;
        message = ManageComputer.listComputer();
        request.setAttribute( "test", message );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/listComputer.jsp" ).forward( request, response );
    }

}
