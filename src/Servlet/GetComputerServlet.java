package Servlet;

import Util.Computer;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Richard-DT on 08/09/2016.
 */
public class GetComputerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Computer> computers;
        int id = 1;
        Computer computer = ManageComputer.getComputer(id);
        String testMsg = "";
        request.setAttribute("computer", computer);
//        request.setAttribute("Servlet.test", computers);
        this.getServletContext().getRequestDispatcher("/WEB-INF/getComputer.jsp").forward(request, response);
    }
}
