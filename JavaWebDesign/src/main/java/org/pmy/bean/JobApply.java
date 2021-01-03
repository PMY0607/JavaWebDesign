package org.pmy.bean;

import java.util.Date;

public class JobApply {
    private Integer companyId;
    private Integer applyId;
    private Integer jobId;
    private String jobName;
    private Integer applicantId;
    private Date applyDate;
    private Integer applyState;
    private Resume resume;
    public JobApply() {
    }

    public JobApply(Integer companyId, Integer applyId, Integer jobId, Integer applicantId, Date applyDate, Integer applyState) {
        this.companyId = companyId;
        this.applyId = applyId;
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.applyDate = applyDate;
        this.applyState = applyState;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "JobApply{" +
                "companyId=" + companyId +
                ", applyId=" + applyId +
                ", jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", applicantId=" + applicantId +
                ", applyDate=" + applyDate +
                ", applyState=" + applyState +
                ", resume=" + resume +
                '}';
    }
}
