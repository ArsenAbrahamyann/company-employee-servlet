// CompaniesServlet.java
package org.example.companyemployeeservlet.servlet;

import org.example.companyemployeeservlet.manager.CompanyManager;
import org.example.companyemployeeservlet.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/companies")
public class CompaniesServlet extends HttpServlet {

    private final CompanyManager companyManager = new CompanyManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = companyManager.getAll();
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("WEB-INF/companies.jsp").forward(req, resp);
    }
}
