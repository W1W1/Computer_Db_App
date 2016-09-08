package Servlet;

import Util.Computer;
import Util.DTO.ComputerDTO;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        ArrayList<ComputerDTO> computerDTOs =new ArrayList<>();

        computers = ManageComputer.listComputer(nbElements,page);
        if (computers != null) {
            for (Computer computer :
                    computers) {
                computerDTOs.add(new ComputerDTO(computer));
            }
        }
        request.setAttribute("page",page);
        request.setAttribute("nbElements",nbElements);
        request.setAttribute("computers", computerDTOs);
        this.getServletContext().getRequestDispatcher("/WEB-INF/listComputer.jsp").forward(request, response);
    }

//    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
//
//        /* Préparation de l'objet formulaire */
//
//        /* Ajout du bean et de l'objet métier à l'objet requête */
//        int page = Integer.valueOf(request.getParameter("page"));
//        int nbElements = Integer.valueOf(request.getParameter("nbElements"));
//        request.setAttribute("nbElements",nbElements);
//        request.setAttribute("page",page);
//        this.getServletContext().getRequestDispatcher("/WEB-INF/listComputer.jsp").forward( request, response );
//
//    }

}
