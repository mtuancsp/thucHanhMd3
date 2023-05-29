package controller;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/insert")
public class InsertServlet extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int department_id = Integer.parseInt(request.getParameter("department_id"));
        String department = request.getParameter("department");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setSalary(salary);
        employee.setDepartment_id(department_id);
        employee.setDepartment(department);
        employeeDAO.insertEmployee(employee);

        request.setAttribute("message", "Add success!");
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

}