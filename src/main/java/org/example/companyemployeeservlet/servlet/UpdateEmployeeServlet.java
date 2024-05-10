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

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    private final EmployeeManager employeeManager = new EmployeeManager();
    private final CompanyManager companyManager = new CompanyManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeManager.getById(id);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("WEB-INF/updateEmployee.jsp").forward(req,resp);

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

        employeeManager.update(employee);
        resp.sendRedirect("/employees");
    }
}
