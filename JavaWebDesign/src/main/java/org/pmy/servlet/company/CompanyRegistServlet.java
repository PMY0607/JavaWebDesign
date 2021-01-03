package org.pmy.servlet.company;

import org.pmy.Dao.CompanyDAO;
import org.pmy.bean.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/companyRegistServlet")
public class CompanyRegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String pwdcfr = request.getParameter("pwdcfr");

        //判断密码匹配
        if (!pwd.equals(pwdcfr)) {
            request.setAttribute("msg", "两次密码输入不匹配！");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
        } else {
            CompanyDAO dao = new CompanyDAO();
            //查询是否存在该账号
            Integer count = dao.selectCompanyEmailCount(email);
            if (count == null || count == 0) {
                Company company = new Company();
                company.setCompanyEmail(email);
                company.setCompanyPwd(pwd);
                dao.createCompany(company);
                request.setAttribute("email", email);
                request.setAttribute("chose", "company");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "已存在该账号!");
                request.getRequestDispatcher("regist.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
