package org.pmy.servlet.company;

import org.pmy.Dao.CompanyDAO;
import org.pmy.Dao.JobDao;
import org.pmy.bean.Company;
import org.pmy.bean.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/upDateJobServlet")
public class UpDateJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index ;
        ArrayList<Job> joblist = (ArrayList<Job>) request.getSession().getAttribute("joblist");
        String method = request.getParameter("method");
        JobDao dao = new JobDao();

        if(method.equals("update")) {
            index = Integer.valueOf(request.getParameter("index"));
            Job job = joblist.get(index);
            setJob(request, job);
            dao.updateJob(job);
            request.getSession().setAttribute("joblist", joblist);
            request.getRequestDispatcher("/company/companyInfo.jsp").forward(request, response);
        }else if(method.equals("add")){
            Company company = (Company) request.getSession().getAttribute("company");
            Job job = new Job();
            job.setCompanyId(company.getCompanyId());
            setJob(request,job);

            dao.saveJob(job);
            //获得job添加到joblist
           joblist = (ArrayList<Job>) dao.getJobListByCompanyId(company.getCompanyId());
            request.getSession().setAttribute("joblist",joblist);
            request.getRequestDispatcher("/company/companyInfo.jsp").forward(request,response);
        }else if(method.equals("delete")){
            index = Integer.valueOf(request.getParameter("index"));
            Job job =joblist.remove(index);
            dao.reomveJob(job.getJobId());
            request.getSession().setAttribute("joblist", joblist);
            request.getRequestDispatcher("/company/companyInfo.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void setJob(HttpServletRequest request, Job job) {
        String jobname = request.getParameter("jobname");
        String jobadd = request.getParameter("jobadd");
        String salary = request.getParameter("salary");
        String hiringnum = request.getParameter("hiringnum");
        String jobstate = request.getParameter("jobstate");
        String jobdesc = request.getParameter("jobdesc");

        job.setJobName(jobname);
        job.setJobAddress(jobadd);
        job.setSalary(salary);
        job.setJobHiringNum(hiringnum);
        job.setJobState(jobstate);
        job.setJobDesc(jobdesc);
    }
}
