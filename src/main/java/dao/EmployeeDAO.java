package dao;

import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAO {
    public EmployeeDAO() {

    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        System.out.println(employeeDAO.getAllEmployees());
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees")) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                double salary = resultSet.getDouble("salary");
                int department_id = resultSet.getInt("department_id");
                String department = getDepartmentByDepartmentId(department_id);
                employees.add(new Employee(id, name, email, address, phone, salary, department_id, department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int e_id) {
        Employee employee = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE id =?")) {
            statement.setInt(1, e_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                double salary = resultSet.getDouble("salary");
                int department_id = resultSet.getInt("department_id");
                String department = getDepartmentByDepartmentId(department_id);
                employee = new Employee(id, name, email, address, phone, salary, department_id, department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public String getDepartmentByDepartmentId(int id) {
        String department = null;
        Connection connection = DatabaseConnector.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement("SELECT name FROM departments WHERE department_id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                department = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public void updateEmployee(Employee employee) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE employees SET name =?, email =?, address =?, phone =?, salary =?, department_id =? WHERE id =?")) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhone());
            statement.setDouble(5, employee.getSalary());
            statement.setInt(6, employee.getDepartment_id());
            statement.setInt(7, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEmployee(Employee employee) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (name, email, address, phone, salary, department_id) VALUES (?,?,?,?,?,?)")) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhone());
            statement.setDouble(5, employee.getSalary());
            statement.setInt(6, employee.getDepartment_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Employee> searchEmployeeByName(String search) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE name LIKE ?")) {
            statement.setString(1, "%" + search + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                double salary = resultSet.getDouble("salary");
                int department_id = resultSet.getInt("department_id");
                String department = getDepartmentByDepartmentId(department_id);
                employees.add(new Employee(id, name, email, address, phone, salary, department_id, department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void deleteEmployee(int id) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id =?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

