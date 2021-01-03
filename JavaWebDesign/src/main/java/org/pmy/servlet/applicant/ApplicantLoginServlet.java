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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/applicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        ApplicantDAO dao = new ApplicantDAO();
        Applicant applicant = dao.getApplicantByEmailAndPass(email, pwd);
        if(applicant==null){
            request.setAttribute("msg","用户名或密码不正确");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            //保存求职者和简历
            Resume resume = new ResumeDAO().getResumeByApplicantId(applicant.getApplicantId());
            HttpSession session = request.getSession();
            session.setAttribute("applicant",applicant);
            session.setAttribute("resume",resume);
            request.getRequestDispatcher("applicant/applicantIndex.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
