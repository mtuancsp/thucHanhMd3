package controller;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/listEmployee")
public class ListServlet extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Employee> listEmployee = employeeDAO.getAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");
        List<Employee> listEmployee = employeeDAO.searchEmployeeByName(search);
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("search", search);
        request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
    }

}
