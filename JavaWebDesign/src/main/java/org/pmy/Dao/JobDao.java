package org.pmy.Dao;

import org.pmy.bean.*;
import org.pmy.utils.DBUtils;

import java.util.List;

public class JobDao {
    //查询公司Job集合
    public List<Job> getJobListByCompanyId(Integer jobId) {
        String sql="SELECT\n" +
                "JOB_ID jobId,\n" +
                "COMPANY_ID companyId,\n" +
                "JOB_NAME jobName,\n" +
                "JOB_HIRINGNUM jobHiringNum,\n" +
                "JOB_SALARY salary,\n" +
                "JOB_ADDRESS jobAddress,\n" +
                "JOB_DESC jobDesc,\n" +
                "JOB_ENDTIME jobEndTime,\n" +
                "JOB_STATE jobState\n" +
                "FROM\n" +
                "tb_job\n"+
                "WHERE COMPANY_ID=?\n" ;

        List<Job> list = DBUtils.getList(Job.class, sql,jobId);

        return list;
    }


    //更新岗位
    public boolean updateJob(Job job) {
        String sql = "UPDATE tb_job SET\n" +
                "JOB_NAME =?,\n" +
                "JOB_HIRINGNUM =?,\n" +
                "JOB_SALARY =?,\n" +
                "JOB_ADDRESS =?,\n" +
                "JOB_DESC =?,\n" +
                "JOB_STATE=?\n" +
                "WHERE JOB_ID=?\n";
        boolean flag = DBUtils.update(sql,job.getJobName(),job.getJobHiringNum(),job.getSalary(),job.getJobAddress(),
                job.getJobDesc(),job.getJobState(),job.getJobId());
        return flag;
    }

    //保存岗位
    public boolean saveJob(Job job) {
            String sql = "INSERT INTO tb_job (COMPANY_ID,JOB_NAME,JOB_HIRINGNUM,JOB_SALARY,JOB_ADDRESS,JOB_DESC,JOB_STATE\t)\n" +
                    "values(?,?,?,?,?,?,?)\n";
          return DBUtils.save(sql,job.getCompanyId(),job.getJobName(),job.getJobHiringNum(),job.getSalary(),job.getJobAddress(),
                    job.getJobAddress(),job.getJobState());
    }

    //删除岗位
    public boolean reomveJob(Integer jobId) {
        String sql ="DELETE FROM tb_job where JOB_ID = ?";
        return DBUtils.update(sql,jobId);
    }

    //查询公司Job集合
    public List<Job> getJobList() {
        String sql="SELECT\n" +
                "JOB_ID jobId,\n" +
                "COMPANY_ID companyId,\n" +
                "JOB_NAME jobName,\n" +
                "JOB_HIRINGNUM jobHiringNum,\n" +
                "JOB_SALARY salary,\n" +
                "JOB_ADDRESS jobAddress,\n" +
                "JOB_DESC jobDesc,\n" +
                "JOB_ENDTIME jobEndTime,\n" +
                "JOB_STATE jobState\n" +
                "FROM\n" +
                "tb_job\n" ;

        List<Job> list = DBUtils.getList(Job.class, sql);

        return list;
    }

    //根据用户ID查询收藏的岗位
    public List<Collect> getCollectJob(Integer applicantId){
        String sql ="SELECT\n" +
                "COLLECT_ID collectId,\n" +
                "APPLICANT_ID applicantId,\n" +
                "JOB_ID jobId\n" +
                "FROM\n" +
                "tb_jobcollect\n" +
                "WHERE APPLICANT_ID=? ";
        return DBUtils.getList(Collect.class,sql,applicantId);
    }

    public List<JobApply> getApplyJob(Integer applicantId) {
        String sql="SELECT\n" +
                "APPLY_ID applyId,\n" +
                "JOB_ID jobId,\n" +
                "APPLY_DATE applyDate,\n" +
                "APPLY_STATE applyState,\n" +
                "COMPANY_ID companyId\n" +
                "FROM\n" +
                "tb_jobapply\n" +
                "WHERE APPLICANT_ID=?\n ";
       return DBUtils.getList(JobApply.class,sql,applicantId);
    }
}
