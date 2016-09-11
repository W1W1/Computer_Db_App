package Servlet;

import Util.Computer;
import Util.DTO.ComputerDTO;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Richard-DT on 08/09/2016.
 */
public class GetComputerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 1;
        if (request.getParameter("id")!=null)
        {
            id = Integer.valueOf(request.getParameter("id"));
        }
        Computer tmpComputer = ManageComputer.getComputer(id);
        ComputerDTO computer = new ComputerDTO();
        if (tmpComputer != null) {
            computer = new ComputerDTO(ManageComputer.getComputer(id));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        request.setAttribute("computer", computer);
        request.setAttribute("sdf", sdf);
        this.getServletContext().getRequestDispatcher("/WEB-INF/getComputer.jsp").forward(request, response);
    }
}
