package org.pmy.servlet.applicant;

import org.pmy.Dao.ApplicantDAO;
import org.pmy.Dao.ResumeDAO;
import org.pmy.bean.Applicant;
import org.pmy.bean.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/applicantRegistServlet")
public class ApplicantRegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String pwdcfr = request.getParameter("pwdcfr");
        //判断密码匹配
        if(!pwd.equals(pwdcfr)){
            request.setAttribute("msg","两次密码输入不匹配！");
            request.getRequestDispatcher("regist.jsp").forward(request,response);
        }else{
            ApplicantDAO dao = new ApplicantDAO();
            //查询是否存在该账号
            Integer count = dao.selectApplicatEmailCount(email);
            if(count==null||count==0) {
                Applicant applicant = new Applicant();
                applicant.setApplicantEmail(email);
                applicant.setApplicantPwd(pwd);
                applicant.setApplicantRegistDate(new Date());
                dao.saveApplicant(applicant);
                //默认添加一份空简历
                ResumeDAO rdao = new ResumeDAO();
                Integer applicantId = dao.getApplicantId(email);
                rdao.createResume(applicantId);

                request.setAttribute("email", email);
                request.setAttribute("chose", "applicant");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
            request.setAttribute("msg","已存在该账号!");
            request.getRequestDispatcher("regist.jsp").forward(request,response);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
