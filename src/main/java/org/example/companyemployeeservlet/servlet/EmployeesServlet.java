// CompaniesServlet.java
package org.example.companyemployeeservlet.servlet;

import org.example.companyemployeeservlet.manager.CompanyManager;
import org.example.companyemployeeservlet.manager.EmployeeManager;
import org.example.companyemployeeservlet.model.Company;
import org.example.companyemployeeservlet.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeesServlet extends HttpServlet {

    private final EmployeeManager employeeManager = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeManager.getAll();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("WEB-INF/employees.jsp").forward(req, resp);
    }
}
