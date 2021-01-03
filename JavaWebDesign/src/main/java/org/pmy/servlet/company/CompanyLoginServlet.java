package org.pmy.servlet.company;

import org.pmy.Dao.ApplicantDAO;
import org.pmy.Dao.CompanyDAO;
import org.pmy.Dao.JobDao;
import org.pmy.bean.Applicant;
import org.pmy.bean.Company;
import org.pmy.bean.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/companyLoginServlet")
public class CompanyLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        CompanyDAO dao = new CompanyDAO();
        Company company = dao.getCompanyByEmailAndPass(email, pwd);
        if(company==null){
            /*
            弹窗提示
            PrintWriter writer = response.getWriter();
            writer.print("<script language='javascript'>");
            writer.print("alert('账号密码不匹配!');");
            writer.print("window.location.href = 'login.jsp';");
            writer.print("</script>");*/
            request.setAttribute("msg","用户名或密码不正确");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            //获得岗位信息
            ArrayList<Job> joblist = (ArrayList<Job>) new JobDao().getJobListByCompanyId(company.getCompanyId());
            request.getSession().setAttribute("company",company);
            request.getSession().setAttribute("joblist",joblist);

            request.getRequestDispatcher("company/companyIndex.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
