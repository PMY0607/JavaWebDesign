package org.pmy.bean;

import java.util.Date;

public class Applicant {
    private Integer applicantId;
    private String applicantPwd;
    private String applicantEmail;
    private Date applicantRegistDate;

    public Applicant() {
        super();
    }

    public Applicant(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Applicant(String applicantPwd, String applicantEmail, Date applicantRegistDate) {
        this.applicantPwd = applicantPwd;
        this.applicantEmail = applicantEmail;
        this.applicantRegistDate = applicantRegistDate;
    }

    public Applicant(Integer applicantId, String applicantPwd, String applicantEmail, Date applicantRegistDate) {
        this.applicantId = applicantId;
        this.applicantPwd = applicantPwd;
        this.applicantEmail = applicantEmail;
        this.applicantRegistDate = applicantRegistDate;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantPwd() {
        return applicantPwd;
    }

    public void setApplicantPwd(String applicantPwd) {
        this.applicantPwd = applicantPwd;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public Date getApplicantRegistDate() {
        return applicantRegistDate;
    }

    public void setApplicantRegistDate(Date applicantRegistDate) {
        this.applicantRegistDate = applicantRegistDate;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", applicantPwd='" + applicantPwd + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", applicantRegistDate=" + applicantRegistDate +
                '}';
    }
}
