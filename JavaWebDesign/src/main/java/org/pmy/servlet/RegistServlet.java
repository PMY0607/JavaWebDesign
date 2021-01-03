package org.pmy.servlet;

import org.pmy.Dao.ApplicantDAO;
import org.pmy.Dao.CompanyDAO;
import org.pmy.bean.Applicant;
import org.pmy.bean.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chose = request.getParameter("chose");
        if (chose.equals("applicant")) {
            request.getRequestDispatcher("applicantRegistServlet").forward(request, response);

        } else if (chose.equals("company")) { //公司账号
            request.getRequestDispatcher("companyRegistServlet").forward(request, response);
        }
        /*String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String pwdcfr = request.getParameter("pwdcfr");
        String chose = request.getParameter("chose");
        //判断密码匹配
        if (!pwd.equals(pwdcfr)) {
            request.setAttribute("msg", "两次密码输入不匹配！");
            request.getRequestDispatcher("regist.jsp").forward(request, response);
        } else {
            if (chose.equals("applicant")) {
                ApplicantDAO dao = new ApplicantDAO();
                //查询是否存在该账号
                Integer count = dao.selectApplicatEmailCount(email);
                if (count == null || count == 0) {
                    Applicant applicant = new Applicant();
                    applicant.setApplicantEmail(email);
                    applicant.setApplicantPwd(pwd);
                    applicant.setApplicantRegistDate(new Date());
                    dao.saveApplicant(applicant);
                    request.setAttribute("email", email);
                    request.setAttribute("chose", "applicant");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "已存在该账号!");
                    request.getRequestDispatcher("regist.jsp").forward(request, response);
                }
            }
            //公司账号
            else if (chose.equals("company")) {
                CompanyDAO dao = new CompanyDAO();
                //查询是否存在该账号
                Integer count = dao.selectCompanyEmailCount(email);
                if (count == null || count == 0) {
                    Company company = new Company();
                    company.setCompanyEmail(email);
                    company.setCompanyPwd(pwd);
                    dao.saveCompany(company);
                    request.setAttribute("email", email);
                    request.setAttribute("chose", "company");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "已存在该账号!");
                    request.getRequestDispatcher("regist.jsp").forward(request, response);
                }
            }
        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
