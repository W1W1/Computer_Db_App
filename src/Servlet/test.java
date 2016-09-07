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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Computer> computers;
        computers = ManageComputer.listComputer();
        String testMsg = "";
        for (Computer comp :
                computers) {
            testMsg += comp;
        }
        request.setAttribute("Servlet.test", testMsg);
//        request.setAttribute("Servlet.test", computers);
        this.getServletContext().getRequestDispatcher("/WEB-INF/listComputer.jsp").forward(request, response);
    }

}
