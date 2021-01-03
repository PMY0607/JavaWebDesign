package org.pmy.Ajax;

import org.pmy.Dao.ApplicantDAO;
import org.pmy.Dao.CompanyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginAjaxServlet")
public class LoginAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String chose = request.getParameter("chose");
        //System.out.println("接受到前台请求.........");
        Integer count=0;
        if(chose.equals("applicant")) {
            ApplicantDAO applicantDAO = new ApplicantDAO();
            count = applicantDAO.selectApplicatEmailCount(email);
        }else{
            CompanyDAO companyDAO = new CompanyDAO();
            count = companyDAO.selectCompanyEmailCount(email);
        }
        // 判断数据库中是否已经有了该邮箱
        if (count > 0){
            //已存在
            response.getWriter().print("ok"); // 将结果返回到前端
        }else {
            //不存在
            response.getWriter().print("账号不存在"); // 将结果返回到前端
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
