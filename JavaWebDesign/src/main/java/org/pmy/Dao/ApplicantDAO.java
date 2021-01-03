package org.pmy.Dao;


import org.pmy.bean.Applicant;
import org.pmy.bean.Collect;
import org.pmy.bean.Job;
import org.pmy.bean.Resume;
import org.pmy.utils.DBUtils;
import sun.security.pkcs11.Secmod;

import java.util.Date;
import java.util.List;

public class ApplicantDAO {

    //保存注册对象
    public boolean saveApplicant(Applicant applicant) {

        String sql = "insert into tb_applicant(APPLICANT_EMAIL,APPLICANT_PWD,APPLICANT_REGISTDATE)" +
                "values(?,?,?)";

        return DBUtils.save(sql,applicant.getApplicantEmail(),applicant.getApplicantPwd(),applicant.getApplicantRegistDate());

    }

    //根据email和密码查询申请人
    public Applicant getApplicantByEmailAndPass(String applicatEmail, String applicatPwd) {

        String sql = "select APPLICANT_ID applicantId,APPLICANT_EMAIL applicantEmail,APPLICANT_PWD applicantPwd,APPLICANT_REGISTDATE applicantRegistDate" +
                " from tb_applicant where APPLICANT_EMAIL = ? and APPLICANT_PWD = ?";
        return DBUtils.getSingleObj(Applicant.class,sql,applicatEmail,applicatPwd);

    }

    //查询Email是否存在
    public Integer selectApplicatEmailCount(String applicatEmail) {
        String sql = "select count(*) from tb_applicant a where a.APPLICANT_EMAIL = ?";
        return DBUtils.getCount(sql,applicatEmail);
    }

    //判断当前用户是否有简历
    public Integer isExistResume(Integer applicantId) {
    String sql = "select BASICINFO_ID from tb_resume_basicinfo b where b.APPLICANT_ID = ?";
        Integer resumeID = DBUtils.getCount(sql, applicantId);
        return resumeID;

    }

    //根据email获得对象id
    public Integer getApplicantId(String email){
        String sql="select APPLICANT_ID value from tb_applicant\n" +
                "where APPLICANT_EMAIL=?";
        return DBUtils.getCount(sql,email);
    }

    //添加岗位申请信息
    public void applyForJob(Job job,Integer applicantId){
        String sql = "insert into tb_jobapply (COMPANY_ID,JOB_ID,APPLICANT_ID,APPLY_DATE) values(?,?,?,?)";
        DBUtils.save(sql,job.getCompanyId(),job.getJobId(),applicantId,new Date());
    }

    //删除岗位申请信息
    public boolean disApplyJob(int jobId, Integer applicantId) {
        String sql ="DELETE FROM tb_jobapply where JOB_ID = ? AND APPLICANT_ID=? ";
        return DBUtils.update(sql,jobId,applicantId);
    }

    //岗位收藏
    public void addCollect(Job job,Integer applicantId){
        String sql = "insert into tb_jobcollect (COMPANY_ID,JOB_ID,APPLICANT_ID,COLLECT_DATE) values(?,?,?,?)";
        DBUtils.save(sql,job.getCompanyId(),job.getJobId(),applicantId,new Date());
    }

    //岗位取消收藏
    public boolean removeCollect(int jobId, Integer applicantId) {
        String sql ="DELETE FROM tb_jobcollect where JOB_ID = ? AND APPLICANT_ID=? ";
        return DBUtils.update(sql,jobId,applicantId);
    }

}
