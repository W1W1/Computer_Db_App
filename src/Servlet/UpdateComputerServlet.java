package Servlet;

import Util.Company;
import Util.Computer;
import Util.DTO.ComputerDTO;
import Util.Forms.CreateComputerForm;
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
 * Created by Alex on 9/13/2016.
 */
public class UpdateComputerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 1;
        if (request.getParameter("id")!=null)
        {
            System.out.printf("//"+request.getParameter("id")+"//");
            id = Integer.valueOf(request.getParameter("id"));
        }

        List<Company> companies = ManageCompany.listCompany();

        Computer tmpComputer = ManageComputer.getComputer(id);
        ComputerDTO computer = new ComputerDTO();
        if (tmpComputer != null) {
            computer = new ComputerDTO(ManageComputer.getComputer(id));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        request.setAttribute("companies",companies);
        request.setAttribute("computer", computer);
        request.setAttribute("id", id);
        request.setAttribute("sdf", sdf);
        this.getServletContext().getRequestDispatcher("/WEB-INF/updateComputer.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form=request.getParameter("form_use");
        int id = 1;
        System.out.printf(request.getParameter("id"));
        if (request.getParameter("id") != null &&
                !request.getParameter("id").equals("")) {
            id = Integer.valueOf(request.getParameter("id"));
        }

        if(form.equals("update")){
            //update computer

            CreateComputerForm compForm = new CreateComputerForm();

            Computer computer = compForm.createComputer( request );

            ManageComputer.updateComputer(computer);

            //go to now updated computer page
            String url= String.format(request.getContextPath() + "/getComputer?id=%d",id);
            response.sendRedirect(url);
        }else if(form.equals("delete")){
            //delete computer
            ManageComputer.deleteComputer(id);
            //go to computer list
            String url= String.format(request.getContextPath() + "/listComputer");
            response.sendRedirect(url);
        }
    }
}
