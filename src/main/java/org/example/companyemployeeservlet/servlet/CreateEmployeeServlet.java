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


@WebServlet("/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {

    private final EmployeeManager employeeManager = new EmployeeManager();
    private final CompanyManager companyManager = new CompanyManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> all = companyManager.getAll();
        req.setAttribute("companies",all);
        req.getRequestDispatcher("WEB-INF/createEmployee.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int companyId = Integer.parseInt(req.getParameter("id"));
        Employee employee = Employee.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .company(companyManager.getById(companyId))
                .build();

        employeeManager.save(employee);
        resp.sendRedirect("/employees");

    }
}
