package controller;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = employeeDAO.getEmployeeById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int department_id = Integer.parseInt(request.getParameter("department_id"));
        String department = request.getParameter("department");

        Employee employee = employeeDAO.getEmployeeById(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setSalary(salary);
        employee.setDepartment_id(department_id);
        employee.setDepartment(department);
        employeeDAO.updateEmployee(employee);

        request.setAttribute("employee", employee);
        request.setAttribute("message", "Update success!");
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

}