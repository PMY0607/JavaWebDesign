package org.pmy.Dao;

import org.pmy.bean.Resume;
import org.pmy.utils.DBUtils;

//简历基本信息DAO
public class ResumeDAO {

    //保存简历
    public Integer saveResumeBasicInfo(Resume basic) {

        String sql = "insert into tb_resume_basicinfo(APPLICANT_ID, REALNAME, GENDER, AGE, CURRENT_LOC, RESIDENT_LOC, TELEPHONE, EMAIL, JOB_INTENSION, JOB_EXPERIENCE )\n"
        +"values (?,?,?,?,?,?,?,?,?,?);";

        return DBUtils.updateForPrimary(sql, basic.getApplicantId(),basic.getRealName(),basic.getGender(),basic.getAge()
        ,basic.getCurrentLoc(),basic.getResidentLoc(),basic.getTelephone(),basic.getEmail(),basic.getJobIntension()
        ,basic.getJobExperience());

    }

    //更新头像
    public void updateHeadShot(int resumeId, String headshot) {

        String sql = "update tb_resume_basicinfo set HEAD_SHOT = ? where BASICINFO_ID = ? ";
        DBUtils.update(sql,headshot,resumeId);

    }

    //根据resumeId查简历
    public Resume getResumeBasicInfoById(Integer resumeID) {

        String sql = "SELECT \n" +
                "BASICINFO_ID basicinfoId,\n" +
                "APPLICANT_ID applicantId,\n" +
                "REALNAME realName,\n" +
                "GENDER gender,\n" +
                "AGE age,\n" +
                "CURRENT_LOC currentLoc,\n" +
                "RESIDENT_LOC residentLoc,\n" +
                "TELEPHONE telephone,\n" +
                "EMAIL email,\n " +
                "JOB_INTENSION jobIntension,\n" +
                "JOB_EXPERIENCE jobExperience,\n" +
                "HEAD_SHOT headShot ,\n" +
                "STATE state \n" +
                "FROM \n" +
                "tb_resume_basicinfo where BASICINFO_ID=?";
        Resume resume = DBUtils.getSingleObj(Resume.class,sql,resumeID);
        return resume;
    }

    //获得applicantId对象
    public Resume getResumeByApplicantId(Integer applicantId){
        String sql = "SELECT\n" +
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
                "tb_resume_basicinfo\n" +
                "where APPLICANT_ID=?\n";
        return DBUtils.getSingleObj(Resume.class,sql,applicantId);
    }

    //更新简历
    public boolean updateResume(Resume resume) {

        String sql = "update tb_resume_basicinfo set \n" +
                "REALNAME = ?,\n" +
                "GENDER = ?,\n" +
                "AGE = ?,\n" +
                "TELEPHONE = ?,\n" +
                "EMAIL = ?,\n" +
                "JOB_INTENSION = ?,\n" +
                "JOB_EXPERIENCE = ? ,\n" +
                "HEAD_SHOT = ? ,\n" +
                "STATE = ? \n" +
                "where BASICINFO_ID = ?";
        boolean flag = DBUtils.update(sql,resume.getRealName(),resume.getGender(),resume.getAge(),resume.getTelephone(),
                resume.getEmail(),resume.getJobIntension(),resume.getJobExperience(),resume.getHeadShot(),resume.getState(),resume.getBasicinfoId());
        return flag;
    }

    //创建空简历
    public void createResume(Integer applicantId){
        String sql ="insert into tb_resume_basicinfo(APPLICANT_ID) "+
                "values(?)";
        DBUtils.save(sql,applicantId);
    }

}
