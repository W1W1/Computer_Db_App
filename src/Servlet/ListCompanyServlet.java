package Servlet;

import Util.Company;
import Util.DTO.ComputerDTO;
import Util.SQLConnection.ManageCompany;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 9/9/2016.
 */
public class ListCompanyServlet extends HttpServlet {
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
        List<Company> companies = ManageCompany.listCompany();

        request.setAttribute("page",page);
        request.setAttribute("nbElements",nbElements);
        request.setAttribute("companies",companies);
        this.getServletContext().getRequestDispatcher("/WEB-INF/listCompany.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


        int page = Integer.valueOf(request.getParameter("page"));
        int nbElements = Integer.valueOf(request.getParameter("nbElements"));
        String url= String.format(request.getContextPath() + "/listCompany?page=%d&nbElements=%d",page,nbElements);
        response.sendRedirect(url);
    }
}