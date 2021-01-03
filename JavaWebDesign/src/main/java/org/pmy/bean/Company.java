package org.pmy.bean;

public class Company {
    private Integer companyId ;
    private String companyName ;
    private String companyAddress;
    private String companySize ;
    private String companyType ;
    private String companyBrief ;
    private Integer companyState ;
    private Integer companySort ;
    private String companyViewnum ;
    private String companyPic ;
    private String companyEmail;
    private String companyPwd;

    public Company() {
    }

    public Company(Integer companyId, String companyName, String companyAddress, String companySize, String companyType, String companyBrief, Integer companyState, Integer companySort, String companyViewnum, String companyPic, String companyEmail, String companyPwd) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companySize = companySize;
        this.companyType = companyType;
        this.companyBrief = companyBrief;
        this.companyState = companyState;
        this.companySort = companySort;
        this.companyViewnum = companyViewnum;
        this.companyPic = companyPic;
        this.companyEmail = companyEmail;
        this.companyPwd = companyPwd;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyBrief() {
        return companyBrief;
    }

    public void setCompanyBrief(String companyBrief) {
        this.companyBrief = companyBrief;
    }

    public Integer getCompanyState() {
        return companyState;
    }

    public void setCompanyState(Integer companyState) {
        this.companyState = companyState;
    }

    public Integer getCompanySort() {
        return companySort;
    }

    public void setCompanySort(Integer companySort) {
        this.companySort = companySort;
    }

    public String getCompanyViewnum() {
        return companyViewnum;
    }

    public void setCompanyViewnum(String companyViewnum) {
        this.companyViewnum = companyViewnum;
    }

    public String getCompanyPic() {
        return companyPic;
    }

    public void setCompanyPic(String companyPic) {
        this.companyPic = companyPic;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPwd() {
        return companyPwd;
    }

    public void setCompanyPwd(String companyPwd) {
        this.companyPwd = companyPwd;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyArea='" + companyAddress + '\'' +
                ", companySize='" + companySize + '\'' +
                ", companyType='" + companyType + '\'' +
                ", companyBrief='" + companyBrief + '\'' +
                ", companyState=" + companyState +
                ", companySort=" + companySort +
                ", companyViewnum=" + companyViewnum +
                ", companyPic='" + companyPic + '\'' +
                ", companyAccount='" + companyEmail + '\'' +
                ", companyPwd='" + companyPwd + '\'' +
                '}';
    }
}
