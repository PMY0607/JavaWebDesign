package org.pmy.servlet.applicant;

import org.pmy.Dao.ApplicantDAO;
import org.pmy.Dao.ResumeDAO;
import org.pmy.bean.Applicant;
import org.pmy.bean.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/updateResumeServlet")
@MultipartConfig
public class UpdateResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Resume resume = (Resume)session.getAttribute("resume");
        //将数据封装到resume对象中
        setResume(request,resume);

        //跟新resume对象
        ResumeDAO dao = new ResumeDAO();
        dao.updateResume(resume);
        resume = dao.getResumeBasicInfoById(resume.getBasicinfoId());

        //保存在session中
        request.getSession().setAttribute("resume",resume);
        request.getRequestDispatcher("/applicant/resume.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void setResume(HttpServletRequest request,Resume resume) throws IOException, ServletException {
        String realName = request.getParameter("realName");
        String gender = request.getParameter("gender");
        String ageStr = request.getParameter("age");
        Integer age;
        if(ageStr==null||ageStr.length()==0){
            age=0;
        }else{
            age=Integer.valueOf(ageStr);
        }
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String jobIntension = request.getParameter("jobIntension");
        String jobExperience = request.getParameter("jobExperience");

        //上传头像
        Part part = request.getPart("headShot");
        //上传的文件名head1.jpg
        String fileName = part.getSubmittedFileName();

        if(fileName!=null&&fileName.length()!=0) {
            //创建保存文件目录
            String dir = this.getServletContext().getRealPath("/images/applicant");
            //判断 目录是否存在
            File imgDir = new File(dir);
            if (!imgDir.exists()) {
                imgDir.mkdirs();
            }
            //上传到服务器文件路径imgDir+'/'+fileName
            part.write(dir + "/" + fileName);
        }else{
            fileName=resume.getHeadShot();
        }

        //设置值
        resume.setRealName(realName);
        resume.setGender(gender);
        resume.setAge(age);
        resume.setTelephone(telephone);
        resume.setEmail(email);
        resume.setJobIntension(jobIntension);
        resume.setJobExperience(jobExperience);
        resume.setHeadShot(fileName);
        resume.setState(1);

    }

}
