package org.pmy.Ajax;

import org.pmy.Dao.ApplicantDAO;
import org.pmy.Dao.CompanyDAO;
import org.pmy.bean.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registAjaxServlet")
public class RegistAjaxServlet extends HttpServlet {
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
            response.getWriter().print("该账号已被注册"); // 将结果返回到前  端
        }else {
            //不存在
            //校验一下邮箱，是否符合规则
            String s = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";
            if (email.matches(s)) {
                response.getWriter().print("ok"); // 将结果返回到前端
            }else {
                response.getWriter().print("邮箱不合法"); // 将结果返回到前端
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
