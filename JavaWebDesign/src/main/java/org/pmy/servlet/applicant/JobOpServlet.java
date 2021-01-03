package org.pmy.servlet.applicant;

import org.pmy.Dao.ApplicantDAO;
import org.pmy.bean.Applicant;
import org.pmy.bean.Collect;
import org.pmy.bean.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jobOpServlet")
public class JobOpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        int index = Integer.valueOf(request.getParameter("index"));
        ArrayList<Job> joblist = (ArrayList<Job>) request.getSession().getAttribute("joblist");
        ArrayList<Collect> collectlist = (ArrayList<Collect>) request.getSession().getAttribute("collectlist");
        Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");

        Job job = joblist.get(index);
        ApplicantDAO dao = new ApplicantDAO();

        //申请岗位
        if(method.equals("putR")){
            dao.applyForJob(job,applicant.getApplicantId());
            job.setApply(1);
            request.getSession().setAttribute("joblist",joblist);
        }else if(method.equals("delR")){        //取消申请
            dao.disApplyJob(job.getJobId(),applicant.getApplicantId());
            job.setApply(0);
            request.getSession().setAttribute("joblist",joblist);
        }
        else if(method.equals("addcollect")){       //添加收藏
            dao.addCollect(job,applicant.getApplicantId());
            job.setCollect(1);
            request.getSession().setAttribute("joblist",joblist);
        }else if(method.equals("deletecollect")){   //取消收藏
            dao.removeCollect(job.getJobId(),applicant.getApplicantId());
            job.setCollect(0);
            request.getSession().setAttribute("joblist",joblist);
        }

        String rePath = (String) request.getSession().getAttribute("rePath");
        request.getRequestDispatcher("applicant/"+rePath).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
