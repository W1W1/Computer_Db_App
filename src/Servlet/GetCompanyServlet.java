package Servlet;

import Util.Company;
import Util.Computer;
import Util.DTO.ComputerDTO;
import Util.SQLConnection.ManageCompany;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 08/09/2016.
 */
public class GetCompanyServlet extends HttpServlet {
    public static int ID = 1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companies;
        int id = ID;
        if (request.getParameter("id") != null) {
            id = Integer.valueOf(request.getParameter("id"));
        }
        Company company = ManageCompany.getCompany(id);
        List<Computer> computers = ManageComputer.listComputer(id);
        ArrayList<ComputerDTO> computerDTOs = new ArrayList<>();
        if (computers != null) {
            for (Computer computer :
                    computers) {
                computerDTOs.add(new ComputerDTO(computer));
            }
        }
        request.setAttribute("company", company);
        request.setAttribute("computers", computerDTOs);
//        request.setAttribute("Servlet.ListComputerServlet", computers);
        this.getServletContext().getRequestDispatcher("/WEB-INF/getCompany.jsp").forward(request, response);
    }
}