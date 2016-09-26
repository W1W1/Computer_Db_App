package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alex on 9/9/2016.
 */
public class AboutServlet extends HttpServlet {
    public static final String VUE_FORM     = "/WEB-INF/about.jsp";

    /**
     * public void doGet : Renvoie la page "A Propos" lorsque celle-ci est appelée
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }
}