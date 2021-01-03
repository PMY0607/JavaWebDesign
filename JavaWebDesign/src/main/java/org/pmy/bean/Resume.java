package org.pmy.bean;

import java.util.Date;

public class Resume {
    private Integer basicinfoId;
    private Integer applicantId;
    private String realName;
    private String gender;
    private Integer age;
    private String currentLoc;
    private String residentLoc;
    private String telephone;
    private String email;
    private String jobIntension;
    private String jobExperience;
    private String headShot;
    private Integer state;
    private Integer invate;

    public Resume() {
    }

    public Resume(Integer basicinfoId, Integer applicantId, String realName, String gender, Integer age, String currentLoc, String residentLoc, String telephone, String email, String jobIntension, String jobExperience, String headShot, Integer state,Integer invate) {
        this.basicinfoId = basicinfoId;
        this.applicantId = applicantId;
        this.realName = realName;
        this.gender = gender;
        this.age = age;
        this.currentLoc = currentLoc;
        this.residentLoc = residentLoc;
        this.telephone = telephone;
        this.email = email;
        this.jobIntension = jobIntension;
        this.jobExperience = jobExperience;
        this.headShot = headShot;
        this.state = state;
        this.invate = invate;
    }

    public Integer getBasicinfoId() {
        return basicinfoId;
    }

    public void setBasicinfoId(Integer basicinfoId) {
        this.basicinfoId = basicinfoId;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCurrentLoc() {
        return currentLoc;
    }

    public void setCurrentLoc(String currentLoc) {
        this.currentLoc = currentLoc;
    }

    public String getResidentLoc() {
        return residentLoc;
    }

    public void setResidentLoc(String residentLoc) {
        this.residentLoc = residentLoc;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobIntension() {
        return jobIntension;
    }

    public void setJobIntension(String jobIntension) {
        this.jobIntension = jobIntension;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public String getHeadShot() {
        return headShot;
    }

    public void setHeadShot(String headShot) {
        this.headShot = headShot;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getInvate() {
        return invate;
    }

    public void setInvate(Integer invate) {
        this.invate = invate;
    }


    @Override
    public String toString() {
        return "Resume{" +
                "basicinfoId=" + basicinfoId +
                ", applicantId=" + applicantId +
                ", realName='" + realName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", currentLoc='" + currentLoc + '\'' +
                ", residentLoc='" + residentLoc + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", jobIntension='" + jobIntension + '\'' +
                ", jobExperience='" + jobExperience + '\'' +
                ", headShot='" + headShot + '\'' +
                ", state=" + state +
                ", invate=" + invate +
                '}';
    }
}
