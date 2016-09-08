package Servlet;

import Util.Company;
import Util.Computer;
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
        if (request.getParameter("id")!=null) {
            id = Integer.valueOf(request.getParameter("id"));
        }
        Company company = ManageCompany.getCompany(id);
        List computers = ManageComputer.listComputer(id);
        String testMsg = "";
        request.setAttribute("company", company);
        request.setAttribute("computers",computers);
//        request.setAttribute("Servlet.test", computers);
        this.getServletContext().getRequestDispatcher("/WEB-INF/getCompany.jsp").forward(request, response);
    }
}