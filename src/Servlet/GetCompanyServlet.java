package Servlet;

import Util.Company;
import Util.SQLConnection.ManageCompany;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Alex on 08/09/2016.
 */
public class GetCompanyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companies;
        int id = 1;
        Company company = ManageCompany.getCompany(id);
        String testMsg = "";
        request.setAttribute("company", company);
//        request.setAttribute("Servlet.test", computers);
        this.getServletContext().getRequestDispatcher("getCompany").forward(request, response);
    }
}