package org.pmy.bean;

import java.util.Date;

public class Invate {
  private  Integer  invateId;
    private Integer  invateState;
    private Integer applicantId;
    private  Integer  jobId;
    private Date invateDate;
    private  Integer  companyId;

    public Invate() {
    }

    public Invate(Integer invateId, Integer invateState, Integer applicantId, Integer jobId, Date invateDate, Integer companyId) {
        this.invateId = invateId;
        this.invateState = invateState;
        this.applicantId = applicantId;
        this.jobId = jobId;
        this.invateDate = invateDate;
        this.companyId = companyId;
    }

    public Integer getInvateId() {
        return invateId;
    }

    public void setInvateId(Integer invateId) {
        this.invateId = invateId;
    }

    public Integer getInvateState() {
        return invateState;
    }

    public void setInvateState(Integer invateState) {
        this.invateState = invateState;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Date getInvateDate() {
        return invateDate;
    }

    public void setInvateDate(Date invateDate) {
        this.invateDate = invateDate;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Invate{" +
                "invateId=" + invateId +
                ", invateState=" + invateState +
                ", applicantId=" + applicantId +
                ", jobId=" + jobId +
                ", invateDate=" + invateDate +
                ", companyId=" + companyId +
                '}';
    }
}
