package org.pmy.Test;

import org.apache.commons.beanutils.BeanUtils;
import org.pmy.Dao.ApplicantDAO;
import org.pmy.Dao.CompanyDAO;
import org.pmy.Dao.JobDao;
import org.pmy.Dao.ResumeDAO;
import org.pmy.bean.Job;
import org.pmy.bean.JobApply;
import org.pmy.utils.DBUtils;

import java.util.List;

public class TestDButil {
    public static void main(String[] args) throws Exception {
        List<JobApply> applylist = new CompanyDAO().getApplyResumeByCompanyId(2);
        for (JobApply apply :applylist){
            apply.setResume(new ResumeDAO().getResumeByApplicantId(apply.getApplicantId()));
        }
    }
}