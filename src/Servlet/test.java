package Servlet;

import Util.Computer;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Richard-DT on 07/09/2016.
 */

public class test extends HttpServlet {
    public final static int PAGE = 1;
    public final static int NB_ELEMENTS= 20;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nbElements = NB_ELEMENTS;
        int page = PAGE;
        if(request.getParameter("page")!=null) {
             page = Integer.valueOf(request.getParameter("page"));
        }
        if(request.getParameter("nbElements")!=null) {
            nbElements = Integer.valueOf(request.getParameter("nbElements"));
        }
        List<Computer> computers;
        computers = ManageComputer.listComputer(nbElements,page);
        request.setAttribute("computers", computers);
        this.getServletContext().getRequestDispatcher("/WEB-INF/listComputer.jsp").forward(request, response);
    }

}
