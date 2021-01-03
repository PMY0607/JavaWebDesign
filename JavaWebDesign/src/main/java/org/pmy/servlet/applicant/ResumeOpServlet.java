package org.pmy.servlet.applicant;

import org.pmy.Dao.CompanyDAO;
import org.pmy.Dao.ResumeDAO;
import org.pmy.bean.Company;
import org.pmy.bean.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/resumeOpServlet")
public class ResumeOpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Company company = (Company) request.getSession().getAttribute("company");
        String method = (String) request.getParameter("method");
        int applicantId = (Integer) request.getSession().getAttribute("applicantId");

        Resume resume = new ResumeDAO().getResumeByApplicantId(applicantId);

        CompanyDAO dao = new CompanyDAO();
        if(method.equals("invate")){
            int jobId =Integer.valueOf(request.getParameter("jobId"));
            dao.invateApplicant(jobId,company.getCompanyId(),resume.getApplicantId());
        }else if(method.equals("disinvate")){
            int jobId = (Integer) request.getSession().getAttribute("jobId");
            dao.disInvateApplicant(jobId,resume.getApplicantId());
        }

        request.getRequestDispatcher("company/applicantList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
