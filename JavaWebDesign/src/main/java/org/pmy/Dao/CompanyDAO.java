package org.pmy.Dao;


import org.pmy.bean.*;
import org.pmy.utils.DBUtils;

import java.util.Date;
import java.util.List;

public class CompanyDAO {

    //保存注册对象
    public boolean createCompany(Company company) {

        String sql = "insert into tb_company(COMPANY_EMAIL,COMPANY_PWD)" +
                "values(?,?)";

        return DBUtils.save(sql,company.getCompanyEmail(),company.getCompanyPwd());

    }

    //更新公司信息
    public boolean updateCompany(Company company){
        String sql="UPDATE tb_company SET\n" +
                "COMPANY_NAME = ?,\n" +
                "COMPANY_ADDRESS = ?,\n" +
                "COMPANY_SIZE = ?,\n" +
                "COMPANY_TYPE = ?,\n" +
                "COMPANY_BRIEF = ?,\n" +
                "COMPANY_VIEWNUM = ?,\n" +
                "COMPANY_PIC = ?\n" +
                "WHERE COMPANY_ID=?";
        return DBUtils.update(sql,company.getCompanyName(),company.getCompanyAddress(),company.getCompanySize(),
                company.getCompanyType(),company.getCompanyBrief(), company.getCompanyViewnum(),company.getCompanyPic(),company.getCompanyId());
    }

    //根据email和密码查询公司信息
    public Company getCompanyByEmailAndPass(String companyEmail, String companyPwd) {

        String sql = "SELECT\n" +
                "COMPANY_ID companyId,\n" +
                "COMPANY_NAME companyName,\n" +
                "COMPANY_ADDRESS companyAddress,\n" +
                "COMPANY_SIZE companySize,\n" +
                "COMPANY_TYPE companyType,\n" +
                "COMPANY_BRIEF companyBrief,\n" +
                "COMPANY_STATE companyState,\n" +
                "COMPANY_SORT companySort,\n" +
                "COMPANY_VIEWNUM companyViewnum,\n" +
                "COMPANY_PIC companyPic,\n" +
                "COMPANY_EMAIL companyEmail,\n" +
                "COMPANY_PWD companyPwd\n" +
                "FROM\n" +
                "tb_company\n"+
                "where COMPANY_EMAIL=? and COMPANY_PWD=?";
        return DBUtils.getSingleObj(Company.class,sql,companyEmail,companyPwd);

    }

    //根据email查询公司数量
    public Integer selectCompanyEmailCount(String CompanyEmail) {

        String sql = "select count(*) from tb_company a where a.COMPANY_EMAIL = ?";

        return DBUtils.getCount(sql,CompanyEmail);

    }

    //分页查询
    public List<Company> getCompanyListByPage(String sql) {

        List<Company> list = DBUtils.getList(Company.class, sql);

        return list;

    }

    //查询一共多少行
    public Integer getCompanyCount(String sql , Object...param) {

        Integer count = DBUtils.getCount(sql , param);
        return count;
    }

    //查询求职者集合
    public List<Resume> getResumeList() {
        String sql="SELECT\n" +
                "BASICINFO_ID basicinfoId,\n" +
                "APPLICANT_ID applicantId,\n" +
                "REALNAME realName,\n" +
                "GENDER gender,\n" +
                "AGE age,\n" +
                "CURRENT_LOC currentLoc,\n" +
                "RESIDENT_LOC residentLoc,\n" +
                "TELEPHONE telephone,\n" +
                "EMAIL email,\n" +
                "JOB_INTENSION jobIntension,\n" +
                "JOB_EXPERIENCE jobExperience,\n" +
                "HEAD_SHOT headShot,\n" +
                "STATE state\n" +
                "FROM\n" +
                "tb_resume_basicinfo\n" ;

        List<Resume> list = DBUtils.getList(Resume.class, sql);

        return list;
    }

    //根据公司ID查询邀请信息
    public List<Invate> getInvateList() {
        String sql="SELECT\n" +
                "INVITATION_ID invateId,\n" +
                "INVITATION_STATE invateState,\n" +
                "APPLICANT_ID applicantId,\n" +
                "JOB_ID jobId,\n" +
                "INVITATION_DATE invateDate,\n" +
                "COMPANY_ID companyId\n" +
                "FROM\n" +
                "tb_jobinvitation\n" +
                "\n" ;

        List<Invate> list = DBUtils.getList(Invate.class, sql);

        return list;
    }

    //添加邀请信息
    public boolean invateApplicant(Integer jobId, Integer companyId, Integer applicantId){
            String sql = "insert into tb_jobinvitation (JOB_ID,COMPANY_ID,APPLICANT_ID,INVITATION_DATE) values(?,?,?,?)";
            return DBUtils.save(sql,jobId,companyId,applicantId,new Date());
    }
    //删除邀请信息
    public boolean disInvateApplicant(Integer jobId,Integer applicantId){
            String sql = "DELETE FROM tb_jobinvitation WHERE JOB_ID=? AND APPLICANT_ID=?";
             return DBUtils.update(sql,jobId,applicantId);
    }

    //获得申请的简历
    public List<JobApply> getApplyResumeByCompanyId(Integer companyId) {
            String sql ="SELECT\n" +
                    "tb_job.JOB_ID jobId, \n" +
                    "tb_job.JOB_NAME jobName,\n" +
                    "tb_jobapply.APPLY_ID applyId ,\n" +
                    "tb_jobapply.JOB_ID jobId,\n" +
                    "tb_jobapply.APPLICANT_ID applicantId,\n" +
                    "tb_jobapply.APPLY_DATE applyDate,\n" +
                    "tb_jobapply.APPLY_STATE applyState,\n" +
                    "tb_jobapply.COMPANY_ID companyId\n" +
                    "FROM\n" +
                    "tb_jobapply ,\n" +
                    "tb_job\n" +
                    "WHERE tb_jobapply.COMPANY_ID=? AND tb_jobapply.JOB_ID=tb_job.JOB_ID AND  APPLY_STATE is null";
            return DBUtils.getList(JobApply.class,sql,companyId);

    }

    //设置Job申请状态
    public boolean setApplyState(Integer state,Integer applyId){
        String sql ="UPDATE tb_jobapply \n" +
                "SET APPLY_STATE = ?\n" +
                "WHERE APPLY_ID=?\n";
        return DBUtils.update(sql,state,applyId);
    }
}
