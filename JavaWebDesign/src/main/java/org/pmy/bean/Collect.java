package org.pmy.bean;

public class Collect {
    private  Integer collectId;
    private Integer applicantId;
    private Integer jobId;

    public Collect() {
    }

    public Collect(Integer collectId, Integer applicantId, Integer jobId) {
        this.collectId = collectId;
        this.applicantId = applicantId;
        this.jobId = jobId;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
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

    @Override
    public String toString() {
        return "Collect{" +
                "collectId=" + collectId +
                ", applicantId=" + applicantId +
                ", jobId=" + jobId +
                '}';
    }
}
