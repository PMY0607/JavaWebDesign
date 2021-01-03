package org.pmy.servlet.applicant;

import org.pmy.Dao.JobDao;
import org.pmy.bean.Applicant;
import org.pmy.bean.Collect;
import org.pmy.bean.Job;
import org.pmy.bean.JobApply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/displayJobServlet")
public class DisplayJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobDao dao = new JobDao();
        List<Job> joblist = dao.getJobList();
        Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");

        List<Collect> collectlist = dao.getCollectJob(applicant.getApplicantId());
        List<JobApply> applylist = dao.getApplyJob(applicant.getApplicantId());

        for(Job job :joblist){
            for(Collect c:collectlist) {
                if (job.getJobId() == c.getJobId()) {
                    job.setCollect(1);
                }
            }

            for(JobApply apply :applylist){
                if(job.getJobId() == apply.getJobId()){
                    job.setApply(1);
                }
            }
        }

        request.getSession().setAttribute("joblist",joblist);
        request.getSession().setAttribute("collectlist",collectlist);
        request.getRequestDispatcher("applicant/jobList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
