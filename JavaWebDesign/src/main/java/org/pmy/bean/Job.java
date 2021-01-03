package org.pmy.bean;

public class Job {
    private Integer jobId;
    private Integer companyId;
    private String jobName;
    private String jobHiringNum;
    private String Salary;
    private String jobAddress;
    private String jobDesc;
    private String jobEndTime;
    private String jobState;
    private Integer collect;
    private Integer apply;

    public Job() {
    }

    public Job(Integer jobId, Integer companyId, String jobName, String jobHiringNum, String salary, String jobAddress, String jobDesc, String jobEndTime, String jobState, Integer collect, Integer apply) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.jobName = jobName;
        this.jobHiringNum = jobHiringNum;
        Salary = salary;
        this.jobAddress = jobAddress;
        this.jobDesc = jobDesc;
        this.jobEndTime = jobEndTime;
        this.jobState = jobState;
        this.collect = collect;
        this.apply = apply;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobHiringNum() {
        return jobHiringNum;
    }

    public void setJobHiringNum(String jobHiringNum) {
        this.jobHiringNum = jobHiringNum;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobEndTime() {
        return jobEndTime;
    }

    public void setJobEndTime(String jobEndTime) {
        this.jobEndTime = jobEndTime;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getApply() {
        return apply;
    }

    public void setApply(Integer apply) {
        this.apply = apply;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", companyId=" + companyId +
                ", jobName='" + jobName + '\'' +
                ", jobHiringNum='" + jobHiringNum + '\'' +
                ", Salary='" + Salary + '\'' +
                ", jobAddress='" + jobAddress + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", jobEndTime='" + jobEndTime + '\'' +
                ", jobState='" + jobState + '\'' +
                ", collect=" + collect +
                ", apply=" + apply +
                '}';
    }
}
